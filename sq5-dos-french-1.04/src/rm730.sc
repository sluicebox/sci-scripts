;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Main)
(use VelocityMover)
(use AnimDialog)
(use genetix)
(use Print)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm730 0
	cliffyTalker 11
	rogTalker 15
	sUseComm 20
)

(local
	local0
	[local1 2]
	local3
)

(instance theMusic3 of Sound
	(properties)
)

(instance rm730 of Rm
	(properties
		noun 21
		picture 112
	)

	(method (init)
		(= style
			(switch gPrevRoomNum
				(760 11)
				(740 -32758)
				(790 -32758)
				(770 -32758)
			)
		)
		(if (IsFlag 22)
			(exit740 init:)
		)
		(self setRegions: 31) ; genetix
		(LoadMany rsMESSAGE number)
		(LoadMany rsVIEW 1003)
		(bigWF init:)
		(bridge init:)
		(domeBack init:)
		(pondF init:)
		(smallFalls init:)
		(gEgo edgeHit: EDGE_NONE)
		(plant init: setScript: swOscilate)
		(super init:)
		(if (not (IsFlag 28))
			(bigDoor init: stopUpd:)
		)
		(if (not (IsFlag 22))
			(if (IsFlag 28)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 148 0 169 319 164 319 125 308 129 279 148 257 148 205 150 166 154 131 148 61 151 49 147 50 141 80 128 90 123 98 119 111 112 142 109 149 102 180 102 195 102 257 104 258 100 209 99 198 98 188 97 173 97 135 95 129 104 111 110 98 113 83 114 84 119 82 124 71 128 56 127 35 123
							yourself:
						)
				)
			else
				(controlPanel init:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 148 0 169 319 164 319 125 308 129 279 148 257 148 205 150 166 154 131 148 61 151 49 147 50 141 80 128 90 123 98 119 111 112 142 109 149 102 180 102 195 102 257 104 258 100 209 99 198 98 188 97 173 97 135 95 129 104 111 110 98 113 83 114 84 119 82 124 71 128 56 127
							yourself:
						)
				)
			)
		else
			(gSq5Music2 number: 600 setLoop: -1 play:)
			(gSq5Music2
				setVol: (Min 127 (Max 30 (- (gEgo y:) 32)))
			)
			(controlPanel init:)
			(gWalkHandler addToFront: self)
			(gWalkHandler addToFront: exit740)
			(gWalkHandler addToFront: controlPanel)
			(if (and (IsFlag 26) (not (IsFlag 117)))
				(gWalkHandler addToFront: myCliffy)
			)
		)
		(cond
			((IsFlag 22)
				(if (and (IsFlag 26) (not (IsFlag 117)))
					(myCliffy init:)
					(if (not (IsFlag 79))
						(wd40 init:)
					)
				)
			)
			((IsFlag 23)
				(cliffy init:)
			)
		)
		(switch gPrevRoomNum
			(240
				(gCurRoom setScript: sFromShipMore)
			)
			(760
				(if (IsFlag 22)
					(proc31_1 230 150)
					(gGame handsOn:)
				else
					(gCurRoom setScript: sHuman760)
				)
			)
			(740
				(if (IsFlag 22)
					(gCurRoom setScript: sFly740)
				else
					(gCurRoom setScript: sHuman740)
				)
			)
			(770
				(gSq5Music1 number: 39 setLoop: -1 play:)
				(proc31_1 67 95)
			)
			(790
				(gCurRoom setScript: sHuman790)
			)
			(else
				(SetFlag 22)
				(SetFlag 23)
				(SetFlag 24)
				(SetFlag 79)
				(SetFlag 82)
				(SetFlag 25)
				(SetFlag 26)
				(SetFlag 27)
				(gCurRoom setScript: sHuman760)
			)
		)
	)

	(method (doit)
		(Palette palANIMATE 225 233 -1)
		(Palette palANIMATE 234 240 -1)
		(if (IsFlag 22)
			(gEgo setLoop: (/ (+ (gEgo heading:) 90) 180))
			(gSq5Music2
				setVol: (Min 127 (Max 30 (- (gEgo y:) 32)))
			)
		)
		(if (and (not script) (not (IsFlag 22)))
			(cond
				((& (= local0 (gEgo onControl: 1)) $0002)
					(gCurRoom setScript: (ScriptID 31 3) 0 0) ; sGenInNout
				)
				((& local0 $1000)
					(gCurRoom setScript: (ScriptID 31 3) 0 1) ; sGenInNout
				)
				((& local0 $2000)
					(gCurRoom setScript: (ScriptID 31 3) 0 2) ; sGenInNout
				)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (IsFlag 22)
			(switch theVerb
				(3 ; Walk
					(proc31_2 gMouseY)
					(if (> 300 gMouseX)
						(gEgo setMotion: VelocityMover gMouseX gMouseY 0 0)
					else
						(gCurRoom setScript: sExitRight)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (dispose)
		(theMusic3 dispose:)
		(gWalkHandler delete: controlPanel)
		(gWalkHandler delete: self)
		(gWalkHandler delete: exit740)
		(gWalkHandler delete: myCliffy)
		(rogTalker dispose:)
		(super dispose: &rest)
	)
)

(instance sFlyLeave740 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 234 84 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 740)
			)
		)
	)
)

