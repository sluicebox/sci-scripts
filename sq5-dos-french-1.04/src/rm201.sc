;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 201)
(include sci.sh)
(use Main)
(use AnimDialog)
(use sStartEggTimer)
(use eureka)
(use Interface)
(use Talker)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use ScaleTo)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm201 0
	sFlashRed 1
	flo 2
	floArm 3
	sBusyFlo 4
	proc201_5 5
	proc201_6 6
	proc201_7 7
	sTurnDrooleBack 8
	bigPlanet 9
	drooleTalker 12
	floTalker 13
	rogTalker 15
	proc201_20 20
	proc201_21 21
	proc201_22 22
	sAbandonShip 23
	droole 24
	ViewScreen 25
	proc201_27 27
	proc201_33 33
	drooleArm 34
	sFlashWhite 35
	sInToOrbit 36
	sOutOfOrbit 37
	sTurnAround 38
	sBigPlanet 39
)

(local
	local0
	local1
	local2
	local3
	[local4 2]
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14 = -1
	[local15 26] = [0 0 0 0 0 0 0 0 0 0 {Nowhere} {garbage1} {garbage2} {ku} {spacebar} {clorox2} {thrakus} {genetix Space Lab} {genetix environdome} {generic planet 1} {generic planet 2} {generic planet 3} {generic planet 4} {generic planet 5} {goliath} {empty space!}]
	[local41 16] = [212 212 213 221 222 223 224 225 226 214 216 214 216 2243 2272 220]
	[local57 16] = [0 0 0 0 0 0 0 0 0 0 0 214 216 0 413 0]
	local73 = 1
	local74 = 1
)

(procedure (proc201_22)
	(return local13)
)

(procedure (proc201_33)
	(= local13 0)
)

(procedure (proc201_20) ; UNUSED
	(return local12)
)

(procedure (proc201_21)
	(= local12 0)
)

(procedure (localproc_0)
	(if (IsFlag 84)
		((ScriptID 202 2) init:) ; panel
		(proc204_1)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3 [temp4 6])
	(= temp1 0)
	(for ((= temp0 0)) (< temp0 14) ((++ temp0))
		(= temp3 1)
		(for ((= temp2 0)) (< temp2 5) ((++ temp2))
			(if
				(!=
					(StrAt @local15 temp2)
					(StrAt
						{00000 71552 92767 20011 69869 90210 53284 41666 41666 91001 01015 44091 81100 54671}
						(+ temp1 temp2)
					)
				)
				(= temp3 0)
				(break)
			)
		)
		(if temp3
			(return (if (<= temp0 13) temp0 else 15))
		)
		(+= temp1 6)
	)
	(return 15)
)

(procedure (proc201_7 param1)
	(drooleArm setScript: 0 hide:)
	(droole setLoop: 1 setCycle: End (if argc param1 else 0))
	(drooleHand hide:)
)

(procedure (localproc_2)
	(cond
		((IsFlag 84)
			(if (!= (gSq5Music1 number:) 42)
				(gSq5Music1 number: 42 loop: -1 play: 127)
			)
		)
		((IsFlag 61)
			(if (!= (gSq5Music1 number:) 20)
				(gSq5Music1 number: 20 loop: -1 play: 127)
			)
		)
		((or (IsFlag 42) (== (eureka puke:) 2))
			(if (!= (gSq5Music1 number:) 38)
				(gSq5Music1 number: 38 loop: -1 play: 127)
			)
		)
		((!= (gSq5Music1 number:) 101)
			(gSq5Music1 number: 101 loop: -1 play: 75)
		)
		(else
			(gSq5Music1 pause: 0)
		)
	)
)

(procedure (localproc_3)
	(if (or (IsFlag 84) (>= (eureka puke:) 4))
	else
		(gSq5Music2 number: 206 loop: -1 play:)
	)
)

(procedure (proc201_6 param1)
	(flo setLoop: 1 setCycle: End (if argc param1 else 0))
	(floArm hide:)
	(gEgo setLoop: 1 setCel: 0 posn: 178 95 show:)
)

(procedure (localproc_4 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 (gCast size:)) ((++ temp0))
		(= temp1 (gCast at: temp0))
		(if (temp1 isKindOf: Actor)
			(temp1 cue:)
		)
	)
)

(procedure (localproc_5 &tmp [temp0 4])) ; UNUSED

(procedure (localproc_6)
	(return local73)
)

(procedure (proc201_5 param1)
	(= local73 param1)
)

(procedure (localproc_7)
	(return local74)
)

(procedure (proc201_27 param1)
	(= local74 param1)
)

(procedure (localproc_8 &tmp temp0 temp1)
	(= temp1 4)
	(for ((= temp0 1)) (< temp0 temp1) ((++ temp0))
		((fastStar new:) init:)
		((mediumStar new:) init:)
		((slowStar new:) init:)
	)
	(fastStar init:)
	(mediumStar init:)
	(slowStar init:)
)

(procedure (localproc_9)
	(if (!= gEurekaLocation 0) ; Nowhere
		(if (IsFlag 32)
			(= local10 0)
		else
			(= local10 1)
		)
		(localproc_8)
	)
)

