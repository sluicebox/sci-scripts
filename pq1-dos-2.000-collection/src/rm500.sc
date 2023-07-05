;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use Print)
(use Feature)
(use LoadMany)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm500 0
	car 1
	exitDrive 2
	proc500_3 3
	changeOverlay 4
	lines 5
	carCursor 6
	straight 7
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7 = 2010
	local8
	local9
	local10 = 55
	local11 = -1
	local12
	local13
	local14
	local15 = 13
	local16
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
	[local33 20] = [2 0 203 57 -7 -49 2 -7 50 3 1 0 255 107 -56 -102 0 56 -102 1]
	[local53 8] = [255 4 255 210 322 57 84 57]
	[local61 88] = [288 62 1 288 62 3 256 33 288 33 3 288 106 2 288 106 2 259 77 230 77 2 227 48 3 227 48 2 259 77 230 77 2 227 4 4 227 4 3 195 33 288 33 3 262 77 5 262 77 0 288 57 288 83 0 201 77 6 201 77 1 227 97 227 32 1 253 33 7 253 33 1 227 53 227 32 1 314 33 8 314 33 0 288 13 288 83 0]
	[local149 96] = [9 1 1 1 1 1 1 1 1 1 1 3 8 4 16 0 0 0 0 0 0 0 0 2 10 15 8 0 0 2 8 16 0 16 0 2 8 1 0 0 0 16 0 0 16 0 0 2 8 0 16 0 0 0 0 4 0 0 4 2 8 0 0 0 16 0 0 1 0 2 15 10 8 16 0 0 0 16 0 0 4 0 5 2 12 4 4 4 4 4 4 4 5 4 5 6]
	[local245 8] = [196 -98 196 111 315 8 77 8]
	[local253 40] = [3 256 7 256 48 2 288 77 230 77 8 367 59 314 59 0 288 39 288 83 1 262 104 262 62 3 230 33 288 33 6 148 57 201 57 1 227 77 227 32]
	[local293 72] = [10 11 4 1 0 3 11 23 8 0 0 2 84 85 1 1 0 3 72 84 2 0 0 2 66 67 1 2 11 3 91 92 1 2 34 2 15 16 1 2 50 1 18 19 1 2 30 2 45 46 1 2 37 2 81 82 4 2 47 2 57 58 4 2 45 2 90 91 1 2 65 2]
	[local365 16] = [129 16 389 16 385 92 125 92 297 -60 297 200 211 167 217 -93]
	[local381 14] = [-8190 -5000 -3000 -1000 -500 -300 0 300 500 1000 1750 2500 4000 5500]
)

(procedure (localproc_0)
	(= [local293 27] 3)
	(= [local293 39] 3)
	(= [local293 45] 3)
	(= [local293 51] 3)
	(= [local293 57] 3)
	(= [local293 63] 3)
	(= [local293 69] 3)
)

(procedure (localproc_1 param1 &tmp temp0)
	(while (= temp0 0)
		(if (== param1 1)
			(return temp0)
		)
		(/= param1 2)
	)
)

(procedure (proc500_3 param1)
	(= local8 2)
	(= local9 15)
	(= local20 0)
	(= local13 0)
	(theSignal init:)
	(= local11 -1)
	(if (== param1 1)
		(= local19 8)
		(= local6 3)
		(= local15 23)
		(= local18 11)
		(= local14 1)
		(= local4 3)
	else
		(= local19 2)
		(= local6 1)
		(= local15 72)
		(= local18 84)
		(= local14 0)
		(= local4 7)
	)
)

(procedure (localproc_2)
	(if (OneOf local14 1 2)
		(return (< (++ local8) 5))
	else
		(return (> (-- local8) 0))
	)
)

(procedure (localproc_3)
	(if (OneOf local14 1 2)
		(= local8 0)
	else
		(= local8 4)
	)
)

(procedure (localproc_4 &tmp temp0)
	(if (OneOf local14 0 3)
		(= temp0 local15)
	else
		(= temp0 local18)
	)
	(= local21 (+ 6 (* (/ temp0 12) 24)))
	(= local22 (+ 5 (* (mod temp0 12) 30)))
	(if (< local14 2)
		(+= local21 (* 5 local8))
	else
		(+= local22 (* 6 local8))
	)
)

(procedure (localproc_5)
	(= local0 0)
	(= global245 local15)
	(= global246 local18)
	(= global247 local14)
	(= global248 2)
	((ScriptID 501 0) register: local14) ; buyFarm
)

(procedure (localproc_6)
	(= global248 local8)
	(= global245 local15)
	(= global246 local18)
	(= global247 local14)
	(switch local26
		(11
			(switch global211
				(27
					(SetScore 135 3)
				)
				(37
					(SetScore 140 1)
				)
			)
			(if (OneOf global211 27 37 50 61 72 77 88)
				(++ global211)
			)
		)
		(34
			(if (OneOf global211 24 47 58 70)
				(++ global211)
			)
		)
		(30
			(if (OneOf global211 7)
				(++ global211)
			)
			(SetScore 131 3)
		)
		(41
			(= global211 12)
			(SetScore 132 4)
		)
		(42
			(= global211 22)
			(SetScore 133 3)
		)
		(40
			(= global211 5)
			(SetScore 130 3)
		)
		(37
			(if (== global211 32)
				(= global211 33)
			)
			(SetScore 137 2)
		)
		(43
			(= global211 44)
			(SetScore 134 5)
		)
		(45
			(= global211 64)
			(SetScore 139 1)
		)
		(47
			(= global211 86)
			(SetScore 195 10)
		)
		(50
			(if (== global211 93)
				(++ global211)
			)
		)
		(65
			(SetScore 138 1)
		)
	)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(gCurRoom newRoom: local26)
)

(procedure (localproc_7 &tmp [temp0 5])
	(if local12
		(Display {} dsRESTOREPIXELS local12)
	)
	(Format @temp0 {%d} local9)
	(= local12 (Display @temp0 dsCOLOR global126 dsFONT 30 dsCOORD 259 116 dsSAVEPIXELS))
	(Display {MPH} dsCOLOR global126 dsFONT 30 dsCOORD 259 122)
	(if (== (gLongSong2 number:) 250)
		(gLongSong2 send: 9 224 [local381 (/ local9 5)])
	)
	(dial1 init:)
)

