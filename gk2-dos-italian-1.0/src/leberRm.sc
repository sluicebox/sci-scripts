;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Feature)
(use Actor)
(use System)

(public
	leberRm 0
)

(instance leberRm of ExitRoom ; "Leber's Office"
	(properties
		modNum 320
		noun 9
		picture 3201
	)

	(method (init)
		(super init: &rest)
		(fMap init:)
		(fFilingCabinet init:)
		(efDoor init:)
		(Lock rsAUDIO 320 1)
		(gGk2Music setLoop: 1 number: 320 play:)
		(cond
			((!= gPrevRoomNum 3211)
				(pLeber init: setPri: 200 setScript: FidgetScript)
				(fixEgo doit:)
				(fBulletinBoard init:)
			)
			((not (IsFlag 682))
				(fDesk init:)
				(aGabeFacingDesk init: setScaler: Scaler 98 77 326 244)
			)
		)
		(cond
			((IsFlag 682)
				(ClearFlag 682)
				(self setScript: sLeberReturns)
			)
			((and (== gChapter 5) (not (IsFlag 353)))
				(SetFlag 353)
				(PlayScene 567)
				(gGame handsOn: 0)
			)
			((== gPrevRoomNum 3240)
				(PlayScene 346)
				(gGame handsOn: 0)
			)
			((== gPrevRoomNum 200) ; MunichMapRm
				(if (IsFlag 516)
					(PlayScene 342)
				else
					(SetFlag 516)
					(PlayScene 341)
				)
				(gGame handsOn: 0)
			)
			(else
				(gGame handsOn: 0)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(Lock rsAUDIO 320 0)
		(super newRoom: newRoomNumber)
	)
)

(instance sLeberReturns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PlayScene 572 self -1)
			)
			(1
				(PlayScene 1568 self -1)
			)
			(2
				(gGame changeScore: 1075)
				(gMessager say: 1 0 0 2 self 320) ; "(LEAVING OFFICE AFTER TELLING LEBER THE CLUB WAS 'THE FRIENDLY WANDERERS')Sucker."
			)
			(3
				(gCurRoom newRoom: 200) ; MunichMapRm
				(self dispose:)
			)
		)
	)
)

(instance aGabeFacingDesk of Actor
	(properties
		x 335
		y 260
		view 550
	)

	(method (doVerb theVerb)
		(gEgo doVerb: theVerb)
	)
)

(instance pLeber of Prop
	(properties
		modNum 320
		sightAngle 360
		x 181
		y 139
		view 21342
		cel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((not (gEgo has: 6)) ; invTapeRecorder
						(gMessager say: 32 0 0 0 0 320) ; "(PREOCCUPIED)I don't want to discuss anythin' heavy 'til I've picked up my tape recorder."
					)
					((and (not (IsFlag 679)) (IsFlag 357))
						(gMessager say: 39 62 0 0 0 320) ; "(PICKUP, TRY TO TALK TO LEBER WHEN YOU'RE SUPPOSED TO PLAY VON ZELL TAPE)He's bein' pretty stubborn about those ledgers. I've got a feelin' I won't be able to just talk my way past this one."
					)
					((proc11_15 3210)
						(gCurRoom newRoom: 3210)
					)
					(else
						(gMessager say: 31 62 0 0 0 320) ; "(TRY TO TALK TO LEBER--DIALOGUE DONE)I don't have any more questions for the Kommisar."
					)
				)
			)
			(59 ; invKlingmannReceipt
				(if (and (not (IsFlag 679)) (IsFlag 357))
					(gMessager say: 40 59 0 0 0 320) ; "(PICKUP, TRY TO KLINGMANN'S RECEIPT TO LEBER WHEN YOU'RE SUPPOSED TO PLAY VON ZELL TAPE)That receipt's not much proof of anythin' by itself."
				else
					(gMessager say: 38 62 0 0 0 320) ; "(PICKUP, TRY TO SHOW LEBER AN INVENTORY ITEM)I not sure why I'd want to show him that."
				)
			)
			(117 ; invVonZellTape
				(cond
					((IsFlag 679)
						(gMessager say: 4 18 0 0 0 320) ; "(TRY TO PLAY VON ZELL TAPE FOR LEBER AGAIN)He was convinced the first time."
					)
					((not (IsFlag 678))
						(gMessager say: 3 18 0 0 0 320) ; "(TRY TO PLAY VON ZELL TAPE FOR LEBER BEFORE HAVING IT TRANSLATED)I'd better figure out what that tape SAYS first."
					)
					((IsFlag 357)
						(SetFlag 679)
						(fBulletinBoard dispose:)
						(fDesk init:)
						(gEgo dispose:)
						(aGabeFacingDesk init: setScaler: Scaler 98 77 326 244)
						(PlayScene 570)
						(self dispose:)
					)
					(else
						(gMessager say: 6 18 0 0 0 320) ; "(TRY TO PLAY VON ZELL TAPE FOR LEBER BEFORE ASKING FOR GROSSBERG'S PAPERS)I COULD share that with Leber, but I'm not sure what it would buy me at the moment."
					)
				)
			)
			(else
				(if (and (not (IsFlag 679)) (IsFlag 357))
					(gMessager say: 40 62 0 0 0 320) ; "(PICKUP, TRY TO SHOW OTHER ITEMS TO LEBER WHEN YOU'RE SUPPOSED TO PLAY VON ZELL TAPE)I don't think THAT would impress Leber."
				else
					(gMessager say: 38 62 0 0 0 320) ; "(PICKUP, TRY TO SHOW LEBER AN INVENTORY ITEM)I not sure why I'd want to show him that."
				)
			)
		)
	)
)

