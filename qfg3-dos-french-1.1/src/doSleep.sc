;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use GloryWindow)
(use n026)
(use IconBar)
(use GameControls)
(use System)

(public
	doSleep 2
	showTime 3
	fixTime 4
	egoRests 5
	advanceTime 6
	egoSleeps 7
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(if
		(OneOf
			gCurRoomNum
			230
			400
			460
			510
			520
			530
			700
			810
			820
			830
			851
			852
			853
			854
		)
		(= global455 param1)
		((= temp1 (Event new:)) type: evMOUSEBUTTON message: KEY_A)
		(if (not (gMouseDownHandler handleEvent: temp1))
			(gRegions handleEvent: temp1)
		)
		(temp1 dispose:)
	else
		(egoRests init: param1 1)
	)
)

(instance doSleep of Code
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 [temp5 60])
		(= temp3 1)
		(= temp2 0)
		(= temp1 (gGame setCursor: 999))
		(if (OneOf gCurRoomNum 150 160 170 180)
			(= local3 40)
			((= local1 (GameControls new:))
				window:
					((GloryWindow new:)
						top: 40
						left: 65
						bottom: (proc0_21 110 110 110 110 80)
						right: 256
						priority: 15
						yourself:
					)
			)
			(= temp4 (sleepIcon new: 1 0 1 1))
			(temp4 view: 935 loop: 1 cel: 0 nsTop: 2 nsLeft: 2 modifiers: 1)
			(local1 add: temp4)
			(= temp4 (sleepIcon new: 1 0 0 1))
			(temp4 nsTop: (proc0_21 50 50 50 50 25) nsLeft: 25 cursor: 1)
			(local1 add: temp4)
			(= temp4 (sleepIcon new: 1 0 0 2))
			(temp4 nsTop: (proc0_21 50 50 50 50 25) nsLeft: 105 cursor: 2)
			(local1 add: temp4)
			(local1 init: show: dispose:)
			(= local1 0)
			(switch local2
				(1
					((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_J)
					(= temp3 0)
					(if (not (gMouseDownHandler handleEvent: temp0))
						(gRegions handleEvent: temp0)
					)
					(temp0 dispose:)
					(= temp2 1)
				)
				(2
					(= temp2 0)
				)
			)
		else
			(= local3 (proc0_21 160 120 160 120 120))
			((= local1 (GameControls new:))
				window:
					((GloryWindow new:)
						top: 40
						left: 65
						bottom: 155
						right: 256
						priority: 15
						yourself:
					)
			)
			(= temp4 (sleepIcon new: 2 0 1 1))
			(temp4 view: 935 loop: 1 cel: 0 nsTop: 2 nsLeft: 2 modifiers: 1)
			(local1 add: temp4)
			(= temp4 (sleepIcon new: 2 0 0 1))
			(temp4 nsLeft: (proc0_21 20 40 20 40 40) nsTop: 28 cursor: 1)
			(local1 add: temp4)
			(= temp4 (sleepIcon new: 2 0 0 2))
			(temp4 nsLeft: (proc0_21 20 40 20 40 40) nsTop: 45 cursor: 2)
			(local1 add: temp4)
			(= temp4 (sleepIcon new: 2 0 0 3))
			(temp4 nsLeft: (proc0_21 20 40 20 40 40) nsTop: 62 cursor: 3)
			(local1 add: temp4)
			(if gNight
				(= temp4 (sleepIcon new: 2 0 0 4))
				(temp4 nsLeft: (proc0_21 20 40 20 40 40) nsTop: 79 cursor: 4)
				(local1 add: temp4)
			else
				((local1 window:) bottom: 138)
			)
			(= temp4 (sleepIcon new: 2 0 0 5))
			(temp4
				nsLeft: (proc0_21 20 40 20 40 40)
				nsTop: (if gNight 96 else 79)
				cursor: 5
			)
			(local1 add: temp4)
			(local1 init: show: dispose:)
			(= local1 0)
			(switch local2
				(1
					(localproc_0 10)
				)
				(2
					(localproc_0 30)
				)
				(3
					(localproc_0 60)
				)
				(4
					(if
						(OneOf
							gCurRoomNum
							150
							160
							170
							180
							310
							390
							400
							430
							440
							600
							700
							770
							780
							820
						)
						((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_J)
						(= temp3 0)
						(if (not (gMouseDownHandler handleEvent: temp0))
							(gRegions handleEvent: temp0)
						)
						(temp0 dispose:)
						(= temp2 1)
					else
						(egoSleeps init: 5 0)
					)
				)
				(5
					(= temp2 1)
				)
			)
		)
		(if temp3
			(gGame setCursor: temp1)
		)
		(return temp2)
	)
)