(procedure (localproc_8 param1 &tmp [temp0 25] [temp25 20] [temp45 5])
	(if local16
		(Display {} dsRESTOREPIXELS local16)
	)
	(if local17
		(Display {} dsRESTOREPIXELS local17)
	)
	(cond
		(local19
			(Message msgGET 500 2 0 13 local4 @temp0)
			(Message msgGET 500 2 0 13 (+ local4 1) @temp25)
		)
		((and argc param1)
			(Message msgGET 500 2 1 11 (+ (mod local15 12) 1) @temp0)
			(Message msgGET 500 2 1 12 (+ (/ local15 12) 1) @temp25)
			(Message msgGET 500 2 1 10 1 @temp45) ; "and"
			(StrCat @temp0 { })
			(StrCat @temp0 @temp45)
		)
		(else
			(Message msgGET 500 4 0 0 (+ local14 1) @temp0)
			(if (< local14 2)
				(Message msgGET 500 2 1 11 (+ (mod local15 12) 1) @temp25)
			else
				(Message msgGET 500 2 1 12 (+ (/ local15 12) 1) @temp25)
			)
		)
	)
	(= local16 (Display @temp0 dsCOLOR global126 dsFONT 30 dsCOORD 197 116 dsSAVEPIXELS))
	(= local17
		(Display @temp25 dsCOLOR global126 dsFONT 30 dsCOORD 197 122 dsWIDTH 58 dsALIGN alCENTER dsSAVEPIXELS)
	)
)

(procedure (localproc_9 &tmp temp0)
	(= temp0 773)
	(if (> local21 94)
		(+= temp0 2)
		(-= local21 73)
	)
	(if (> local22 176)
		(++ temp0)
		(-= local22 150)
	)
	(if (and (not (carCursor script:)) (!= temp0 global249))
		(carCursor setScript: changeOverlay 0 temp0)
	)
)

(procedure (localproc_10)
	(if (== global211 43)
		(return (<= 14 local15 22))
	else
		(return (== (& [local149 local15] $000f) 0))
	)
)

(procedure (localproc_11 &tmp temp0 [temp1 20])
	(switch local14
		(0
			(= temp0 (if (== local13 1) 8 else 2))
		)
		(1
			(= temp0 (if (== local13 2) 8 else 2))
		)
		(2
			(= temp0 (if (== local13 1) 1 else 4))
		)
		(3
			(= temp0 (if (== local13 2) 1 else 4))
		)
	)
	(if local19
		(if (< 0 local20 3)
			(return (== local19 temp0))
		else
			(return 0)
		)
	else
		(return (not (& [local149 local15] temp0)))
	)
)

(procedure (localproc_12 &tmp temp0 temp1)
	(if local19
		(return)
	)
	(= temp1 local13)
	(if (not local13)
		(switch local14
			(0
				(= temp0 1)
			)
			(1
				(= temp0 4)
			)
			(2
				(= temp0 2)
			)
			(3
				(= temp0 8)
			)
		)
		(if (not (& [local149 local15] temp0))
			(return)
		else
			(= local13 1)
		)
	)
	(if (localproc_11)
		(theSignal init:)
		(return)
	)
	(= local13 (if (== local13 1) 2 else 1))
	(if (localproc_11)
		(theSignal init:)
		(return)
	)
	(theSignal init:)
	(= local13 0)
)

(procedure (localproc_13 &tmp temp0 [temp1 20])
	(for ((= temp0 0)) (< temp0 72) ((+= temp0 6))
		(if
			(and
				(OneOf local15 [local293 temp0] [local293 (+ temp0 1)])
				(OneOf local18 [local293 temp0] [local293 (+ temp0 1)])
				(== local8 [local293 (+ temp0 5)])
			)
			(= local3 [local293 (+ temp0 4)])
			(= local20 [local293 (+ temp0 3)])
			(= local4 (+ (* (/ temp0 6) 2) 1))
			(= local19 [local293 (+ temp0 2)])
			(return)
		)
	)
	(= local3 0)
	(= local19 0)
)

(instance rm500 of Rm
	(properties
		picture 25
		horizon -150
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 501)
	)

	(method (doit)
		(if (GameIsRestarting)
			(= global249 -1)
		)
		(super doit: &rest)
	)

	(method (init)
		(gEgo view: 0)
		(if (OneOf gPrevRoomNum 50 11 34 30 37 45 47 65)
			(= local19 1)
			(= local6 0)
			(= local9 5)
			(= local14 2)
			(= local20 2)
			(switch gPrevRoomNum
				(11
					(= local8 3)
					(= local15 67)
					(= local18 66)
					(= local14 2)
					(= local4 9)
				)
				(50
					(= local8 1)
					(= local15 16)
					(= local18 15)
					(= local14 2)
					(= local4 13)
				)
				(34
					(= local8 2)
					(= local15 92)
					(= local18 91)
					(= local14 2)
					(= local4 11)
				)
				(30
					(= local8 2)
					(= local15 19)
					(= local18 18)
					(= local14 2)
					(= local4 15)
				)
				(37
					(= local8 2)
					(= local15 46)
					(= local18 45)
					(= local14 2)
					(= local4 17)
				)
				(47
					(= local8 2)
					(= local15 81)
					(= local18 82)
					(= local14 3)
					(= local4 19)
					(= local19 4)
					(= local6 2)
				)
				(45
					(= local8 2)
					(= local15 57)
					(= local18 58)
					(= local14 3)
					(= local4 21)
					(= local19 4)
					(= local6 2)
				)
				(65
					(= local8 2)
					(= local15 91)
					(= local18 90)
					(= local14 2)
					(= local4 23)
				)
			)
		else
			(= local8 global248)
			(= local15 global245)
			(= local18 global246)
			(= local14 global247)
			(= local9 10)
		)
		(= local1 (if (< local14 2) 10 else 0))
		(= local10 55)
		(localproc_4)
		(= global249 773)
		(if (> local21 94)
			(+= global249 2)
			(-= local21 73)
		)
		(if (> local22 176)
			(++ global249)
			(-= local22 150)
		)
		(switch global207
			(914
				(= local7 2010)
				(= picture 25)
				(sirenSwitch init:)
				(car noun: 5)
			)
			(105
				(= local7 2020)
				(= picture 26)
				(car noun: 6)
			)
			(104
				(= local7 2030)
				(= picture 27)
				(car noun: 7)
			)
		)
		(Load rsPIC 773 774 775 picture)
		(LoadMany
			rsVIEW
			201
			771
			local7
			(+ local7 1)
			(+ local7 2)
			(+ local7 3)
			(+ local7 4)
			(+ local7 5)
			(+ local7 6)
			(+ local7 7)
			(+ local7 8)
		)
		(car setScript: dispatcher)
		(dashFeature init:)
		(controlFeature init:)
		(car init:)
		(mapFeature init:)
		(super init: &rest)
		(DrawPic global249 -32668 0 global40)
		(brake addToPic:)
		(gas addToPic:)
		(leftSignal addToPic:)
		(rightSignal addToPic:)
		(straightSignal addToPic:)
		(theSignal init:)
		(carCursor init:)
		(localproc_7)
		(if (> [local149 local15] 15)
			(stopSign init: (& [local149 local15] $0020))
		)
		(if (OneOf gPrevRoomNum 50 11 34 30 37 45 47 65)
			(self setScript: exitDrive)
		else
			(= local6 -1)
			(lines init: [local33 (+ local1 2)] [local33 (+ local1 3)])
			(self setScript: travel)
		)
	)
)

