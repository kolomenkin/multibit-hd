package org.multibit.hd.ui.fest.test_cases;

import com.google.common.base.Optional;
import org.junit.Ignore;
import org.junit.Test;
import org.multibit.hd.core.dto.WalletMode;
import org.multibit.hd.core.dto.WalletSummary;
import org.multibit.hd.testing.hardware_wallet_fixtures.HardwareWalletFixture;
import org.multibit.hd.testing.hardware_wallet_fixtures.HardwareWalletFixtures;
import org.multibit.hd.ui.fest.requirements.trezor.ReattachTrezorHardwareWalletRequirements;
import org.multibit.hd.ui.fest.requirements.trezor.create_wallet.CreateTrezorHardwareWalletColdStart_en_US_Requirements;
import org.multibit.hd.ui.fest.requirements.trezor.create_wallet.CreateTrezorHardwareWalletColdStart_ro_RO_Requirements;
import org.multibit.hd.ui.fest.requirements.trezor.create_wallet.CreateTrezorHardwareWalletColdStart_ru_RU_Requirements;
import org.multibit.hd.ui.fest.requirements.trezor.create_wallet.CreateTrezorHardwareWalletWarmStartRequirements;
import org.multibit.hd.ui.fest.requirements.trezor.restore_wallet.RestoreTrezorRestoreWithLocalBackupRequirements;
import org.multibit.hd.ui.fest.requirements.trezor.restore_wallet.RestoreTrezorWarmStartRequirements;
import org.multibit.hd.ui.fest.requirements.trezor.unlock_wallet.*;
import org.multibit.hd.ui.fest.use_cases.trezor.TrezorSendBitcoinTrezorRequirements;

/**
 * <p>Trezor hardware wallet functional tests</p>
 *
 * @since 0.0.1
 */
public class TrezorFestTest extends AbstractFestTest {

  private static final WalletMode walletMode = WalletMode.TREZOR;

  /**
   * <p>Verify the following:</p>
   * <ul>
   * <li>Start with fresh wallet fixture (cold)</li>
   * <li>Attach a Trezor when prompted</li>
   * <li>Create a Trezor hard wallet</li>
   * <li>Unlock the wallet</li>
   * </ul>
   */
  // not working yet
  @Ignore
  public void verifyCreateHardwareWallet_ColdStart() throws Exception {

    // Prepare an empty and attached Trezor device that will be initialised
    HardwareWalletFixture hardwareWalletFixture = HardwareWalletFixtures.newWipedFixture(walletMode);

    // Start with a completely empty random application directory
    arrangeFresh(Optional.of(hardwareWalletFixture));

    // Verify
    CreateTrezorHardwareWalletColdStart_en_US_Requirements.verifyUsing(window, hardwareWalletFixture);

  }

  /**
   * <p>Verify the following:</p>
   * <ul>
   * <li>Start with fresh application directory</li>
   * <li>Create a wallet in Romanian</li>
   * </ul>
   */
  // not working yet
  @Ignore
  public void verifyCreateHardwareWallet_ro_RO_ColdStart() throws Exception {

    // Prepare an empty and attached Trezor device that will be initialised
    HardwareWalletFixture hardwareWalletFixture = HardwareWalletFixtures.newWipedFixture(walletMode);

    // Start with a completely empty random application directory
    arrangeFresh(Optional.of(hardwareWalletFixture));

    // Verify
    CreateTrezorHardwareWalletColdStart_ro_RO_Requirements.verifyUsing(window, hardwareWalletFixture);

  }

  /**
   * <p>Verify the following:</p>
   * <ul>
   * <li>Start with fresh application directory</li>
   * <li>Create a wallet in Russian</li>
   * </ul>
   */
  // not working yet
  @Ignore
  public void verifyCreateHardwareWallet_ru_RU_ColdStart() throws Exception {

    // Prepare an empty and attached Trezor device that will be initialised
    HardwareWalletFixture hardwareWalletFixture = HardwareWalletFixtures.newWipedFixture(walletMode);

    // Start with a completely empty random application directory
    arrangeFresh(Optional.of(hardwareWalletFixture));

    // Verify
    CreateTrezorHardwareWalletColdStart_ru_RU_Requirements.verifyUsing(window, hardwareWalletFixture);

  }

