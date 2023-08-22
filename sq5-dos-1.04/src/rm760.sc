;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 760)
(include sci.sh)
(use Main)
(use VelocityMover)
(use genetix)
(use Talker)
(use Scaler)
(use Polygon)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm760 0
	floTalker 13
	rogTalker 15
	sUseComm 20
)

(local
	[local0 4] = [1 147 157 164]
	[local4 5] = [1 79 79 75 1]
	local9
	local10
	local11
	local12
	[local13 5]
)

(procedure (localproc_0 param1 param2)
	(if
		(and
			(< (GetDistance param1 param2 (gEgo x:) (gEgo y:)) 120)
			(<
				160
				(Abs
					(-
						(gEgo heading:)
						(GetAngle param1 param2 (gEgo x:) (gEgo y:))
					)
				)
			)
		)
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance rm760 of Rm
	(properties
		noun 15
		picture 110
	)

	(method (init)
		(self setRegions: 31) ; genetix
		(gSq5Music1 number: 39 setLoop: -1 play:)
		(plants init:)
		(domeF init:)
		(palmTree init:)
		(bridgeR init:)
		(gEgo edgeHit: EDGE_NONE)
		(= style
			(switch gPrevRoomNum
				(730 12)
				(740 -32758)
			)
		)
		(if (or (IsFlag 22) (not (IsFlag 25)))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 162 144 219 103 148 77 98 110 160 145
						yourself:
					)
			)
			(UnLoad 128 0)
			(pond1 init:)
			(pond2 init:)
			(pond3 init:)
			(pond4 init:)
			(exit740 init:)
			(flower1 init: stopUpd:)
			(flower2 init: stopUpd:)
			(flower3 init: stopUpd:)
			(gWalkHandler addToFront: self)
			(gWalkHandler addToFront: comm)
			(gWalkHandler addToFront: exit740)
			(gWalkHandler addToFront: pond1)
			(gWalkHandler addToFront: pond2)
			(gWalkHandler addToFront: pond3)
			(gWalkHandler addToFront: pond4)
			(gWalkHandler addToFront: flower1)
			(gWalkHandler addToFront: flower2)
			(gWalkHandler addToFront: flower3)
		else
			(flower1 init: addToPic: dispose:)
			(flower2 init: addToPic: dispose:)
			(flower3 init: addToPic: dispose:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 2 152 46 122 88 110 212 113 218 151 271 151 289 104 70 95 55 87 42 93 58 99 54 104 1 120 1 148
						yourself:
					)
			)
		)
		(super init:)
		(switch gPrevRoomNum
			(730
				(if (IsFlag 22)
					(comm init:)
					(proc31_1 40 140)
					(gEgo edgeHit: EDGE_NONE)
					(gGame handsOn:)
				else
					(gCurRoom setScript: sHuman730)
				)
			)
			(740
				(if (IsFlag 22)
					(comm init:)
					(proc31_1 40 40)
				else
					(gCurRoom setScript: sHuman740)
				)
			)
			(else
				(gCurRoom setScript: sFromShipFirst)
			)
		)
		(if (IsFlag 22)
			(gSq5Music2 number: 600 loop: -1 play:)
			(gSq5Music2
				setVol: (Min 127 (Max 30 (- (gEgo y:) 32)))
			)
		)
		(UnLoad 128 607)
	)

	(method (doit)
		(if (IsFlag 22)
			(if (!= (gEgo view:) 603)
				(gEgo setLoop: (/ (+ (gEgo heading:) 90) 180))
			)
			(gSq5Music2
				setVol: (Min 127 (Max 30 (- (gEgo y:) 32)))
			)
			(if (not script)
				(switch local10
					(0 0)
					(1
						(if (localproc_0 [local0 local10] [local4 local10])
							(gCurRoom setScript: sFrogJump2)
						)
					)
					(2
						(if (localproc_0 [local0 local10] [local4 local10])
							(if (Random 0 1)
								(gCurRoom setScript: sFrogJump1)
							else
								(gCurRoom setScript: sFrogJump3)
							)
						)
					)
					(3
						(if (localproc_0 [local0 local10] [local4 local10])
							(gCurRoom setScript: sFrogJump3)
						)
					)
					(4
						(if (and (not local11) (not (IsFlag 24)))
							(gCurRoom setScript: sFrogJump4)
						)
					)
				)
			)
		)
		(if (not (or (IsFlag 22) script))
			(cond
				((& (= local12 (gEgo onControl: 1)) $0002)
					(gCurRoom setScript: (ScriptID 31 3) 0 5) ; sGenInNout
				)
				((& local12 $0004)
					(gCurRoom setScript: (ScriptID 31 3) 0 6) ; sGenInNout
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
					(= local10 0)
					(cond
						((< 10 gMouseX)
							(gEgo
								setMotion:
									VelocityMover
									gMouseX
									gMouseY
									self
									0
							)
						)
						(script
							(gEgo
								setMotion:
									VelocityMover
									gMouseX
									gMouseY
									self
									0
							)
							((gCurRoom script:) next: sExitLeft)
						)
						(else
							(gCurRoom setScript: sExitLeft)
						)
					)
				)
				(1 ; Look
					(if (== 110 (self curPic:))
						(super doVerb: 1 &rest)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: comm)
		(gWalkHandler delete: self)
		(gWalkHandler delete: flower1)
		(gWalkHandler delete: flower2)
		(gWalkHandler delete: flower3)
		(gWalkHandler delete: pond1)
		(gWalkHandler delete: pond2)
		(gWalkHandler delete: pond3)
		(gWalkHandler delete: pond4)
		(gWalkHandler delete: exit740)
		(DisposeScript 29)
		(DisposeScript 932)
		(super dispose: &rest)
	)
)

(instance sExitLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: VelocityMover -200 100 0 1)
				(= seconds 5)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 730)
			)
		)
	)
)

