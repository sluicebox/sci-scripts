;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use SQRoom)
(use DText)
(use Str)
(use Array)
(use Osc)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm210 0
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
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	[local19 8] = [0 1 1 0 2 0 2 0]
	local27
	local28
	local29
	local30 = 6
	local31
)

(procedure (localproc_0)
	(if local5
		(local5 dispose:)
		(= local5 0)
	)
	(if local2
		(local2 dispose:)
		(= local2 0)
	)
	(if local6
		(local6 dispose:)
		(= local6 0)
	)
	(if local3
		(local3 dispose:)
		(= local3 0)
	)
	(if local7
		(local7 dispose:)
		(= local7 0)
	)
	(if local4
		(local4 dispose:)
		(= local4 0)
	)
)

(procedure (localproc_1 param1 param2 param3)
	(= local8 (IntArray with: 0 0 0 0))
	(Text 0 (local8 data:) (param1 data:) 210 320) ; TextSize
	(switch param3
		(1
			((= local5 (DText new:))
				text: (KString 8 (param1 data:)) ; StrDup
				fore: 0
				font: 210
				mode: 1
				posn: (+ (- 160 (/ (local8 at: 2) 2)) 1) (+ param2 1)
				setPri: 253
				setSize: 310
				init:
			)
			((= local2 (DText new:))
				text: (KString 8 (param1 data:)) ; StrDup
				font: 210
				fore: 27
				mode: 1
				posn: (- 160 (/ (local8 at: 2) 2)) param2
				setPri: 254
				setSize: 310
				init:
			)
		)
		(2
			((= local6 (DText new:))
				text: (KString 8 (param1 data:)) ; StrDup
				fore: 0
				font: 210
				mode: 1
				posn: (+ (- 160 (/ (local8 at: 2) 2)) 1) (+ param2 1)
				setPri: 253
				setSize: 310
				init:
			)
			((= local3 (DText new:))
				text: (KString 8 (param1 data:)) ; StrDup
				fore: 37
				font: 210
				mode: 1
				posn: (- 160 (/ (local8 at: 2) 2)) param2
				setPri: 254
				setSize: 310
				init:
			)
		)
		(3
			((= local7 (DText new:))
				text: (KString 8 (param1 data:)) ; StrDup
				fore: 0
				font: 210
				mode: 1
				posn: (+ (- 160 (/ (local8 at: 2) 2)) 1) (+ param2 1)
				setPri: 253
				setSize: 310
				init:
			)
			((= local4 (DText new:))
				text: (KString 8 (param1 data:)) ; StrDup
				fore: 20
				font: 210
				mode: 1
				posn: (- 160 (/ (local8 at: 2) 2)) param2
				setPri: 254
				setSize: 310
				init:
			)
		)
	)
	(local8 dispose:)
)

(procedure (localproc_2)
	(gGame handsOn:)
	(gTheIconBar setupExit: 1)
	(gTheIconBar select: (gTheIconBar at: 2) disable: 0 1 3 4 5 6)
	(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
)

(procedure (localproc_3)
	(gTheIconBar enable: 6)
	(gGame handsOff:)
)

(class chooseCast of Set
	(properties)
)

(instance rm210 of SQRoom
	(properties
		noun 1
		picture 210
	)

	(method (init)
		(joystick init:)
		(leftJoystick init:)
		(downJoystick init:)
		(rightJoystick init:)
		(buttonA init:)
		(buttonB init:)
		(buttonC init:)
		(buttonAFeature init:)
		(buttonBFeature init:)
		(buttonCFeature init:)
		(chooseCast
			add:
				chooseTitle
				chooseLarry
				chooseCoily
				chooseMo
				coilyName
				larryName
				moName
		)
		(= local17 (>> (<< (= local16 (GetTime 3)) $0007) $000c)) ; SysDate
		(= local18 (>> (<< local16 $000b) $000b))
		(if
			(or
				(and (== local17 1) (== local18 3))
				(and (== local17 4) (== local18 11))
				(and (== local17 12) (== local18 29))
			)
			(= local15 1)
		)
		(super init:)
		(gGSound1 stop:)
		(gGSound2 number: 216 setLoop: -1 play: setVol: 127)
		(= local1 (Str newWith: 80 {}))
		(gCurRoom setScript: sIntroScript)
		(gKeyDownHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_a
					(leftJoystick doVerb: 4)
				)
				(KEY_s
					(downJoystick doVerb: 4)
				)
				(KEY_d
					(rightJoystick doVerb: 4)
				)
				(KEY_q
					(buttonA doVerb: 4)
				)
				(KEY_w
					(buttonB doVerb: 4)
				)
				(KEY_e
					(buttonC doVerb: 4)
				)
				(KEY_c
					(if local28
						(buttonSecret doVerb: 4)
					)
				)
			)
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(gKeyDownHandler delete: self)
		(gTheIconBar setupExit: 0)
		(gGSound2 stop:)
		(gGSound1 play:)
		(local1 dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if chooseCast
			(super doVerb: theVerb)
		)
	)
)