(instance rm201 of Rm
	(properties
		noun 32
		picture 41
		style 10
	)

	(method (init &tmp temp0)
		(gCurRoom setRegions: 210) ; eureka
		(LoadMany rsMESSAGE 201 205 202)
		(LoadMany rsVIEW 98 217 202 203 992 200)
		(super init: &rest)
		(gCurRoom setScript: sInitRoom)
	)

	(method (notify param1 param2 param3 param4 param5 param6 &tmp temp0)
		(gGame handsOff:)
		(switch param1
			(1
				(Format ; "%c%c%c%c%c"
					@local15
					201
					0
					(+ param2 48)
					(+ param3 48)
					(+ param4 48)
					(+ param5 48)
					(+ param6 48)
				)
				(= temp0 0)
				(if (eureka destination:)
					(= temp0 (eureka destination:))
				)
				(= local14 (localproc_1))
				(eureka destination: local14)
				(cond
					((== (eureka destination:) 0) ; Nowhere
						(eureka destination: 0) ; Nowhere
					)
					((and (== (eureka destination:) 7) (== gAct 2)) ; genetix Space Lab
						(eureka destination: 8) ; genetix environdome
					)
				)
				(cond
					((== (eureka destination:) (eureka curLocation:))
						(switch (eureka state:)
							(3
								(eureka destination: 0) ; Nowhere
							)
							(1)
						)
					)
					((and (== (eureka destination:) 4) (IsFlag 30)) ; spacebar
						(gMessager say: 23 0 43 1) ; "We can't go to the space bar, Captain, you blew it up. Or don't you remember?"
						(if temp0
							(eureka destination: temp0)
							(= param1 -1)
						else
							(eureka destination: 0) ; Nowhere
							(eureka warnings: 0 timer: 0 setScript: 0)
						)
					)
					((IsFlag 32)
						(eureka warnings: 0 timer: 0 state: 1 setScript: 0)
						(eureka
							setScript:
								(if
									(and
										(== (eureka destination:) 3) ; ku
										(not (IsFlag 9))
									)
									(ScriptID 210 6) ; sWD40Timer
								else
									(ScriptID 210 4) ; sApproachTimer
								)
								0
								30
						)
					)
					(else
						(eureka timer: 0 warnings: 0 setScript: 0)
						(if (== (eureka state:) 2)
							(eureka state: 1)
						)
						(eureka setScript: (ScriptID 210 2) 0 30) ; sLiteSpeedTimer
					)
				)
				(eureka warnings: 0)
			)
		)
		(= local13 param1)
		(switch (eureka state:)
			(0
				((ScriptID 214 3) stopUpd:) ; rightBayDoor
				((ScriptID 214 2) stopUpd:) ; leftBayDoor
			)
		)
		(droole stopUpd:)
	)

	(method (doit)
		(cond
			(script)
			((eureka timer:)
				(self setScript: sHandleTimer)
			)
			((and (IsFlag 84) (not (IsFlag 86)))
				(SetFlag 85)
				(gCurRoom setScript: sAbandonShip)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (and (gCast contains: (ScriptID 204 4)) (not (IsFlag 84))) ; eggTimer
			(gCurRoom setScript: (ScriptID 204 5)) ; sStopEggTimer
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(gWalkHandler delete: bridge)
		(theMusic3 dispose:)
		(if (not (OneOf gNewRoomNum 200 222))
			(gSq5Music2 fade:)
			(if (not (OneOf gNewRoomNum 212 213))
				(gSq5Music1 fade:)
			)
		)
		(DisposeScript 202)
		(DisposeScript 204)
		(DisposeScript 207)
		(DisposeScript 208)
		(DisposeScript 209)
		(DisposeScript 211)
		(DisposeScript 214)
		(DisposeScript 216)
		(DisposeScript 217)
		(DisposeScript 218)
		(DisposeScript 219)
		(DisposeScript 220)
		(DisposeScript 221)
		(DisposeScript 232)
		(DisposeScript 233)
		(super dispose:)
	)
)

(instance sInitRoom of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(bridge init:)
				(buttonPanel init:)
				(gEgo
					view: 200
					init:
					loop: 0
					cel: 0
					posn: 132 95
					setScale: 0
					setPri: 12
					hide:
				)
				(localproc_0)
				(switch gPrevRoomNum
					(107
						(eureka
							timer: 0
							setScript:
								(if
									(and
										(== (eureka destination:) 3) ; ku
										(not (IsFlag 9))
									)
									(ScriptID 210 6) ; sWD40Timer
								else
									(ScriptID 210 4) ; sApproachTimer
								)
								0
								30
						)
						(gGame handsOn:)
					)
					(200
						(if (and (== gEurekaLocation 3) (IsFlag 9) (IsFlag 61)) ; ku
							(ClearFlag 61)
						)
						(cond
							(
								(and
									(== gAct 1)
									(IsFlag 45)
									(not (IsFlag 86))
									(== gEurekaLocation 6) ; thrakus
								)
								(if (== gBeaState 1)
									(SetFlag 42)
									(eureka setScript: 0)
									(eureka setScript: (ScriptID 210 1) 0 3) ; sGoliathTimer
								else
									(= next (ScriptID 233 3)) ; sBeaDies
								)
							)
							(
								(and
									(IsFlag 76)
									(== gAct 0)
									(not (IsFlag 97))
								)
								(= next (ScriptID 211 1)) ; sDistressCall
								(= gAct 1)
							)
							((and (== gEurekaLocation 8) (IsFlag 75) (< gBeaState 8)) ; genetix environdome
								(= next (ScriptID 233 3)) ; sBeaDies
							)
							(
								(and
									(== gEurekaLocation 14) ; goliath
									(not (IsFlag 86))
									(== (eureka puke:) 1)
								)
								(eureka setScript: (ScriptID 210 5) 0 1) ; sBlobTimer
							)
							((and (== (eureka garbage:) 1) (not (IsFlag 86)))
								(= next (ScriptID 232 25)) ; sGarbageComplaint
							)
							(
								(and
									(not (IsFlag 86))
									(or
										(not (IsFlag 56))
										(IsFlag 113)
										(IsFlag 114)
									)
									(> gSpikeState 1)
								)
								(= next (ScriptID 232 24)) ; sSpikeComplaint
							)
							(else
								(gGame handsOn:)
							)
						)
					)
					(206
						((ScriptID 209 2) init: view: 218 setLoop: 0 cel: 0) ; viewPort
						(= next (ScriptID 232 4)) ; sAfterAlien
					)
					(212
						(gGame handsOn:)
						(eureka puke: 2)
					)
					(213
						(gGame handsOn:)
						(eureka puke: 3)
					)
					(222
						(gGame handsOn:)
						(if (== gEurekaLocation 6) ; thrakus
							(eureka setScript: 0)
							(eureka setScript: (ScriptID 210 1) 0 10) ; sGoliathTimer
						else
							(= next (ScriptID 221 6)) ; sInTheAsteroids
						)
					)
					(280
						(++ gGarbagePickupCount)
						(switch (eureka curLocation:)
							(1 ; garbage1
								(= next (ScriptID 232 7)) ; sSpikeHere
							)
							(2 ; garbage2
								(= next (ScriptID 232 5)) ; sAlienHere
							)
						)
					)
					(290
						(++ gGarbagePickupCount)
						(switch (eureka curLocation:)
							(1 ; garbage1
								(= next (ScriptID 232 7)) ; sSpikeHere
							)
							(2 ; garbage2
								(= next (ScriptID 232 5)) ; sAlienHere
							)
							(else
								(gGame handsOn:)
							)
						)
					)
					(215
						(gGame handsOn:)
					)
					(550
						(= gEurekaLocation 16) ; empty space
						(= local10 1)
						(eureka state: 1 prevLocation: 4 curLocation: 0) ; Nowhere
						(SetFlag 30)
						(SetFlag 56)
						(SetFlag 35)
						(SetFlag 36)
						(SetFlag 9)
						(SetFlag 60)
						(ClearFlag 32)
						(ClearFlag 86)
						(= gWD40State 2)
						(= gCliffyState 1)
						(= gSpikeState 6)
						(= next (ScriptID 233 8)) ; sSquishMonkeys
					)
					(else
						(gGame handsOn:)
						(if
							(>=
								(= temp0
									(GetNumber
										{Eureka State: \n\n\n(0) starcon \n(1) regular speed \n(2) chasing goliath \n(3) wd40 attacks \n(4) garbage pickup \n(5) distress call \n(6) goliath blobbed \n(7) approach space bar \n(8) cliffy lost in space \n(9) goliath attacks\n}
									)
								)
								0
							)
							(= local0 temp0)
						else
							(= local0 0)
						)
						(switch local0
							(0
								(= gEurekaLocation 0) ; Nowhere
								(= gCliffyState 1)
								(eureka state: 0)
							)
							(1
								(gGame handsOn:)
								(= gEurekaLocation 16) ; empty space
								(= gCliffyState 1)
								(eureka state: 1)
								(= local10 1)
								(ClearFlag 32)
							)
							(2
								(eureka
									warnings: 0
									state: 1
									destination: 12 ; generic planet 4
									setScript: (ScriptID 210 4) 0 5 ; sApproachTimer
								)
								(= gEurekaLocation 17) ; empty space
								(= local10 0)
								(= gCliffyState 1)
								(= gBeaState 8)
								(= gWD40State 2)
								(= gAct 2)
								(= local10 0)
								(SetFlag 32)
								(SetFlag 33)
								(SetFlag 94)
								(SetFlag 93)
								(SetFlag 87)
								(SetFlag 89)
								(SetFlag 75)
								(SetFlag 30)
								(ClearFlag 42)
								(SetFlag 45)
							)
							(3
								(= gEurekaLocation 17) ; empty space
								(= gCliffyState 1)
								(SetFlag 32)
								(eureka state: 1)
								(= local10 0)
								(eureka
									warnings: 0
									destination: 3 ; ku
									setScript: (ScriptID 210 6) 0 10 ; sWD40Timer
								)
							)
							(4
								(= gEurekaLocation 17) ; empty space
								(SetFlag 32)
								(= local10 0)
								(= gGarbagePickupCount 0)
								(ClearFlag 35)
								(= gCliffyState 1)
								(ClearFlag 36)
								(eureka
									warnings: 0
									state: 1
									destination: 1 ; garbage1
									setScript: (ScriptID 210 4) 0 5 ; sApproachTimer
								)
								(ClearFlag 30)
							)
							(5
								(= gEurekaLocation 5) ; clorox2
								(= gWD40State 2)
								(SetFlag 76)
								(SetFlag 30)
								(SetFlag 9)
								(SetFlag 93)
								(= gCliffyState 1)
								(= gAct 0)
								(eureka state: 3 destination: 0 curLocation: 5) ; Nowhere, clorox2
								(= local10 1)
								(= gGarbagePickupCount 3)
								(localproc_8)
							)
							(6
								(= gEurekaLocation 14) ; goliath
								(= gAct 2)
								(= gWD40State 2)
								(SetFlag 60)
								(SetFlag 30)
								(SetFlag 76)
								(SetFlag 9)
								(SetFlag 93)
								(SetFlag 56)
								(ClearFlag 32)
								(eureka
									state: 3
									curLocation: 14 ; goliath
									puke: 1
									destination: 0 ; Nowhere
									setScript: (ScriptID 210 5) 0 1 ; sBlobTimer
								)
							)
							(7
								(= gCliffyState 1)
								(= gSpikeState 4)
								(= gEurekaLocation 17) ; empty space
								(= local10 0)
								(= gGarbagePickupCount 3)
								(SetFlag 32)
								(SetFlag 35)
								(SetFlag 36)
								(SetFlag 56)
								(ClearFlag 30)
								(eureka
									warnings: 0
									state: 1
									destination: 4 ; spacebar
									setScript: (ScriptID 210 4) 0 10 ; sApproachTimer
								)
							)
							(8
								(eureka
									state: 3
									warnings: 0
									timer: 0
									destination: 0 ; Nowhere
									curLocation: 15 ; empty space
									setScript: 0
								)
								(SetFlag 33)
								(SetFlag 94)
								(SetFlag 93)
								(ClearFlag 87)
								(SetFlag 89)
								(ClearFlag 75)
								(SetFlag 30)
								(SetFlag 45)
								(ClearFlag 42)
								(ClearFlag 32)
								(= gWD40State 2)
								(= gCliffyState 1)
								(= gEurekaLocation 15) ; empty space
								(= gAct 2)
								(= gBeaState 1)
								(= next (ScriptID 221 6)) ; sInTheAsteroids
							)
							(9
								(= gEurekaLocation 6) ; thrakus
								(= gWD40State 2)
								(= gAct 1)
								(eureka
									state: 3
									warnings: 0
									timer: 0
									destination: 0 ; Nowhere
									curLocation: 6 ; thrakus
									setScript: 0
								)
								(SetFlag 42)
								(eureka setScript: (ScriptID 210 1) 0 5) ; sGoliathTimer
								(SetFlag 33)
								(SetFlag 94)
								(SetFlag 93)
								(SetFlag 76)
								(SetFlag 63)
								(SetFlag 30)
								(SetFlag 45)
								(= gCliffyState 1)
								(= gBeaState 1)
								(ClearFlag 32)
							)
							(else
								(= gEurekaLocation 16) ; empty space
								(eureka state: 1)
								(ClearFlag 32)
							)
						)
					)
				)
				(localproc_9)
				(flo init:)
				(droole init:)
				(bigPlanet init:)
				(ViewScreen init: setOnMeCheck: 1 2)
				(vid1Monitor init:)
				(vid2Monitor init:)
				(vid3Monitor init:)
				(capChair init:)
				(dConsole init:)
				(fConsole init:)
				(gWalkHandler addToFront: bridge)
				(gUser canControl: 0)
				(if (or (>= (eureka puke:) 4) (IsFlag 84))
					((ScriptID 202 13) init:) ; monitor1
					((ScriptID 202 14) init:) ; monitor2
					((ScriptID 202 15) init:) ; monitor3
				)
				(= cycles 1)
			)
			(1
				(localproc_2)
				(localproc_3)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sTurnDrooleBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(droole setCycle: Beg self)
			)
			(1
				(drooleArm show: setScript: sDrooleArm)
				(droole setLoop: 0 setCycle: 0 stopUpd:)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sAbandonShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 84)
					(= seconds 8)
				else
					(= seconds 1)
				)
				(gGame handsOff:)
			)
			(1
				(gCurRoom newRoom: 200)
				(self dispose:)
			)
		)
	)
)

