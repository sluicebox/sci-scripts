;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 850)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use soundRegion)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	wahnEntryRm 0
)

(instance wahnEntryRm of ExitRoom ; "Wagner Museum: Entry Hall"
	(properties
		noun 6
		picture 8501
		west 8601 ; wahnDispRm
	)

	(method (newRoom newRoomNumber)
		(if (OneOf newRoomNumber 800 12) ; bavMapRm, endChapter
			(gSoundManager stop:)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(gEgo
			posn: 353 347
			heading: 315
			BAD_SELECTOR:
			setScaler: Scaler 100 90 343 315
			init:
		)
		(super init: &rest)
		(if (not (IsFlag 627))
			(SetFlag 627)
			(PlayScene 519 0 8601) ; wahnDispRm
		else
			(if
				(and
					(== 0 (SoundManager seconds:))
					(or
						(not (gGk2Music handle:))
						(not (OneOf (gGk2Music number:) 851 852 853))
					)
				)
				(gSoundManager play: 0 851 852 853)
			)
			(george init: setScript: FidgetScript)
			(door init:)
			(fSouvenirs init:)
			(fDisplay init:)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 496
		nsTop 30
		nsRight 632
		nsBottom 330
		approachX 538
		approachY 341
		BAD_SELECTOR 800
		BAD_SELECTOR 2
	)
)

(instance fSouvenirs of GKFeature
	(properties
		noun 2
		modNum 850
		sightAngle 360
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 194 191 202 217 351 198 308 181
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fDisplay of GKFeature
	(properties
		sightAngle 360
		BAD_SELECTOR 8540
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 77 195 108 192 128 216 127 224 88 233 78 216
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance george of Prop
	(properties
		sightAngle 360
		x 109
		y 216
		priority 400
		fixPriority 1
		view 20519
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((and (== gChapter 4) (proc11_15 8520))
						(gCurRoom newRoom: 8520) ; topic850
					)
					((gEgo has: 44) ; invDiaryTranslation
						(gMessager say: 14 62 0 1) ; "(TRY TO TALK TO GEORG--FAX OF DIARY IS IN INVENTORY, EXCITED)I DO have something to discuss with Georg -- but he'll never believe me unless I show him!"
					)
					(else
						(gMessager say: 3 62 0 1) ; "(DON'T PICK UPT!! TRY TO TALK TO GEORG AFTER EXHAUSTING DIALOGUE)I don't have anything else to Georg about at the moment."
					)
				)
			)
			(15 ; invDiaryTranslation
				(if (IsFlag 300)
					(gCurRoom newRoom: 12) ; endChapter
				else
					(gMessager say: 5 theVerb 0 1) ; "(TRY TO SHOW GEORG LUDWIG'S DIARY BEFORE DISCUSSING LOST OPERA WITH HIM, THOUGHTFUL)I'm not sure whether Georg would be interested in Ludwig's diary or not."
				)
			)
			(else
				(gMessager say: 4 0 0 1) ; "(TRY TO SHOW GEORG ANYTHING OTHER THAN LUDWIG'S DIARY)I'm not sure Georg would want to see that."
			)
		)
	)
)

