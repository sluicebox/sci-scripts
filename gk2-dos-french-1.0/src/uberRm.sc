;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	uberRm 0
)

(local
	local0
)

(instance uberRm of ExitRoom ; "\9abergrau's Office"
	(properties
		noun 15
		picture 4201
	)

	(method (init)
		(gEgo
			setScale: 0
			view: 22071
			setLoop: 0 1
			cel: 0
			posn: 407 187
			init:
			setScript: sFidget
			setPri: 300 1
		)
		(pUbergrau init: setPri: 300 setScript: sUbergrauFidget)
		(fOfficeDoor init:)
		(super init: &rest)
		(if
			(and
				(or (== gPrevRoomNum 42201) (== gPrevRoomNum 42200)) ; rm4220b
				(not (IsFlag 8))
			)
			(gMessager say: 22 0 0 1 0 420) ; "(TRY TO TALK TO UBERGRAU--DIALOGUE DONE)I don't have anything else to say right now."
		)
		(cond
			((not (IsFlag 427))
				(switch gChapter
					(1
						(PlayScene 69)
					)
					(3
						(PlayScene 242)
						(gEgo get: 80) ; invAddressedPackage
					)
					(5
						(PlayScene 554)
						(gEgo get: 47) ; invGraceLetter3
					)
				)
				(SetFlag 427)
			)
			((and (!= gPrevRoomNum 42200) (!= gPrevRoomNum 42201)) ; rm4220b
				(if (== gChapter 1)
					(if
						(and
							(not (IsFlag 433))
							(gEgo has: 4) ; invGabeWallet
							(gEgo has: 16) ; invEvidenceReport
							(not (gEgo has: 9)) ; invGabeEnvelope1
							(IsFlag 411)
							(IsFlag 432)
							(IsFlag 430)
							(IsFlag 41)
							(IsFlag 412)
							(IsFlag 230) ; "I'm an avid hunter." in rm4320
							(IsFlag 842)
						)
						(SetFlag 433)
					)
					(cond
						((gEgo has: 14) ; invRitterPapers
							(PlayScene 70)
						)
						((and (IsFlag 433) (IsFlag 115)) ; "Ritter Family Papers" in rm4220
							(gEgo get: 14) ; invRitterPapers
							(PlayScene 71)
						)
						((IsFlag 115) ; "Ritter Family Papers" in rm4220
							(PlayScene 70)
							(PlayScene 83)
						)
						(else
							(PlayScene 70)
						)
					)
				else
					(PlayScene 243)
				)
			)
		)
		(gGame handsOn: 0)
	)
)

(instance pUbergrau of Prop
	(properties
		modNum 420
		x 102
		y 166
		view 21071
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 29 211 21 139 65 112 59 56 116 63 112 119 128 120 162 186
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (not (gEgo has: 6)) ; invTapeRecorder
					(gMessager say: 2 62 0 1 0 420) ; "(UBERGRAU'S OFFICE, PREOCCUPIED)I don't want to discuss anythin' heavy 'til I've picked up my tape recorder."
				else
					(switch gChapter
						(1
							(gCurRoom newRoom: 42200)
						)
						(3
							(gCurRoom newRoom: 42201) ; rm4220b
						)
						(5
							(gCurRoom newRoom: 42201) ; rm4220b
						)
					)
				)
			)
			(56 ; invFarmHair
				(gMessager say: 1 0 0 0 0 420) ; "(TRY TO SHOW HAIR SAMPLES TO UBERGRAU)He MIGHT know someone who can help me out. I'll have to ask him about it."
			)
			(57 ; invZooHair
				(gMessager say: 1 0 0 0 0 420) ; "(TRY TO SHOW HAIR SAMPLES TO UBERGRAU)He MIGHT know someone who can help me out. I'll have to ask him about it."
			)
			(58 ; invPawPrintCast
				(gMessager say: 1 0 0 0 0 420) ; "(TRY TO SHOW HAIR SAMPLES TO UBERGRAU)He MIGHT know someone who can help me out. I'll have to ask him about it."
			)
			(117 ; invVonZellTape
				(if (IsFlag 678)
					(gMessager say: 4 19 0 1 0 420) ; "(TRY TO PLAY VON ZELL TAPE WITH UBERGRAU A SECOND TIME)Harry nearly had a heart attack the FIRST time."
				else
					(SetFlag 678)
					(PlayScene 556)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fOfficeDoor of ExitFeature
	(properties
		sightAngle 360
		x 516
		y 268
		exitDir 0
	)

	(method (init)
		(super init:)
		(self createPoly: 464 264 464 0 556 7 556 254)
	)

	(method (doVerb)
		(if (== gChapter 1)
			(PlayScene 72)
		else
			(PlayScene 244)
		)
		(gCurRoom newRoom: 4004)
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cel: 0 setCycle: End)
				(= seconds (Random 5 12))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance sUbergrauFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(pUbergrau cel: 0 setCycle: End)
				(= seconds (Random 4 12))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