(instance sHandleTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(or
						(== (eureka timer:) 3)
						(IsFlag 86)
						(and (== (eureka timer:) 6) (== (eureka warnings:) 1))
						(and (IsFlag 37) (IsFlag 39))
						(and
							(== (eureka timer:) 5)
							(or (== gEurekaLocation 14) (> (eureka warnings:) 1)) ; goliath
						)
						(== gSpikeState 1)
						(and
							(== (eureka destination:) 32)
							(>= gGarbagePickupCount 3)
							(not (IsFlag 56))
						)
					)
					(= cycles 4)
				else
					(proc201_7 self)
				)
			)
			(1
				(eureka warnings: (+ (eureka warnings:) 1))
				(switch (eureka timer:)
					(1
						(gMessager say: 11 0 17 (eureka warnings:) self)
						(if (== (eureka warnings:) 3)
							(eureka warnings: 0)
						)
						(eureka setScript: 0)
						(eureka setScript: (ScriptID 210 2) 0 30) ; sLiteSpeedTimer
					)
					(2
						(cond
							(
								(or
									(== gSpikeState 1)
									(and
										(== (eureka destination:) 4) ; spacebar
										(>= gGarbagePickupCount 3)
										(not (IsFlag 56))
									)
								)
								(= next (ScriptID 232 9)) ; sDidntGetSpike
								(self dispose:)
							)
							((< (eureka warnings:) 3)
								(SetFlag 60)
								(eureka state: 2)
								(eureka setScript: (ScriptID 210 4) 0 30) ; sApproachTimer
								(gMessager say: 11 0 14 (eureka warnings:) self)
							)
							((IsFlag 37)
								(if (not (IsFlag 39))
									(gMessager say: 24 0 0 1 self 202) ; "She's spotted us, sir. Her weapons are locked and preparing to fire. Been nice knowin' ya."
								else
									(= cycles 1)
								)
								(= next (ScriptID 207 7)) ; sFindGoliath
								(eureka
									state: 2
									timer: 0
									warnings: 0
									destination: 0 ; Nowhere
									curLocation: 14 ; goliath
								)
							)
							(else
								(if (IsFlag 32)
									(= next sSmallPlanet)
								else
									(if (gCast contains: wasteBeacon)
										(wasteBeacon dispose:)
									)
									(if (== (eureka destination:) 6) ; thrakus
										((ScriptID 221 0) dispose:) ; asteroids
									)
									(bigPlanet dispose:)
									(ClearFlag 38)
								)
								(gMessager say: 11 0 14 3 self) ; "Pull your head out Captain, we just missed our destination. Now we're gonna have to lay in a course again!"
								(eureka
									timer: 0
									warnings: 0
									state: 1
									destination: 0 ; Nowhere
								)
							)
						)
					)
					(3
						(if (!= gSpikeState 1)
							(switch (eureka warnings:)
								(1
									(SetFlag 61)
									(SetFlag 60)
									(eureka timer: 0 setScript: 0)
									(= local12 0)
									(= next (ScriptID 208 0)) ; sWD40Attacks
									(= cycles 1)
								)
								(2
									(= next (ScriptID 208 1)) ; sWD40Kills
									(eureka timer: 0)
									(= cycles 1)
								)
								(3
									(= next (ScriptID 208 1)) ; sWD40Kills
									(eureka timer: 0)
									(= cycles 1)
								)
							)
						else
							(= next (ScriptID 232 9)) ; sDidntGetSpike
							(= cycles 1)
						)
						(self dispose:)
					)
					(5
						(switch gEurekaLocation
							(6 ; thrakus
								(switch (eureka warnings:)
									(1
										(gMessager say: 13 0 14 0 self 202) ; "We found the Goliath, sir -- or rather she found us."
										(eureka setScript: 0)
										(eureka setScript: (ScriptID 210 1) 0 2) ; sGoliathTimer
									)
									(2
										(gMessager
											say:
												13
												0
												12
												(+ (eureka hits:) 1)
												self
												202
										)
										(eureka setScript: 0)
										(eureka
											setScript: (ScriptID 210 1) 0 20 ; sGoliathTimer
										)
									)
									(3
										(= next (ScriptID 221 5)) ; sGoliathAttacks
										(= cycles 1)
									)
									(4
										(eureka warnings: 1)
										(gCurRoom newRoom: 222)
										(= cycles 1)
									)
								)
							)
							(14 ; goliath
								(if (IsFlag 39)
									(= cycles 1)
								else
									(= next (ScriptID 207 5)) ; sGoliathShoots
									(= cycles 1)
								)
							)
						)
					)
					(6
						(switch (eureka puke:)
							(1
								(switch (eureka warnings:)
									(1
										(gMessager say: 11 0 15 1 self) ; "The Goliath's hull is nearing structural failure, Captain. She's going to implode if we don't do something."
										(eureka setScript: 0)
										(eureka
											setScript: (ScriptID 210 5) 0 15 ; sBlobTimer
										)
									)
									(else
										(= next (ScriptID 207 2)) ; sBlowUpGoliath
										(self dispose:)
									)
								)
							)
							(2
								(= next (ScriptID 207 4)) ; sEurekaBlobbed
								(self dispose:)
							)
							(4
								(client setScript: (ScriptID 210 3) 0 7) ; sBlowUpEureka
								(self dispose:)
							)
							(else
								(eureka timer: 0 setScript: 0 warnings: 0)
								(= cycles 1)
							)
						)
					)
				)
				(eureka timer: 0)
			)
			(2
				(self setScript: sTurnDrooleBack self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSmallPlanet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(smallPlanet init: setScale: ScaleTo 100 10 self)
			)
			(1
				(smallPlanet setMotion: MoveTo 275 120 self)
				(eureka state: 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTurnAround of Script
	(properties)

	(method (changeState newState &tmp [temp0 4])
		(switch (= state newState)
			(0
				(if (eureka curLocation:)
					(= local11 1)
					(eureka setScript: 0 timer: 0)
					(leadStar init:)
				else
					(= cycles 1)
				)
			)
			(1
				(= seconds 3)
			)
			(2
				(eureka state: 2)
				(self setScript: sBigPlanet self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sFloArm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(floArm
					setCel:
						(switch (Random 0 6)
							(0 0)
							(else
								(Random 1 2)
							)
						)
				)
				(= cycles 1)
			)
			(1
				(= ticks (Random 3 20))
				(-= state 2)
			)
		)
	)
)

(instance sBusyFlo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo startUpd:)
				(flo setCycle: Beg self)
			)
			(1
				(flo setLoop: 0 setCel: 0 setCycle: 0)
				(gEgo hide:)
				(floArm show: self)
				(= cycles 1)
			)
			(2
				(if (<= 1 register 3)
					(gSq5Music2 number: 212 setLoop: 1 play:)
					(= seconds 2)
				else
					(= ticks 30)
				)
			)
			(3
				(if (<= 1 register 3)
					(proc201_5 0)
					(floTalker talkWidth: 60)
					(gMessager say: 19 0 0 1 self) ; "Hailing, sir..."
				else
					(self changeState: 6)
				)
			)
			(4
				(= seconds 3)
				(floTalker talkWidth: 120)
				(proc201_5 1)
				(gSq5Music2 number: 234 setLoop: 1 play:)
			)
			(5
				(if (and (== register 1) (not (IsFlag 34)) (== gEurekaLocation 0)) ; Nowhere
					(= cycles 1)
				else
					(proc201_6 self)
				)
			)
			(6
				(flo stopUpd:)
				(if (not (IsFlag 61))
					(gSq5Music2 number: 206 setLoop: -1 play:)
				)
				(self dispose:)
			)
		)
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance sDrooleArm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(switch (Random 0 6)
					(0
						(drooleArm setCel: 0)
						(drooleHand hide:)
					)
					(else
						(drooleArm setCel: 1)
						(drooleHand show: setCel: (Random 2 4))
					)
				)
				(= cycles 1)
			)
			(2
				(= ticks (Random 3 20))
			)
			(3
				(self changeState: 1)
			)
		)
	)
)