(instance sFrogJump1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gEgo setMotion: MoveTo 132 83)
				(gSq5Music1 number: 40 setLoop: 1 play:)
				(mwog init: startUpd: loop: 0 cel: 0 x: 193 y: 150)
				(= ticks 7)
			)
			(2
				(mwog cel: 0 x: 190 y: 141)
				(= ticks 7)
			)
			(3
				(mwog cel: 0 x: 186 y: 130)
				(= ticks 7)
			)
			(4
				(mwog cel: 0 x: 180 y: 118)
				(= ticks 7)
			)
			(5
				(mwog cel: 1 x: 167 y: 103)
				(= ticks 7)
			)
			(6
				(mwog cel: 2 x: 157 y: 94)
				(= ticks 7)
			)
			(7
				(mwog cel: 3 x: 135 y: 86)
				(= ticks 7)
			)
			(8
				(mwog cel: 4 x: 122 y: 83)
				(= ticks 7)
			)
			(9
				(theMusic3 number: 604 setLoop: 1 play:)
				(if
					(or
						(not (gEgo mover:))
						(not ((gEgo mover:) isKindOf: VelocityMover))
					)
					(gEgo hide:)
					(gSq5Music2 stop:)
					(= local9 1)
				)
				(mwog cel: 5 x: 121 y: 83)
				(= ticks 7)
			)
			(10
				(mwog cel: 6 x: 128 y: 88)
				(= ticks 7)
			)
			(11
				(mwog cel: 7 x: 134 y: 92)
				(= ticks 7)
			)
			(12
				(mwog cel: 2 x: 124 y: 97)
				(= ticks 7)
			)
			(13
				(mwog cel: 4 x: 109 y: 103)
				(= ticks 7)
			)
			(14
				(mwog cel: 6 x: 122 y: 118)
				(= ticks 7)
			)
			(15
				(mwog cel: 7 x: 129 y: 132)
				(= ticks 7)
			)
			(16
				(mwog loop: 5 cel: 0 x: 131 y: 140 setCycle: End self)
			)
			(17
				(= local10 0)
				(if local9
					(EgoDead 26) ; "Doesn't look like you'll be bugging anyone for awhile."
				else
					(mwog dispose:)
					(theMusic3 number: 411 setLoop: 1 play: self)
				)
			)
			(18
				(gSq5Music1 number: 39 setLoop: -1 play:)
				(gMessager say: 12 0 0 0 self) ; "Whew! That was too close!"
			)
			(19
				(self dispose:)
			)
		)
	)
)

