;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 325)
(include sci.sh)
(use Main)
(use PQRoom)
(use Plane)
(use Print)
(use ROsc)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm325 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	[local8 2]
	local10 = 319
	local11 = 179
	local12
	local13 = 1
	local14
	local15 = 1
	local16 = 1
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	local45
)

(instance rm325 of PQRoom
	(properties
		picture 0
		infoRoomSignal 72
	)

	(method (init)
		(if (not global403)
			((ScriptID 45 0) initData:) ; dopeBook
		)
		(= global114 myShootCode)
		(Lock rsAUDIO 31001 0)
		(gBackMusic stop:)
		(SetFlag 15)
		(SetFlag 12)
		(SetFlag 110)
		(Load rsAUDIO 42)
		(Load rsAUDIO 45)
		(Load rsAUDIO 56)
		(Load rsVIEW 10)
		(super init: &rest)
		(if (== gPrevRoomNum 300)
			((ScriptID 19 2) doit: 14 1) ; addToInv
		)
		(= global432 myTalkerStopCheck)
		(gNormalCursor view: 996)
		(gGame setCursor: gNormalCursor)
		(SetCursor 319 179)
		(gThePlane picture: -2 setBitmap: 3301 0 0 setRect: 0 0 640 358)
		(= local2 global402)
		(= local1 global401)
		(if (IsFlag 53)
			(= local14 1)
			(= local44 1)
		)
		(topDial init:)
		(sideDial init:)
		(bolt init:)
		(windWindow init:)
		(windFlag
			init:
			setLoop:
				(if (or (not (IsFlag 53)) (IsFlag 23))
					8
				else
					(Random 0 9)
				)
			setCycle: Fwd
		)
		(trigger init:)
		(focusDial init:)
		(cardBoard init: gFtrInitializer snipePlane)
		(if (and (IsFlag 53) (!= global136 2))
			(++ global136)
		)
		(gGame handsOn:)
		(drillManager doit:)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(== (event message:) $001d)
					(not local12)
				)
				(= local12 1)
				(gNormalCursor view: 999)
				(gGame setCursor: gNormalCursor)
			)
			((and (& (event type:) evMOUSEBUTTON) (== (event message:) $001d) local12)
				(= local26 2)
				(gNormalCursor view: 996)
				(gGame setCursor: gNormalCursor 1 local10 local11)
				(= gMouseX local10)
				(= gMouseY local11)
				(= local12 0)
			)
		)
		(super handleEvent: event)
	)

	(method (dispose)
		(= local12 1)
		(= local13 0)
		(Lock rsAUDIO 45 0)
		(theBlast dispose:)
		(= global114 0)
		(= global432 0)
		(clearDoits doit:)
		(if (!= gNewRoomNum 320)
			(Lock rsAUDIO 31001 0)
			(gBackMusic fade: 0 2 21 1)
			(ClearFlag 110)
		)
		(= global402 local2)
		(= global401 local1)
		(ClearFlag 23)
		(reloadTimer dispose: delete:)
		(qualProd dispose: delete:)
		(shootTimer dispose: delete:)
		(windTimer dispose: delete:)
		(ballonTimer dispose: delete:)
		(shotSound dispose:)
		(snipePlane dispose:)
		((gThePlane bitmapCast:) dispose:)
		(gThePlane bitmap: 0)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (and (OneOf newRoomNumber 100 15) (not local43)) ; mainMenu
			(= global138 newRoomNumber)
			(if (not local44)
				(gCurRoom setScript: leaveBeforeZero 0 newRoomNumber)
			else
				(gCurRoom setScript: leaveDuringDrill 0 newRoomNumber)
			)
			(return)
		)
		(if (gTalkers size:)
			(gMessager cue: 1)
		)
		(if (not (OneOf newRoomNumber 320 310))
			(ClearFlag 12)
		)
		(if (not (IsFlag 53))
			(SetFlag 49)
		)
		(gNormalCursor view: 999)
		(gGame setCursor: gNormalCursor 1)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doit)
		(super doit: &rest)
		(if (Save 8) ; GameIsRestarting
			(gNormalCursor view: 999)
			(gGame setCursor: gNormalCursor 1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(super doVerb: theVerb)
			)
			(6
				(gMessager say: 13 6 0 0 0 320) ; "Holster that handgun, NOW!"
			)
			(else
				(gMessager say: 13 0 0 0 0 320) ; "Hey you! Knock it off with the funny stuff! We have live fire conditions!"
			)
		)
	)
)