(instance exitDrive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 0)
				(localproc_8)
				(localproc_7)
				(p2 init: posn: 196 8)
				(*= local6 10)
				(car
					init:
						1
						[local253 (+ local6 0)]
						[local253 (+ local6 1)]
						[local253 (+ local6 2)]
					setMotion:
						MoveTo
						[local253 (+ local6 3)]
						[local253 (+ local6 4)]
						self
				)
			)
			(1
				(car setCycle: End self)
			)
			(2
				(if (or (== global211 3) (not (IsFlag 78)))
					(SetFlag 78)
					(gMessager say: 1 1 0 0 self 502) ; "Welcome to the Police Quest Driving Interface. We've made navigating Lytton easier than ever before. Here's how:"
				else
					(= next straight)
					(self dispose:)
				)
			)
			(3
				(localproc_2)
				(dispatcher seconds: 90)
				(= next straight)
				(self dispose:)
			)
		)
	)
)

(instance travel of Script
	(properties)

	(method (changeState newState &tmp [temp0 10])
		(switch (= state newState)
			(0
				(HandsOn)
				(gTheIconBar disable: 0 3)
				(= local5 1)
				(localproc_8)
				(carCursor startUpd:)
				(theSignal startUpd:)
				(car stopUpd:)
				(= local19 0)
				(= cycles 1)
			)
			(1
				(if (not local9)
					(= ticks 1)
					(-- state)
				else
					(= ticks (+ 50 (* (- 60 local9) 4)))
				)
			)
			(2
				(if
					(and
						(localproc_2)
						(not (localproc_13))
						(not
							(and
								local26
								(or
									(and
										(== local28 local18)
										(== local27 local15)
									)
									(and
										(== local28 local15)
										(== local27 local18)
									)
								)
								(== local8 local30)
							)
						)
					)
					(-= state 2)
				)
				(= cycles 1)
			)
			(3
				(cond
					((and (== global211 42) (OneOf local15 72 73 84 85))
						(targetCursor dispose:)
						(car setScript: dispatcher)
						(= next endInter)
						(= local26 0)
						(= local28 -1)
					)
					(
						(and
							local26
							(or
								(and (== local28 local18) (== local27 local15))
								(and (== local28 local15) (== local27 local18))
							)
							(== local8 local30)
						)
						(= next pullOver)
					)
					(else
						(= next endInter)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance turn of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(car
					view: (+ (car view:) [local61 (+ 2 register)])
					setLoop: 0
					cel: 0
				)
				(if (not local19)
					(car
						x: [local61 (+ 3 register)]
						y: [local61 (+ 4 register)]
					)
				)
				(if (and (> local9 30) (sirenSwitch cel:))
					(gLongSong2 number: 910 loop: 1 play:)
				)
				(car setCycle: End self)
			)
			(1
				(if (and (> local9 30) (sirenSwitch cel:))
					(gLongSong2 number: 911 loop: -1 play:)
				)
				(if local19
					(if local3
						(= local26 local3)
						(localproc_6)
					else
						((ScriptID 501 1) ; travelFreeway
							register: (if (== local4 1) -1 else 1)
						)
						(= next (ScriptID 501 1)) ; travelFreeway
						(self dispose:)
					)
				else
					(= temp0
						(switch (= local14 [local61 (+ 10 register)])
							(0 1)
							(1 0)
							(2 3)
							(3 2)
						)
					)
					(p2
						setMotion:
							MoveTo
							[local245 (* temp0 2)]
							[local245 (+ (* temp0 2) 1)]
							self
					)
					(= local1 (if (OneOf local14 0 1) 10 else 0))
					(lines
						init:
							[local53 (* local14 2)]
							[local53 (+ (* local14 2) 1)]
							[local33 (+ local1 2)]
							[local33 (+ local1 3)]
							self
					)
					(car
						view: local7
						setLoop: 0
						cel: [local61 (+ 5 register)]
						x: [local61 (+ 6 register)]
						y: [local61 (+ 7 register)]
						setMotion:
							MoveTo
							[local61 (+ 8 register)]
							[local61 (+ 9 register)]
							self
					)
				)
			)
			(2)
			(3)
			(4
				(curb1 stopUpd:)
				(curb2 stopUpd:)
				(if (not local19)
					(= temp0
						(switch local14
							(0 -12)
							(1 12)
							(2 1)
							(3 -1)
						)
					)
					(p2 dispose:)
					(= local18 local15)
					(+= local15 temp0)
					(localproc_3)
				)
				(if local23
					(= next getEm)
				else
					(= next travel)
				)
				(= local13 0)
				(theSignal init:)
				(if (> [local149 local15] 15)
					(stopSign init: (& [local149 local15] $0020))
				)
				(self dispose:)
			)
		)
	)
)

(instance getEm of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(car setScript: 0)
				(= local5 0)
				(switch local14
					(0
						(= local24 0)
						(= local25 25)
					)
					(1
						(= local24 0)
						(= local25 -25)
					)
					(2
						(= local24 -25)
						(= local25 0)
					)
					(3
						(= local24 25)
						(= local25 0)
					)
				)
				(car
					moveSpeed: 6
					setStep: 3 2
					setMotion:
						MoveTo
						(+ (car x:) local24)
						(+ (car y:) local25)
						self
				)
				(offCar
					moveSpeed: 3
					xStep: 3
					yStep: 2
					posn:
						(+ (offCar x:) (* local25 2))
						(- (offCar y:) (* local24 2))
					setMotion:
						MoveTo
						(- (car x:) (* local24 2))
						(- (car y:) (* local25 2))
						self
				)
			)
			(1)
			(2
				(gMessager
					say:
						9
						2
						(switch local32
							(220 28)
							(224 26)
							(226 30)
						)
						0
						self
				)
			)
			(3
				(localproc_2)
				(car
					setMotion:
						MoveTo
						(+ (car x:) (/ local25 2))
						(- (car y:) (/ local24 2))
						self
				)
				(offCar
					moveSpeed: 6
					setStep: 3 2
					setMotion:
						MoveTo
						(+ (offCar x:) (/ local25 2))
						(- (offCar y:) (/ local24 2))
						self
				)
			)
			(4
				(localproc_2)
			)
			(5
				(self setScript: changeSpeed self 0)
			)
			(6
				(localproc_6)
			)
		)
	)
)