(instance sFrogJump2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 132 78)
				(mwog init: startUpd: loop: 0 cel: 0 x: 160 y: 112)
				(gSq5Music1 number: 40 setLoop: 1 play:)
				(= ticks 9)
			)
			(1
				(mwog cel: 0 x: 158 y: 102)
				(= ticks 9)
			)
			(2
				(mwog cel: 1 x: 151 y: 94)
				(= ticks 9)
			)
			(3
				(mwog cel: 2 x: 148 y: 88)
				(= ticks 9)
			)
			(4
				(mwog cel: 3 x: 137 y: 83)
				(= ticks 9)
			)
			(5
				(mwog cel: 4 x: 134 y: 81)
				(= ticks 9)
			)
			(6
				(mwog cel: 5 x: 137 y: 79)
				(= ticks 9)
			)
			(7
				(theMusic3 number: 604 setLoop: 1 play:)
				(if
					(or
						(not (gEgo mover:))
						(not ((gEgo mover:) isKindOf: VelocityMover))
					)
					(gEgo hide:)
					(gSq5Music2 stop:)
					(= local9 1)
				)
				(mwog cel: 6 x: 146 y: 81)
				(= ticks 9)
			)
			(8
				(mwog cel: 7 x: 153 y: 85)
				(= ticks 9)
			)
			(9
				(mwog cel: 5 x: 138 y: 86)
				(= ticks 9)
			)
			(10
				(mwog cel: 6 x: 146 y: 92)
				(= ticks 9)
			)
			(11
				(mwog cel: 7 x: 152 y: 96)
				(= ticks 9)
			)
			(12
				(mwog cel: 7 x: 152 y: 105)
				(= ticks 9)
			)
			(13
				(mwog cel: 7 x: 152 y: 115)
				(= ticks 9)
			)
			(14
				(mwog loop: 4 cel: 0 x: 166 y: 128 setCycle: End self)
			)
			(15
				(mwog loop: 5 cel: 0 x: 152 y: 126 setCycle: End self)
			)
			(16
				(if local9
					(EgoDead 26) ; "Doesn't look like you'll be bugging anyone for awhile."
				else
					(mwog dispose:)
					(theMusic3 number: 411 setLoop: 1 play: self)
				)
			)
			(17
				(gSq5Music1 number: 39 setLoop: -1 play:)
				(gMessager say: 12 0 0 0 self) ; "Whew! That was too close!"
			)
			(18
				(= local10 0)
				(self dispose:)
			)
		)
	)
)

(instance sFrogJump3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gEgo setMotion: MoveTo 185 78)
				(gSq5Music1 number: 40 setLoop: 1 play:)
				(mwog init: startUpd: loop: 1 cel: 7 x: 152 y: 115)
				(= ticks 9)
			)
			(2
				(mwog cel: 0 x: 137 y: 135)
				(= ticks 9)
			)
			(3
				(mwog cel: 0 x: 140 y: 126)
				(= ticks 9)
			)
			(4
				(mwog cel: 0 x: 143 y: 115)
				(= ticks 9)
			)
			(5
				(mwog cel: 1 x: 155 y: 98)
				(= ticks 9)
			)
			(6
				(mwog cel: 3 x: 173 y: 86)
				(= ticks 9)
			)
			(7
				(mwog cel: 4 x: 180 y: 80)
				(= ticks 9)
			)
			(8
				(mwog cel: 6 x: 170 y: 78)
				(= ticks 9)
			)
			(9
				(mwog cel: 7 x: 170 y: 76)
				(= ticks 9)
			)
			(10
				(theMusic3 number: 604 setLoop: 1 play:)
				(mwog cel: 5 x: 188 y: 75)
				(= ticks 9)
				(if
					(or
						(not (gEgo mover:))
						(not ((gEgo mover:) isKindOf: VelocityMover))
					)
					(= local9 1)
					(gSq5Music2 stop:)
					(gEgo hide:)
				)
			)
			(11
				(mwog cel: 4 x: 195 y: 76)
				(= ticks 9)
			)
			(12
				(mwog cel: 6 x: 185 y: 81)
				(= ticks 9)
			)
			(13
				(mwog cel: 7 x: 179 y: 88)
				(= ticks 9)
			)
			(14
				(mwog cel: 7 x: 182 y: 97)
				(= ticks 9)
			)
			(15
				(mwog cel: 7 x: 183 y: 111)
				(= ticks 9)
			)
			(16
				(mwog cel: 7 x: 185 y: 125)
				(= ticks 9)
			)
			(17
				(mwog cel: 7 x: 188 y: 141)
				(= ticks 9)
			)
			(18
				(mwog loop: 5 cel: 3 x: 186 y: 147 setCycle: End self)
			)
			(19
				(if local9
					(EgoDead 26) ; "Doesn't look like you'll be bugging anyone for awhile."
				else
					(mwog dispose:)
					(theMusic3 number: 411 setLoop: 1 play: self)
				)
			)
			(20
				(gSq5Music1 number: 39 setLoop: -1 play:)
				(gMessager say: 12 0 0 0 self) ; "Whew! That was too close!"
			)
			(21
				(= local10 0)
				(self dispose:)
			)
		)
	)
)