(instance doQualification of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local25 0)
				(= local20 (List new:))
				(targetBack1
					view: 3329
					setLoop: 2
					setCel: 0
					posn: 509 361
					setPri: 470
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBull1
					view: 3329
					setLoop: 2
					setCel: 1
					posn: 509 361
					setPri: 471
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(gMessager say: 12 29 0 0 self 320) ; "Qualification begins with a cold barrel shot in a one inch square. Then a five round group in a one and a half inch square, and then nine bull's-eyes, each in a one inch square. All from one hundred yards. Load your weapon and when ready, fire at will for your cold barrel shot."
			)
			(1
				(SetFlag 81)
				(shootTimer setReal: shootTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance firstTrain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 22)
				(targetBack1
					view: 3329
					setLoop: 2
					setCel: 0
					posn: 509 361
					setPri: 470
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBull1
					view: 3329
					setLoop: 2
					setCel: 1
					posn: 509 361
					setPri: 471
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(gGame handsOn:)
				(gMessager say: 0 0 6 0 self 320) ; "All right. Now to check the zero on your rifle, you're going to want to take a shot aiming at the center of the one inch square. But before you do, there's a few things you need to know. First, your Bullet Drop Compensator knob, or your BDC, is the top knob on your scope. This is the knob you use to compensate for up/down. Your right knob, the windage knob, is two-fold. Yes, it allows you to adjust for wind, but it also functions as a horizontal adjustment when zeroing."
			)
			(1
				(= local30 targetBull1)
				(shootTimer setReal: shootTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance prodPlayer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 23)
					(gMessager say: 0 0 79 0 self 320) ; "Cold barrel shot. Fire at will."
				else
					(gMessager say: 0 0 16 0 self 320) ; "We have calm. Fire at will."
				)
			)
			(1
				(shootTimer setReal: shootTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance ejectBullet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local14 1)
				(bolt setLoop: 1 setCel: 0 setCycle: CT 4 1 self)
			)
			(1
				(bolt setCycle: End self)
				(gFxSound number: 42 setLoop: 0 play:)
			)
			(2
				(reloadTimer setReal: reloadTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance instructToReload of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 9 0 self 320) ; "Please reload and fire at will."
			)
			(1
				(reloadTimer setReal: reloadTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance reloadBullet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local14 0)
				(gFxSound number: 46 setLoop: 0 play:)
				(bolt setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(bolt setLoop: 1 setCel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance missedTarget of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 0 8 0 self) ; MISSING MESSAGE
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance drillOver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(SetFlag 79)
				(= local43 1)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance failedQual of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global432 0)
				(= seconds 3)
			)
			(1
				(cond
					((IsFlag 81)
						(gMessager say: 0 0 82 0 self 320) ; "Target missed completely. Qualification failed on first shot."
					)
					((IsFlag 287)
						(gMessager say: 0 0 86 0 self 320) ; "Target missed completely. Qualification failed on first shot."
					)
					(else
						(gMessager say: 0 0 90 0 self 320) ; "Target missed completely. Qualification failed on first shot."
					)
				)
			)
			(2
				(ClearFlag 81)
				(ClearFlag 287)
				(SetFlag 82)
				(= local43 1)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance hitColdBarrel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global432 0)
				(gMessager say: 0 0 80 0 self 320) ; "Spotter confirms cold barrel hit dead on. Qualification continues."
			)
			(1
				(local20 dispose:)
				(target1 dispose:)
				(gMessager say: 0 0 81 0 self 320) ; "Please reload and fire at will for the five round group at one hundred yards."
			)
			(2
				(targetBull1
					view: 3331
					setCel: 0
					setLoop: 0
					posn: 504 350
					setPri: 471
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBack1
					view: 3331
					setCel: 1
					setLoop: (targetBull1 loop:)
					posn: (targetBull1 x:) (targetBull1 y:)
					setPri: 470
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(= local20 (List new:))
				(qualProd setReal: qualProd 15)
				(ClearFlag 81)
				(SetFlag 287)
				(= global432 myTalkerStopCheck)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tellToShoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((IsFlag 286)
						(gMessager say: 0 0 87 0 self 320) ; "One inch target at one hundred yards! One of nine! Fire at will."
						(qualProd setReal: qualProd 6)
					)
					((IsFlag 287)
						(gMessager say: 0 0 83 0 self 320) ; "Five round group! Fire at will."
						(qualProd setReal: qualProd 15)
					)
					(else
						(gMessager say: 0 0 79 0 self 320) ; "Cold barrel shot. Fire at will."
						(qualProd setReal: qualProd 6)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance hitFiveGroup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(qualProd dispose: delete:)
				(gMessager say: 0 0 84 0 self 320) ; "Spotter confirms hit dead on. Qualification continues."
			)
			(1
				(if (== (++ local21) 5)
					(= global432 0)
					(local20 dispose:)
					(targetBull1 dispose:)
					(targetBack1 dispose:)
					(gMessager say: 0 0 85 0 self 320) ; "Please reload and fire at will for the nine one inch targets."
				else
					(qualProd setReal: qualProd 15)
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(2
				(targetBull1
					view: 3331
					setCel: 0
					setLoop: 4
					posn: 486 333
					setPri: 471
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBull2
					view: 3331
					setCel: 0
					setLoop: 4
					posn: 506 333
					setPri: 471
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBull3
					view: 3331
					setCel: 0
					setLoop: 4
					posn: 526 333
					setPri: 471
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBull4
					view: 3331
					setCel: 0
					setLoop: 4
					posn: 486 349
					setPri: 471
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBull5
					view: 3331
					setCel: 0
					setLoop: 4
					posn: 506 349
					setPri: 471
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBull6
					view: 3331
					setCel: 0
					setLoop: 4
					posn: 526 349
					setPri: 471
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBull7
					view: 3331
					setCel: 0
					setLoop: 4
					posn: 486 364
					setPri: 471
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBull8
					view: 3331
					setCel: 0
					setLoop: 4
					posn: 506 364
					setPri: 471
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBull9
					view: 3331
					setCel: 0
					setLoop: 4
					posn: 526 364
					setPri: 471
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBack1
					view: 3331
					setCel: 1
					setLoop: (targetBull1 loop:)
					posn: (targetBull1 x:) (targetBull1 y:)
					setPri: 470
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBack2
					view: 3331
					setCel: 1
					setLoop: (targetBull2 loop:)
					posn: (targetBull2 x:) (targetBull2 y:)
					setPri: 470
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBack3
					view: 3331
					setCel: 1
					setLoop: (targetBull3 loop:)
					posn: (targetBull3 x:) (targetBull3 y:)
					setPri: 470
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBack4
					view: 3331
					setCel: 1
					setLoop: (targetBull4 loop:)
					posn: (targetBull4 x:) (targetBull4 y:)
					setPri: 470
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBack5
					view: 3331
					setCel: 1
					setLoop: (targetBull5 loop:)
					posn: (targetBull5 x:) (targetBull5 y:)
					setPri: 470
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBack6
					view: 3331
					setCel: 1
					setLoop: (targetBull6 loop:)
					posn: (targetBull6 x:) (targetBull6 y:)
					setPri: 470
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBack7
					view: 3331
					setCel: 1
					setLoop: (targetBull7 loop:)
					posn: (targetBull7 x:) (targetBull7 y:)
					setPri: 470
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBack8
					view: 3331
					setCel: 1
					setLoop: (targetBull8 loop:)
					posn: (targetBull8 x:) (targetBull8 y:)
					setPri: 470
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(targetBack9
					view: 3331
					setCel: 1
					setLoop: (targetBull9 loop:)
					posn: (targetBull9 x:) (targetBull9 y:)
					setPri: 470
					init: ((snipePlane casts:) at: 0) gFtrInitializer
				)
				(= local30 targetBull1)
				(= local20 (List new:))
				(= local21 0)
				(qualProd setReal: qualProd 6)
				(ClearFlag 287)
				(SetFlag 286)
				(= global432 myTalkerStopCheck)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hitNineShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(qualProd dispose: delete:)
				(if (== (++ local21) 9)
					(local20 dispose:)
					(SetFlag 24)
					(gEgo awardMedal: 256)
					(= local43 1)
					(gCurRoom newRoom: 320)
				else
					(gMessager say: 0 0 88 0 self 320) ; "Spotter confirms hit dead on. Qualification continues."
				)
			)
			(1
				(gMessager say: 0 0 89 0 self 320) ; "Reload if necessary and fire at will."
			)
			(2
				(= local20 (List new:))
				(qualProd setReal: qualProd 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hitZero of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local3 local1)
				(= local4 local2)
				(= global432 0)
				(= seconds 2)
			)
			(1
				(gMessager say: 0 0 26 0 self 320) ; "Spotter confirming bullseye. Good shooting!"
			)
			(2
				(if local24
					(reloadTimer dispose: delete:)
					(Palette 2 42 254 0) ; PalIntensity
					(FrameOut)
					(gTheDoits delete: (snipePlane dispose: yourself:))
					(SetFlag 53)
					(= local44 1)
					(SetFlag 299)
					((ScriptID 45 0) ; dopeBook
						update:
							global412
							local6
							local7
							(GetTime 1) ; SysTime12
							(GetTime 3) ; SysDate
							local5
							local1
							local3
							local2
							local4
							local40
							local41
					)
					(= local28 0)
					(= global437 local2)
					(= global438 local1)
					(drillManager doit:)
					(= global432 myTalkerStopCheck)
					(gGame handsOn:)
					(self dispose:)
				else
					(= local24 1)
					(gMessager say: 0 0 12 0 self 320) ; "Very good. Now reload and let's try once again."
				)
			)
			(3
				(= global432 myTalkerStopCheck)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance missZero of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(if
					(not
						(and
							(< -202 (snipePlane left:) -196)
							(< -185 (snipePlane top:) -179)
						)
					)
					(gMessager say: 0 0 8 0 self 320) ; "Target missed completely. Given your current BDC and windage settings, the problem would appear to be with the shooter and not the current adjustments. Please reload and try again. This time, place your cross hairs in the center of the target."
				else
					(= cycles 1)
				)
			)
			(2
				(if
					(not
						(and
							(< -202 (snipePlane left:) -196)
							(< -185 (snipePlane top:) -179)
						)
					)
					(gGame handsOn:)
					(self dispose:)
				else
					(switch (Abs local22)
						(0
							(= cycles 1)
						)
						(1
							(if (< 0 local22)
								(gMessager say: 0 0 15 11 self 320) ; "You must click your windage one more time to the right."
							else
								(gMessager say: 0 0 103 11 self 320) ; "You must click your windage one more time to the left."
							)
						)
						(2
							(if (< 0 local22)
								(gMessager say: 0 0 15 10 self 320) ; "You must click your windage two more times to the right."
							else
								(gMessager say: 0 0 103 10 self 320) ; "You must click your windage two more times to the left."
							)
						)
						(3
							(if (< 0 local22)
								(gMessager say: 0 0 15 9 self 320) ; "You must click your windage three more times to the right."
							else
								(gMessager say: 0 0 103 9 self 320) ; "You must click your windage three more times to the left."
							)
						)
						(4
							(if (< 0 local22)
								(gMessager say: 0 0 15 8 self 320) ; "You must click your windage four more times to the right."
							else
								(gMessager say: 0 0 103 8 self 320) ; "You must click your windage four more times to the left."
							)
						)
						(5
							(if (< 0 local22)
								(gMessager say: 0 0 15 7 self 320) ; "You must click your windage five more times to the right."
							else
								(gMessager say: 0 0 103 7 self 320) ; "You must click your windage five more times to the left."
							)
						)
						(6
							(if (< 0 local22)
								(gMessager say: 0 0 15 6 self 320) ; "You must click your windage six more times to the right."
							else
								(gMessager say: 0 0 103 6 self 320) ; "You must click your windage six more times to the left."
							)
						)
						(7
							(if (< 0 local22)
								(gMessager say: 0 0 15 5 self 320) ; "You must click your windage seven more times to the right."
							else
								(gMessager say: 0 0 103 5 self 320) ; "You must click your windage seven more times to the left."
							)
						)
						(8
							(if (< 0 local22)
								(gMessager say: 0 0 15 4 self 320) ; "You must click your windage eight more times to the right."
							else
								(gMessager say: 0 0 103 4 self 320) ; "You must click your windage eight more times to the left."
							)
						)
						(9
							(if (< 0 local22)
								(gMessager say: 0 0 15 3 self 320) ; "You must click your windage nine more times to the right."
							else
								(gMessager say: 0 0 103 3 self 320) ; "You must click your windage nine more times to the left."
							)
						)
						(10
							(if (< 0 local22)
								(gMessager say: 0 0 15 2 self 320) ; "You must click your windage ten more times to the right."
							else
								(gMessager say: 0 0 103 2 self 320) ; "You must click your windage ten more times to the left."
							)
						)
						(11
							(if (< 0 local22)
								(gMessager say: 0 0 15 1 self 320) ; "You must click your windage eleven more times to the right."
							else
								(gMessager say: 0 0 103 1 self 320) ; "You must click your windage eleven more times to the left."
							)
						)
						(else
							(gMessager say: 0 0 99 0 self 320) ; "Your shot could be off due to windage. Check your setting."
						)
					)
				)
			)
			(3
				(switch (Abs local23)
					(0
						(= cycles 1)
					)
					(1
						(if (< 0 local23)
							(gMessager say: 0 0 14 7 self 320) ; "You must click your BDC up one more time."
						else
							(gMessager say: 0 0 104 7 self 320) ; "You must click your BDC down one more time."
						)
					)
					(2
						(if (< 0 local23)
							(gMessager say: 0 0 14 6 self 320) ; "You must click your BDC up two more times."
						else
							(gMessager say: 0 0 104 6 self 320) ; "You must click your BDC down two more times."
						)
					)
					(3
						(if (< 0 local23)
							(gMessager say: 0 0 14 5 self 320) ; "You must click your BDC up three more times."
						else
							(gMessager say: 0 0 104 5 self 320) ; "You must click your BDC down three more times."
						)
					)
					(4
						(if (< 0 local23)
							(gMessager say: 0 0 14 4 self 320) ; "You must click your BDC up four more times."
						else
							(gMessager say: 0 0 104 4 self 320) ; "You must click your BDC down four more times."
						)
					)
					(5
						(if (< 0 local23)
							(gMessager say: 0 0 14 3 self 320) ; "You must click your BDC up five more times."
						else
							(gMessager say: 0 0 104 3 self 320) ; "You must click your BDC down five more times."
						)
					)
					(6
						(if (< 0 local23)
							(gMessager say: 0 0 14 2 self 320) ; "You must click your BDC up six more times."
						else
							(gMessager say: 0 0 104 2 self 320) ; "You must click your BDC down six more times."
						)
					)
					(7
						(if (< 0 local23)
							(gMessager say: 0 0 14 1 self 320) ; "You must click your BDC up seven more times."
						else
							(gMessager say: 0 0 104 1 self 320) ; "You must click your BDC down seven more times."
						)
					)
					(else
						(gMessager say: 0 0 100 0 self 320) ; "It looks like you miscalcuated your shot. Check your BDC setting."
					)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hitDrill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
				(= global432 0)
			)
			(1
				(cond
					((== local25 2)
						(cond
							((== local30 redBallon)
								(gMessager say: 0 0 41 0 self 320) ; "Spotter confirming called red balloon hit."
							)
							((== local30 greenBallon)
								(gMessager say: 0 0 42 0 self 320) ; "Spotter confirming called green balloon hit."
							)
							((== local30 blueBallon)
								(gMessager say: 0 0 43 0 self 320) ; "Spotter confirming called blue balloon hit."
							)
						)
					)
					(local32
						(gMessager say: 0 0 47 0 self 320) ; "Spotter confirming called head strike."
					)
					(local33
						(gMessager say: 0 0 49 0 self 320) ; "Spotter confirming called body strike."
					)
					(else
						(gMessager say: 0 0 35 0 self 320) ; "Spotter confirming center hit. Hit is within target."
					)
				)
			)
			(2
				(= global432 myTalkerStopCheck)
				(++ local21)
				(switch local25
					(0
						(if (== local21 5)
							(SetFlag 79)
							(= local43 1)
							(gCurRoom newRoom: 320)
						else
							(gGame handsOn:)
							(self dispose:)
						)
					)
					(1
						(if (== local21 9)
							(SetFlag 79)
							(= local43 1)
							(gCurRoom newRoom: 320)
						else
							(gGame handsOn:)
							(self dispose:)
						)
					)
					(else
						(if local29
							(SetFlag 79)
							(= local43 1)
							(gCurRoom newRoom: 320)
						else
							(callTarget init:)
							(gGame handsOn:)
							(self dispose:)
						)
					)
				)
			)
		)
	)
)

(instance missDrill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(if (== local25 2)
					(if
						(or
							(redBallon onMe: (local19 x:) (local19 y:))
							(greenBallon onMe: (local19 x:) (local19 y:))
							(blueBallon onMe: (local19 x:) (local19 y:))
						)
						(gMessager say: 0 0 45 0 self 320) ; "Spotter confirming hit. Wrong color."
					else
						(gMessager say: 0 0 44 0 self 320) ; "Spotter confirming missed call."
					)
				else
					(if (== local25 3)
						(callTarget init:)
					)
					(gMessager say: 0 0 36 0 self 320) ; "Spotter confirming miss."
				)
			)
			(2
				(if local29
					(SetFlag 79)
					(= local43 1)
					(gCurRoom newRoom: 320)
				else
					(if (== local25 2)
						(callTarget init:)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance windChanger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local36 (windFlag loop:))
				(= local38 (windFlag view:))
				(= local6 (Random 1 5))
				(while (== local45 local7)
					(= local7 (Random 1 12))
				)
				(switch local7
					(1
						(= local39 3250)
					)
					(2
						(= local39 3251)
					)
					(3
						(= local39 3252)
					)
					(4
						(= local39 3257)
					)
					(5
						(= local39 3258)
					)
					(6
						(= local39 3261)
					)
					(7
						(= local39 3250)
					)
					(8
						(= local39 3251)
					)
					(9
						(= local39 3252)
					)
					(10
						(= local39 3257)
					)
					(11
						(= local39 3258)
					)
					(12
						(= local39 3259)
					)
				)
				(switch local6
					(6
						(= local6 20)
						(if (> local7 6)
							(= local37 0)
						else
							(= local37 1)
						)
					)
					(5
						(= local6 15)
						(if (> local7 6)
							(= local37 2)
						else
							(= local37 3)
						)
					)
					(4
						(= local6 10)
						(if (> local7 6)
							(= local37 4)
						else
							(= local37 5)
						)
					)
					(3
						(= local6 8)
						(if (> local7 6)
							(= local37 4)
						else
							(= local37 5)
						)
					)
					(2
						(= local6 5)
						(if (> local7 6)
							(= local37 6)
						else
							(= local37 7)
						)
					)
					(1
						(= local6 3)
						(if (> local7 6)
							(= local37 8)
						else
							(= local37 9)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(if (> local37 local36)
					(if
						(or
							(and (mod local37 2) (not (mod local36 2)))
							(and (not (mod local37 2)) (mod local36 2))
						)
						(++ local36)
					else
						(+= local36 2)
					)
				)
				(if (< local37 local36)
					(if
						(or
							(and (mod local37 2) (not (mod local36 2)))
							(and (not (mod local37 2)) (mod local36 2))
						)
						(-- local36)
					else
						(-= local36 2)
					)
				)
				(if (> local39 local38)
					(cond
						((== local38 3259)
							(= local38 3261)
						)
						((== local38 3252)
							(= local38 3257)
						)
						(else
							(++ local38)
						)
					)
				)
				(if (< local39 local38)
					(cond
						((== local38 3261)
							(= local38 3259)
						)
						((== local38 3257)
							(= local38 3252)
						)
						(else
							(-- local38)
						)
					)
				)
				(windFlag view: local38 setLoop: local36 setCycle: Fwd)
				(= cycles 65)
			)
			(2
				(if (or (!= local36 local37) (!= local38 local39))
					(-= state 2)
				)
				(self changeState: (+ state 1) &rest)
			)
			(3
				(= local45 local7)
				(windTimer setReal: windTimer (Random 60 180))
				(self dispose:)
			)
		)
	)
)

(instance showCallTarget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global432 0)
				(callTarget init:)
				(if (== local25 2)
					(gMessager say: 0 0 40 0 self 320) ; "Time has elapsed! New call required!"
				else
					(gMessager say: 0 0 62 0 self 320) ; "Human silhouette up! Call out area to be hit. No strike results in new call. Miss results in new call."
				)
			)
			(1
				(= global432 myTalkerStopCheck)
				(= local30 0)
				(self dispose:)
			)
		)
	)
)