(instance fDesk of Feature
	(properties
		modNum 320
		sightAngle 360
	)

	(method (init)
		(self createPoly: 236 161 270 161 269 191 236 191)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 571 0 3211) ; rm3211
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fMap of GKFeature
	(properties
		sightAngle 360
	)

	(method (init)
		(self
			createPoly: 184 18 327 18 328 38 341 39 363 46 364 86 355 97 337 99 327 119 184 119
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gChapter 5)
					(gMessager say: 37 62 0 0 0 320) ; "(PICKUP, TRY TO LOOK AT MAP IN LEBER'S OFFICE, CH 5)I'm sure nothin's changed since the last time I looked at the map."
				else
					(PlayScene 345 0 3240) ; rm3240
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fBulletinBoard of Feature
	(properties
		noun 35
		sightAngle 360
	)

	(method (init)
		(self createPoly: 128 133 32 150 28 -4 52 -3 123 21)
		(super init: &rest)
	)
)

(instance fFilingCabinet of GKFeature
	(properties
		noun 36
		sightAngle 360
	)

	(method (init)
		(self createPoly: 482 55 535 37 615 36 616 333 495 334 470 294)
		(super init: &rest)
	)
)

(instance efDoor of ExitFeature
	(properties
		sightAngle 360
		x 240
		y 48
		BAD_SELECTOR 0
	)

	(method (init)
		(self createPoly: 378 23 481 23 479 235 377 234)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					(
						(and
							(not (gCast contains: pLeber))
							(not (gEgo has: 48)) ; invLedgerPage
						)
						(gMessager say: 2 62 0 0 0 320) ; "(TRY TO LEAVE OFFICE WITH GROSSBERG'S PAPERS ON DESK)If I leave now, I'll never get another look at those papers."
					)
					((and (not (gCast contains: pLeber)) (gEgo has: 48)) ; invLedgerPage
						(gCurRoom setScript: sLeberReturns)
					)
					((== gChapter 5)
						(PlayScene 569 0 200) ; MunichMapRm
					)
					((IsFlag 517)
						(PlayScene 344 0 200) ; MunichMapRm
					)
					(else
						(PlayScene 343 0 200) ; MunichMapRm
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fixEgo of Code
	(properties)

	(method (doit)
		(gEgo
			setScale: 0
			view: 22342
			setLoop: 0 1
			cel: 0
			posn: 414 144
			init:
			setScript: (FidgetScript new:)
		)
	)
)