(instance sFrogJump4 of Script
	(properties)

	(method (dispose)
		(= local10 0)
		(= local11 1)
		(hello dispose:)
		(gSq5Music1 number: 39 setLoop: -1 play:)
		(gSq5Music2 number: 600 loop: -1 play:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 40 setLoop: 1 play:)
				(gEgo setMotion: VelocityMover 226 128 0 0)
				(= seconds 2)
			)
			(1
				(mwog init: loop: 1 cel: 0 x: 190 y: 146)
				(= ticks 5)
			)
			(2
				(mwog loop: 1 cel: 0 x: 193 y: 135)
				(= ticks 5)
			)
			(3
				(mwog loop: 1 cel: 0 x: 197 y: 121)
				(= ticks 5)
			)
			(4
				(mwog loop: 1 cel: 2 x: 210 y: 107)
				(= ticks 5)
			)
			(5
				(mwog loop: 1 cel: 3 x: 232 y: 96)
				(= ticks 5)
			)
			(6
				(mwog loop: 1 cel: 4 x: 240 y: 94)
				(= ticks 5)
				(theMusic3 number: 604 setLoop: 1 play:)
			)
			(7
				(mwog loop: 1 cel: 6 x: 232 y: 99)
				(= ticks 5)
			)
			(8
				(mwog loop: 2 cel: 0 x: 218 y: 105)
				(= ticks 5)
			)
			(9
				(mwog loop: 2 cel: 1 x: 222 y: 113)
				(= ticks 5)
			)
			(10
				(mwog loop: 2 cel: 2 x: 229 y: 115)
				(= ticks 5)
			)
			(11
				(mwog loop: 2 cel: 3 x: 239 y: 117)
				(= ticks 9)
			)
			(12
				(mwog loop: 3 cel: 0 x: 238 y: 119)
				(= ticks 9)
			)
			(13
				(mwog loop: 3 cel: 1 x: 233 y: 114)
				(= ticks 9)
			)
			(14
				(mwog loop: 3 cel: 2 x: 239 y: 103)
				(= ticks 9)
			)
			(15
				(mwog loop: 3 cel: 3 x: 230 y: 107)
				(= ticks 9)
			)
			(16
				(mwog loop: 3 cel: 4 x: 224 y: 116)
				(= ticks 9)
			)
			(17
				(mwog loop: 3 cel: 5 x: 221 y: 124)
				(= ticks 9)
			)
			(18
				(mwog loop: 3 cel: 6 x: 217 y: 122)
				(= ticks 9)
			)
			(19
				(mwog loop: 10 cel: 0 x: 214 y: 125)
				(= ticks 9)
			)
			(20
				(mwog loop: 10 cel: 1 x: 216 y: 121)
				(= ticks 9)
			)
			(21
				(mwog loop: 10 cel: 2 x: 204 y: 116)
				(= ticks 9)
			)
			(22
				(mwog loop: 10 cel: 3 x: 193 y: 118)
				(= ticks 9)
			)
			(23
				(mwog loop: 10 cel: 4 x: 185 y: 117)
				(= ticks 9)
				(theMusic3 number: 603 setLoop: 1 play:)
			)
			(24
				(mwog loop: 10 cel: 4 x: 182 y: 129)
				(= ticks 9)
			)
			(25
				(mwog loop: 11 cel: 1 x: 180 y: 144)
				(= ticks 9)
			)
			(26
				(mwog loop: 4 cel: 1 x: 186 y: 150)
				(= ticks 9)
			)
			(27
				(mwog loop: 4 cel: 2 x: 185 y: 149)
				(= ticks 9)
			)
			(28
				(mwog dispose:)
				(theMusic3 number: 411 setLoop: 1 play:)
				(= seconds 1)
			)
			(29
				(SetScore 228 100)
				(comm cel: 1)
				(= seconds 1)
			)
			(30
				(hello init:)
				(= seconds 4)
			)
			(31
				(hello cel: 1 x: 185 y: 101)
				(= seconds 2)
			)
			(32
				(self dispose:)
			)
		)
	)
)

