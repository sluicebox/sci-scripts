;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use RamaRegion)
(use InvInitialize)
(use SaveManager)
(use SoundManager)
(use n1111)
(use Actor)
(use System)

(public
	cplainRegion 0
)

(local
	local0
	local1
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 0)))))
	(if (and (= temp0 (proc70_6 40)) (temp0 ownedBy: -2))
		0
	else
		(= temp0 0)
	)
	(if (and (= temp1 (proc70_6 47)) (temp1 ownedBy: -2))
		0
	else
		(= temp1 0)
	)
	(if (and (= temp2 (proc70_6 37)) (temp2 ownedBy: -2))
		0
	else
		(= temp2 0)
	)
	(if (and (= temp3 (proc70_6 104)) (temp3 ownedBy: -2))
		0
	else
		(= temp3 0)
	)
	(if (and (= temp4 (proc70_6 1)) (temp4 ownedBy: -2))
		0
	else
		(= temp4 0)
	)
	(if (and temp0 temp1 temp2 temp3 temp4)
		(return 1)
	else
		(return 0)
	)
)

(class MigratingView of View
	(properties
		invItemID 0
	)

	(method (init &tmp temp0)
		(= temp0 (proc70_6 invItemID))
		(if (and (& (temp0 state:) $0001) (self checkLocation: temp0))
			(super init: &rest)
			(if (self okayToGet:)
				(self setHotspot: 2)
			)
		else
			(return)
		)
	)

	(method (checkLocation param1)
		(OneOf (param1 owner:) -1 gCurRoomNum)
	)

	(method (okayToGet)
		(return 1)
	)

	(method (itemPickedUp)
		(proc70_1 invItemID 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self itemPickedUp: dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class CPlainRegion of RamaRegion
	(properties
		migrateList 0
		positiveMapPosn 1
		currentActor 0
		curInvItemInStill 0
		ruinedBiotState 0
		currentChannel 1
		curCornDispenser 2
		allowedAreas 16
		numPiecesDropped 0
		iceportWarningCount 0
	)

	(method (init)
		(super init: &rest)
		(= initialized 0)
		(if
			(and
				(!= (SoundManager musicNum:) 1010)
				(OneOf gCurRoomNum 2000 2070) ; cplains, encounterCloseup
			)
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 1010)
		)
		(if (and (not script) (localproc_0) (not (IsFlag 74)))
			(self setScript: 2)
		)
		(= global190 0)
	)

	(method (dispose)
		(if migrateList
			(migrateList dispose:)
			(= migrateList 0)
		)
		(super dispose:)
	)

	(method (setScript param1 &tmp temp0)
		(= temp0
			(switch (= local1 param1)
				(1
					(ScriptID 3080 0) ; Rama_Quake_Vmail_Seq
				)
				(2
					(ScriptID 1018 0) ; CPlain_Vmail_Seq
				)
				(else 0)
			)
		)
		(super setScript: temp0)
	)

	(method (setKeep)
		(= keep
			(if (not (OneOf gCurRoomNum 1015 15 95)) ; easyPickins, prologue, morgue
				(not
					(or
						(<= 6001 gNewRoomNum 6911) ; avianLeftShaft1, mirmicatPoolCloseUp
						(<= 5001 gNewRoomNum 5030) ; NYAvian1, NYAvianTetraCU
						(== gNewRoomNum 6000) ; avianShaft
						(<= 7000 gNewRoomNum 7924) ; octoAtriumRamp, ocMorphGateSW
						(<= 5301 gNewRoomNum 5331) ; NY_Octospider_Plaza_1, NY_Octospider_Plaza_31
						(<= 8000 gNewRoomNum 8130) ; HumanRamp, HumanBeds
						(<= 5202 gNewRoomNum 5215) ; humanPlazaRm2, NY_Human_Plaza_15
						(<= 5401 gNewRoomNum 5419) ; NY_Subway_1, puzzleIconCU
						(<= 5700 gNewRoomNum 5701) ; NYPort, NYPort2
						(<= 5500 gNewRoomNum 5524) ; NYMazeA, NYMazeZ
					)
				)
			)
		)
	)

	(method (addMigrantIfEqualTo param1 param2 &tmp temp0)
		(if (not migrateList)
			(= migrateList (Set new:))
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(if (== (proc70_9 [param2 temp0]) param1)
				(migrateList add: (proc70_6 [param2 temp0]))
			)
		)
	)

	(method (addMigrant param1 &tmp temp0)
		(if (not migrateList)
			(= migrateList (Set new:))
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(migrateList add: (proc70_6 [param1 temp0]))
		)
	)

	(method (migrate &tmp [temp0 2])
		(if (or (not migrateList) (not (migrateList size:)))
			(return)
		)
		(migrateList eachElementDo: #doVerb 36 release: dispose:)
		(= migrateList 0)
	)

	(method (serialize param1 &tmp temp0 temp1 [temp2 3] temp5)
		(if (and argc param1)
			(super serialize: param1 &rest)
			(= temp0 (SaveManager readWord:))
			(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
				(self addMigrant: (SaveManager readWord:))
			)
			(self positiveMapPosn: (SaveManager readWord:))
			(self curInvItemInStill: (SaveManager readWord:))
			(self ruinedBiotState: (SaveManager readWord:))
			(self currentChannel: (SaveManager readWord:))
			(self curCornDispenser: (SaveManager readWord:))
			(self allowedAreas: (SaveManager readWord:))
			(self numPiecesDropped: (SaveManager readWord:))
			(self iceportWarningCount: (SaveManager readWord:))
			(= temp5 (SaveManager readWord:))
			(self setScript: temp5)
			(if script
				(script serialize: param1)
			)
		else
			(super serialize:)
			(if migrateList
				(SaveManager writeWord: (migrateList size:))
				(for ((= temp1 0)) (< temp1 (migrateList size:)) ((++ temp1))
					(SaveManager writeWord: (proc70_7 (migrateList at: temp1)))
				)
			else
				(SaveManager writeWord: 0)
			)
			(SaveManager writeWord: (self positiveMapPosn:))
			(SaveManager writeWord: (self curInvItemInStill:))
			(SaveManager writeWord: (self ruinedBiotState:))
			(SaveManager writeWord: (self currentChannel:))
			(SaveManager writeWord: (self curCornDispenser:))
			(SaveManager writeWord: (self allowedAreas:))
			(SaveManager writeWord: (self numPiecesDropped:))
			(SaveManager writeWord: (self iceportWarningCount:))
			(if (not script)
				(= local1 0)
			)
			(SaveManager writeWord: local1)
			(if script
				(script serialize: param1)
			)
		)
	)

	(method (changeChannels)
		(if (> (++ currentChannel) 2)
			(= currentChannel 1)
		)
		(return currentChannel)
	)

	(method (advanceIceportWarning &tmp temp0)
		(= temp0 iceportWarningCount)
		(if (> (++ iceportWarningCount) 3)
			(= iceportWarningCount 3)
		)
		(return temp0)
	)
)

(instance cplainRegion of CPlainRegion
	(properties)
)