  /**
   * <p>Verify the following:</p>
   * <ul>
   * <li>Start with empty wallet fixture (warm)</li>
   * <li>Create a HardwareWalletFixtures.new hardware wallet</li>
   * <li>Unlock the wallet</li>
   * </ul>
   */
  @Test
  public void verifyCreateHardwareWallet_WarmStart() throws Exception {

    // Prepare an empty and attached Trezor device that will be initialised
    HardwareWalletFixture hardwareWalletFixture = HardwareWalletFixtures.newWipedFixture(walletMode);

    // Start with the empty hardware wallet fixture
    arrangeEmpty(Optional.of(hardwareWalletFixture));

    // Verify
    CreateTrezorHardwareWalletWarmStartRequirements.verifyUsing(window, hardwareWalletFixture);

  }

  /**
   * <p>Verify the following:</p>
   * <ul>
   * <li>Start with empty wallet fixture (warm)</li>
   * <li>Unlock wallet</li>
   * </ul>
   */
  @Test
  public void verifyUnlockHardwareWallet_WarmStart() throws Exception {

    // Prepare an initialised and attached Trezor device that will be unlocked
    HardwareWalletFixture hardwareWalletFixture = HardwareWalletFixtures.newInitialisedUnlockFixture(walletMode);

    // Start with the empty hardware wallet fixture
    arrangeEmpty(Optional.of(hardwareWalletFixture));

    // Verify
    UnlockTrezorHardwareWalletWarmStartRequirements.verifyUsing(window, hardwareWalletFixture);

  }

  /**
   * <p>Verify the following:</p>
   * <ul>
   * <li>Start with fresh wallet fixture (cold)</li>
   * <li>Unlock wallet</li>
   * </ul>
   */
  // not working yet
  @Ignore
  public void verifyUnlockHardwareWallet_ColdStart() throws Exception {

    // Prepare an initialised and attached Trezor device that will be unlocked
    HardwareWalletFixture hardwareWalletFixture = HardwareWalletFixtures.newInitialisedUnlockFixture(walletMode);

    // Start with a completely empty random application directory
    arrangeFresh(Optional.of(hardwareWalletFixture));

    // Verify
    UnlockTrezorHardwareWalletColdStartRequirements.verifyUsing(window, hardwareWalletFixture);

  }

  /**
   * <p>Verify the following:</p>
   * <ul>
   * <li>Start with empty wallet fixture (warm)</li>
   * <li>Detach Trezor, see password screen, attach Trezor, see PIN matrix, unlock</li>
   * </ul>
   */
  @Test
  public void verifyReattachHardwareWallet() throws Exception {

    // Prepare an initialised and attached Trezor device that will be re-attached
    HardwareWalletFixture hardwareWalletFixture = HardwareWalletFixtures.newInitialisedReattachedFixture(walletMode);

    // Start with the empty hardware wallet fixture
    arrangeEmpty(Optional.of(hardwareWalletFixture));

    // Verify
    ReattachTrezorHardwareWalletRequirements.verifyUsing(window, hardwareWalletFixture);

  }

  /**
   * <p>Verify the following:</p>
   * <ul>
   * <li>Start with standard application directory</li>
   * <li>Show the PIN entry, unlock screen and restore from there. This FEST test creates a local backup</li>
   * </ul>
   */
  // not working yet
  @Ignore
  public void verifyRestoreWithLocalBackup() throws Exception {

    // Prepare an initialised and attached Trezor device that will be restored then unlocked
    HardwareWalletFixture hardwareWalletFixture = HardwareWalletFixtures.newInitialisedRestoreFixture(walletMode);

    // Start with the empty hardware wallet fixture
    WalletSummary walletSummary = arrangeEmpty(Optional.of(hardwareWalletFixture));

    // Verify up to the restore
    RestoreTrezorWarmStartRequirements.verifyUsing(window, hardwareWalletFixture);

    // Create a local backup so that there is something to load
    // (this is done after the initial trezor dialog so that the
    // master public key has been returned)
    createLocalBackup(walletSummary);

    // Do the restore with the local backup available
    RestoreTrezorRestoreWithLocalBackupRequirements.verifyUsing(window, hardwareWalletFixture);

  }