(instance egoSleeps of Code
	(properties)

	(method (init param1 param2 &tmp temp0 temp1 [temp2 60])
		(if
			(OneOf
				gCurRoomNum
				150
				160
				170
				180
				310
				390
				400
				430
				440
				600
				700
				770
				780
				820
			)
			(= global137 0)
			(= temp1 gClock)
			(switch argc
				(0
					(fixTime init: 5)
				)
				(1
					(fixTime init: param1)
				)
				(else
					(fixTime init: param1 param2)
				)
			)
			(= temp0 (/ (mod (- (+ gClock 3600) temp1) 3600) 150))
			(= [gEgoStats 17] (gEgo maxStamina:)) ; stamina
			(if
				(and
					(not
						(gEgo
							takeDamage:
								(- (/ (* temp0 (gEgo maxHealth:)) 16))
						)
					)
					(IsFlag 115)
				)
				(EgoDead 27 28) ; "You are completely strychnine by poison. No curare for you. Next time, take some poison cure pills."
				(return)
			)
			(gEgo useMana: (- (/ (* temp0 (gEgo maxMana:)) 16)))
			(if (and (> temp1 gClock) (IsFlag 31))
				(NextDay)
			)
			(if (< temp0 2)
				(gMessager say: 0 0 12 1 0 7) ; "You awaken as the sun begins to rise, but you feel as though you haven't slept at all."
			else
				(gMessager say: 0 0 3 1 0 7) ; "You awaken as the sun begins to rise."
			)
		else
			(gMessager say: 3 6 11 0 0 7) ; "This would not be a good place to sleep."
		)
	)
)

(instance showTime of Code
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 [temp5 50] [temp55 50])
		(= temp0 gDay)
		(Message msgGET 7 0 0 10 1 @temp5) ; "It's day"
		(Format @temp55 @temp5 (+ gDay 1))
		(if (or (!= gTimeOfDay 6) (> gClock 500))
			(++ temp0)
		)
		(if (>= (= temp2 gClock) 2750)
			(-= temp2 3600)
		)
		(if (< temp2 790)
			(+= temp2 1800)
		)
		(= temp3 (/ (-= temp2 1800) 16))
		(= temp4 (+ (= temp4 (Abs (/ temp2 24))) 3))
		(+= temp3 71)
		(= local0
			((GloryWindow new:)
				top: 0
				left: 84
				bottom: 74
				right: 240
				priority: 15
				open:
				yourself:
			)
		)
		(Display @temp55 dsCOLOR 17 dsCOORD 0 66 dsWIDTH 156 dsFONT 999)
		(if (not gNight)
			(DrawCel 938 1 0 0 3)
			(DrawCel 938 2 0 temp3 temp4)
			(DrawCel 938 0 0 0 3)
		else
			(DrawCel 938 4 0 0 3)
			(DrawCel 938 5 0 temp3 temp4)
			(DrawCel 938 3 0 0 3)
		)
		(while 1
			(= temp1 (Event new:))
			(if
				(or
					(and
						(== (temp1 type:) evKEYBOARD)
						(OneOf (temp1 message:) KEY_RETURN KEY_ESCAPE)
					)
					(== (temp1 type:) evMOUSEBUTTON)
					(== (temp1 type:) evJOYDOWN)
				)
				(break)
			)
			(temp1 dispose:)
		)
		(temp1 dispose:)
		(local0 dispose:)
		(self dispose:)
	)
)