(instance leaveBeforeZero of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 0 21 0 self 320) ; "You're leaving now? You haven't shot your cold barrel shot. But I guess if you have to..."
			)
			(1
				(= local43 1)
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance leaveDuringDrill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 0 74 0 self 320) ; "I'll see you later, partner. Next time try to stay for the entire drill."
			)
			(1
				(= local43 1)
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance sideDial of Prop
	(properties
		x 428
		y 205
		view 3305
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setCel: global446)
	)

	(method (dispose)
		(= global446 cel)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(if (> (event y:) (- y 58))
				(= scratch 1)
			else
				(= scratch 0)
			)
		)
		(super handleEvent: event)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((or (& signal $0008) (not local12)) 0)
				((not onMeCheck)
					(IsOnMe temp0 temp1 self (& signal $1000))
				)
				(else
					(super onMe: temp0 temp1)
				)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(29
				(if (and (== local28 0) (not (IsFlag 53)))
					(gMessager say: 0 0 11 0 0 320) ; "Hold on. You need to shoot at your current settings to determine where you are in relation to your zero. You adjust after you shoot."
				else
					(= temp0 cel)
					(if local12
						(cond
							(scratch
								(if
									(and
										(< (snipePlane left:) 166)
										(!= temp0 (self lastCel:))
									)
									(++ local2)
									(++ global448)
									(if (== temp0 (self lastCel:))
										(= temp0 0)
									else
										(++ temp0)
									)
									(self setCel: temp0)
									(snipePlane
										setRect:
											(+ (snipePlane left:) local15)
											(snipePlane top:)
											(+ (snipePlane right:) local15)
											(snipePlane bottom:)
											1
									)
								)
							)
							((and (> (snipePlane right:) 436) (!= temp0 0))
								(-- local2)
								(-- global448)
								(if (== temp0 0)
									(= temp0 (self lastCel:))
								else
									(-- temp0)
								)
								(self setCel: temp0)
								(snipePlane
									setRect:
										(- (snipePlane left:) local15)
										(snipePlane top:)
										(- (snipePlane right:) local15)
										(snipePlane bottom:)
										1
								)
							)
						)
					)
				)
			)
			(6
				(gMessager say: 12 6 0 0 0 320) ; "Put that handgun away! Long rifle training is in progress! Do it NOW!"
			)
			(else
				(gMessager say: 12 0 0 0 0 320) ; "What are you doing?! Knock that crap off!"
			)
		)
	)
)