(instance sDazedTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 300)
			)
			(1
				(client command: 18)
				(self dispose:)
			)
		)
	)
)

(instance sIntroScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3)
				(mainTitle setScale: 0 setScale: setCycle: Fwd init:)
				(= cycles 1)
			)
			(1
				(for ((= local0 0)) (< local0 129) ((++ local0))
					(mainTitle scaleX: local0 scaleY: local0)
					(= gGameTime (+ gTickOffset (GetTime)))
					(gCast doit:)
					(FrameOut)
				)
				(= cycles 1)
			)
			(2
				(mainTitle setCycle: End self)
			)
			(3
				(mainTitle cel: 0 show:)
				(= ticks 90)
			)
			(4
				(notSoMainTitle init: setCycle: Fwd)
				(Load rsVIEW 214)
				(= cycles 1)
			)
			(5
				(= ticks 200)
			)
			(6
				(mainTitle dispose:)
				(notSoMainTitle dispose:)
				(chooseCast eachElementDo: #init)
				(= ticks 5)
			)
			(7
				(gGame handsOn:)
				(gTheIconBar setupExit: 1)
				(gTheIconBar select: (gTheIconBar at: 2) disable: 4 5 6 enable: 0)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				(self dispose:)
			)
		)
	)
)

(instance sStartGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3)
				(chooseCast dispose:)
				(UnLoad 128 214)
				(= cycles 5)
			)
			(1
				(background init:)
				(= ticks 30)
			)
			(2
				(Message msgGET 210 14 0 0 1 (local1 data:)) ; "To play using the keyboard! Press "A" to move backward. Press "S" to duck. Press "D" to move forward. Press "Q, W or E" to attack."
				(localproc_1 local1 30 1)
				(= cycles 1)
			)
			(3
				(Load rsVIEW 217 218)
				(switch register
					(0
						(playerOne
							name: {Lar Man}
							view: 213
							loopACel: 3
							loopBCel: 2
							loopCCel: 9
							loopSecret: 7
							loopFatal: 7
							loopNonFinish: 7
							nonFatalFall: 4
							fatalFall: 7
							soundA: 2101
							soundB: 2102
							soundC: 2103
							soundS: 2115
							soundF: 2116
							soundNF: 2111
							gauge: playerOneGauge
							ball: playerOneBall
							opponent: playerTwo
							init:
							hide:
							command: 0
						)
					)
					(1
						(playerOne
							name: {Coily Joe}
							view: 219
							loopACel: 3
							loopBCel: 4
							loopCCel: 4
							loopSecret: 2
							loopFatal: 22
							loopNonFinish: 4
							nonFatalFall: 4
							fatalFall: 7
							soundA: 2123
							soundB: 2104
							soundC: 2121
							soundS: 2119
							soundF: 2120
							soundNF: 2113
							gauge: playerOneGauge
							ball: playerOneBall
							opponent: playerTwo
							init:
							hide:
							command: 0
						)
					)
					(2
						(playerOne
							name: {Big Mo}
							view: 216
							loopACel: 5
							loopBCel: 4
							loopCCel: 4
							loopSecret: 2
							loopFatal: 6
							loopNonFinish: 5
							nonFatalFall: 9
							fatalFall: 9
							soundA: 2106
							soundB: 2107
							soundC: 2108
							soundS: 2122
							soundF: 2118
							soundNF: 2110
							gauge: playerOneGauge
							ball: playerOneBall
							opponent: playerTwo
							init:
							hide:
							command: 0
						)
					)
				)
				(= seconds 10)
			)
			(4
				(localproc_0)
				(Message msgGET 210 13 0 0 1 (local1 data:)) ; "To play using the mouse! Click on the "A, B or C" buttons to attack. Click on joystick pads to move forward, backward or duck."
				(localproc_1 local1 30 1)
				(= cycles 1)
			)
			(5
				(switch register
					(0
						(playerTwo
							name: {Big Mo}
							view: 2130
							loopACel: 5
							loopBCel: 4
							loopCCel: 4
							loopSecret: 2
							loopFatal: 6
							loopNonFinish: 5
							nonFatalFall: 9
							fatalFall: 9
							soundA: 2106
							soundB: 2107
							soundC: 2108
							soundS: 2122
							soundF: 2118
							soundNF: 2110
							gauge: playerTwoGauge
							ball: playerTwoBall
							opponent: playerOne
							init:
							hide:
							command: 0
						)
					)
					(1
						(playerTwo
							name: {Big Mo}
							view: 2190
							loopACel: 5
							loopBCel: 4
							loopCCel: 4
							loopSecret: 2
							loopFatal: 6
							loopNonFinish: 5
							nonFatalFall: 9
							fatalFall: 9
							soundA: 2106
							soundB: 2107
							soundC: 2108
							soundS: 2122
							soundF: 2118
							soundNF: 2110
							gauge: playerTwoGauge
							ball: playerTwoBall
							opponent: playerOne
							init:
							hide:
							command: 0
						)
					)
					(2
						(playerTwo
							name: {Coily Joe}
							view: 2160
							loopACel: 2
							loopBCel: 4
							loopCCel: 4
							loopSecret: 2
							loopFatal: 22
							loopNonFinish: 4
							nonFatalFall: 4
							fatalFall: 7
							soundA: 2123
							soundB: 2104
							soundC: 2121
							soundS: 2119
							soundF: 2120
							soundNF: 2113
							gauge: playerTwoGauge
							ball: playerTwoBall
							opponent: playerOne
							init:
							hide:
							command: 0
						)
					)
				)
				(= seconds 8)
			)
			(6
				(localproc_0)
				(= cycles 1)
			)
			(7
				(gGSound2 number: 217 setLoop: -1 play: setVol: 127)
				(round init:)
				(roundNumber init:)
				(playerOneBall init:)
				(playerTwoBall init:)
				(playerOneGauge init:)
				(playerTwoGauge init:)
				(playerOne show:)
				(playerTwo show:)
				(switch register
					(0
						(playerOneTitle cel: 0 init:)
						(playerTwoTitle cel: 5 init:)
					)
					(1
						(playerOneTitle cel: 1 init:)
						(playerTwoTitle cel: 5 init:)
					)
					(2
						(playerOneTitle cel: 2 init:)
						(playerTwoTitle cel: 4 init:)
					)
				)
				(= cycles 5)
			)
			(8
				(stoogeSound number: 1000 play: self)
			)
			(9
				(stoogeSound number: 1100 play: self)
				(rumble init: setCycle: Fwd)
			)
			(10
				(rumble dispose:)
				(= cycles 5)
			)
			(11
				(localproc_2)
				(= local13 1)
				(self dispose:)
			)
		)
	)
)