(instance sGetSlapped of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: VelocityMover 178 60 self 1)
			)
			(1
				(gSq5Music2 stop:)
				(= seconds 2)
			)
			(2
				(myCliffy setCycle: End self)
			)
			(3
				(gSq5Music2 number: 620 setLoop: -1 play:)
				(= seconds 2)
			)
			(4
				(EgoDead 41) ; "What we have here is a failure to communicate. Or something."
			)
		)
	)
)

(instance sUseComm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 14 loop: 0 cel: 0 setCycle: End self)
				(gSq5Music2 number: 603 setLoop: 1 play:)
			)
			(1
				(gMessager say: 4 32 4 0 self 701) ; "Wilco to Eureka, come in Eureka."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToCliffy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc31_2 60)
				(gEgo setMotion: VelocityMover 178 60 self 1)
			)
			(1
				(gSq5Music2 pause: 1)
				(if (IsFlag 79)
					(gMessager say: 24 0 0 0 self) ; "You bring a whole new meaning to the expression ''fly boy'' sir. If you can show me where the rest of you is, I'll see what I can do to fix you up."
				else
					(= cycles 1)
				)
			)
			(2
				(if (IsFlag 79)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(3
				(SetScore 235 5)
				(SetFlag 79)
				(= seconds 2)
			)
			(4
				(gEgo stopUpd:)
				(= seconds 1)
			)
			(5
				(cliffOverlay init:)
				(flyOL init: setCycle: Fwd)
				(= seconds 1)
			)
			(6
				(gMessager say: 17 0 0 0 self) ; "Cliffy, it's just a hunch, but I think there's something wrong with the transporter."
			)
			(7
				(cliffOverlay dispose:)
				(flyOL dispose:)
				(gEgo startUpd:)
				(= seconds 2)
			)
			(8
				(gMessager say: 23 0 0 0 self) ; "Excuse me, Captain, I am going to scan the perimeter."
			)
			(9
				(theMusic3 init: number: 156 flags: 1 setLoop: -1 play:)
				(wd40
					view: 6000
					setLoop: 0
					cel: 0
					x: 207
					y: 103
					setPri: 15
					setStep: 8 2
					setCycle: End self
				)
			)
			(10
				(wd40 setMotion: MoveTo 360 103 self)
				(theMusic3 fade:)
			)
			(11
				(wd40 dispose:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gEgo setMotion: VelocityMover 178 60 0 0)
		(gSq5Music2 play:)
		(gGame handsOn:)
		(super dispose:)
	)
)

(instance sFly740 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc31_1 250 60)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sFlyToLock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc31_2 95)
				(SetScore 230 20)
				(gEgo setMotion: VelocityMover 67 95 self 1)
				(gSq5Music2 stop:)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 770)
			)
		)
	)
)