(instance sStepOnGas of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic3 number: 163 loop: 1 play: self)
			)
			(1
				(UnLoad 132 163)
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 4))
				(gGame setCursor: 984 1)
				(self dispose:)
			)
		)
	)
)

(instance sFlashWhite of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music2 number: 211 setLoop: 1 play:)
				(if (gCast contains: wasteBeacon)
					(wasteBeacon dispose:)
				)
				(= seconds 2)
			)
			(1
				(Palette palSET_INTENSITY 64 127 0)
				(= cycles 1)
			)
			(2
				(Palette palSET_FROM_RESOURCE 4101 2)
				(Palette palSET_INTENSITY 64 127 0)
				(droole setScript: sStepOnGas)
				(= cycles 1)
			)
			(3
				(for ((= register 0)) (< register 65) ((+= register 15))
					(Palette palSET_INTENSITY 64 127 register)
					(if (== register 60)
						(= cycles 1)
					)
				)
				(= local8 1)
				(= local10 0)
				(localproc_4)
			)
			(4
				(Palette palSET_INTENSITY 64 127 100)
				(= cycles 1)
			)
			(5
				(Palette palSET_FROM_RESOURCE 412 2)
				(= gEurekaLocation 17) ; empty space
				(= local8 0)
				(eureka timer: 0 setScript: 0)
				(eureka
					setScript:
						(if (and (== (eureka destination:) 3) (not (IsFlag 9))) ; ku
							(ScriptID 210 6) ; sWD40Timer
						else
							(ScriptID 210 4) ; sApproachTimer
						)
						0
						30
				)
				(= cycles 1)
			)
			(6
				(gSq5Music2 number: 206 setLoop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance sPutOnBrakes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music2 number: 214 loop: 1 play: self)
			)
			(1
				(gSq5Music2 number: 107 loop: 1 play: self)
			)
			(2
				(gSq5Music2 number: 206 loop: -1 play:)
				(= gEurekaLocation 16) ; empty space
				(if (and (== (eureka state:) 2) (eureka destination:))
					(= next sBigPlanet)
					(self dispose:)
				else
					(gGame handsOn:)
					(gTheIconBar select: (gTheIconBar at: 4))
					(gGame setCursor: 984 1)
					(self dispose:)
				)
			)
		)
	)
)