(instance pullOver of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(car setScript: 0)
				(= local5 0)
				(switch local14
					(0
						(= local24 0)
						(= local25 25)
					)
					(1
						(= local24 0)
						(= local25 -25)
					)
					(2
						(= local24 -25)
						(= local25 0)
					)
					(3
						(= local24 25)
						(= local25 0)
					)
				)
				(car
					moveSpeed: 6
					setStep: 3 2
					setMotion:
						MoveTo
						(+ (car x:) (/ local25 2))
						(- (car y:) (/ local24 2))
						self
				)
			)
			(1
				(self setScript: changeSpeed self 0)
			)
			(2
				(localproc_6)
			)
		)
	)
)

(instance changeSpeed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= register local9)
					(-- state)
					(if (> local9 register)
						(-= local9 5)
					else
						(+= local9 5)
					)
					(localproc_7)
				)
				(= ticks 30)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance endInter of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local5 0)
				(localproc_12)
				(localproc_8 1)
				(= local0 0)
				(cond
					((and local32 (not local19) (localproc_10))
						(= local31 1)
					)
					((and (> [local149 local15] 15) (< local9 20))
						(= local31 1)
					)
					(
						(and
							(> [local149 local15] 15)
							(> local9 15)
							(not (sirenSwitch cel:))
						)
						(= local0 1)
						(= local13 0)
					)
					(else
						(= local31 0)
					)
				)
				(cond
					(local31
						(self setScript: changeSpeed self 5)
					)
					(
						(and
							(> local9 (if (sirenSwitch cel:) 45 else 35))
							local13
							(not local0)
						)
						(self
							setScript:
								changeSpeed
								self
								(if (sirenSwitch cel:) 40 else 30)
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(= temp0
					(switch local14
						(0
							(= local24 0)
							(= local25 20)
							1
						)
						(1
							(= local24 0)
							(= local25 -20)
							0
						)
						(2
							(= local24 -20)
							(= local25 0)
							3
						)
						(3
							(= local24 20)
							(= local25 0)
							2
						)
					)
				)
				(if (not local31)
					(= local24 0)
					(= local25 0)
				)
				(= local1 (if (OneOf temp0 0 1) 10 else 0))
				(if
					(or
						(not (OneOf (& [local149 local15] $000f) 5 10))
						local19
					)
					(p2
						init:
						setMotion:
							MoveTo
							(- 196 (* local24 3))
							(- 8 (* local25 3))
							self
					)
					(lines
						init:
							[local33 (+ local1 2)]
							[local33 (+ local1 3)]
							(- [local53 (* temp0 2)] (* local24 3))
							(- [local53 (+ (* temp0 2) 1)] (* local25 3))
							self
					)
					(if local31
						(car
							setMotion:
								MoveTo
								(+ (car x:) local24)
								(+ (car y:) local25)
						)
					else
						(+= state 3)
						(if (and local13 (localproc_11) (not local0))
							(= register (* (+ (* 2 local14) (- local13 1)) 11))
							(if (not local19)
								(car
									setMotion:
										MoveTo
										[local61 (+ 0 register)]
										[local61 (+ 1 register)]
								)
							)
						)
					)
				else
					(= local13 0)
					(theSignal init:)
					(if local0
						(localproc_5)
						(= next (ScriptID 501 0)) ; buyFarm
					else
						(= next straight)
					)
					(= cycles 0)
					(self dispose:)
				)
			)
			(2
				(if local31
					(= local9 0)
					(localproc_7)
				)
			)
			(3
				(if local32
					(offCar init: self)
				else
					(self changeState: (+= state 2))
				)
			)
			(4
				(gMessager
					say:
						9
						2
						(switch local32
							(220 27)
							(224 25)
							(226 29)
						)
						0
						self
				)
			)
			(5
				(= local5 1)
				(if local31
					(if (and (not local9) (not (sirenSwitch cel:)))
						(-- state)
					)
					(= cycles 1)
				)
			)
			(6
				(localproc_7)
				(= local5 0)
				(= temp0
					(switch local14
						(0
							(= local24 0)
							(= local25 20)
							1
						)
						(1
							(= local24 0)
							(= local25 -20)
							0
						)
						(2
							(= local24 -20)
							(= local25 0)
							3
						)
						(3
							(= local24 20)
							(= local25 0)
							2
						)
					)
				)
				(localproc_12)
				(if local31
					(p2 setMotion: MoveTo 196 8 self)
					(lines
						init:
							(lines x:)
							(lines y:)
							[local53 (* temp0 2)]
							[local53 (+ (* temp0 2) 1)]
							self
					)
					(if local32
						(if (sirenSwitch cel:)
							(= local13 2)
							(sirenSwitch stopUpd:)
							(= local23 1)
							(theSignal setScript: changeSpeed 0 60)
						else
							(= local32 0)
							(switch global211
								(11
									(= global211 13)
									(car setScript: dispatcher)
								)
								(21
									(= global211 27)
									(car setScript: dispatcher)
								)
								(43
									(gMessager say: 10 2 35 0) ; "You've completely missed your chance to apprehend an extremely dangerous figure in Lytton's burgeoning crime world."
									(localproc_6)
								)
							)
						)
					)
					(if (and local13 (localproc_11))
						(= register (* (+ (* 2 local14) (- local13 1)) 11))
						(if (not local19)
							(car
								setMotion:
									MoveTo
									[local61 (+ 0 register)]
									[local61 (+ 1 register)]
									self
							)
						else
							(= cycles 1)
						)
					else
						(car
							setMotion:
								MoveTo
								(- (car x:) local24)
								(- (car y:) local25)
								self
						)
					)
				else
					(+= state 2)
					(= cycles 1)
				)
			)
			(7)
			(8)
			(9
				(stopSign dispose:)
				(= local31 0)
				(if local13
					(if (localproc_11)
						(= local1 (if (OneOf local14 0 1) 10 else 0))
						(turn register: (* (+ (* 2 local14) (- local13 1)) 11))
						(= next turn)
					else
						(= local13 0)
						(theSignal init:)
						(if local0
							(localproc_5)
							(= next (ScriptID 501 0)) ; buyFarm
						else
							(= next straight)
						)
						(if local19
							(switch local20
								(0
									(gMessager say: 10 2 34 0) ; "This ramp is only for exiting the freeway."
								)
								(3
									(gMessager say: 10 2 33 0) ; "When you're transporting suspects, they should be brought directly to the Lytton County Jail. Regulations prohibit you from making other stops unless told to do so by Dispatch."
								)
								(4
									(gMessager say: 10 2 39 0) ; "A stop at the Cove isn't on your agenda, Bonds. Return to duty."
								)
								(5
									(gMessager say: 10 2 40 0) ; "You don't have time to be lounging around at the park, Bonds."
								)
							)
						)
					)
					(self dispose:)
				else
					(= local13 0)
					(theSignal init:)
					(if local0
						(localproc_5)
						(= next (ScriptID 501 0)) ; buyFarm
					else
						(= next straight)
					)
					(self dispose:)
				)
			)
		)
	)
)