(instance topDial of Prop
	(properties
		x 256
		y 56
		view 3305
	)

	(method (init)
		(super init: &rest)
		(self setCel: global445)
	)

	(method (dispose)
		(= global445 cel)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(if (< (event x:) (+ x 44))
				(= scratch 1)
			else
				(= scratch 0)
			)
			(super handleEvent: event)
		else
			(event claimed: 0)
			(return)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((or (& signal $0008) (not local12)) 0)
				((not onMeCheck)
					(IsOnMe temp0 temp1 self (& signal $1000))
				)
				(else
					(super onMe: temp0 temp1)
				)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(29
				(if (and (== local28 0) (not (IsFlag 53)))
					(gMessager say: 0 0 11 0 0 320) ; "Hold on. You need to shoot at your current settings to determine where you are in relation to your zero. You adjust after you shoot."
				else
					(= temp0 cel)
					(if local12
						(cond
							(scratch
								(if
									(and
										(< (snipePlane top:) 17)
										(!= temp0 (self lastCel:))
									)
									(++ local1)
									(++ global447)
									(if (== temp0 (self lastCel:))
										(= temp0 0)
									else
										(++ temp0)
									)
									(self setCel: temp0)
									(snipePlane
										setRect:
											(snipePlane left:)
											(+ (snipePlane top:) local16)
											(snipePlane right:)
											(+ (snipePlane bottom:) local16)
											1
									)
								)
							)
							((and (> (snipePlane bottom:) 332) (!= temp0 0))
								(-- local1)
								(-- global447)
								(if (== temp0 0)
									(= temp0 (self lastCel:))
								else
									(-- temp0)
								)
								(self setCel: temp0)
								(snipePlane
									setRect:
										(snipePlane left:)
										(- (snipePlane top:) local16)
										(snipePlane right:)
										(- (snipePlane bottom:) local16)
										1
								)
							)
						)
					)
				)
			)
			(6
				(gMessager say: 12 6 0 0 0 320) ; "Put that handgun away! Long rifle training is in progress! Do it NOW!"
			)
			(else
				(gMessager say: 12 0 0 0 0 320) ; "What are you doing?! Knock that crap off!"
			)
		)
	)
)

(instance bolt of Prop
	(properties
		x 239
		y 387
		view 3307
		loop 1
		cycleSpeed 2
	)

	(method (init)
		(super init: &rest)
		(if local14
			(self setCel: (self lastCel:))
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((or (& signal $0008) (not local12)) 0)
				((not onMeCheck)
					(IsOnMe temp0 temp1 self (& signal $1000))
				)
				(else
					(super onMe: temp0 temp1)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (not local14)
					(self setScript: ejectBullet)
				else
					(shotSound number: 47 setLoop: 0 play:)
				)
			)
			(6
				(gMessager say: 12 6 0 0 0 320) ; "Put that handgun away! Long rifle training is in progress! Do it NOW!"
			)
			(else
				(gMessager say: 12 0 0 0 0 320) ; "What are you doing?! Knock that crap off!"
			)
		)
	)
)

(instance bulletHole of Prop
	(properties
		view 3302
	)

	(method (init)
		(super init: &rest)
		(self setPri: 480)
	)

	(method (onMe)
		(return 0)
	)
)

(instance redBallon of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(SetNowSeen self)
	)
)

(instance redShade of Prop
	(properties)
)

(instance blueBallon of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(SetNowSeen self)
	)
)

(instance blueShade of Prop
	(properties)
)

(instance greenBallon of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(SetNowSeen self)
	)
)

(instance greenShade of Prop
	(properties)
)

(instance redTarg of Prop
	(properties
		x 10
		y 90
		view 3262
		cel 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 300)
	)

	(method (doVerb)
		(gMessager say: 4 29 0 0 0 320) ; "Red!"
		(= local30 redBallon)
		(ballonTimer setReal: ballonTimer 5)
		(callTarget dispose:)
	)
)

(instance blueTarg of Prop
	(properties
		x 45
		y 90
		view 3262
	)

	(method (init)
		(super init: &rest)
		(self setPri: 300)
	)

	(method (doVerb)
		(gMessager say: 2 29 0 0 0 320) ; "Blue!"
		(= local30 blueBallon)
		(ballonTimer setReal: ballonTimer 5)
		(callTarget dispose:)
	)
)

(instance greenTarg of Prop
	(properties
		x 80
		y 90
		view 3262
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 300)
	)

	(method (doVerb)
		(gMessager say: 3 29 0 0 0 320) ; "Green!"
		(= local30 greenBallon)
		(ballonTimer setReal: ballonTimer 5)
		(callTarget dispose:)
	)
)