(instance sButtonAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 1)
				(= ticks 20)
			)
			(1
				(client cel: 0)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sDoFinishing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setCycle:
						CT
						(if register
							(client fatalFall:)
						else
							(client nonFatalFall:)
						)
						1
						self
				)
			)
			(1
				(stoogeSound number: 2112 play:)
				(client setCycle: End self)
			)
			(2
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance sPerformAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((client opponent:) iAmDazed:)
					((client opponent:) setScript: 0)
					(sDazedTimer dispose:)
					(= local31 1)
					(if
						(and
							(== (client loop:) 11)
							(== (client name:) {Coily Joe})
						)
						(stoogeSound number: (client soundF:) play:)
					)
					(client
						setCycle:
							CT
							(switch (client loop:)
								(11
									(client loopFatal:)
								)
								(else
									(client loopNonFinish:)
								)
							)
							1
							self
					)
				else
					(client
						setCycle:
							CT
							(switch (client loop:)
								(4
									(client loopACel:)
								)
								(5
									(client loopBCel:)
								)
								(6
									(client loopCCel:)
								)
								(10
									(client loopSecret:)
								)
								(11
									(client loopFatal:)
								)
							)
							1
							self
					)
				)
			)
			(1
				(if
					(and
						(<=
							(GetDistance
								(client x:)
								100
								((client opponent:) x:)
								100
							)
							44
						)
						(not (OneOf ((client opponent:) loop:) 3 2))
					)
					(cond
						(
							(and
								((client opponent:) iAmDazed:)
								(== (client name:) {Coily Joe})
								(== (client loop:) 11)
							)
							((client opponent:) command: 15)
						)
						(((client opponent:) iAmDazed:)
							(if (== (client loop:) 11)
								(stoogeSound number: (client soundF:) play:)
								((client opponent:) command: 13)
							else
								(stoogeSound number: (client soundNF:) play:)
								((client opponent:) command: 18)
							)
						)
						(else
							(((client opponent:) gauge:) cue: register)
							((client opponent:)
								command:
									(switch (client loop:)
										(4 7)
										(5 8)
										(6 9)
										(10 12)
										(11 13)
									)
							)
							(switch (client loop:)
								(4
									(stoogeSound number: (client soundA:) play:)
								)
								(5
									(stoogeSound number: (client soundB:) play:)
								)
								(6
									(stoogeSound number: (client soundC:) play:)
								)
								(10
									(stoogeSound number: (client soundS:) play:)
								)
							)
						)
					)
					(client setCycle: End self)
				else
					(client setCycle: Beg self)
				)
			)
			(2
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance sResetTheGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3)
				(= ticks 60)
			)
			(1
				(switch (client name:)
					({Lar Man}
						(Message msgGET 210 9 0 0 1 (local1 data:)) ; "Lar Man Wins!"
						(stoogeSound number: 1300 play: self)
					)
					({Coily Joe}
						(Message msgGET 210 9 0 0 2 (local1 data:)) ; "Coily Joe Wins!"
						(stoogeSound number: 1500 play: self)
					)
					({Big Mo}
						(Message msgGET 210 9 0 0 3 (local1 data:)) ; "Big Mo Wins!"
						(stoogeSound number: 1700 play: self)
					)
				)
				(localproc_1 local1 35 1)
			)
			(2
				(= ticks 30)
			)
			(3
				(if (== ((client gauge:) cel:) 0)
					(switch (RandomNumber 1 3)
						(1
							(Message msgGET 210 12 0 0 1 (local1 data:)) ; "Untainted victory!"
							(stoogeSound number: 1120 play: self)
						)
						(2
							(Message msgGET 210 12 0 0 2 (local1 data:)) ; "Unblemished victory!"
							(stoogeSound number: 1130 play: self)
						)
						(3
							(Message msgGET 210 12 0 0 3 (local1 data:)) ; "Choice victory!"
							(stoogeSound number: 1140 play: self)
						)
					)
					(localproc_1 local1 50 2)
				else
					(= cycles 1)
				)
			)
			(4
				(= ticks 30)
			)
			(5
				(if local14
					(if (== client playerOne)
						(Message msgGET 210 11 0 0 1 (local1 data:)) ; "You moidered him."
						(stoogeSound number: 1900 play: self)
					else
						(Message msgGET 210 11 0 0 2 (local1 data:)) ; "He moidered you!"
						(stoogeSound number: 1110 play: self)
					)
					(localproc_1 local1 65 3)
				else
					(= cycles 1)
				)
			)
			(6
				(= ticks 30)
			)
			(7
				(localproc_0)
				(roundNumber cue:)
				(playerOne hide:)
				(playerTwo hide:)
				((playerOne gauge:) setCycle: Beg self)
				((playerTwo gauge:) setCycle: Beg self)
			)
			(8)
			(9
				(gGSound2 number: 217 play:)
				(= local14 0)
				(playerOne
					x: 104
					iAmDazed: 0
					loop: 0
					cel: 0
					setCycle: Fwd
					show:
				)
				(playerTwo
					x: 216
					iAmDazed: 0
					loop: 0
					cel: 0
					setCycle: Fwd
					show:
				)
				(= ticks 60)
			)
			(10
				(stoogeSound number: 1200 play: self)
				(rumble init: setCycle: Fwd)
			)
			(11
				(rumble dispose:)
				(= ticks 30)
			)
			(12
				(= local31 0)
				(= local30 6)
				(= local13 1)
				(localproc_2)
				(self dispose:)
			)
		)
	)
)