(instance sHuman760 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo 0)
				(gEgo
					init:
					posn: 305 144
					signal: 16384
					setScale: Scaler 124 55 167 80
					setMotion: MoveTo 277 149 self
				)
				(if (not (gEgo has: 10)) ; Communicator
					(= next sGiveCommBack)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHuman740 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(NormalEgo 0)
				(gEgo
					init:
					setScale: Scaler 124 55 167 80
					posn: 261 101
					setMotion: MoveTo 180 101 self
				)
				(if (not (gEgo has: 10)) ; Communicator
					(= next sGiveCommBack)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveCommBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(wd40
					init:
					view: 6000
					setLoop: 1
					cel: 0
					setStep: 8 2
					moveSpeed: 1
					x: 311
					y: 139
				)
				(theMusic3 init: number: 156 setLoop: -1 play:)
				(= cycles 2)
			)
			(1
				(wd40 setMotion: MoveTo 311 139 self)
			)
			(2
				(wd40 setMotion: MoveTo 282 137 self)
			)
			(3
				(wd40 setMotion: MoveTo 248 134 self)
			)
			(4
				(wd40 setMotion: MoveTo 215 130 self)
			)
			(5
				(wd40 setMotion: MoveTo 184 134 self)
			)
			(6
				(theMusic3 fade:)
				(wd40 setMotion: MoveTo 153 138 self)
			)
			(7
				(wd40 setMotion: MoveTo 123 134 self)
			)
			(8
				(wd40 setMotion: MoveTo 97 128 self)
			)
			(9
				(wd40 setMotion: MoveTo 80 136 self)
			)
			(10
				(wd40 setCycle: End self)
			)
			(11
				(if (or (!= (gEgo x:) 51) (!= (gEgo y:) 134))
					(gEgo setMotion: PolyPath 51 134 self)
				else
					(= cycles 3)
				)
			)
			(12
				(gEgo
					view: 6000
					setLoop: 4
					setCel: 0
					setCycle: 0
					x: 51
					y: 134
				)
				(wd40 setLoop: 2 setCycle: End self)
			)
			(13
				(= seconds 2)
			)
			(14
				(gMessager say: 13 0 0 0 self) ; "Perimeter secured, Captain Wilco."
			)
			(15
				(gEgo setCycle: End self)
			)
			(16
				(wd40 setLoop: 3 setCel: 0)
				(= seconds 2)
			)
			(17
				(gMessager say: 13 0 3 0 self) ; "Thanks, WD40."
			)
			(18
				(wd40 view: 34 x: 66 y: 131 setCel: 15)
				(= seconds 3)
			)
			(19
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(wd40 setCycle: Beg self)
			)
			(20
				(wd40 dispose:)
				(= seconds 4)
			)
			(21
				(gEgo get: 10) ; Communicator
				(NormalEgo 0)
				(sHuman790 cue:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHuman790 of Script
	(properties)

	(method (dispose)
		(NormalEgo 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(NormalEgo 0)
				(gEgo
					init:
					posn: 10 134
					setScale: Scaler 124 55 167 80
					setMotion: MoveTo 50 134 self
				)
				(if (IsFlag 23)
					(cliffy init:)
				)
			)
			(1
				(if (IsFlag 23)
					(= seconds 2)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(2
				(if (not (gEgo has: 10)) ; Communicator
					(self setScript: sGiveCommBack)
				else
					(= ticks 1)
				)
			)
			(3
				(= local3
					(if (not (IsFlag 102))
						6
					else
						(ClearFlag 102)
						(cond
							((gEgo has: 16) ; Liquid_Nitro_Tank
								(gEgo put: 16) ; Liquid_Nitro_Tank
								(if (IsFlag 82) 4 else 7)
							)
							((IsFlag 82) 5)
							(else 8)
						)
					)
				)
				(gMessager say: 14 0 local3 0 self 730)
			)
			(4
				(cliffyTalker
					normal: 0
					keepWindow: 1
					curNoun: 2
					curVerb: 0
					curCase: 2
				)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2))
				(gGame setCursor: 999 1)
				(gMessager say: 2 0 2 1 self) ; "Well, Captain, what do ya wanna do now?"
			)
			(6
				(cliffyTalker normal: 1 keepWindow: 0 disposeWhenDone: 1)
				(= cycles 1)
			)
			(7
				(if (== (cliffyTalker whichSelect:) 1)
					(= next sBeamMeUp)
					(= cycles 1)
				else
					(gTheIconBar select: (gTheIconBar at: 0))
					(gGame setCursor: 980 1)
					(self dispose:)
				)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance sCommandCliffy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cliffyTalker
					normal: 0
					keepWindow: 1
					curNoun: 1
					curVerb: 24
					curCase: 1
				)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2))
				(gGame setCursor: 982)
				(gMessager say: 1 24 1 0 self) ; "What is it, Cap'n?"
			)
			(2
				(cliffyTalker normal: 1 keepWindow: 0 disposeWhenDone: 1)
				(= cycles 1)
			)
			(3
				(if (== (cliffyTalker whichSelect:) 1)
					(= next sBeamMeUp)
				else
					(gTheIconBar select: (gTheIconBar at: 0))
					(gGame setCursor: 980 1)
				)
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sFly790 of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc31_1 70 0)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCardNLock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 84 125 self)
			)
			(1
				(gEgo setHeading: 290 self)
			)
			(2
				(gEgo view: 611 loop: 5 cel: 0 setCycle: End self)
				(gGame handsOn:)
				(gGame setCursor: 999 1)
			)
			(3
				(NormalEgo 0)
				(if (!= global129 341)
					(if (< global165 5)
						(if global129
							(cond
								((& global129 $feaa)
									(Print
										addText: 5 0 0 0 ; "Oops. You've bungled this puzzle. Maybe you should have paid more attention to your surroundings while you were a fly. We'll reset the puzzle and give you another try."
										addButton: 0 8 0 0 0 120 54 ; "Reset Puzzle"
										init:
									)
									(= global129 0)
									(++ global165)
								)
								(
									(Print
										addText: 16 35 0 1 ; "That is not the correct configuration..."
										addButton: 1 6 0 0 0 15 44 ; "Reset"
										addButton: 0 7 0 0 0 120 44 ; "Continue"
										init:
									)
									(= global129 0)
									(++ global165)
								)
							)
						else
							(Print addText: 16 43 0 1 init:) ; "The lock simply rejects your card."
							(++ global165)
						)
					else
						(EgoDead 42) ; "Five times and you still couldn't get it right. Next time you're buzzing around, pay more attention."
					)
					(gGame handsOn:)
					(self dispose:)
				else
					(= cycles 2)
				)
			)
			(4
				((gCurRoom obstacles:) dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 148 0 169 319 164 319 125 308 129 279 148 257 148 205 150 166 154 131 148 61 151 49 147 50 141 80 128 90 123 98 119 111 112 142 109 149 102 180 102 195 102 257 104 258 100 209 99 198 98 188 97 173 97 135 95 129 104 111 110 98 113 83 114 84 119 82 124 71 128 56 127 35 123
							yourself:
						)
				)
				(SetFlag 28)
				(controlPanel dispose:)
				(bigDoor startUpd: setCycle: End)
				(gSq5Music2 number: 108 setLoop: 1 play: self)
			)
			(5
				(switch global165
					(0
						(SetScore 239 500)
					)
					(1
						(SetScore 240 300)
					)
					(2
						(SetScore 241 100)
					)
					(3
						(SetScore 242 50)
					)
					(else
						(SetScore 243 25)
					)
				)
				(= cycles 1)
			)
			(6
				(= seconds 2)
			)
			(7
				(gMessager say: 9 1 0 0 self) ; "It looks dangerous down there Captain, I volunteer to stand guard up here."
			)
			(8
				(gGame handsOn:)
				(bigDoor dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sExitRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 400 100 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 760)
			)
		)
	)
)