(instance windWindow of View
	(properties
		x 514
		y 3
		view 3260
	)

	(method (handleEvent))

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance windFlag of Prop
	(properties
		x 578
		y 76
		view 3250
		loop 5
	)

	(method (handleEvent))

	(method (init)
		(if (or (not (IsFlag 53)) (IsFlag 23))
			(= view 3250)
			(= local7 7)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance theBlast of View
	(properties
		x 212
		y 222
		view 1503
	)

	(method (init)
		(+= x (- (gThePlane left:) (snipePlane left:)))
		(+= y (- (gThePlane top:) (snipePlane top:)))
		(super init: &rest)
		(self setPri: 1001)
	)

	(method (dispose)
		(= x 212)
		(= y 222)
		(super dispose: &rest)
	)
)

(instance target1 of View
	(properties
		view 3329
	)
)

(instance targetBack1 of View
	(properties
		view 3329
	)
)

(instance targetBack2 of View
	(properties)
)

(instance targetBack3 of View
	(properties)
)

(instance targetBack4 of View
	(properties)
)

(instance targetBack5 of View
	(properties)
)

(instance targetBack6 of View
	(properties)
)

(instance targetBack7 of View
	(properties)
)

(instance targetBack8 of View
	(properties)
)

(instance targetBack9 of View
	(properties)
)

(instance targetBull1 of View
	(properties
		view 3329
	)

	(method (init)
		(super init: &rest)
		(SetNowSeen self)
	)
)

(instance targetBull2 of View
	(properties)

	(method (init)
		(super init: &rest)
		(SetNowSeen self)
	)
)

(instance targetBull3 of View
	(properties)

	(method (init)
		(super init: &rest)
		(SetNowSeen self)
	)
)

(instance targetBull4 of View
	(properties)

	(method (init)
		(super init: &rest)
		(SetNowSeen self)
	)
)

(instance targetBull5 of View
	(properties)

	(method (init)
		(super init: &rest)
		(SetNowSeen self)
	)
)

(instance targetBull6 of View
	(properties)

	(method (init)
		(super init: &rest)
		(SetNowSeen self)
	)
)

(instance targetBull7 of View
	(properties)

	(method (init)
		(super init: &rest)
		(SetNowSeen self)
	)
)

(instance targetBull8 of View
	(properties)

	(method (init)
		(super init: &rest)
		(SetNowSeen self)
	)
)

(instance targetBull9 of View
	(properties)

	(method (init)
		(super init: &rest)
		(SetNowSeen self)
	)
)

(instance backGround of View
	(properties
		x 455
		y 430
		view 3320
	)

	(method (init)
		(self setPri: 100)
		(switch local5
			(25
				(self posn: 290 540)
			)
			(50
				(self posn: 445 450)
			)
			(75
				(self posn: 455 475)
			)
			(200
				(self posn: 492 525)
			)
			(250
				(self posn: 498 561)
			)
			(300
				(self posn: 524 585)
			)
			(400
				(self posn: 553 490)
			)
			(500
				(self posn: 497 433)
			)
		)
		(super init: &rest)
		(SetNowSeen self)
	)
)

(instance callTarget of View
	(properties
		x 5
		y 160
		view 3302
		loop 1
	)

	(method (init)
		(super init: &rest)
		(= local30 0)
		(if (== local25 2)
			(if (!= (redBallon cel:) 5)
				(redTarg init:)
			)
			(if (!= (blueBallon cel:) 5)
				(blueTarg init:)
			)
			(if (!= (greenBallon cel:) 5)
				(greenTarg init:)
			)
		)
	)

	(method (handleEvent event)
		(if (and (!= local25 2) (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(if (< (event y:) (- y 131))
				(= local35 0)
				(= local34 1)
			else
				(= local34 0)
				(= local35 1)
			)
			(super handleEvent: event)
		else
			(event claimed: 0)
			(return)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((or (& signal $0008) (== local25 2) (not local12)) 0)
				((not onMeCheck)
					(IsOnMe temp0 temp1 self (& signal $1000))
				)
				(else
					(super onMe: temp0 temp1)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(cond
					((!= local25 3)
						(Prints
							{Error callTarget thinks your shooting at shilouette.}
						)
					)
					(local34
						(= local30 headFeature)
						(gMessager say: 5 29 0 0 0 320) ; "Head!"
						(ballonTimer setReal: ballonTimer 5)
						(self dispose:)
					)
					(else
						(= local30 bodyFeature)
						(gMessager say: 7 29 0 0 0 320) ; "Body mass!"
						(ballonTimer setReal: ballonTimer 5)
						(self dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(if (== local25 2)
			(redTarg dispose:)
			(blueTarg dispose:)
			(greenTarg dispose:)
		)
		(super dispose: &rest)
	)
)

(instance trigger of Feature
	(properties
		y 480
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 262 359 285 291 348 291 372 359
					yourself:
				)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((not local12) 0)
				((not onMeCheck)
					(if
						(or
							(not (or nsLeft nsRight nsTop nsBottom))
							(and
								(<= nsLeft temp0 nsRight)
								(<= nsTop temp1 nsBottom)
							)
						)
						1
					else
						0
					)
				)
				((onMeCheck isKindOf: List)
					(onMeCheck firstTrue: #onMe temp0 temp1)
				)
				(else
					(onMeCheck onMe: temp0 temp1)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27
				(if local14
					(reloadTimer dispose: delete:)
					(bolt setScript: reloadBullet)
				else
					(gMessager say: 0 0 109 0 0 320) ; "Your weapon is already loaded."
				)
			)
			(29
				(if (OneOf (gCurRoom script:) hitZero hitDrill missDrill)
					(return)
				)
				(if
					(and
						(OneOf local25 2 3)
						(gCast contains: callTarget)
						(not local30)
					)
					(if (== local25 2)
						(gMessager say: 0 0 40 0 0 320) ; "Time has elapsed! New call required!"
					else
						(gMessager say: 0 0 62 0 0 320) ; "Human silhouette up! Call out area to be hit. No strike results in new call. Miss results in new call."
					)
					(return)
				)
				(if local14
					(gFxSound number: 47 setLoop: 0 play:)
				else
					(if gTalkers
						(gTalkers eachElementDo: #dispose)
					)
					(bolt setScript: ejectBullet)
					(= local27 0)
					(shootTimer dispose: delete:)
					(ballonTimer dispose: delete:)
					(if local12
						((= local19 (bulletHole new:))
							x: (+ 319 (- (gThePlane left:) (snipePlane left:)))
							y: (+ 179 (- (gThePlane top:) (snipePlane top:)))
						)
						(local19 x: (adjustForWind doit: (local19 x:)))
						(local19 y: (adjustForDistance doit: (local19 y:)))
						(local19
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setLoop: 3
							setCel: 0
							setPri: 601
						)
						(if (IsFlag 23)
							(local20 add: local19)
						)
						(UpdateScreenItem local19)
						(theBlast init: ((snipePlane casts:) at: 0))
						(UpdateScreenItem theBlast)
						(FrameOut)
						(DoAudio 18 1) ; AudDACCritical
						(shotSound number: 45 setLoop: 0 play:)
						(DoAudio 18 0) ; AudDACCritical
						(if
							(and
								(not (mod global412 10))
								(not (IsFlag 23))
								(IsFlag 53)
							)
							(gCurRoom setScript: drillOver)
						)
						(shotManager doit:)
					)
				)
			)
			(6
				(gMessager say: 12 6 0 0 0 320) ; "Put that handgun away! Long rifle training is in progress! Do it NOW!"
			)
			(else
				(gMessager say: 12 0 0 0 0 320) ; "What are you doing?! Knock that crap off!"
			)
		)
	)
)

(instance cardBoard of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 422 240 421 561 430 561 429 541 591 541 592 560 600 559 600 240
					yourself:
				)
		)
	)
)

(instance focusDial of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 143 102 149 102 152 92 164 92 167 102 195 103 195 200 172 200 172 202 168 203 164 210 152 210 147 202 143 202
					yourself:
				)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return
			(cond
				((not local12) 0)
				((not onMeCheck)
					(if
						(or
							(not (or nsLeft nsRight nsTop nsBottom))
							(and
								(<= nsLeft temp0 nsRight)
								(<= nsTop temp1 nsBottom)
							)
						)
						1
					else
						0
					)
				)
				((onMeCheck isKindOf: List)
					(onMeCheck firstTrue: #onMe temp0 temp1)
				)
				(else
					(onMeCheck onMe: temp0 temp1)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gMessager say: 8 29 72 0 0 320) ; "If your sight picture is clear, no adjustment to focus is necessary."
			)
			(6
				(gMessager say: 12 6 0 0 0 320) ; "Put that handgun away! Long rifle training is in progress! Do it NOW!"
			)
			(else
				(gMessager say: 12 0 0 0 0 320) ; "What are you doing?! Knock that crap off!"
			)
		)
	)
)

(instance headFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(switch local5
			(500
				(self
					nsTop: 401
					nsLeft: 504
					nsBottom: 406
					nsRight: 510
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 504 406 510 405 510 401 505 401
							yourself:
						)
				)
			)
			(400
				(self
					nsTop: 452
					nsLeft: 562
					nsBottom: 459
					nsRight: 570
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 562 459 570 458 570 452 562 452
							yourself:
						)
				)
			)
			(300
				(self
					nsTop: 534
					nsLeft: 536
					nsBottom: 541
					nsRight: 546
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 536 541 546 541 546 534 537 534
							yourself:
						)
				)
			)
			(250
				(self
					nsTop: 498
					nsLeft: 515
					nsBottom: 506
					nsRight: 526
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 515 506 526 506 526 498 515 498
							yourself:
						)
				)
			)
			(200
				(self
					nsTop: 450
					nsLeft: 512
					nsBottom: 459
					nsRight: 528
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 512 459 528 459 528 450 513 450
							yourself:
						)
				)
			)
			(100
				(self nsTop: 282 nsLeft: 498 nsBottom: 301 nsRight: 525)
			)
		)
	)
)

(instance bodyFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(switch local5
			(500
				(self
					nsTop: 406
					nsLeft: 496
					nsBottom: 432
					nsRight: 519
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 497 409 499 406 515 406 519 409 518 429 514 432 500 432 496 428
							yourself:
						)
				)
			)
			(400
				(self
					nsTop: 462
					nsLeft: 552
					nsBottom: 490
					nsRight: 581
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 555 459 577 458 581 462 581 484 574 490 558 489 552 484 553 462
							yourself:
						)
				)
			)
			(300
				(self
					nsTop: 542
					nsLeft: 524
					nsBottom: 585
					nsRight: 560
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 528 542 554 542 559 546 560 578 553 584 531 585 524 579 524 545
							yourself:
						)
				)
			)
			(250
				(self
					nsTop: 459
					nsLeft: 492
					nsBottom: 524
					nsRight: 547
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 502 507 539 507 545 513 544 553 535 561 505 560 498 553 498 513
							yourself:
						)
				)
			)
			(200
				(self
					nsTop: 459
					nsLeft: 492
					nsBottom: 524
					nsRight: 547
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 496 459 544 459 547 464 547 517 541 524 498 524 492 518 493 465
							yourself:
						)
				)
			)
			(100
				(self nsTop: 301 nsLeft: 458 nsBottom: 427 nsRight: 565)
			)
		)
	)
)