(instance sGameOverMan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_3)
				(= ticks 60)
			)
			(1
				(switch (client name:)
					({Lar Man}
						(Message msgGET 210 10 0 0 1 (local1 data:)) ; "Lar Man wins the match!"
						(stoogeSound number: 1400 play: self)
					)
					({Coily Joe}
						(Message msgGET 210 10 0 0 2 (local1 data:)) ; "Coily Joe wins the match!"
						(stoogeSound number: 1600 play: self)
					)
					({Big Mo}
						(Message msgGET 210 10 0 0 3 (local1 data:)) ; "Big Mo wins the match!"
						(stoogeSound number: 1800 play: self)
					)
				)
				(localproc_1 local1 35 1)
			)
			(2
				(= ticks 30)
			)
			(3
				(if (== ((client gauge:) cel:) 0)
					(switch (RandomNumber 1 3)
						(1
							(Message msgGET 210 12 0 0 1 (local1 data:)) ; "Untainted victory!"
							(stoogeSound number: 1120 play: self)
						)
						(2
							(Message msgGET 210 12 0 0 2 (local1 data:)) ; "Unblemished victory!"
							(stoogeSound number: 1130 play: self)
						)
						(3
							(Message msgGET 210 12 0 0 3 (local1 data:)) ; "Choice victory!"
							(stoogeSound number: 1140 play: self)
						)
					)
					(localproc_1 local1 50 2)
				else
					(= cycles 1)
				)
			)
			(4
				(= ticks 30)
			)
			(5
				(if local14
					(if (== client playerOne)
						(Message msgGET 210 11 0 0 1 (local1 data:)) ; "You moidered him."
						(stoogeSound number: 1900 play: self)
					else
						(Message msgGET 210 11 0 0 2 (local1 data:)) ; "He moidered you!"
						(stoogeSound number: 1110 play: self)
					)
					(localproc_1 local1 65 3)
				else
					(= cycles 1)
				)
			)
			(6
				(= ticks 30)
			)
			(7
				(localproc_0)
				(= cycles 1)
			)
			(8
				(round hide:)
				(roundNumber hide:)
				(playerOneBall hide:)
				(playerTwoBall hide:)
				(playerOneGauge hide:)
				(playerTwoGauge hide:)
				(playerOne hide:)
				(playerTwo hide:)
				(playerOneTitle hide:)
				(playerTwoTitle hide:)
				(background hide:)
				(= ticks 30)
			)
			(9
				(if (IsFlag 4)
					(cond
						((== client playerOne)
							(gGame points: 7 508)
							(SetFlag 7)
						)
						((IsFlag 5)
							(SetFlag 6)
						)
						(else
							(SetFlag 5)
						)
					)
				)
				(= cycles 10)
			)
			(10
				(Message msgGET 210 15 0 0 1 (local1 data:)) ; "Game Over, Man."
				(localproc_1 local1 50 1)
				(= ticks 120)
			)
			(11
				(localproc_0)
				(= cycles 1)
			)
			(12
				(gCurRoom newRoom: 200)
				(self dispose:)
			)
		)
	)
)