(instance swOscilate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 15))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= seconds (Random 4 15))
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(= cycles 1)
				(= state -1)
			)
		)
	)
)

(instance plant of MyProp
	(properties
		x 271
		y 189
		noun 19
		view 610
		loop 1
		priority 14
		signal 16
		cycleSpeed 50
	)
)

(instance bigDoor of MyProp
	(properties
		x 14
		y 102
		noun 12
		view 610
		signal 16384
	)
)

(instance controlPanel of MyFeature
	(properties
		x 271
		y 189
		noun 16
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(proc31_2 gMouseY)
				(gCurRoom setScript: sFlyToLock)
			)
			(35 ; Business_Card
				(gCurRoom setScript: sCardNLock)
			)
			(1 ; Look
				(if (IsFlag 22)
					(gMessager say: 16 1 10 0) ; "It looks like every other electronic card key lock you've ever seen."
				else
					(gMessager say: 16 1 11 0) ; "It looks like an electronic card key lock."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance myCliffy of MyActor
	(properties
		x 179
		y 104
		noun 17
		modNum 701
		view 626
		signal 16384
	)

	(method (init)
		(super init:)
		(self setScale: Scaler 124 55 167 80)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (and (IsFlag 24) (not (IsFlag 23)) (IsFlag 22))
					(proc31_2 gMouseY)
					(gCurRoom setScript: sTalkToCliffy)
				)
				(if (not (IsFlag 24))
					(proc31_2 gMouseY)
					(gCurRoom setScript: sGetSlapped)
				)
			)
			(2 ; Talk
				(myCliffy doVerb: 3 &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wd40 of MyActor
	(properties
		x 202
		y 102
		noun 23
		view 13
		loop 2
		cel 4
		signal 16384
		moveSpeed 2
	)

	(method (init)
		(super init:)
		(self setScale: Scaler 124 55 167 80)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 22)
					(gMessager say: 23 4 10 0 self) ; MISSING MESSAGE
				else
					(gMessager say: 23 4 11 0 self) ; MISSING MESSAGE
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance exit740 of MyFeature
	(properties
		x 271
		y 79
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(proc31_2 gMouseY)
				(gCurRoom setScript: sFlyLeave740)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rogTalker of Narrator
	(properties)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 99 tailY: 70 xOffset: 10 isBottom: 0)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance bigWF of MyFeature
	(properties
		x 133
		y 90
		noun 3
		onMeCheck 8
	)
)

(instance bridge of MyFeature
	(properties
		x 302
		y 136
		noun 4
		onMeCheck 2
	)
)

(instance domeBack of MyFeature
	(properties
		x 200
		y 11
		noun 11
		onMeCheck 16
	)
)

(instance pondF of MyFeature
	(properties
		x 208
		y 124
		noun 20
		onMeCheck 32
	)
)

(instance smallFalls of MyFeature
	(properties
		x 282
		y 79
		noun 22
		onMeCheck 64
	)
)

(instance cliffOverlay of View
	(properties
		x 10
		y 25
		view 1003
		loop 7
		priority 15
		signal 16
	)
)

(instance cliffyTalker of ChoiceTalker
	(properties
		x 10
		y 25
		view 1003
		talkWidth 150
		textX 120
		textY 10
		normal 1
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSq5Win)
		(super init: 0 cliffyEyes cliffyMouth &rest)
		(if (not (IsFlag 22))
			(cliffyEyes setLoop: (Random 2 3))
		)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance cliffyEyes of Prop
	(properties
		nsTop 14
		nsLeft 58
		view 1003
		loop 5
	)
)

(instance cliffyMouth of Prop
	(properties
		nsTop 32
		nsLeft 52
		view 1003
		loop 1
	)
)

(instance flyOL of MyActor
	(properties
		x 87
		y 254
		z 200
		view 1003
		loop 6
		priority 15
		signal 16
		cycleSpeed 15
	)
)

(instance sBeamMeUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 15 0 0 0 self) ; "I'll beam us up now, Cap'n."
				(gGame handsOff:)
			)
			(1
				(cliffy view: 604 loop: 2 cel: 0)
				(gEgo setHeading: 180)
				(= seconds 1)
			)
			(2
				(cliffy setCel: 1)
				(= seconds 3)
			)
			(3
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(gEgo view: 6 cel: 15 setCycle: Beg self)
				(cliffy view: 33 cel: 15 setCycle: Beg self)
			)
			(4 0)
			(5
				(cliffy dispose:)
				(gEgo dispose:)
				(= seconds 2)
			)
			(6
				(gCurRoom newRoom: 240)
			)
		)
	)
)