(instance sHuman730 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(NormalEgo 0)
				(gEgo
					init:
					posn: 15 134
					setScale: Scaler 124 55 167 80
					setMotion: MoveTo 56 114 self
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
				(= seconds 1)
			)
			(1
				(NormalEgo 0)
				(gEgo
					posn: 20 101
					init:
					setScale: Scaler 124 55 167 80
					setMotion: MoveTo 78 103 self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFromShipFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsMESSAGE (gCurRoom number:))
				(gTheIconBar disable: 4 5 2 6)
				(= seconds 2)
			)
			(1
				(gTheIconBar disable: 4 5 2 1 6)
				(gEgo put: 10) ; Communicator
				(gSq5Music2 number: 600 loop: -1 play:)
				(gSq5Music2
					setVol: (Min 127 (Max 30 (- (gEgo y:) 32)))
				)
				(SetFlag 25)
				(SetFlag 22)
				(proc31_1 225 125)
				(theMusic3 number: 260 loop: 1 play:)
				(UnLoad 141 260)
				(comm init:)
				(rogCan init: setScale: Scaler 124 55 167 80 setCycle: End self)
			)
			(2
				(gSq5Music2 number: 600 loop: -1 play:)
				(rogCan view: 606)
				(gMessager say: 1 0 0 0 self) ; "Looks like you've had a ''zany transporter blooper,'' Rog. Quick, get a camera! Galactic Inquirer will pay you ten buckazoids if they publish your photo!"
			)
			(3
				(gGame handsOn:)
				(rogCan view: 606 setLoop: 0 cel: 0 setCycle: End self)
			)
			(4
				(rogCan setLoop: 1 setCycle: Fwd setMotion: MoveTo 224 135 self)
			)
			(5
				(rogCan setLoop: 1 setCycle: Fwd setMotion: MoveTo 221 111 self)
			)
			(6
				(rogCan
					setLoop: 1
					setCycle: Fwd
					setPri: 1
					setMotion: MoveTo 31 101 self
				)
			)
			(7
				(rogCan dispose:)
				(= cycles 1)
			)
			(8
				(UnLoad 128 604)
				(Load rsVIEW 605)
				(self dispose:)
			)
		)
	)
)

(instance sFlyLeave740 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 55 84 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 740)
			)
		)
	)
)

