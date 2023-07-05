;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use RamaRegion)
(use VidmailChoices)
(use InvInitialize)
(use SaveManager)
(use SoundManager)
(use RegionSFX)
(use n1111)
(use System)

(public
	HubCampRegion 0
)

(instance HubCampRegion of RamaRegion
	(properties)

	(method (init)
		(if (not initialized)
			(SoundManager
				short_Delay: 2
				playSounds:
					((RegionSFX new:) number: 1050 setVol: 30 yourself:)
					((RegionSFX new:) number: 1051 setVol: 40 yourself:)
					((RegionSFX new:) number: 1052 setVol: 30 yourself:)
			)
		)
		(super init: &rest)
		(if
			(and
				(not (proc55_5 34))
				(IsFlag 84)
				(== (proc70_9 9) 1011)
				(not (gGame script:))
				(not (gGame script:))
			)
			(gGame setScript: franVidMail)
		)
		(if (and (IsFlag 82) (not (IsFlag 83)))
			(self setScript: puckKnock)
		)
		(if
			(and
				(IsFlag 84)
				(IsFlag 83)
				(not (proc55_5 35))
				(not (proc55_5 36))
				(proc1111_24 80)
			)
			(self setScript: (ScriptID 1017 0)) ; HubCamp_Vmail_Seq
		)
		(= global190 16)
	)

	(method (dispose)
		(SoundManager fadeMusic: 0 10 8 1 stopSounds:)
		(if script
			(script dispose:)
			(= script 0)
		)
		((ScriptID 1017 0) dispose:) ; HubCamp_Vmail_Seq
		(if (== (gGame script:) franVidMail)
			(franVidMail dispose:)
		)
		(DisposeScript 1017)
		(= initialized 0)
		(super dispose:)
	)

	(method (setKeep)
		(= keep
			(or (<= 1000 gNewRoomNum 1014) (== gNewRoomNum 1020) (== gNewRoomNum 1016)) ; hubCamp0, hubCampBomb, hubCableCar, hubCampLocker4
		)
	)

	(method (notify param1)
		(if (== param1 83)
			(puckKnock dispose:)
		)
	)

	(method (serialize param1 &tmp temp0)
		(if (and argc param1)
			(if script
				(script dispose:)
			)
			(super serialize: param1)
			(if (= temp0 (SaveManager readWord:))
				((ScriptID 1017 0) serialize: param1) ; HubCamp_Vmail_Seq
				(self script: (ScriptID 1017 0)) ; HubCamp_Vmail_Seq
				((ScriptID 1017 0) client: self) ; HubCamp_Vmail_Seq
			)
		else
			(super serialize: param1)
			(if (and script (!= script puckKnock))
				(SaveManager writeWord: script)
				(script serialize: param1)
			else
				(SaveManager writeWord: 0)
			)
		)
	)
)

(instance puckKnock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(
				(sPuckKnock
					number: 1053
					owner: self
					loop: -1
					setProx:
						1012
						127
						0
						1002
						120
						0
						1005
						100
						270
						1001
						100
						330
						1006
						90
						60
						1000
						40
						30
						1003
						50
						80
				)
				(SoundManager addSFXLocs: sPuckKnock)
				(= seconds (Random 1 3))
			)
			((sPuckKnock fade: 0 10 8 1)
				(SoundManager deleteSFXLoc: sPuckKnock)
				(= seconds (Random 2 5))
				(= start state)
			)
			((sPuckKnock play:)
				(SoundManager addSFXLocs: sPuckKnock)
				(= seconds (Random 1 3))
			)
			((self init: &rest))
		)
	)

	(method (dispose)
		(SoundManager deleteSFXLoc: sPuckKnock)
		(sPuckKnock dispose:)
		(super dispose:)
	)
)

(instance sPuckKnock of RegionSFX
	(properties)
)

(instance franVidMail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(gGame script: 0)
				(self client: 0)
				(self caller: 0)
				(if (not (proc55_5 34))
					(proc55_3 34)
					(PrintDebug {real 1})
				)
				(PrintDebug {disposing})
			)
		)
	)
)