(instance sFlashRed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 61))
					(gSq5Music2 number: 211 setLoop: 1 play:)
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(1
				(Palette palSET_INTENSITY 64 127 0)
				(if (not (IsFlag 61))
					(droole setScript: sPutOnBrakes)
				else
					(gSq5Music2 number: 128 loop: -1 play:)
				)
				(= cycles 1)
			)
			(2
				(Palette palSET_FROM_RESOURCE 4102 2)
				(Palette palSET_INTENSITY 64 127 0)
				(= cycles 1)
			)
			(3
				(for ((= register 0)) (< register 65) ((+= register 10))
					(Palette palSET_INTENSITY 64 127 register)
					(if (>= register 60)
						(= cycles 1)
					)
				)
				(= local9 1)
				(localproc_4)
			)
			(4
				(Palette palSET_INTENSITY 64 127 100)
				(= cycles 1)
			)
			(5
				(Palette palSET_FROM_RESOURCE 412 2)
				(= local9 0)
				(= cycles 1)
			)
			(6
				(= local10 1)
				(if (IsFlag 61)
					(= seconds 1)
				else
					(= cycles 1)
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance sTrashBeacon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc201_6 self)
			)
			(1
				(gMessager say: 39 0 51 1 self) ; "I'm tracking a waste beacon, sir."
			)
			(2
				(self setScript: sBusyFlo self 0)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sBigPlanet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 38)
				(eureka setScript: 0 timer: 0)
				(if (> (eureka curLocation:) 14) ; goliath
					(eureka state: 1 destination: 0 curLocation: 0) ; Nowhere, Nowhere
					(proc201_27 0)
					(gMessager say: 11 0 14 4 self) ; "Here we are Captain, nowhere!"
					(= state 3)
				else
					(switch (eureka curLocation:)
						(1 ; garbage1
							(if (IsFlag 35)
								(ClearFlag 38)
							else
								(SetFlag 38)
							)
							(= cycles 1)
						)
						(2 ; garbage2
							(if (IsFlag 36)
								(ClearFlag 38)
							else
								(SetFlag 38)
							)
							(= cycles 1)
						)
						(5 ; clorox2
							(if (and (not (IsFlag 93)) (IsFlag 30))
								(= local2 1)
							else
								(= local2 0)
							)
							(= cycles 1)
						)
						(6 ; thrakus
							(if (and (not (IsFlag 94)) (IsFlag 33))
								(= local3 1)
							else
								(= local3 0)
							)
							(= cycles 1)
							((ScriptID 221 0) init:) ; asteroids
						)
						(12 ; generic planet 4
							(if (IsFlag 75)
								(self setScript: (ScriptID 207 6) self) ; sFoundGoliath
							else
								(= cycles 1)
							)
						)
						(else
							(= cycles 1)
						)
					)
				)
			)
			(1
				(if (IsFlag 38)
					(wasteBeacon init: setCycle: Fwd self)
				)
				(bigPlanet
					init:
					setScale: ScaleTo 100 5 2
					setMotion: MoveTo -64 125 self
				)
			)
			(2
				(cond
					((IsFlag 38)
						(self setScript: sTrashBeacon self)
					)
					(local3
						(= local3 0)
						(self setScript: (ScriptID 233 2) self) ; sApproachThrakus
					)
					(local2
						(= local2 0)
						(self setScript: (ScriptID 233 1) self) ; sApproachClorox
					)
					((IsFlag 61)
						(self dispose:)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(eureka
					timer: 0
					setScript: (ScriptID 210 4) 0 30 ; sApproachTimer
					warnings: 2
					destination: 0 ; Nowhere
				)
				(= cycles 1)
			)
			(4
				(proc201_27 1)
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 4))
				(gGame setCursor: 984 1)
				(self dispose:)
			)
		)
	)
)

(instance sInToOrbit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 61))
					(gSq5Music2 number: 211 setLoop: 1 play:)
				)
				(= seconds 2)
			)
			(1
				(= local6 1)
				(bigPlanet init:)
				(if (== (eureka curLocation:) 6) ; thrakus
					((ScriptID 221 0) init:) ; asteroids
				)
			)
			(2
				(= gEurekaLocation (eureka curLocation:))
				(switch (eureka curLocation:)
					(7 ; genetix Space Lab
						(= next (ScriptID 232 11)) ; sGenetixAlien
					)
					(4 ; spacebar
						(cond
							((< gGarbagePickupCount 3)
								(= next (ScriptID 232 12)) ; sSpaceBarQuirk
							)
							((== gGarbagePickupCount 3)
								(SetFlag 85)
								(= next sAbandonShip)
							)
						)
					)
					(6 ; thrakus
						(if (== gAct 1)
							(SetScore 181 20)
						)
						((ScriptID 221 0) addToPic:) ; asteroids
					)
					(5 ; clorox2
						(if (IsFlag 30)
							(SetScore 177 10)
							(if (and (not (IsFlag 97)) (not (IsFlag 76)))
								(SetFlag 108)
							)
						)
					)
					(8 ; genetix environdome
						(SetScore 180 10)
					)
				)
				(if (not (IsFlag 61))
					(bigPlanet addToPic:)
				)
				(= cycles 1)
			)
			(3
				(if (not (IsFlag 61))
					(gSq5Music2 number: 206 setLoop: -1 play:)
					(gGame handsOn:)
					(gTheIconBar select: (gTheIconBar at: 4))
					(gGame setCursor: 984 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance sOutOfOrbit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (== gEurekaLocation 6) (gAddToPics contains: (ScriptID 221 0))) ; thrakus, asteroids
					(gAddToPics delete: (ScriptID 221 0)) ; asteroids
				)
				(gSq5Music2 number: 211 setLoop: 1 play:)
				(= seconds 2)
			)
			(1
				(gCurRoom drawPic: 41 100)
				(flo startUpd:)
				(droole startUpd:)
				(bigPlanet init:)
				(if (== gEurekaLocation 6) ; thrakus
					((ScriptID 221 0) init:) ; asteroids
				)
				(= local7 1)
			)
			(2
				(= gEurekaLocation 16) ; empty space
				(eureka state: 1)
				(= local7 0)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 4))
				(gGame setCursor: 984 1)
				(if (== (eureka curLocation:) 15) ; empty space
					(eureka curLocation: 6) ; thrakus
				)
				(gSq5Music2 number: 206 setLoop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance smallPlanet of Actor
	(properties
		x 156
		y 81
		view 217
		loop 4
		cel 6
		maxScale 20
	)

	(method (init)
		(self
			setLoop: 4
			setCel: 6
			x: 156
			y: 81
			setPri: 5
			ignoreActors: 1
			scaleX: 20
			scaleY: 20
			moveSpeed: 0
			setStep: 5 5
		)
		(super init: &rest)
	)

	(method (doit)
		(if (and (== (eureka state:) 2) (== gEurekaLocation 16)) ; empty space
			(self dispose:)
		)
		(super doit: &rest)
	)
)