(instance straight of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= register
					(switch local14
						(0 1)
						(1 0)
						(2 3)
						(3 2)
					)
				)
				(= local1 (if (OneOf local14 0 1) 10 else 0))
				(if
					(or
						(not (OneOf (& [local149 local15] $000f) 5 10))
						local19
					)
					(lines
						init:
							[local53 (* local14 2)]
							[local53 (+ (* local14 2) 1)]
							[local33 (+ local1 2)]
							[local33 (+ local1 3)]
							self
					)
					(p2
						setMotion:
							MoveTo
							[local245 (* register 2)]
							[local245 (+ (* register 2) 1)]
							self
					)
					(if (!= local6 -1)
						(car
							view: local7
							loop: 0
							cel: [local253 (+ local6 5)]
							posn:
								[local253 (+ local6 6)]
								[local253 (+ local6 7)]
							setMotion:
								MoveTo
								[local253 (+ local6 8)]
								[local253 (+ local6 9)]
						)
						(= local6 -1)
					)
				else
					(= cycles 1)
					(++ state)
				)
			)
			(1)
			(2
				(curb1 stopUpd:)
				(curb2 stopUpd:)
				(p2 dispose:)
				(if (not local19)
					(= temp0
						(switch local14
							(0 -12)
							(1 12)
							(2 1)
							(3 -1)
						)
					)
					(= local18 local15)
					(+= local15 temp0)
					(localproc_3)
				)
				(= next travel)
				(if (> [local149 local15] 15)
					(stopSign init: (& [local149 local15] $0020))
				)
				(self dispose:)
			)
		)
	)
)

(instance changeOverlay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(carCursor hide:)
				(car startUpd:)
				(curb1 startUpd:)
				(curb2 startUpd:)
				(dial1 startUpd:)
				(dial2 startUpd:)
				(= cycles 4)
			)
			(1
				(= global249 register)
				(Graph grFILL_BOX 4 4 108 190 4 -1 -1 0)
				(Graph grREDRAW_BOX 4 4 108 190)
				(DrawPic register -32668 0 global40)
				(= cycles 1)
			)
			(2
				(carCursor show:)
				(self dispose:)
			)
		)
	)
)

(instance offCar of Actor
	(properties
		yStep 8
		view 224
		priority 5
		signal 16400
		xStep 12
		moveSpeed 2
	)

	(method (init param1 &tmp temp0)
		(= temp0 (* local14 4))
		(self
			view: local32
			cel: local14
			posn: [local365 temp0] [local365 (+ temp0 1)]
		)
		(super init:)
		(self
			setMotion:
				MoveTo
				[local365 (+ temp0 2)]
				[local365 (+ temp0 3)]
				param1
		)
	)
)

(instance car of Actor
	(properties
		yStep 4
		view 2010
		priority 5
		signal 16400
		illegalBits 0
		xStep 6
	)

	(method (doit)
		(if (not (OneOf (gCurRoom script:) getEm pullOver))
			(= cycleSpeed (+ (= moveSpeed (/ (- 60 local9) 5)) 3))
		)
		(super doit: &rest)
	)

	(method (init param1 param2 param3 param4)
		(self view: local7)
		(if (and argc param1)
			(self view: (+ view param2) loop: 0 cel: 0 posn: param3 param4)
		else
			(switch local14
				(0
					(self posn: 288 83 setCel: 0)
				)
				(1
					(self posn: 227 32 setCel: 1)
				)
				(2
					(self posn: 230 77 setCel: 2)
				)
				(3
					(self posn: 288 33 setCel: 3)
				)
			)
		)
		(super init: &rest)
	)
)

(instance curb1 of View
	(properties
		noun 2
		view 201
		priority 2
		signal 16400
	)

	(method (init)
		(self
			posn:
				(+ [local33 (+ local1 4)] (lines x:))
				(+ [local33 (+ local1 5)] (lines y:))
			setLoop: 1
			cel: [local33 (+ local1 6)]
		)
		(super init: &rest)
	)

	(method (doit)
		(self
			posn:
				(+ [local33 (+ local1 4)] (lines x:))
				(+ [local33 (+ local1 5)] (lines y:))
		)
		(super doit: &rest)
	)
)

(instance curb2 of View
	(properties
		noun 2
		view 201
		priority 2
		signal 16400
	)

	(method (init)
		(self
			posn:
				(+ [local33 (+ local1 7)] (lines x:))
				(+ [local33 (+ local1 8)] (lines y:))
			setLoop: 1
			cel: [local33 (+ local1 9)]
		)
		(super init: &rest)
	)

	(method (doit)
		(self
			posn:
				(+ [local33 (+ local1 7)] (lines x:))
				(+ [local33 (+ local1 8)] (lines y:))
		)
		(super doit: &rest)
	)
)

(instance lines of Actor
	(properties
		noun 2
		yStep 4
		view 771
		loop 1
		priority 2
		signal 16400
		illegalBits 0
		xStep 6
	)

	(method (init param1 param2 param3 param4 param5)
		(self
			setCycle: 0
			posn: param1 param2
			setLoop: [local33 (+ local1 0)]
			cel: [local33 (+ local1 1)]
		)
		(super init: &rest)
		(curb1 init:)
		(curb2 init:)
		(if (> argc 2)
			(self setMotion: MoveTo param3 param4 param5)
		)
	)

	(method (dispose)
		(curb1 dispose:)
		(curb2 dispose:)
		(super dispose: &rest)
	)

	(method (doit)
		(= cycleSpeed (= moveSpeed (/ (- 60 local9) 5)))
		(if (and cycler (not local9))
			(self setCycle: 0)
		)
		(if
			(and
				(not cycler)
				local9
				(or (== (gCurRoom script:) getEm) (== (gCurRoom script:) travel))
			)
			(self setCycle: (if (OneOf local14 0 2) Fwd else Rev))
		)
		(super doit: &rest)
	)
)