(instance shootTimer of Timer
	(properties)

	(method (cue)
		(if (gTalkers size:)
			(self setReal: self 5)
		else
			(gCurRoom setScript: prodPlayer)
			(self dispose: delete:)
		)
	)
)

(instance qualProd of Timer
	(properties)

	(method (cue)
		(if (gTalkers size:)
			(self setReal: self 5)
		else
			(gCurRoom setScript: tellToShoot)
			(self dispose: delete:)
		)
	)
)

(instance reloadTimer of Timer
	(properties)

	(method (cue)
		(cond
			((gTalkers size:)
				(self setReal: self 5)
			)
			(local14
				(gCurRoom setScript: instructToReload)
				(self dispose: delete:)
			)
			(else
				(self dispose: delete:)
			)
		)
	)
)

(instance windTimer of Timer
	(properties)

	(method (cue)
		(if (gCurRoom script:)
			(self setReal: self (Random 20 30))
		else
			(gCurRoom setScript: windChanger)
			(self dispose: delete:)
		)
	)
)

(instance ballonTimer of Timer
	(properties)

	(method (cue)
		(if (gTalkers size:)
			(self setReal: self 5)
		else
			(gCurRoom setScript: showCallTarget)
			(self dispose: delete:)
		)
	)
)

(instance snipePlane of Plane
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(if local26
			(-- local26)
			(return)
		)
		(if (and local13 (not local12))
			(= temp2 0)
			(= temp0 (- local10 gMouseX))
			(= temp1 (- local11 gMouseY))
			(cond
				((< local10 gMouseX)
					(= temp2 1)
					(self
						setRect:
							(- left (Abs temp0))
							top
							(- right (Abs temp0))
							bottom
					)
				)
				((> local10 gMouseX)
					(= temp2 1)
					(self
						setRect:
							(+ left (Abs temp0))
							top
							(+ right (Abs temp0))
							bottom
					)
				)
			)
			(cond
				((< local11 gMouseY)
					(= temp2 1)
					(self
						setRect:
							left
							(- top (Abs temp1))
							right
							(- bottom (Abs temp1))
					)
				)
				((> local11 gMouseY)
					(= temp2 1)
					(self
						setRect:
							left
							(+ top (Abs temp1))
							right
							(+ bottom (Abs temp1))
					)
				)
			)
			(if temp2
				(= local10 gMouseX)
				(= local11 gMouseY)
				(UpdatePlane self)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance shotSound of Sound
	(properties)
)

(instance adjustForWind of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 (= temp0 0))
		(if (mod local7 3)
			(= temp2 1)
		)
		(= temp1 0)
		(if (or (OneOf local7 6 12) (< local5 100) (< local6 5))
			(return (+ param1 (* global448 local15)))
		)
		(if (>= local5 100)
			(= temp0 (/ (* (/ local5 100) local6) 15))
			(if temp2
				(= temp3 (* temp0 3))
			else
				(= temp3 (* temp0 4))
			)
			(if (>= global448 0)
				(= temp0 (* (- (+ temp3 2) global448) local15))
			else
				(= temp0 (* (+ temp3 2 global448) local15))
			)
		)
		(return
			(if (OneOf local7 1 2 3 4 5)
				(+ param1 temp0)
			else
				(- param1 temp0)
			)
		)
	)
)

(instance adjustForDistance of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= temp1 0)
		(switch local5
			(100
				(return (+ param1 4 global447))
			)
			(200
				(if (>= global447 0)
					(return (+ param1 (* (- 13 global447) local16)))
				else
					(return (+ param1 (* (+ 13 global447) local16)))
				)
			)
			(250
				(if (>= global447 0)
					(return (+ param1 (* (- 14 global447) local16)))
				else
					(return (+ param1 (* (+ 14 global447) local16)))
				)
			)
			(300
				(if (>= global447 0)
					(return (+ param1 (* (- 16 global447) local16)))
				else
					(return (+ param1 (* (+ 16 global447) local16)))
				)
			)
			(400
				(if (>= global447 0)
					(return (+ param1 (* (- 18 global447) local16)))
				else
					(return (+ param1 (* (+ 18 global447) local16)))
				)
			)
			(500
				(if (>= global447 0)
					(return (+ param1 (* (- 20 global447) local16)))
				else
					(return (+ param1 (* (+ 20 global447) local16)))
				)
			)
			(else
				(return (+ param1 temp1))
			)
		)
	)
)

(instance shotManager of Code
	(properties)

	(method (doit)
		(++ local28)
		(if (and (not (IsFlag 23)) (== local28 10))
			(= local29 1)
		)
		(= local32 0)
		(= local33 0)
		(if (backGround onMe: (local19 x:) (local19 y:))
			(= local42 1)
			(placeHole doit: (local19 x:) (local19 y:))
		else
			(= local40 0)
			(= local41 0)
			(= local42 0)
		)
		(if (and (not (IsFlag 23)) (IsFlag 53))
			(if (not local30)
				(PrintDebug {no target})
			else
				(if (< (local19 x:) (local30 nsLeft:))
					(= local4 (/ (- (local30 nsLeft:) (local19 x:)) local15))
				)
				(if (> (local19 x:) (local30 nsRight:))
					(= local4 (/ (- (local30 nsRight:) (local19 x:)) local15))
				)
				(if (< (local19 y:) (local30 nsTop:))
					(= local3 (/ (- (local30 nsTop:) (local19 y:)) local16))
				)
				(if (> (local19 y:) (local30 nsBottom:))
					(= local3 (/ (- (local30 nsBottom:) (local19 y:)) local16))
				)
				((ScriptID 45 0) ; dopeBook
					update:
						global412
						local6
						local7
						(GetTime 1) ; SysTime12
						(GetTime 3) ; SysDate
						local5
						local1
						local3
						local2
						local4
						local40
						local41
				)
			)
		)
		(switch local25
			(0
				(if (targetBull1 onMe: (local19 x:) (local19 y:))
					(= local27 1)
				)
			)
			(1
				(switch local21
					(1
						(= local30 targetBull2)
					)
					(2
						(= local30 targetBull3)
					)
					(3
						(= local30 targetBull4)
					)
					(4
						(= local30 targetBull5)
					)
					(5
						(= local30 targetBull6)
					)
					(6
						(= local30 targetBull7)
					)
					(7
						(= local30 targetBull8)
					)
					(8
						(= local30 targetBull9)
					)
				)
				(if (local30 onMe: (local19 x:) (local19 y:))
					(= local27 1)
				)
			)
			(2
				(if (local30 onMe: (local19 x:) (local19 y:))
					(= local27 1)
				)
				(cond
					((redBallon onMe: (local19 x:) (local19 y:))
						(redBallon setCycle: 0 setCel: 5)
						(UpdateScreenItem redBallon)
						(gTheDoits delete: (redShade dispose: yourself:))
					)
					((greenBallon onMe: (local19 x:) (local19 y:))
						(greenBallon setCycle: 0 setCel: 5)
						(UpdateScreenItem greenBallon)
						(gTheDoits delete: (greenShade dispose: yourself:))
					)
					((blueBallon onMe: (local19 x:) (local19 y:))
						(blueBallon setCycle: 0 setCel: 5)
						(UpdateScreenItem blueBallon)
						(gTheDoits delete: (blueShade dispose: yourself:))
					)
				)
				(if
					(and
						(== (redBallon cel:) 5)
						(== (greenBallon cel:) 5)
						(== (blueBallon cel:) 5)
					)
					(= local29 1)
				)
			)
			(3
				(cond
					(
						(and
							(== local30 headFeature)
							(headFeature onMe: (local19 x:) (local19 y:))
						)
						(= local32 1)
					)
					(
						(and
							(== local30 bodyFeature)
							(bodyFeature onMe: (local19 x:) (local19 y:))
						)
						(= local33 1)
					)
				)
			)
			(else
				(Prints
					{Error: *shotManager* is confused. It doesn't know what drill you're shooting. Report immediately.}
				)
			)
		)
		(cond
			((IsFlag 23)
				(cond
					((IsFlag 81)
						(if
							(or
								(targetBull1 onMe: (local19 x:) (local19 y:))
								(targetBack1 onMe: (local19 x:) (local19 y:))
							)
							(gCurRoom setScript: hitColdBarrel)
						else
							(gCurRoom setScript: failedQual)
						)
					)
					((IsFlag 287)
						(if
							(or
								(targetBull1 onMe: (local19 x:) (local19 y:))
								(targetBack1 onMe: (local19 x:) (local19 y:))
							)
							(gCurRoom setScript: hitFiveGroup)
						else
							(gCurRoom setScript: failedQual)
						)
					)
					((IsFlag 286)
						(switch local21
							(1
								(= local30 targetBull2)
							)
							(2
								(= local30 targetBull3)
							)
							(3
								(= local30 targetBull4)
							)
							(4
								(= local30 targetBull5)
							)
							(5
								(= local30 targetBull6)
							)
							(6
								(= local30 targetBull7)
							)
							(7
								(= local30 targetBull8)
							)
							(8
								(= local30 targetBull9)
							)
						)
						(if (local30 onMe: (local19 x:) (local19 y:))
							(gCurRoom setScript: hitNineShot)
						else
							(gCurRoom setScript: failedQual)
						)
					)
					(else
						(Prints
							{Error: *shotManger* Qualification flag not set. If you teleported, this bug is invalid.}
						)
					)
				)
			)
			((not (IsFlag 53))
				(if
					(or
						(targetBull1 onMe: (local19 x:) (local19 y:))
						(targetBack1 onMe: (local19 x:) (local19 y:))
					)
					(gCurRoom setScript: hitZero)
				else
					(if (> (targetBull1 nsLeft:) (local19 x:))
						(= local22
							(/
								(- (+ (targetBull1 nsLeft:) 3) (local19 x:))
								local15
							)
						)
					else
						(= local22
							(/
								(- (- (targetBull1 nsRight:) 3) (local19 x:))
								local15
							)
						)
					)
					(if (> (targetBull1 nsTop:) (local19 y:))
						(= local23
							(/
								(- (+ (targetBull1 nsTop:) 3) (local19 y:))
								local16
							)
						)
					else
						(= local23
							(/
								(- (- (targetBull1 nsBottom:) 3) (local19 y:))
								local16
							)
						)
					)
					(gCurRoom setScript: missZero)
				)
			)
			((or local27 local32 local33)
				(gCurRoom setScript: hitDrill)
			)
			(else
				(gCurRoom setScript: missDrill)
			)
		)
		(theBlast dispose:)
	)
)