(instance wasteBeacon of Prop
	(properties
		x 130
		y 75
		view 217
		loop 3
		detailLevel 2
	)

	(method (init)
		(if (< (eureka warnings:) 2)
			(self setPri: 6 setLoop: 3 x: 130 y: 75 ignoreActors:)
		else
			(self x: -64 y: 125 hide:)
		)
		(super init: &rest)
		(theMusic3 number: 224 loop: -1 play:)
	)

	(method (doit)
		(self x: (+ (bigPlanet x:) 10) y: (bigPlanet y:))
		(super doit: &rest)
	)

	(method (dispose)
		(theMusic3 fade: 0 10 10 1)
		(super dispose: &rest)
	)
)

(instance bigPlanet of Actor
	(properties
		view 212
		signal 24576
	)

	(method (init &tmp temp0)
		(if
			(or
				(and
					(== (eureka state:) 2)
					(eureka destination:)
					(not (IsFlag 32))
				)
				(== (eureka state:) 3)
			)
			(self
				view: [local41 (eureka curLocation:)]
				setStep: 15 15
				setPri: 5
			)
			(if (= temp0 [local57 (eureka curLocation:)])
				(Palette palSET_FROM_RESOURCE temp0 2)
			)
			(switch (eureka state:)
				(2
					(self
						x: 130
						y: 75
						scaleX: 10
						scaleY: 10
						maxScale: 10
						scaleSignal: 1
						setCel: 0
						setLoop: 0
						moveSpeed: 0
						ignoreActors: 1
					)
				)
				(3
					(self signal: 0)
					(if local6
						(self
							ignoreActors: 1
							view: [local41 (eureka curLocation:)]
							setLoop:
								(if (OneOf (eureka curLocation:) 4 7 8 14) ; spacebar, genetix Space Lab, genetix environdome, goliath
									0
								else
									1
								)
							x: -186
							y: 58
							setCycle: 0
							scaleSignal: 1
							scaleX: 128
							scaleY: 128
							maxScale: 128
							setPri: 5
						)
					else
						(self
							ignoreActors: 1
							view: [local41 (eureka curLocation:)]
							setLoop:
								(if
									(OneOf
										(eureka curLocation:)
										4 ; spacebar
										7 ; genetix Space Lab
										8 ; genetix environdome
										14 ; goliath
										15 ; empty space
									)
									0
								else
									1
								)
							x: 48
							y: 58
							setCycle: 0
							scaleSignal: 1
							scaleX: 128
							scaleY: 128
							maxScale: 128
							setPri: 5
						)
					)
					(if
						(and
							(== (eureka curLocation:) 14) ; goliath
							(>= (eureka puke:) 1)
						)
						(self view: 227)
					)
				)
				(else
					(super init: &rest)
				)
			)
			(super init: &rest)
		)
	)

	(method (doit)
		(cond
			(local6
				(if (> x 42)
					(sInToOrbit cue:)
					(= local6 0)
				else
					(self setMotion: MoveTo (+ x 6) y)
				)
			)
			(local7
				(if (< x -180)
					(sOutOfOrbit cue:)
					(switch (eureka curLocation:)
						(15 ; empty space
							((ScriptID 221 1) dispose:) ; asteroid1
							((ScriptID 221 2) dispose:) ; asteroid2
							((ScriptID 221 3) dispose:) ; asteroid3
							((ScriptID 221 4) dispose:) ; asteroid4
						)
						(6 ; thrakus
							((ScriptID 221 0) dispose:) ; asteroids
						)
					)
					(self dispose:)
				else
					(self setMotion: MoveTo (- x 6) y)
				)
			)
		)
		(super doit: &rest)
	)
)

(instance leadStar of Actor
	(properties
		view 217
		priority 4
		signal 24576
	)

	(method (init)
		(self x: 44 y: 129 ignoreActors: 1)
		(super init: &rest)
	)

	(method (doit)
		(if local11
			(if (> x 464)
				(= local11 0)
				(sTurnAround cue:)
				(self dispose:)
			else
				(self x: (+ x 6))
			)
		else
			(self dispose:)
		)
		(super doit: &rest)
	)
)

(instance fastStar of Actor
	(properties
		view 217
		priority 4
		signal 24592
		moveSpeed 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(cond
			((== (eureka state:) 3)
				(= temp0 (Random 5 85))
			)
			(local10
				(= temp0 (Random 5 65))
			)
			(else
				(= temp0 (Random 15 25))
			)
		)
		(= temp1 (Random 0 359))
		(= temp2 (+ 155 (CosMult temp1 temp0)))
		(= temp3 (+ 78 (SinMult temp1 temp0)))
		(self
			illegalBits: 0
			posn: temp2 temp3
			setLoop: 0
			setCel: 0
			heading: (+ temp1 90)
			setStep: 5 5
			setCycle: 0
		)
		(if local10
			(self setLoop: (Random 0 2) stopUpd: setMotion: 0)
		else
			(self setStep: 5 5 setMotion: MoveFwd 40 self)
		)
		(super init: &rest)
	)

	(method (doit)
		(cond
			(local6
				(if (> x 276)
					(self x: (- x 230))
				)
				(self x: (+ x 6))
			)
			(local7
				(if (< x 44)
					(self x: (+ x 240))
				)
				(self x: (- x 6))
			)
			(local11
				(if (< x 44)
					(self x: (+ x 230))
				)
				(self x: (- x 6))
			)
		)
		(super doit: &rest)
	)

	(method (cue)
		(cond
			(local9
				(self setStep: 1 1 setMotion: MoveFwd 10 self)
			)
			(local8
				(self setStep: 10 10 setMotion: MoveFwd 20 self)
			)
			(local10
				(self setMotion: 0)
			)
			((self inRect: 44 39 276 128)
				(self
					setLoop: (mod (+ (self loop:) 1) 3)
					setStep: (* xStep 2) (* yStep 2)
					setMotion: MoveFwd 40 self
				)
			)
			(else
				(self init:)
			)
		)
	)
)