(instance sShowComm of Script
	(properties)

	(method (doit)
		(if
			(and
				(& (= local12 (gEgo onControl: 1)) $1000)
				(OneOf state 2 9)
			)
			(self dispose:)
		)
		(super doit:)
	)

	(method (dispose)
		(gWalkHandler dispose: outside)
		(gWalkHandler addToFront: gCurRoom)
		(gWalkHandler addToFront: comm)
		(gWalkHandler addToFront: exit740)
		(gWalkHandler addToFront: flower1)
		(gWalkHandler addToFront: flower2)
		(gWalkHandler addToFront: flower3)
		(gWalkHandler addToFront: pond1)
		(gWalkHandler addToFront: pond2)
		(gWalkHandler addToFront: pond3)
		(gWalkHandler addToFront: pond4)
		(outside dispose:)
		(comScreen dispose:)
		(gCurRoom drawPic: 110 100)
		(proc31_1 226 108)
		(proc31_2 108)
		(gCast eachElementDo: #show)
		(gSq5Music2 pause: 0)
		(= local10 0)
		(commButton dispose:)
		(hello dispose:)
		(floOverlay startUpd: dispose:)
		(gSq5Music2 number: 600 loop: -1 play:)
		(gSq5Music2 setVol: (Min 127 (Max 30 (- (gEgo y:) 32))))
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gWalkHandler delete: comm)
				(gWalkHandler delete: gCurRoom)
				(gWalkHandler delete: flower1)
				(gWalkHandler delete: flower2)
				(gWalkHandler delete: flower3)
				(gWalkHandler delete: pond1)
				(gWalkHandler delete: pond2)
				(gWalkHandler delete: pond3)
				(gWalkHandler delete: pond4)
				(gWalkHandler delete: exit740)
				(proc31_2 65)
				(gEgo setMotion: VelocityMover 226 128 self 1)
			)
			(1
				(gSq5Music2 pause: 1)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 111 100)
				(if (or (IsFlag 24) (not local11))
					(commButton init: setLoop: 4)
					(comScreen init:)
				else
					(commButton init: setLoop: 3)
					(commButton setCycle: Fwd)
					(floOverlay init: stopUpd:)
				)
				(commButton init:)
				(outside init:)
				(gWalkHandler addToFront: outside)
				(= cycles 2)
			)
			(2
				(NormalEgo 603)
				(gEgo show: setScale: 0 posn: 137 108)
				(if (or (IsFlag 24) (not local11))
					(gGame handsOn:)
				else
					(gGame handsOn:)
					(= state 4)
				)
			)
			(3
				(self dispose:)
			)
			(4 0)
			(5
				(gEgo setMotion: MoveTo 137 108 self)
			)
			(6
				(commButton cel: 0)
				(SetScore 229 40)
				(if (IsFlag 64)
					(gMessager say: 6 0 1 0 self) ; "Hello, Flo..."
				else
					(gMessager say: 6 0 2 0 self) ; "Can somebody up there explain to me how the captain of a starship can be reduced to a common house fly?!"
				)
			)
			(7
				(commButton setLoop: 4)
				(SetFlag 24)
				(floOverlay dispose:)
				(DrawPic 111 9)
				(= seconds 2)
			)
			(8
				(comm cel: 0)
				(gGame handsOn:)
			)
		)
	)
)

(instance sFlyTrap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(switch register
					(flower1
						(gEgo setMotion: VelocityMover 127 137 self 1)
					)
					(flower2
						(gEgo setMotion: VelocityMover 158 114 self 1)
					)
					(flower3
						(gEgo setMotion: VelocityMover 207 118 self 1)
					)
				)
			)
			(2
				(register startUpd: setCycle: End self)
				(if (!= register flower3)
					(gSq5Music2 number: 604 setLoop: 1 play:)
				)
			)
			(3
				(gEgo dispose:)
				(if (== register flower3)
					(flower3 setLoop: 3 cel: 0)
					(gSq5Music2 number: 604 setLoop: 1 play:)
				)
				(register setCycle: Beg self)
			)
			(4
				(register stopUpd:)
				(= seconds 3)
			)
			(5
				(EgoDead 25) ; "You taste as good as you crunch."
			)
		)
	)
)

(instance rogCan of MyActor
	(properties
		x 224
		y 134
		noun 11
		view 604
		priority 15
		signal 24592
		cycleSpeed 4
		moveSpeed 3
	)
)