(instance playerOneGauge of Prop
	(properties
		x 79
		y 20
		view 2101
		loop 1
	)

	(method (cue param1)
		(self cel: (+ (self cel:) param1))
	)
)

(instance playerTwoGauge of Prop
	(properties
		x 240
		y 20
		view 2101
		loop 2
	)

	(method (cue param1)
		(self cel: (+ (self cel:) param1))
		(cond
			((== local28 1))
			((>= cel 15)
				(= local30 3)
			)
			((>= cel 10)
				(= local30 4)
			)
			((>= cel 5)
				(= local30 5)
			)
			(else
				(= local30 6)
			)
		)
	)
)

(instance playerOneBall of Prop
	(properties
		x 72
		y 20
		view 2101
		loop 5
	)

	(method (cue)
		(self cel: (+ (self cel:) 1))
	)
)

(instance playerTwoBall of Prop
	(properties
		x 246
		y 20
		view 2101
		loop 4
	)

	(method (cue)
		(self cel: (+ (self cel:) 1))
	)
)

(instance roundNumber of Prop
	(properties
		x 159
		y 21
		view 2101
		loop 3
		cel 1
	)

	(method (cue)
		(self cel: (+ (self cel:) 1))
	)
)

(instance lameBrain of Prop
	(properties
		x 94
		y 46
		priority 110
		fixPriority 1
		view 217
	)
)

(instance rumble of Prop
	(properties
		x 86
		y 60
		priority 110
		fixPriority 1
		view 218
	)
)

(instance playerOneTitle of View
	(properties
		x 80
		y 13
		view 2101
	)
)

(instance playerTwoTitle of View
	(properties
		x 238
		y 13
		view 2101
		cel 2
	)
)

(instance round of View
	(properties
		x 148
		y 12
		view 2101
		loop 3
	)
)

(instance background of View
	(properties
		y 9
		priority 10
		fixPriority 1
		view 2100
	)
)