(instance p2 of Actor
	(properties
		noun 2
		yStep 4
		view 201
		loop 1
		cel 2
		priority 2
		signal 16400
		xStep 6
	)

	(method (init &tmp [temp0 10])
		(cond
			(local19
				(switch local19
					(1
						(self
							cel: 2
							setLoop: (+ 2 (if (< local20 3) local20 else 2))
						)
					)
					(4
						(self cel: 2 setLoop: 1)
					)
					(else
						(self cel: 0 setLoop: 0)
					)
				)
			)
			((not (& [local149 local15] $0001))
				(self cel: 0 setLoop: 0)
			)
			(else
				(self cel: 2 setLoop: 1)
			)
		)
		(switch local14
			(0
				(self posn: 196 -98)
			)
			(1
				(self posn: 196 111)
			)
			(2
				(self posn: 315 8)
			)
			(3
				(self posn: 77 8)
			)
		)
		(super init: &rest)
		(if local19
			(p0 init:)
			(p1 init:)
			(p3 init:)
		else
			(if (or (& [local149 local15] $0008) local19)
				(p0 init:)
			)
			(if (or (& [local149 local15] $0002) local19)
				(p1 init:)
			)
			(if (or (& [local149 local15] $0004) local19)
				(p3 init:)
			)
		)
	)

	(method (dispose)
		(p0 dispose:)
		(p1 dispose:)
		(p3 dispose:)
		(super dispose: &rest)
	)

	(method (doit)
		(= cycleSpeed (= moveSpeed (/ (- 60 local9) 5)))
		(super doit: &rest)
	)
)

(instance p0 of View
	(properties
		noun 2
		view 201
		loop 1
		priority 2
		signal 16400
	)

	(method (init)
		(if local19
			(switch local19
				(8
					(self
						cel: 0
						setLoop: (+ 2 (if (< local20 3) local20 else 2))
					)
				)
				(2
					(self cel: 0 setLoop: 1)
				)
				(else
					(self cel: 0 setLoop: 0)
				)
			)
		else
			(self cel: 0 setLoop: 1)
		)
		(self posn: (+ (p2 x:) 3) (- (p2 y:) 3))
		(super init: &rest)
	)

	(method (doit)
		(self posn: (+ (p2 x:) 3) (- (p2 y:) 3))
		(super doit: &rest)
	)
)

(instance p1 of View
	(properties
		noun 2
		view 201
		loop 1
		cel 1
		priority 2
		signal 16400
	)

	(method (init)
		(if local19
			(switch local19
				(2
					(self
						cel: 1
						setLoop: (+ 2 (if (< local20 3) local20 else 2))
					)
				)
				(8
					(self cel: 1 setLoop: 1)
				)
				(else
					(self cel: 0 setLoop: 0)
				)
			)
		else
			(self cel: 1 setLoop: 1)
		)
		(self posn: (+ (p2 x:) 115) (- (p2 y:) 3))
		(super init: &rest)
	)

	(method (doit)
		(self posn: (+ (p2 x:) 115) (- (p2 y:) 3))
		(super doit: &rest)
	)
)

(instance p3 of View
	(properties
		noun 2
		view 201
		loop 1
		cel 3
		priority 2
		signal 16400
	)

	(method (init)
		(if local19
			(switch local19
				(4
					(self
						cel: 3
						setLoop: (+ 2 (if (< local20 3) local20 else 2))
					)
				)
				(1
					(self cel: 3 setLoop: 1)
				)
				(else
					(self cel: 0 setLoop: 0)
				)
			)
		else
			(self cel: 3 setLoop: 1)
		)
		(self posn: (p2 x:) (+ (p2 y:) 99))
		(super init: &rest)
	)

	(method (doit)
		(self posn: (p2 x:) (+ (p2 y:) 99))
		(super doit: &rest)
	)
)