(instance fixTime of Code
	(properties)

	(method (init param1 param2 &tmp temp0 temp1)
		(= temp1 gClock)
		(if (>= argc 1)
			(= gClock (* 150 param1))
			(= gOldSysTime (GetTime 1)) ; SysTime12
			(if (>= argc 2)
				(+= gClock (/ (* 150 param2) 60))
			)
		)
		(= temp0 gTimeOfDay)
		(cond
			((< (^ gClock $0001) 300)
				(= gTimeOfDay 6)
			)
			((< (^ gClock $0001) 750)
				(= gTimeOfDay 7)
			)
			((< (^ gClock $0001) 1200)
				(= gTimeOfDay 0)
			)
			((< (^ gClock $0001) 1650)
				(= gTimeOfDay 1)
			)
			((< (^ gClock $0001) 2100)
				(= gTimeOfDay 2)
			)
			((< (^ gClock $0001) 2550)
				(= gTimeOfDay 3)
			)
			((< (^ gClock $0001) 3000)
				(= gTimeOfDay 4)
			)
			((< (^ gClock $0001) 3450)
				(= gTimeOfDay 5)
			)
			(else
				(= gTimeOfDay 6)
			)
		)
		(if (< gClock temp1)
			(NextDay)
		)
		(if (and (== gTimeOfDay 6) (!= temp0 6))
			(if (== (++ global137) 1)
				(gMessager say: 0 0 6 1 0 7) ; "You are getting tired."
			else
				(gMessager say: 0 0 7 1 0 7) ; "You are exhausted from lack of sleep."
			)
		)
	)
)

(instance egoRests of Code
	(properties)

	(method (init param1 param2)
		(if
			(and
				(<= gDay global106)
				(<= gClock (+ global105 150))
				(> [gEgoStats 17] (/ (gEgo maxStamina:) 2)) ; stamina
			)
			(gMessager say: 0 0 8 1 0 7) ; "You're too impatient to rest right now."
		else
			(= global106 gDay)
			(= global105 gClock)
			(gEgo
				useStamina: (- param1)
				useMana: (- (/ param1 5))
				takeDamage: (- (/ (+ param1 5) 15))
			)
			(if param2
				(if (IsFlag 115)
					(gMessager say: 0 0 13 1 0 7) ; "After some rest, you feel worse than before."
				else
					(gMessager say: 0 0 9 1 0 7) ; "After some rest, you feel better."
				)
			)
			(advanceTime init: 0 param1)
		)
	)
)

(instance advanceTime of Code
	(properties)

	(method (init param1 param2 &tmp temp0)
		(switch argc
			(1
				(= temp0 (+ gClock (* 150 param1)))
			)
			(2
				(= temp0 (+ gClock (* 150 param1) (/ (* 150 param2) 60)))
			)
		)
		(^= temp0 $0001)
		(if
			(or
				(and (< gClock 1100) (> temp0 1200))
				(and (< gClock 2500) (or (> temp0 2600) (< temp0 gClock)))
			)
			(gEgo eatMeal:)
		)
		(while (>= temp0 3600)
			(-= temp0 3600)
			(++ gDay)
		)
		(fixTime init: (/ temp0 150) (/ (* (mod temp0 150) 60) 150))
	)
)

(instance sleepIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
	)

	(method (new param1 param2 param3 param4 &tmp temp0 temp1 temp2)
		(= temp0 (Clone self))
		(if argc
			(= temp1 (Message msgSIZE 7 param1 param2 param3 param4))
			(temp0 message: (Memory memALLOC_NONCRIT temp1))
			(Message msgGET 7 param1 param2 param3 param4 (temp0 message:))
		)
		(return temp0)
	)

	(method (show)
		(= nsRight
			(+
				nsLeft
				(if (== loop 1)
					0
				else
					(+ local3 20)
				)
			)
		)
		(= nsBottom
			(if (== loop 1)
				nsTop
			else
				(+ nsTop 15)
			)
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display
			message
			dsCOORD
			(if (== loop 1)
				nsLeft
			else
				(+ nsLeft 20)
			)
			(if (== loop 1)
				(+ nsTop 2)
			else
				nsTop
			)
			dsFONT
			(proc0_21 310 310 310 310 123)
			dsCOLOR
			17
			dsALIGN
			modifiers
			dsWIDTH
			(if (== loop 1) 189 else local3)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if (!= loop 1)
			(if param1
				(DrawCel view loop 1 nsLeft nsTop -1)
				(= temp0 46)
			else
				(DrawCel view loop 0 nsLeft nsTop -1)
				(= temp0 17)
			)
			(Display
				message
				dsCOORD
				(if (== loop 1)
					nsLeft
				else
					(+ nsLeft 20)
				)
				nsTop
				dsFONT
				(proc0_21 310 310 310 310 123)
				dsCOLOR
				temp0
				dsALIGN
				modifiers
				dsWIDTH
				(if (== loop 1) 189 else local3)
			)
		)
	)

	(method (select)
		(if (!= loop 1)
			(= local2 cursor)
			(local1 state: (& (local1 state:) $ffdf))
		else
			(return 0)
		)
	)

	(method (dispose)
		(Memory memFREE message)
		(super dispose:)
	)
)