(class StoogeActor of Actor
	(properties
		opponent 0
		stepLength 0
		loopACel 0
		loopBCel 0
		loopCCel 0
		loopFatal 0
		loopSecret 0
		loopNonFinish 0
		fatalFall 0
		nonFatalFall 0
		soundA 0
		soundB 0
		soundC 0
		soundS 0
		soundF 0
		soundNF 0
		gauge 0
		ball 0
		iAmDazed 0
		perryDist 17
	)

	(method (command param1)
		(cond
			((not local13))
			((== param1 13)
				(self loop: 13 cel: 0 setCycle: End self)
			)
			((== param1 15)
				(self loop: 15 cel: 0 setScript: sDoFinishing 0 1)
			)
			((== param1 18)
				(self loop: 18 cel: 0 setScript: sDoFinishing 0 0)
			)
			(iAmDazed)
			(else
				(switch param1
					(0
						(self loop: 0 cel: 0 setCycle: Fwd)
					)
					(1
						(cond
							(
								(and
									(== ((self opponent:) loop:) 1)
									(==
										(GetDistance
											(self x:)
											0
											((self opponent:) x:)
											0
										)
										61
									)
								)
								0
							)
							(
								(and
									(== (self loop:) 0)
									(>
										(GetDistance
											(self x:)
											0
											((self opponent:) x:)
											0
										)
										44
									)
									(not ((self opponent:) iAmDazed:))
								)
								(self loop: param1 cel: 0 setCycle: End self)
							)
						)
					)
					(2
						(if
							(and
								(== (self loop:) 0)
								(> (self x:) 70)
								(< (self x:) 250)
								(not ((self opponent:) iAmDazed:))
							)
							(self loop: param1 cel: 0 setCycle: End self)
						)
					)
					(3
						(if (== (self loop:) 0)
							(self loop: param1 cel: 0 setCycle: Osc 1 self)
						)
					)
					(4
						(if
							(and
								(== (self loop:) 0)
								(not
									(OneOf
										((self opponent:) loop:)
										4
										5
										6
										10
										7
										8
										9
										12
										18
										15
									)
								)
							)
							(self
								loop:
									(if ((self opponent:) iAmDazed:)
										17
									else
										param1
									)
								cel: 0
								setPri: 105
								setScript: (sPerformAction new:) 0 1
							)
							((self opponent:) setPri: 100)
						)
					)
					(5
						(if
							(and
								(== (self loop:) 0)
								(not
									(OneOf
										((self opponent:) loop:)
										4
										5
										6
										10
										7
										8
										9
										12
										18
										15
									)
								)
							)
							(self
								loop:
									(if ((self opponent:) iAmDazed:)
										17
									else
										param1
									)
								cel: 0
								setPri: 105
								setScript: (sPerformAction new:) 0 1
							)
							((self opponent:) setPri: 100)
						)
					)
					(6
						(if
							(and
								(== (self loop:) 0)
								(not
									(OneOf
										((self opponent:) loop:)
										4
										5
										6
										10
										7
										8
										9
										12
										18
										15
									)
								)
							)
							(self
								loop:
									(if ((self opponent:) iAmDazed:)
										17
									else
										param1
									)
								cel: 0
								setPri: 105
								setScript: (sPerformAction new:) 0 1
							)
							((self opponent:) setPri: 100)
						)
					)
					(10
						(if
							(and
								(== (self loop:) 0)
								(not
									(OneOf
										((self opponent:) loop:)
										4
										5
										6
										10
										7
										8
										9
										12
										18
										15
									)
								)
							)
							(self
								loop:
									(if ((self opponent:) iAmDazed:)
										11
									else
										param1
									)
								cel: 0
								setPri: 105
								setScript:
									(sPerformAction new:)
									0
									(if (== self playerOne) 10 else 5)
							)
							((self opponent:) setPri: 100)
						)
					)
					(11
						(if ((self opponent:) iAmDazed:)
							(self
								loop: param1
								cel: 0
								setPri: 105
								setScript: (sPerformAction new:) 0 1
							)
							((self opponent:) setPri: 100)
						)
					)
					(14
						(self loop: param1 cel: 0 iAmDazed: 1 setCycle: Fwd)
						(stoogeSound number: 2109 play:)
						(lameBrain init: setCycle: ForwardCounter 8 self)
						(= local13 0)
					)
					(16
						(gGSound2 number: 213 play:)
						(self loop: param1 cel: 0 setCycle: End self)
					)
					(else
						(self loop: param1 cel: 0 setCycle: End self)
					)
				)
			)
		)
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (cue)
		(switch loop
			(16
				(= local13 0)
				((self ball:) cue:)
				(if (== ((self ball:) cel:) 2)
					(self setScript: sGameOverMan)
				else
					(self setScript: sResetTheGame)
				)
			)
			(2
				(if (== self playerTwo)
					(self
						x: (+ (self x:) perryDist)
						loop: 0
						cel: 0
						setCycle: Fwd
					)
				else
					(self
						x: (- (self x:) perryDist)
						loop: 0
						cel: 0
						setCycle: Fwd
					)
				)
			)
			(1
				(if (== self playerTwo)
					(self
						x: (- (self x:) perryDist)
						loop: 0
						cel: 0
						setCycle: Fwd
					)
				else
					(self
						cel: 0
						loop: 0
						x: (+ (self x:) perryDist)
						setCycle: Fwd
					)
				)
			)
			(14
				(= local13 1)
				(lameBrain dispose:)
				(self setScript: sDazedTimer)
			)
			(13
				(self command: 15)
			)
			(15
				(= local14 1)
				((self opponent:) command: 16)
			)
			(18
				((self opponent:) command: 16)
			)
			(else
				(if (< ((self gauge:) cel:) ((self gauge:) lastCel:))
					(self loop: 0 cel: 0 setCycle: Fwd)
				else
					(self command: 14)
				)
			)
		)
	)
)