(instance mediumStar of Actor
	(properties
		view 217
		priority 4
		signal 24592
		moveSpeed 5
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(cond
			((== (eureka state:) 3)
				(= temp0 (Random 5 85))
			)
			(local10
				(= temp0 (Random 5 65))
			)
			(else
				(= temp0 (Random 10 15))
			)
		)
		(= temp1 (Random 0 359))
		(= temp2 (+ 155 (CosMult temp1 temp0)))
		(= temp3 (+ 78 (SinMult temp1 temp0)))
		(self
			illegalBits: 0
			setHeading: (+ temp1 90)
			posn: temp2 temp3
			setLoop: 0
			setCel: (Random 0 1)
			setStep: 4 4
			setCycle: 0
		)
		(if local10
			(self setLoop: (Random 0 2) stopUpd: setMotion: 0)
		else
			(self setStep: 4 4 setMotion: MoveFwd 40 self)
		)
		(super init: &rest)
	)

	(method (doit)
		(cond
			(local6
				(if (> x 276)
					(self x: (- x 230))
				)
				(self x: (+ x 3))
			)
			(local7
				(if (< x 44)
					(self x: (+ x 240))
				)
				(self x: (- x 3))
			)
			(local11
				(if (< x 44)
					(self x: (+ x 230))
				)
				(self x: (- x 3))
			)
		)
		(super doit: &rest)
	)

	(method (cue)
		(cond
			(local9
				(self setStep: 1 1 setMotion: MoveFwd 10 self)
			)
			(local8
				(self setStep: 5 5 setMotion: MoveFwd 20 self)
			)
			(local10
				(self setMotion: 0)
			)
			((self inRect: 44 39 276 128)
				(self
					setLoop: (mod (+ (self loop:) 1) 3)
					setStep: (* xStep 2) (* yStep 2)
					setMotion: MoveFwd 40 self
				)
			)
			(else
				(self init:)
			)
		)
	)
)

(instance slowStar of Actor
	(properties
		view 217
		priority 4
		signal 24592
		moveSpeed 10
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(cond
			((== (eureka state:) 3)
				(= temp0 (Random 5 85))
			)
			(local10
				(= temp0 (Random 5 65))
			)
			(else
				(= temp0 (Random 10 15))
			)
		)
		(= temp1 (Random 0 359))
		(= temp2 (+ 155 (CosMult temp1 temp0)))
		(= temp3 (+ 78 (SinMult temp1 temp0)))
		(self
			illegalBits: 0
			setHeading: (+ temp1 90)
			posn: temp2 temp3
			setLoop: 0
			setCel: (Random 2 3)
			setStep: 1 1
			setCycle: 0
		)
		(if local10
			(self setLoop: (Random 0 2) stopUpd: setMotion: 0)
		else
			(self setStep: 2 2 setMotion: MoveFwd 40 self)
		)
		(super init: &rest)
	)

	(method (doit)
		(cond
			(local6
				(if (> x 276)
					(self x: (- x 230))
				)
				(self x: (+ (self x:) xStep))
			)
			(local7
				(if (< x 44)
					(self x: (+ x 240))
				)
				(self x: (- (self x:) xStep))
			)
			(local11
				(if (< x 44)
					(self x: (+ x 230))
				)
				(self x: (- x 3))
			)
		)
		(super doit: &rest)
	)

	(method (cue)
		(cond
			(local9
				(self setStep: 1 1 setMotion: MoveFwd 10 self)
			)
			(local8
				(self setStep: 2 2 setMotion: MoveFwd 20 self)
			)
			(local10
				(self setMotion: 0)
			)
			((self inRect: 44 39 276 128)
				(self
					setLoop: (mod (+ (self loop:) 1) 3)
					setStep: (* xStep 2) (* yStep 2)
					setMotion: MoveFwd 40 self
				)
			)
			(else
				(self init:)
			)
		)
	)
)