(instance cliffy of MyActor
	(properties
		x 75
		y 145
		noun 17
		view 20
		signal 16384
	)

	(method (init)
		(super init:)
		(self setHeading: 300 setScale: Scaler 124 55 167 80)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((IsFlag 22)
						(gMessager say: 17 2 10 1) ; "Get closer."
					)
					((not (gEgo has: 10)) ; Communicator
						(gMessager say: 1 2 0 0 0 701) ; "Let's worry about the door, before we shoot the breeze"
					)
					(else
						(gCurRoom setScript: sCommandCliffy)
					)
				)
			)
			(24 ; Order
				(if (not (gEgo has: 10)) ; Communicator
					(gMessager say: 1 24 2 0 0 701) ; "Let's beam back to the Eureka now, Cliffy."
				else
					(gCurRoom setScript: sCommandCliffy)
				)
			)
			(35 ; Business_Card
				(= local3 (if global129 15 else 14))
				(gMessager say: 17 35 local3 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sFromShipMore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music1 number: 39 setLoop: -1 play:)
				(theMusic3 number: 260 setLoop: 1 play:)
				(cliffy view: 33 init: cel: 0 setCycle: End)
				(NormalEgo 6)
				(gEgo
					init:
					posn: 50 134
					loop: 0
					cel: 0
					setScale: Scaler 124 55 167 80
					setCycle: End self
				)
			)
			(1
				(NormalEgo 0)
				(gEgo setScale: Scaler 124 55 167 80 setHeading: 180)
				(cliffy view: 604 loop: 2 cel: 0)
				(= seconds 2)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