  /**
   * <p>Verify the following:</p>
   * <ul>
   * <li>Start with empty wallet fixture (warm)</li>
   * <li>Unlock the wallet</li>
   * <li>Send and force a PIN request</li>
   * </ul>
   */
  // not working yet
  @Ignore
  public void verifySendScreen() throws Exception {

    // Prepare an initialised and attached Trezor device that will be restored then unlocked
    HardwareWalletFixture hardwareWalletFixture = HardwareWalletFixtures.newInitialisedUnlockFixture(walletMode);

    // Start with the empty hardware wallet fixture
    arrangeStandard(Optional.of(hardwareWalletFixture));

    // Verify up to unlock
    UnlockTrezorHardwareWalletWarmStartRequirements.verifyUsing(window, hardwareWalletFixture);

    // Verify send workflow
    TrezorSendBitcoinTrezorRequirements.verifyUsing(window, hardwareWalletFixture);

  }

  /**
   * <p>Verify the following:</p>
   * <ul>
   * <li>Start with standard application directory</li>
   * <li>Show the unsupported firmware popover</li>
   * </ul>
   */
  @Test
  public void verifyUnsupportedFirmware() throws Exception {

    // Prepare an initialised and attached Trezor device that will be restored then unlocked
    HardwareWalletFixture hardwareWalletFixture = HardwareWalletFixtures.newInitialisedUnsupportedFirmwareFixture(walletMode);

    // Start with the empty hardware wallet fixture
    arrangeStandard(Optional.of(hardwareWalletFixture));

    // Verify up to unlock
    UnlockTrezorHardwareWalletUnsupportedFirmwareRequirements.verifyUsing(window, hardwareWalletFixture);

  }

  /**
   * <p>Verify the following:</p>
   * <ul>
   * <li>Start with standard application directory</li>
   * <li>Show the deprecated firmware popover</li>
   * </ul>
   *
   * Currently there are no deprecated firmware versions
   */
  @Ignore
  public void verifyDeprecatedFirmware() throws Exception {

    // Prepare an initialised and attached Trezor device that will be restored then unlocked
    HardwareWalletFixture hardwareWalletFixture = HardwareWalletFixtures.newInitialisedDeprecatedFirmwareFixture(walletMode);

    // Start with the empty hardware wallet fixture
    arrangeStandard(Optional.of(hardwareWalletFixture));

    // Verify up to unlock
    UnlockTrezorHardwareWalletDeprecatedFirmwareRequirements.verifyUsing(window, hardwareWalletFixture);

  }

  /**
   * <p>Verify the following:</p>
   * <ul>
   * <li>Start with standard application directory</li>
   * <li>Use an initialised Trezor with an unsupported configuration (e.g. passphrase)</li>
   * <li>Show the unsupported configuration "passphrase" popover</li>
   * </ul>
   */
  @Test
  public void verifyUnsupportedConfiguration_Passphrase() throws Exception {

    // Prepare an initialised and attached Trezor device that will be attached
    HardwareWalletFixture hardwareWalletFixture = HardwareWalletFixtures.newInitialisedUnsupportedConfigurationPassphraseFixture(walletMode);

    // Start with the standard hardware wallet fixture
    arrangeStandard(Optional.of(hardwareWalletFixture));

    // Verify up to unlock
    UnlockTrezorHardwareWalletUnsupportedConfigurationPassphraseRequirements.verifyUsing(window, hardwareWalletFixture);

  }

}