(instance playerOne of StoogeActor
	(properties
		x 104
		y 92
		priority 105
		fixPriority 1
	)
)

(instance sPlayerTwoDelay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local29 1)
				(= cycles (RandomNumber 30 90))
			)
			(1
				(= local29 0)
				(self dispose:)
			)
		)
	)
)

(instance playerTwo of StoogeActor
	(properties
		x 216
		y 92
		priority 100
		fixPriority 1
	)

	(method (doit)
		(cond
			(local29)
			((not local13))
			((playerOne iAmDazed:)
				(if (== ((playerTwo ball:) cel:) 0)
					(playerTwo command: 4)
				else
					(= local29 1)
					(playerTwo command: 11)
				)
			)
			(
				(and
					(OneOf (playerOne loop:) 4 5 6)
					(== (playerTwo loop:) 0)
					(== (GetDistance (self x:) 0 ((self opponent:) x:) 0) 44)
				)
				(switch (RandomNumber 1 local30)
					(1
						(playerTwo command: 3)
					)
					(2
						(if (< (self x:) 250)
							(playerTwo command: 2)
						else
							(playerTwo command: 3)
						)
					)
					(3
						(playerTwo command: 3)
					)
					(else
						(gCurRoom setScript: sPlayerTwoDelay)
					)
				)
			)
			(
				(and
					(!= ((self opponent:) loop:) 1)
					(> (GetDistance (self x:) 0 ((self opponent:) x:) 0) 44)
				)
				(switch (RandomNumber 1 local30)
					(1
						(playerTwo command: 1)
					)
					(2
						(playerTwo command: 1)
					)
					(3
						(playerTwo command: 1)
					)
					(else
						(gCurRoom setScript: sPlayerTwoDelay)
					)
				)
			)
			((and (OneOf (playerOne loop:) 0) (== (playerTwo loop:) 0))
				(switch (RandomNumber 1 (+ local30 1))
					(1
						(playerTwo command: 4)
					)
					(2
						(playerTwo command: 5)
					)
					(3
						(playerTwo command: 6)
					)
					(4
						(playerTwo command: 10)
					)
					(else
						(gCurRoom setScript: sPlayerTwoDelay)
					)
				)
			)
		)
		(super doit:)
	)
)

(class ChooseStooge of Prop
	(properties
		view 214
	)

	(method (doit)
		(super doit:)
		(cond
			(local9)
			(
				(and
					(not local11)
					(not local12)
					(== (gTheCursor loop:) 0)
					(== (self cel:) 0)
					(self onMe: gMouseX gMouseY)
				)
				(self setup:)
			)
			(
				(and
					local11
					(not local12)
					(== (gTheCursor loop:) 0)
					(== (self cel:) (self lastCel:))
					(not (self onMe: gMouseX gMouseY))
				)
				(self clear:)
			)
			(
				(and
					local11
					(not local12)
					(!= (gTheCursor loop:) 0)
					(== (self cel:) (self lastCel:))
					(self onMe: gMouseX gMouseY)
				)
				(self clear:)
			)
		)
	)

	(method (clear)
		(= local12 1)
		(self setCycle: Beg self)
	)

	(method (setup)
		(= local11 1)
		(self setCycle: End)
	)

	(method (cue)
		(PalCycle 4) ; Off
		(= local12 0)
		(= local11 0)
	)
)