(instance comm of MyProp
	(properties
		x 224
		y 125
		noun 7
		onMeCheck 512
		view 606
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(cond
					((not (gCurRoom script:))
						(gCurRoom setScript: sShowComm)
					)
					(
						(and
							(== (gCurRoom script:) sFrogJump4)
							(> (sFrogJump4 state:) 28)
							(sFrogJump4 dispose:)
							(gCurRoom setScript: sShowComm)
						))
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance commButton of MyProp
	(properties
		x 160
		y 121
		noun 8
		onMeCheck 16384
		view 608
		loop 3
		cel 3
		priority 1
		signal 16400
		cycleSpeed 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== 4 (self loop:))
					(gMessager say: 8 4 0 (Random 1 3) 0)
				else
					(gMessager say: 8 4 0 4 0) ; "The communicator has already been activated. Flo is awaiting your transmission with her usual (low) degree of enthusiasm."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance floTalker of Talker
	(properties
		x 164
		y 47
		view 608
		talkWidth 200
		textX 10
		textY -30
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 180 tailY: 73 xOffset: 5 isBottom: 0)
		(super init: floBust floEyes floMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance floBust of MyProp
	(properties
		view 608
	)
)

(instance floEyes of MyProp
	(properties
		nsTop 14
		nsLeft 2
		view 608
		loop 2
	)
)

(instance floMouth of MyProp
	(properties
		nsTop 20
		nsLeft 2
		view 608
		loop 1
	)
)

(instance rogTalker of Narrator
	(properties
		talkWidth 150
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 104 tailY: 107 xOffset: -5 isBottom: 0)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance mwog of MyProp
	(properties
		noun 12
		view 605
		priority 15
		signal 16
	)
)

(instance pond1 of MyFeature
	(properties
		x 180
		y 120
		noun 14
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(proc31_2 (- gMouseY 30))
				(gEgo
					setMotion: VelocityMover gMouseX (- gMouseY 30) self 0
				)
				(= local10 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pond2 of MyFeature
	(properties
		x 180
		y 120
		noun 14
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(proc31_2 (- gMouseY 30))
				(gEgo
					setMotion: VelocityMover gMouseX (- gMouseY 30) self 0
				)
				(= local10 2)
				(= local10 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pond3 of MyFeature
	(properties
		x 180
		y 120
		noun 14
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(proc31_2 (- gMouseY 30))
				(gEgo
					setMotion: VelocityMover gMouseX (- gMouseY 30) self 0
				)
				(= local10 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pond4 of MyFeature
	(properties
		x 180
		y 120
		noun 14
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(proc31_2 (- gMouseY 30))
				(gEgo
					setMotion: VelocityMover gMouseX (- gMouseY 30) self 0
				)
				(= local10 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance outside of MyFeature
	(properties
		x 180
		y 130
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(sShowComm dispose:)
			)
			(4 ; Do
				(sShowComm dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flower1 of MyProp
	(properties
		x 70
		y 180
		noun 3
		view 607
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(if (and (IsFlag 22) (not (gCurRoom script:)))
			(switch theVerb
				(3 ; Walk
					(proc31_2 gMouseY)
					(gCurRoom setScript: sFlyTrap 0 flower1)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance flower2 of MyProp
	(properties
		x 152
		y 158
		noun 4
		view 607
		loop 1
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(if (and (IsFlag 22) (not (gCurRoom script:)))
			(switch theVerb
				(3 ; Walk
					(proc31_2 gMouseY)
					(gCurRoom setScript: sFlyTrap 0 flower2)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance flower3 of MyProp
	(properties
		x 205
		y 174
		noun 5
		view 607
		loop 2
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(if (and (IsFlag 22) (not (gCurRoom script:)))
			(switch theVerb
				(3 ; Walk
					(proc31_2 gMouseY)
					(gCurRoom setScript: sFlyTrap 0 flower3)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance floOverlay of MyProp
	(properties
		x 167
		y 353
		z 300
		noun 10
		onMeCheck 8192
		view 608
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(sShowComm cue:)
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
		y 189
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (IsFlag 22)
					(proc31_2 gMouseY)
					(gCurRoom setScript: sFlyLeave740)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bridgeR of MyFeature
	(properties
		x 60
		y 116
		noun 2
		onMeCheck 4098
	)
)

(instance domeF of MyFeature
	(properties
		x 94
		y 20
		noun 9
		onMeCheck 8
	)
)

(instance palmTree of MyFeature
	(properties
		x 300
		y 95
		noun 16
		onMeCheck 2048
	)
)

(instance plants of MyFeature
	(properties
		x 186
		y 85
		noun 13
		onMeCheck 8192
	)
)

(instance hello of View
	(properties
		x 220
		y 102
		view 606
		loop 3
		priority 15
		signal 16400
	)
)

(instance sUseComm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 14 loop: 0 cel: 0 setCycle: End self)
				(theMusic3 number: 603 setLoop: 1 play:)
			)
			(1
				(gMessager say: 4 32 4 0 self 701) ; "Wilco to Eureka, come in Eureka."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo 0)
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance comScreen of MyFeature
	(properties
		x 270
		y 310
		z 300
		noun 17
		onMeCheck 8192
	)
)