(instance ViewScreen of Feature
	(properties
		x 165
		y 179
		z 93
		noun 23
		onMeCheck 2
	)

	(method (init)
		(switch gEurekaLocation
			(0 ; Nowhere
				((ScriptID 214 1) init: ignoreActors: 1 addToPic:) ; dockWall
				((ScriptID 214 0) init: ignoreActors: 1 addToPic:) ; starField
				(if (not (IsFlag 31))
					((ScriptID 214 3) init: stopUpd: ignoreActors: 1) ; rightBayDoor
					((ScriptID 214 2) init: stopUpd: ignoreActors: 1) ; leftBayDoor
				)
			)
			(6 ; thrakus
				((ScriptID 221 0) init: addToPic:) ; asteroids
			)
			(15 ; empty space
				((ScriptID 221 1) init:) ; asteroid1
				((ScriptID 221 2) init:) ; asteroid2
				((ScriptID 221 3) init:) ; asteroid3
				((ScriptID 221 4) init:) ; asteroid4
			)
			(14 ; goliath
				((ScriptID 207 0) init:) ; blob
			)
			(3 ; ku
				(if (IsFlag 61)
					((ScriptID 208 2) init: addToPic:) ; wd40Ship
				)
			)
		)
		(if (== (eureka state:) 3)
			(bigPlanet addToPic:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (gCast contains: (ScriptID 204 4)) (not (IsFlag 84))) ; eggTimer
			(gCurRoom setScript: (ScriptID 204 5)) ; sStopEggTimer
		else
			(switch theVerb
				(1 ; Look
					(cond
						((and (== (eureka state:) 2) (eureka curLocation:))
							(gMessager say: 23 1 0 (eureka curLocation:) 0 202)
						)
						((== gEurekaLocation 0) ; Nowhere
							(if (IsFlag 31)
								(gMessager say: 23 1 88 1 0 202) ; "The stars beckon through the station's open space doors."
							else
								(gMessager say: 23 1 20 1 0 202) ; "The massive doors of the station's vehicle bay are visible on the viewscreen."
							)
						)
						((and (== gEurekaLocation 6) (> gMouseX 136)) ; thrakus
							(gMessager say: 23 1 17 1 0 202) ; "An asteroid belt, perhaps the remnants of a former moon, orbits the emerald-hued planet."
						)
						((and (== gEurekaLocation 14) (< (eureka puke:) 2)) ; goliath
							(cond
								((== (eureka puke:) 1)
									(gMessager say: 23 1 92 1 0 202) ; "The huge Quirk/Pukoid blob creature has grabbed onto the Goliath."
								)
								((IsFlag 119)
									(gMessager say: 23 1 14 1 0 202) ; "Ahead of your cloaked vessel, the battle cruiser Goliath travels toward a fateful rendezvous with StarCon Command."
								)
								(else
									(SetFlag 119)
									(gMessager say: 23 1 14 0 0 202) ; "Ahead of your cloaked vessel, the battle cruiser Goliath travels toward a fateful rendezvous with StarCon Command."
								)
							)
						)
						((IsFlag 61)
							(gMessager say: 29 1 0 1 0 202) ; "A sinister looking battle cruiser looms ominously in your viewscreen."
						)
						(else
							(gMessager say: 23 1 0 gEurekaLocation 0 202)
						)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance flo of Prop
	(properties
		x -12
		y 199
		z 90
		noun 16
		view 202
		priority 12
		signal 20496
	)

	(method (init)
		(if (not (IsFlag 86))
			(self stopUpd: setCycle: 0 setScript: sFloArm ignoreActors: 1)
			(floArm init: show:)
			(super init: &rest)
		else
			(self dispose:)
		)
	)

	(method (doVerb theVerb)
		(if (gCast contains: (ScriptID 204 4)) ; eggTimer
			(gCurRoom setScript: (ScriptID 204 5)) ; sStopEggTimer
		else
			(switch theVerb
				(24 ; Order
					(gGame handsOff:)
					(gCurRoom setScript: (ScriptID 216 0)) ; sCommandFlo
				)
				(2 ; Talk
					(gGame handsOff:)
					(gCurRoom setScript: (ScriptID 216 1)) ; sTalkToFlo
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance droole of Prop
	(properties
		x 276
		y 200
		z 80
		noun 11
		view 203
		priority 9
		signal 20496
		detailLevel 3
	)

	(method (init)
		(if (or (IsFlag 86) (IsFlag 97))
			(self dispose:)
		else
			(self stopUpd: setCycle: 0 ignoreActors: 1)
			(drooleArm init:)
			(super init: &rest)
		)
	)

	(method (doVerb theVerb)
		(if (gCast contains: (ScriptID 204 4)) ; eggTimer
			(gCurRoom setScript: (ScriptID 204 5)) ; sStopEggTimer
		else
			(switch theVerb
				(24 ; Order
					(gGame handsOff:)
					(gCurRoom setScript: (ScriptID 217 0)) ; sCommandDroole
				)
				(2 ; Talk
					(gCurRoom setScript: (ScriptID 217 1)) ; sTalkToDroole
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance drooleArm of Prop
	(properties
		x 275
		y 178
		view 203
		loop 2
		priority 9
		signal 16
		detailLevel 3
	)

	(method (init)
		(drooleHand init:)
		(self setScript: sDrooleArm setCycle: 0 show:)
		(super init: &rest)
	)
)

(instance drooleHand of Prop
	(properties
		x 275
		y 178
		view 203
		loop 2
		cel 2
		priority 9
		signal 16
		detailLevel 3
	)

	(method (init)
		(self hide:)
		(super init: &rest)
	)
)

(instance rogTalker of Narrator
	(properties)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 152 tailY: 138 xOffset: 0 isBottom: 0)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance floTalker of ChoiceTalker
	(properties
		x -22
		y 107
		view 202
		loop 1
		cel 1
		signal 16384
		talkWidth 120
		normal 1
	)

	(method (init)
		(= font gUserFont)
		(if normal
			(= gSystemWindow gSpeakWindow)
			(gSystemWindow tailX: 55 tailY: 88 xOffset: 30 isBottom: 1)
		else
			(= gSystemWindow gSq5Win)
			(self textX: 50 textY: -100 talkWidth: 150)
		)
		(if (localproc_6)
			(self loop: 1 cel: 1)
			(super init: 0 0 floMouth &rest)
		else
			(self loop: 4 cel: 0)
			(super init: 0 0 0 &rest)
		)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance floMouth of Prop
	(properties
		nsTop 26
		nsLeft 30
		view 202
		loop 3
		cel 4
		signal 16384
	)

	(method (init)
		(self cel: 4)
		(super init: &rest)
	)
)

(instance drooleTalker of ChoiceTalker
	(properties
		x 268
		y 120
		view 203
		loop 1
		cel 2
		signal 16384
		talkWidth 120
		textX -100
		normal 1
	)

	(method (init)
		(= font gUserFont)
		(if normal
			(= gSystemWindow gSpeakWindow)
			(gSystemWindow tailX: 250 tailY: 115 xOffset: -1 isBottom: 1)
		else
			(= gSystemWindow gSq5Win)
			(self textX: -120 textY: -100 talkWidth: 120)
		)
		(if (localproc_7)
			(self loop: 1 cel: 2 x: 268 y: 120)
			(super init: 0 drooleEyes drooleMouth &rest)
		else
			(self setLoop: 5 cel: 0)
			(super init: 0 0 0 &rest)
		)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance drooleMouth of Prop
	(properties
		nsTop 16
		nsLeft 31
		view 203
		loop 3
		signal 16384
	)

	(method (init)
		(self ignoreActors: 1)
		(super init: &rest)
	)
)

(instance drooleEyes of Prop
	(properties
		nsTop 7
		nsLeft 28
		view 203
		loop 4
		priority 14
		signal 16400
	)
)

(instance floArm of View
	(properties
		x 31
		y 176
		view 202
		loop 2
		priority 12
		signal 16400
	)
)

(instance dConsole of Feature
	(properties
		x 257
		y 188
		z 30
		noun 9
		nsTop 135
		nsLeft 227
		nsBottom 182
		nsRight 287
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; Order
				(if (and (not (IsFlag 86)) (not (IsFlag 97)))
					(gGame handsOff:)
					(gCurRoom setScript: (ScriptID 217 0)) ; sCommandDroole
				else
					(super doVerb: theVerb &rest)
				)
			)
			(2 ; Talk
				(if (and (not (IsFlag 86)) (not (IsFlag 97)))
					(gGame handsOff:)
					(gCurRoom setScript: (ScriptID 217 1)) ; sTalkToDroole
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fConsole of Feature
	(properties
		x 48
		y 184
		z 30
		noun 14
		nsTop 138
		nsLeft 23
		nsBottom 170
		nsRight 74
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; Order
				(if (not (IsFlag 86))
					(gGame handsOff:)
					(gCurRoom setScript: (ScriptID 216 0)) ; sCommandFlo
				else
					(super doVerb: theVerb &rest)
				)
			)
			(2 ; Talk
				(if (not (IsFlag 86))
					(gGame handsOff:)
					(gCurRoom setScript: (ScriptID 216 1)) ; sTalkToFlo
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance capChair of Feature
	(properties
		x 162
		y 199
		z 30
		noun 5
		nsTop 149
		nsLeft 127
		nsBottom 189
		nsRight 197
	)
)

(instance vid1Monitor of Feature
	(properties
		x 100
		y 35
		noun 36
		nsTop 26
		nsLeft 89
		nsBottom 41
		nsRight 112
	)
)

(instance vid2Monitor of Feature
	(properties
		x 219
		y 34
		noun 37
		nsTop 26
		nsLeft 207
		nsBottom 41
		nsRight 232
	)
)

(instance vid3Monitor of Feature
	(properties
		x 160
		y 34
		noun 38
		nsTop 26
		nsLeft 143
		nsBottom 42
		nsRight 177
	)
)

(instance bridge of Feature
	(properties
		x 163
		y 234
		z 50
		nsTop 171
		nsLeft 145
		nsBottom 188
		nsRight 178
	)

	(method (doVerb theVerb)
		(cond
			((and (gCast contains: (ScriptID 204 4)) (not (IsFlag 84))) ; eggTimer
				(gCurRoom setScript: (ScriptID 204 5)) ; sStopEggTimer
			)
			((OneOf theVerb 4 3) ; Do, Walk
				(gGame handsOff:)
				(gCurRoom newRoom: 200)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buttonPanel of Feature
	(properties
		x 201
		y 153
		nsTop 150
		nsLeft 200
		nsBottom 157
		nsRight 218
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(cond
					((InRect 200 160 204 167 gMouseX gMouseY)
						(= temp0 0)
					)
					((InRect 207 160 211 167 gMouseX gMouseY)
						(= temp0 1)
					)
					((InRect 214 160 218 167 gMouseX gMouseY)
						(= temp0 2)
					)
				)
				(if (not (gCurRoom script:))
					(gGame handsOff:)
					(gCurRoom setScript: (ScriptID 202 6) 0 temp0) ; sPushButtons
				)
			)
			(1 ; Look
				(cond
					((InRect 200 160 204 167 gMouseX gMouseY)
						(= temp0 1)
					)
					((InRect 207 160 211 167 gMouseX gMouseY)
						(= temp0 2)
					)
					((InRect 214 160 218 167 gMouseX gMouseY)
						(= temp0 3)
					)
				)
				(gMessager say: 6 1 0 temp0 0 202)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