(instance chooseLarry of ChooseStooge
	(properties
		noun 3
		x 83
		y 86
	)

	(method (setup)
		(larryName cel: 1)
		(PalCycle 0 176 185 1 3) ; Start
		(super setup:)
	)

	(method (clear)
		(larryName cel: 0)
		(super clear:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (self cel:) (self lastCel:))
					(PalCycle 4) ; Off
					(gCurRoom setScript: sStartGame 0 0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chooseCoily of ChooseStooge
	(properties
		noun 4
		x 159
		y 84
		loop 1
	)

	(method (setup)
		(coilyName cel: 1)
		(PalCycle 0 186 195 1 3) ; Start
		(super setup:)
	)

	(method (clear)
		(coilyName cel: 0)
		(super clear:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (self cel:) (self lastCel:))
					(PalCycle 4) ; Off
					(gCurRoom setScript: sStartGame 0 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chooseMo of ChooseStooge
	(properties
		noun 2
		x 237
		y 89
		loop 2
	)

	(method (setup)
		(moName cel: 1)
		(PalCycle 0 196 205 1 3) ; Start
		(super setup:)
	)

	(method (clear)
		(moName cel: 0)
		(super clear:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (self cel:) (self lastCel:))
					(PalCycle 4) ; Off
					(gCurRoom setScript: sStartGame 0 2)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance larryName of View
	(properties
		noun 1
		x 85
		y 94
		view 215
		loop 2
	)

	(method (init)
		(if local15
			(= loop 5)
		)
		(super init:)
	)
)

(instance coilyName of View
	(properties
		noun 1
		x 159
		y 94
		view 215
		loop 3
	)

	(method (init)
		(if local15
			(= loop 6)
		)
		(super init:)
	)
)

(instance moName of View
	(properties
		noun 1
		x 234
		y 94
		view 215
		loop 4
	)

	(method (init)
		(if local15
			(= loop 7)
		)
		(super init:)
	)
)

(instance chooseTitle of View
	(properties
		noun 1
		x 118
		y 11
		view 215
		loop 1
	)
)

(instance mainTitle of Prop
	(properties
		x 146
		y 65
		scaleX 0
		scaleY 0
		maxScale 0
		view 210
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance notSoMainTitle of Prop
	(properties
		x 151
		y 95
		view 210
		loop 1
		cycleSpeed 9
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(class ButtonProp of Prop
	(properties
		y 130
		priority 200
		fixPriority 1
		view 211
		signal 20513
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			(local31
				(self setScript: (sButtonAction new:))
			)
			((== theVerb 4) ; Do
				(switch self
					(buttonA
						(playerOne command: 4)
						(= temp0 0)
					)
					(buttonB
						(playerOne command: 5)
						(= temp0 1)
					)
					(buttonC
						(playerOne command: 6)
						(= temp0 2)
					)
					(buttonSecret
						(playerOne command: 10)
					)
				)
				(self setScript: (sButtonAction new:))
				(cond
					(local13)
					((not (gEgo has: 18))) ; Cheat_Sheet
					((== temp0 [local19 local27])
						(if (== local27 7)
							(if (== local28 1)
								(= local28 0)
								(= local27 0)
								(buttonSecret loop: 9)
								(buttonSecret
									cel: (buttonSecret lastCel:)
									setCycle: Beg buttonSecret
								)
							else
								(= local28 1)
								(= local27 0)
								(buttonSecret init: setCycle: End buttonSecret)
							)
						else
							(++ local27)
						)
					)
					(else
						(= local27 0)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance buttonA of ButtonProp
	(properties
		noun 5
		x 202
		loop 4
	)
)

(instance buttonB of ButtonProp
	(properties
		noun 6
		x 222
		loop 5
	)
)

(instance buttonC of ButtonProp
	(properties
		noun 7
		x 242
		loop 5
	)
)

(instance buttonSecret of ButtonProp
	(properties
		x 141
		y 110
		loop 9
	)

	(method (cue)
		(if (== cel 0)
			(self dispose:)
		else
			(self loop: 10 cel: 0)
		)
	)
)

(instance joystick of Prop
	(properties
		noun 8
		x 101
		y 133
		priority 200
		fixPriority 1
		view 211
		signal 20513
	)
)

(instance leftJoystick of Feature
	(properties
		y 133
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 102 113 83 141 65 139 74 113
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(joystick loop: 0 setScript: (sButtonAction new:))
			(playerOne command: 2)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance rightJoystick of Feature
	(properties
		y 133
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 102 113 133 113 133 139 118 139
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(joystick loop: 1 setScript: (sButtonAction new:))
			(playerOne command: 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance downJoystick of Feature
	(properties
		y 128
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 92 113 83 139 119 140 111 113
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(joystick loop: 3 setScript: (sButtonAction new:))
			(playerOne command: 3)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance buttonAFeature of Feature
	(properties
		noun 5
		x 198
		y 128
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 187 119 210 119 211 138 186 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(buttonA doVerb: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buttonBFeature of Feature
	(properties
		noun 6
		x 222
		y 128
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 211 119 232 119 234 138 212 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(buttonB doVerb: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buttonCFeature of Feature
	(properties
		noun 7
		x 246
		y 128
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 233 119 256 119 260 138 235 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(buttonC doVerb: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stoogeSound of Sound
	(properties
		flags 1
	)
)