(instance leftSignal of View
	(properties
		x 43
		y 118
		noun 13
		view 2000
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if local5
				(= local13 1)
				(theSignal init:)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance siren of Prop
	(properties
		x 288
		y 121
		noun 23
		view 769
		loop 2
		priority 15
		signal 16400
		cycleSpeed 0
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance sirenSwitch of View
	(properties
		x 60
		y 183
		noun 24
		view 203
		loop 4
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if cel
				(self setCel: 0)
				(= local10 55)
				(siren dispose:)
				(gLongSong2 stop:)
			else
				(self setCel: (self lastCel:))
				(= local10 65)
				(siren init:)
				(gLongSong2 number: 911 loop: -1 play:)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rightSignal of View
	(properties
		x 104
		y 118
		noun 14
		view 2000
		loop 1
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if local5
				(= local13 2)
				(theSignal init:)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance straightSignal of View
	(properties
		x 73
		y 109
		noun 15
		view 2000
		loop 2
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if local5
				(= local13 0)
				(theSignal init:)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theSignal of Prop
	(properties
		view 2000
		priority 14
		signal 16400
		cycleSpeed 12
		detailLevel 2
	)

	(method (init)
		(switch local13
			(0
				(self posn: 73 109 setLoop: 2 noun: 15)
			)
			(2
				(self posn: 104 118 setLoop: 1 noun: 14)
			)
			(1
				(self posn: 43 118 setLoop: 0 noun: 13)
			)
		)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance gas of View
	(properties
		x 137
		y 117
		noun 11
		view 2000
		loop 3
		cel 1
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (and local5 (< local9 local10))
				(+= local9 5)
				(localproc_7)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance brake of View
	(properties
		x 117
		y 117
		noun 12
		view 2000
		loop 3
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (and local5 (> local9 0))
				(-= local9 5)
				(localproc_7)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance carCursor of Prop
	(properties
		view 2000
		loop 4
		priority 15
		signal 16400
	)

	(method (init)
		(localproc_4)
		(localproc_9)
		(self posn: local22 local21)
		(super init: &rest)
		(self setCycle: Fwd)
		(= local11 -1)
	)

	(method (doit)
		(if (and (!= local11 local8) (!= (gCurRoom script:) (ScriptID 501 1))) ; travelFreeway
			(= local11 local8)
			(localproc_4)
			(localproc_9)
			(self posn: local22 local21)
		)
		(super doit: &rest)
	)
)

(instance targetCursor of View
	(properties
		view 2000
		loop 5
		priority 1
		signal 16400
	)

	(method (init param1 param2 param3 param4 &tmp temp0 temp1 temp2)
		(= local26 param4)
		(= local27 param2)
		(= local28 param1)
		(= local30 param3)
		(= temp0 (+ 6 (* (/ local28 12) 24)))
		(= temp1 (+ (= temp1 (+ 5 (* (mod local28 12) 30))) (* 6 local30)))
		(= temp2 773)
		(if (> temp0 94)
			(+= temp2 2)
			(-= temp0 73)
		)
		(if (> temp1 176)
			(++ temp2)
			(-= temp1 150)
		)
		(if (== global249 temp2)
			(self posn: local22 local21)
		else
			(self posn: -10 -10)
		)
		(super init: &rest)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (+ 6 (* (/ local28 12) 24)))
		(= temp1 (+ (= temp1 (+ 5 (* (mod local28 12) 30))) (* 6 local30)))
		(= temp2 773)
		(if (> temp0 94)
			(+= temp2 2)
			(-= temp0 73)
		)
		(if (> temp1 176)
			(++ temp2)
			(-= temp1 150)
		)
		(if (== global249 temp2)
			(self posn: temp1 temp0)
		else
			(self posn: -10 -10)
		)
		(super doit: &rest)
	)
)

(instance dial1 of View
	(properties
		view 200
		priority 15
		signal 16400
	)

	(method (init)
		(dial2 init:)
		(self
			cel:
				(if (< local9 65)
					(/ local9 5)
				else
					12
				)
		)
		(switch global207
			(914
				(self view: 203 loop: 1 x: 31 y: 160 noun: 18)
			)
			(105
				(self view: 200 loop: 0 x: 23 y: 169 noun: 17)
			)
			(104
				(self view: 202 loop: 0 x: 43 y: 164 noun: 19)
			)
		)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance dial2 of View
	(properties
		view 200
		priority 15
		signal 16400
	)

	(method (init)
		(self
			cel:
				(if (< local9 65)
					(/ local9 5)
				else
					12
				)
		)
		(switch global207
			(914
				(self view: 203 loop: 2 x: 59 y: 162 noun: 21)
			)
			(105
				(self view: 200 loop: 1 x: 110 y: 169 noun: 22)
			)
			(104
				(self view: 202 loop: 1 x: 98 y: 164 noun: 20)
			)
		)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance stopSign of View
	(properties
		x 153
		y 127
		view 769
		priority 15
		signal 16400
	)

	(method (init param1)
		(self cel: 0)
		(if (and argc param1)
			(self loop: 0)
		else
			(self loop: 1)
		)
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance mapFeature of Feature
	(properties
		noun 1
		nsTop 5
		nsLeft 5
		nsBottom 107
		nsRight 188
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(return
			(if (== theVerb 1) ; Look
				(= temp2
					(OnControl
						CONTROL
						((gUser curEvent:) x:)
						((gUser curEvent:) y:)
					)
				)
				(if (& $0002 temp2)
					(gMessager say: 3 1 0 0) ; "This is Highway 41, which continues far north to San Francisco and far south to Los Angeles."
					(return 1)
				)
				(switch global249
					(773
						(cond
							(
								(InRect
									10
									35
									63
									77
									((gUser curEvent:) x:)
									((gUser curEvent:) y:)
								)
								(gMessager say: 1 1 1 7) ; "The Richman Center, a small museum and performing-arts playhouse set in a pleasant little park. You've never been there on an unofficial basis; the common wisdom is that you have to be a "rich man" to afford a ticket."
								(return 1)
							)
							(
								(InRect
									159
									35
									183
									77
									((gUser curEvent:) x:)
									((gUser curEvent:) y:)
								)
								(gMessager say: 1 1 1 12) ; "The Lytton Community College's football stadium and natatorium. As with many towns, there's more pride in Lytton's football scores than in its academic scores."
								(return 1)
							)
						)
					)
					(774
						(if
							(InRect
								10
								35
								34
								77
								((gUser curEvent:) x:)
								((gUser curEvent:) y:)
							)
							(gMessager say: 1 1 2 7) ; "The Lytton Community College's football stadium and natatorium. As with many towns, there's more pride in Lytton's football scores than in its academic scores."
							(return 1)
						)
					)
					(776
						(cond
							(
								(InRect
									40
									35
									93
									53
									((gUser curEvent:) x:)
									((gUser curEvent:) y:)
								)
								(gMessager say: 1 1 4 8) ; "The Lytton Police Station."
								(return 1)
							)
							(
								(InRect
									129
									35
									83
									77
									((gUser curEvent:) x:)
									((gUser curEvent:) y:)
								)
								(gMessager say: 1 1 4 11) ; "Bert's Park, named for the kindly caretaker who maintained the Park for over 45 years. The park was originally called, simply, Lytton City Park. It's still a beautiful, well-tended park, but it's been getting a bad reputation as unsafe, especially at night."
								(return 1)
							)
							(
								(InRect
									70
									82
									123
									102
									((gUser curEvent:) x:)
									((gUser curEvent:) y:)
								)
								(gMessager say: 1 1 4 21) ; "The Lytton County Jail."
								(return 1)
							)
							(
								(InRect
									129
									83
									183
									102
									((gUser curEvent:) x:)
									((gUser curEvent:) y:)
								)
								(gMessager say: 1 1 4 23) ; "Cotton Cove, a small alternative park and annex to Bert's Park."
								(return 1)
							)
						)
					)
				)
				(= temp1
					(-
						(- ((gUser curEvent:) y:) 5)
						(* (/ (- ((gUser curEvent:) y:) 5) 25) 25)
					)
				)
				(cond
					(
						(and
							(>
								(= temp0
									(-
										(- ((gUser curEvent:) x:) 4)
										(*
											(/
												(- ((gUser curEvent:) x:) 4)
												30
											)
											30
										)
									)
								)
								4
							)
							(> temp1 4)
						)
						(= temp2
							(+
								(* 6 (/ (- ((gUser curEvent:) y:) 5) 25))
								(/ (- ((gUser curEvent:) x:) 4) 30)
								1
							)
						)
						(= temp3
							(switch global249
								(773 1)
								(774 2)
								(775 3)
								(776 4)
							)
						)
						(if (Message msgSIZE 500 1 1 temp3 temp2)
							(gMessager say: 1 1 temp3 temp2)
						else
							(gMessager say: 1 1 41) ; "You see nothing special."
						)
					)
					((and (< temp0 5) (< temp1 5))
						(= temp0 (+ (/ (- ((gUser curEvent:) x:) 4) 30) 1))
						(= temp1 (+ (/ (- ((gUser curEvent:) y:) 5) 25) 1))
						(if (OneOf global249 774 776)
							(+= temp0 5)
						)
						(if (OneOf global249 775 776)
							(+= temp1 3)
						)
						(= temp4 (Message msgSIZE 500 2 1 11 temp0))
						(= temp6 (Message msgSIZE 500 2 1 9 1)) ; "The intersection of"
						(= temp7 (Message msgSIZE 500 2 1 10 1)) ; "and"
						(Print
							addText: 2 1 9 1 0 0 ; "The intersection of"
							addText: 2 1 11 temp0 (* temp6 6)
							addText: 2 1 10 1 (* (+ temp6 temp4) 6) ; "and"
							addText: 2 1 12 temp1 (* (+ temp6 temp4 temp7) 6)
							init:
						)
					)
					(else
						(= temp2 temp0)
						(= temp0 (+ (/ (- ((gUser curEvent:) x:) 4) 30) 1))
						(= temp1 (+ (/ (- ((gUser curEvent:) y:) 5) 25) 1))
						(if (OneOf global249 774 776)
							(+= temp0 5)
						)
						(if (OneOf global249 775 776)
							(+= temp1 3)
						)
						(if (< temp2 5)
							(gMessager say: 2 1 11 temp0)
						else
							(gMessager say: 2 1 12 temp1)
						)
					)
				)
			else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dashFeature of Feature
	(properties
		nsTop 132
		nsBottom 189
		nsRight 319
		onMeCheck 32766
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(if (== theVerb 1) ; Look
			(= temp0
				(OnControl
					CONTROL
					((gUser curEvent:) x:)
					((gUser curEvent:) y:)
				)
			)
			(= temp1 (+ (localproc_1 temp0) 1))
			(gMessager
				say:
					(switch global207
						(914 5)
						(105 6)
						(104 7)
					)
					theVerb
					14
					temp1
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance controlFeature of Feature
	(properties
		x 162
		y 112
		noun 16
		nsTop 110
		nsBottom 131
		nsRight 319
		onMeCheck 62
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(if (== theVerb 1) ; Look
			(= temp0
				(OnControl
					CONTROL
					((gUser curEvent:) x:)
					((gUser curEvent:) y:)
				)
			)
			(= temp1 (localproc_1 temp0))
			(gMessager say: 16 theVerb 0 temp1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance dispatcher of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= [local293 57] 4)
				(= [local293 63] 5)
				(cond
					((OneOf global211 3 6 10 27 50 77 88 84)
						(gLongSong number: 254)
					)
					((OneOf global211 13 20 37 61 72 32 74 93)
						(gLongSong number: 251)
					)
					((OneOf global211 24 47 82 58 70)
						(gLongSong number: 670)
					)
					((== global211 41)
						(gLongSong number: 252)
					)
					((== global211 55)
						(gLongSong number: 270)
					)
					((OneOf global211 63 85)
						(gLongSong number: 670)
					)
				)
				(switch global211
					(3
						(if (IsFlag 78)
							(= seconds 90)
						)
					)
					(85
						(localproc_0)
						(= [local293 57] 2)
					)
					(63
						(localproc_0)
						(= [local293 63] 2)
					)
					(6
						(= seconds 60)
					)
					(10
						(= seconds 60)
					)
					(13
						(= seconds 60)
					)
					(20
						(= seconds 60)
					)
					(41
						(= seconds 60)
					)
					(24
						(localproc_0)
					)
					(70
						(localproc_0)
					)
					(47
						(localproc_0)
					)
					(27
						(= seconds 60)
					)
					(37
						(= seconds 60)
					)
					(50
						(= seconds 60)
					)
					(42
						(= cycles 1)
					)
					(84
						(= seconds 20)
					)
				)
				(if (not (gLongSong2 number:))
					(gLongSong2 number: 250)
				)
				(if (gLongSong number:)
					(gLongSong loop: -1 setVol: 127 play:)
				)
			)
			(1
				(switch global211
					(3
						(++ global211)
						(targetCursor init: 27 28 2 40)
						(gMessager say: 8 2 15 0 self) ; "83-32, we have a report of an 11-80 on Fig Street between 4th and 3rd. Please respond immediately. Repeat, 11-80, Fig Street between 4th and 3rd."
					)
					(6
						(++ global211)
						(gMessager say: 8 2 17 0 self) ; "83-32, you've been requested to detour to Caffeine Carol's for an 11-98."
					)
					(10
						(= global211 11)
						(= local32 220)
						(= local26 41)
					)
					(13
						(++ global211)
						(gMessager say: 8 2 19 0 self) ; "83-32, we have a complaint at Caffeine Carol's, Oak Street between 6th and 7th. Please investigate."
					)
					(20
						(= global211 21)
						(= local32 224)
						(= local26 42)
					)
					(41
						(++ global211)
						(gMessager say: 8 2 21 0 self) ; "83-32, we have a report of a domestic disturbance on the corner of Lily and 1st. Please investigate."
					)
					(27
						(gMessager say: 8 2 31 0 self) ; "83-32, you are code 10-19. Repeat, you are 10-19."
					)
					(42
						(gMessager say: 8 2 23 0 self) ; "83-32, we have a sighting on a stolen Mercedes proceeding eastbound on Oak Street. Vehicle is a silver Mercedes, possible stolen vehicle. Overtake and investigate. Thank you."
						(gLongSong number: 252 loop: -1 setVol: 127 play:)
						(= global211 43)
						(= local32 226)
						(= local26 43)
					)
					(84
						(++ global211)
						(localproc_0)
						(= [local293 57] 2)
						(gMessager say: 8 2 37 0 self) ; "83-32, please proceed directly to Cotton Cove. We have a report of a possible 11-44. That is all."
					)
				)
			)
			(2
				(= seconds 60)
			)
			(3
				(switch global211
					(4
						(-= state 2)
						(gMessager say: 8 2 16 0 self) ; "83-32! Please respond immediately to 11-80, Fig Street between 3rd and 4th."
					)
					(7
						(-= state 2)
						(gMessager say: 8 2 18 0 self) ; "Sonny, don't forget that 11-98 with Keith at Carol's. Just thought I'd remind you. Out."
					)
					(14
						(-= state 2)
						(gMessager say: 8 2 20 0 self) ; "83-32, please respond to complaint at Caffeine Carol's. Repeat, please respond to complaint at Caffeine Carol's."
					)
					(42
						(-= state 2)
						(gMessager say: 8 2 22 0 self) ; "83-32, you are requested to investigate the domestic disturbance at 1st and Lilly. Please proceed immediately. Thank you."
					)
					(27
						(gMessager say: 8 2 32 0 self) ; "83-32, please return to LPD immediately. Repeat, 83-32, you are 10-19 immediately."
						(-= state 2)
					)
					(43
						(gMessager say: 8 2 24 0 self) ; "83-32, please overtake and investigate possible stolen vehicle traveling eastbound on Oak Street. The vehicle is a silver Mercedes. Respond immediately. That is all."
						(-= state 2)
					)
					(85
						(gMessager say: 8 2 38 0 self) ; "83-32, you are to prceed immediately to Cotton Cove to investigate possible 11-44. Repeat, 83-32 to Cotton Cove."
						(-= state 2)
					)
				)
			)
		)
	)
)