(instance drillManager of Code
	(properties)

	(method (doit)
		(cond
			((not (IsFlag 53))
				(= local5 100)
				(= local31 3302)
				(= local6 (Random 1 3))
				(= local16 (= local15 1))
			)
			((IsFlag 23)
				(= local5 100)
				(= local31 3302)
			)
			((== (= local25 (Random 0 3)) 3)
				(switch (Random 0 5)
					(0
						(= local5 500)
						(= local31 3325)
						(= local16 3)
						(= local15 3)
					)
					(1
						(= local5 400)
						(= local31 3324)
						(= local16 3)
						(= local15 3)
					)
					(2
						(= local5 300)
						(= local31 3323)
						(= local16 2)
						(= local15 2)
					)
					(3
						(= local5 250)
						(= local31 3322)
						(= local16 2)
						(= local15 2)
					)
					(4
						(= local5 200)
						(= local31 3321)
						(= local16 1)
						(= local15 1)
					)
					(5
						(= local5 100)
						(= local31 3302)
						(= local16 1)
						(= local15 1)
					)
				)
			)
			(else
				(switch (Random 0 3)
					(0
						(= local5 100)
						(= local31 3302)
					)
					(1
						(= local5 75)
						(= local31 3326)
					)
					(2
						(= local5 50)
						(= local31 3327)
					)
					(3
						(= local5 25)
						(= local31 3328)
					)
				)
			)
		)
		(= local18 (CelWide local31 0 0))
		(= local17 (CelHigh local31 0 0))
		(if (not local15)
			(= local16 (= local15 1))
		)
		(snipePlane
			priority: (- (gThePlane priority:) 3)
			init: 0 0 local18 local17
			setBitmap: local31 0 0
		)
		(snipePlane
			setRect:
				(- (/ (- local18 640) 2))
				(- (/ (- local17 480) 2))
				(- local18 (/ (- local18 640) 2))
				(- local17 (/ (- local17 480) 2))
				1
		)
		(gTheDoits add: snipePlane)
		(UpdatePlane gThePlane)
		(backGround
			view: local31
			setLoop: 1
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(Palette 2 42 254 100) ; PalIntensity
		(FrameOut)
		(cond
			((not (IsFlag 53))
				(gCurRoom setScript: firstTrain)
			)
			((IsFlag 23)
				(gCurRoom setScript: doQualification)
			)
			(else
				(windFlag setScript: windChanger)
				(switch local25
					(0
						(fiveShotDrillManager doit:)
					)
					(1
						(nineTargetDrillManager doit:)
					)
					(2
						(ballonDrillManager doit:)
					)
					(3
						(shilouetteDrillManager doit:)
					)
				)
			)
		)
	)
)

(instance fiveShotDrillManager of Code
	(properties)

	(method (doit)
		(= local30 targetBull1)
		(targetBull1
			view: 3331
			setCel: 0
			setLoop:
				(switch local5
					(100 0)
					(75 1)
					(50 2)
					(25 3)
				)
			x:
				(switch local5
					(100 504)
					(75 513)
					(50 548)
					(25 500)
				)
			y:
				(switch local5
					(100 350)
					(75 364)
					(50 284)
					(25 290)
				)
			setPri: 471
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBack1
			view: 3331
			setCel: 1
			setLoop: (targetBull1 loop:)
			posn: (targetBull1 x:) (targetBull1 y:)
			setPri: 470
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(gMessager say: 0 0 34 0 0 320) ; "OK, we have a two inch square target. You need to place five shots within the square. Go ahead and load your rifle. Remember... Check the direction and the speed of the wind and make any adjustments required."
	)
)

(instance nineTargetDrillManager of Code
	(properties)

	(method (doit)
		(targetBull1
			view: 3331
			setCel: 0
			setLoop:
				(switch local5
					(100 4)
					(75 5)
					(50 6)
					(25 7)
				)
			x:
				(switch local5
					(100 486)
					(75 496)
					(50 522)
					(25 450)
				)
			y:
				(switch local5
					(100 333)
					(75 333)
					(50 265)
					(25 223)
				)
			setPri: 471
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBull2
			view: 3331
			setCel: 0
			setLoop:
				(switch local5
					(100 4)
					(75 5)
					(50 6)
					(25 7)
				)
			x:
				(switch local5
					(100 506)
					(75 517)
					(50 552)
					(25 510)
				)
			y:
				(switch local5
					(100 333)
					(75 333)
					(50 265)
					(25 223)
				)
			setPri: 471
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBull3
			view: 3331
			setCel: 0
			setLoop:
				(switch local5
					(100 4)
					(75 5)
					(50 6)
					(25 7)
				)
			x:
				(switch local5
					(100 526)
					(75 538)
					(50 582)
					(25 570)
				)
			y:
				(switch local5
					(100 333)
					(75 333)
					(50 265)
					(25 223)
				)
			setPri: 471
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBull4
			view: 3331
			setCel: 0
			setLoop:
				(switch local5
					(100 4)
					(75 5)
					(50 6)
					(25 7)
				)
			x:
				(switch local5
					(100 486)
					(75 496)
					(50 522)
					(25 450)
				)
			y:
				(switch local5
					(100 349)
					(75 353)
					(50 299)
					(25 290)
				)
			setPri: 471
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBull5
			view: 3331
			setCel: 0
			setLoop:
				(switch local5
					(100 4)
					(75 5)
					(50 6)
					(25 7)
				)
			x:
				(switch local5
					(100 506)
					(75 517)
					(50 552)
					(25 510)
				)
			y:
				(switch local5
					(100 349)
					(75 353)
					(50 299)
					(25 290)
				)
			setPri: 471
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBull6
			view: 3331
			setCel: 0
			setLoop:
				(switch local5
					(100 4)
					(75 5)
					(50 6)
					(25 7)
				)
			x:
				(switch local5
					(100 526)
					(75 538)
					(50 582)
					(25 570)
				)
			y:
				(switch local5
					(100 349)
					(75 353)
					(50 299)
					(25 290)
				)
			setPri: 471
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBull7
			view: 3331
			setCel: 0
			setLoop:
				(switch local5
					(100 4)
					(75 5)
					(50 6)
					(25 7)
				)
			x:
				(switch local5
					(100 486)
					(75 496)
					(50 522)
					(25 450)
				)
			y:
				(switch local5
					(100 364)
					(75 373)
					(50 333)
					(25 357)
				)
			setPri: 471
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBull8
			view: 3331
			setCel: 0
			setLoop:
				(switch local5
					(100 4)
					(75 5)
					(50 6)
					(25 7)
				)
			x:
				(switch local5
					(100 506)
					(75 517)
					(50 552)
					(25 510)
				)
			y:
				(switch local5
					(100 364)
					(75 373)
					(50 333)
					(25 357)
				)
			setPri: 471
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBull9
			view: 3331
			setCel: 0
			setLoop:
				(switch local5
					(100 4)
					(75 5)
					(50 6)
					(25 7)
				)
			x:
				(switch local5
					(100 526)
					(75 538)
					(50 582)
					(25 570)
				)
			y:
				(switch local5
					(100 364)
					(75 373)
					(50 333)
					(25 357)
				)
			setPri: 471
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBack1
			view: 3331
			setCel: 1
			setLoop: (targetBull1 loop:)
			posn: (targetBull1 x:) (targetBull1 y:)
			setPri: 470
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBack2
			view: 3331
			setCel: 1
			setLoop: (targetBull2 loop:)
			posn: (targetBull2 x:) (targetBull2 y:)
			setPri: 470
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBack3
			view: 3331
			setCel: 1
			setLoop: (targetBull3 loop:)
			posn: (targetBull3 x:) (targetBull3 y:)
			setPri: 470
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBack4
			view: 3331
			setCel: 1
			setLoop: (targetBull4 loop:)
			posn: (targetBull4 x:) (targetBull4 y:)
			setPri: 470
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBack5
			view: 3331
			setCel: 1
			setLoop: (targetBull5 loop:)
			posn: (targetBull5 x:) (targetBull5 y:)
			setPri: 470
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBack6
			view: 3331
			setCel: 1
			setLoop: (targetBull6 loop:)
			posn: (targetBull6 x:) (targetBull6 y:)
			setPri: 470
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBack7
			view: 3331
			setCel: 1
			setLoop: (targetBull7 loop:)
			posn: (targetBull7 x:) (targetBull7 y:)
			setPri: 470
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBack8
			view: 3331
			setCel: 1
			setLoop: (targetBull8 loop:)
			posn: (targetBull8 x:) (targetBull8 y:)
			setPri: 470
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(targetBack9
			view: 3331
			setCel: 1
			setLoop: (targetBull9 loop:)
			posn: (targetBull9 x:) (targetBull9 y:)
			setPri: 470
			init: ((snipePlane casts:) at: 0) gFtrInitializer
		)
		(= local30 targetBull1)
		(gMessager say: 0 0 38 0 0 320) ; "OK, we have nine one and a half inch targets. Each target requires its own center hit. Begin left to right. Load your rifle and fire at will."
	)
)

(instance ballonDrillManager of Code
	(properties)

	(method (doit)
		(callTarget init:)
		(switch local5
			(100
				(gTheDoits
					add:
						(redBallon
							view: 3256
							setCel: (Random 0 4)
							setLoop: 0
							cycleSpeed: 17
							posn: 450 359
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(redShade
							view: 3256
							setCel: (redBallon cel:)
							setLoop: 1
							cycleSpeed: 17
							posn: 450 359
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(blueBallon
							view: 3256
							setCel: (Random 0 4)
							setLoop: 4
							cycleSpeed: 17
							posn: 490 359
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(blueShade
							view: 3256
							setCel: (blueBallon cel:)
							setLoop: 5
							cycleSpeed: 17
							posn: 490 359
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(greenBallon
							view: 3256
							setCel: (Random 0 4)
							setLoop: 2
							cycleSpeed: 17
							posn: 530 359
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(greenShade
							view: 3256
							setCel: (greenBallon cel:)
							setLoop: 3
							cycleSpeed: 17
							posn: 530 359
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
				)
			)
			(75
				(gTheDoits
					add:
						(redBallon
							view: 3255
							setCel: (Random 0 4)
							setLoop: 0
							cycleSpeed: 17
							posn: 445 359
							setPri: 500
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(redShade
							view: 3255
							setCel: (redBallon cel:)
							setLoop: 1
							cycleSpeed: 17
							posn: 445 359
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(blueBallon
							view: 3255
							setCel: (Random 0 4)
							setLoop: 4
							cycleSpeed: 17
							posn: 493 359
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(blueShade
							view: 3255
							setCel: (blueBallon cel:)
							setLoop: 5
							cycleSpeed: 17
							posn: 493 359
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(greenBallon
							view: 3255
							setCel: (Random 0 4)
							setLoop: 2
							cycleSpeed: 17
							posn: 536 359
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(greenShade
							view: 3255
							setCel: (greenBallon cel:)
							setLoop: 3
							cycleSpeed: 17
							posn: 536 359
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
				)
			)
			(50
				(gTheDoits
					add:
						(redBallon
							view: 3254
							setCel: (Random 0 4)
							setLoop: 0
							cycleSpeed: 17
							posn: 450 319
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(redShade
							view: 3254
							setCel: (redBallon cel:)
							setLoop: 1
							cycleSpeed: 17
							posn: 450 319
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(blueBallon
							view: 3254
							setCel: (Random 0 4)
							setLoop: 4
							cycleSpeed: 17
							posn: 520 319
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(blueShade
							view: 3254
							setCel: (blueBallon cel:)
							setLoop: 5
							cycleSpeed: 17
							posn: 520 319
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(greenBallon
							view: 3254
							setCel: (Random 0 4)
							setLoop: 2
							cycleSpeed: 17
							posn: 589 319
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(greenShade
							view: 3254
							setCel: (greenBallon cel:)
							setLoop: 3
							cycleSpeed: 17
							posn: 589 319
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
				)
			)
			(25
				(gTheDoits
					add:
						(redBallon
							view: 3253
							setCel: (Random 0 4)
							setLoop: 0
							cycleSpeed: 17
							posn: 280 349
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(redShade
							view: 3253
							setCel: (redBallon cel:)
							setLoop: 1
							cycleSpeed: 17
							posn: 280 349
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(blueBallon
							view: 3253
							setCel: (Random 0 4)
							setLoop: 4
							cycleSpeed: 17
							posn: 440 349
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(blueShade
							view: 3253
							setCel: (blueBallon cel:)
							setLoop: 5
							cycleSpeed: 17
							posn: 440 349
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(greenBallon
							view: 3253
							setCel: (Random 0 4)
							setLoop: 2
							cycleSpeed: 17
							posn: 595 349
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
						(greenShade
							view: 3253
							setCel: (greenBallon cel:)
							setLoop: 3
							cycleSpeed: 17
							posn: 595 349
							init: ((snipePlane casts:) at: 0) gFtrInitializer
							setCycle: ROsc -1 0 4 0 0
							yourself:
						)
				)
			)
		)
		(gMessager say: 0 0 39 0 0 320) ; "We have three balloons, each a different color. Call out which balloon you're going to hit. Strike within three seconds. No strike results in new call. Miss results in new call."
	)
)

(instance shilouetteDrillManager of Code
	(properties)

	(method (doit)
		(headFeature init: gFtrInitializer snipePlane)
		(bodyFeature init: gFtrInitializer snipePlane)
		(callTarget init:)
		(if (== local5 500)
			(gMessager say: 0 0 52 0 0 320) ; "Human silhouette up! Range estimation required! Employ the following formula to estimate the distance between you and your target. Determine the height of your target in yards. Using your reticle, determine how many mil-dots high your target is. Then multiply the number of yards by a thousand and divide the result by the number of mil-dots. Next, check your dope book and determine how many comeups are required to hit your target. Adjust your BDC accordingly. For reference, your target is three feet, or one yard tall."
		else
			(gMessager say: 0 0 62 0 0 320) ; "Human silhouette up! Call out area to be hit. No strike results in new call. Miss results in new call."
		)
		(ballonTimer setReal: ballonTimer 15)
	)
)

(instance placeHole of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp0
			(CelWide (backGround view:) (backGround loop:) (backGround cel:))
		)
		(= temp1
			(CelHigh (backGround view:) (backGround loop:) (backGround cel:))
		)
		(= temp2 (* (- param1 (backGround x:)) 100))
		(= temp3 (* (- (backGround y:) param2) 100))
		(= temp4 (/ temp2 temp0))
		(= temp5 (/ temp3 temp1))
		(= temp6 (CelWide 3302 1 0))
		(= temp7 (CelHigh 3302 1 0))
		(= local40 (/ (* temp4 temp6) 100))
		(= local41 (/ (* temp5 temp7) 100))
	)
)

(instance clearDoits of Code
	(properties)

	(method (doit)
		(if (gTheDoits contains: redBallon)
			(gTheDoits delete: redBallon)
		)
		(if (gTheDoits contains: blueBallon)
			(gTheDoits delete: blueBallon)
		)
		(if (gTheDoits contains: greenBallon)
			(gTheDoits delete: greenBallon)
		)
		(if (gTheDoits contains: redShade)
			(gTheDoits delete: redShade)
		)
		(if (gTheDoits contains: blueShade)
			(gTheDoits delete: blueShade)
		)
		(if (gTheDoits contains: greenShade)
			(gTheDoits delete: greenShade)
		)
		(if (gTheDoits contains: snipePlane)
			(gTheDoits delete: snipePlane)
		)
	)
)

(instance myShootCode of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

(instance myTalkerStopCheck of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

