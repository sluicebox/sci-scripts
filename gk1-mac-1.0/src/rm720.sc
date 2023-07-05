;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use n013)
(use sHRoom8)
(use Talker)
(use Scaler)
(use ROsc)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm720 0
)

(local
	local0
	local1
	local2 = 1
	local3
	local4
	local5
	local6
)

(instance rm720 of Room
	(properties
		noun 1
		picture 720
		style 14
		exitStyle 13
	)

	(method (init)
		(if (or (IsFlag 435) (not (== gPrevRoomNum 50))) ; interrogation
			(Load rsPIC 720)
			(Load rsVIEW 720)
			(Load rsVIEW 721)
		else
			(self picture: 730)
			(Load rsPIC 730)
		)
		(if (!= gPrevRoomNum 50) ; interrogation
			(gGkMusic1
				setLoop: -1
				number: 720
				play:
				setVol: 0
				fade: (gGkMusic1 musicVolume:) 25 10 0
			)
		)
		(super init:)
		(= local4 0)
		(gEgo
			normalize: (if (== gPrevRoomNum 50) 7 else 4) 901 ; interrogation
			state: 2
			init:
			setScaler: Scaler 100 84 137 121
		)
		(gEgo scaleSignal: (| $0004 (gEgo scaleSignal:)))
		(gEgo ignoreActors: 1)
		(= local5 gNarrator)
		(= gNarrator snakeNarrator)
		(if (== gPrevRoomNum 50) ; interrogation
			(gEgo
				posn:
					(if (or (IsFlag 435) (not (== gPrevRoomNum 50))) 290 else 30) ; interrogation
					128
			)
			(wolfgang
				view: 7322
				loop: 0
				cel: 0
				x: (if (or (IsFlag 435) (not (== gPrevRoomNum 50))) 290 else 30) ; interrogation
				y: 113
				approachX:
					(if (or (IsFlag 435) (not (== gPrevRoomNum 50))) 285 else 35) ; interrogation
				approachY: 125
				init:
			)
			(if (not (IsFlag 436))
				(wolfgang posn: 189 113 approachX: 194)
				(gEgo posn: 194 (gEgo y:))
			)
		else
			(gEgo posn: 107 127)
			(wolfgang init:)
		)
		(torchLeft init: setCycle: Fwd)
		(torchRight init: setCycle: Fwd)
		(if (or (IsFlag 435) (not (== gPrevRoomNum 50))) ; interrogation
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 23 145 319 145 319 114 188 114 134 124 103 115 92 116 94 123
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 200 127 255 126 273 135 231 142 192 139
						yourself:
					)
			)
			(wayout init:)
			(gWalkHandler add: wayout)
			(deadGuy init:)
			(vines init:)
			(muralMask init:)
			(muralSnake init:)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 285 145 246 129 186 121 125 114 0 114 0 145
						yourself:
					)
			)
			(torchLeft loop: 1 x: (- 320 (torchLeft x:)))
			(torchRight loop: 3 x: (- 319 (torchRight x:)))
			(self
				addObstacle:
					(if (IsFlag 425)
						((Polygon new:)
							type: PBarredAccess
							init: 92 123 193 124 198 140 161 143 122 143 94 139
							yourself:
						)
					else
						(= local4
							((Polygon new:)
								type: PBarredAccess
								init: 107 119 180 123 183 137 161 141 122 141 108 136
								yourself:
							)
						)
					)
			)
			(vines init:)
			(muralMask init: 1)
			(muralSnake init: 1)
			(otherSnake init:)
			(otherMask init:)
			(vineView1 init:)
			(vineView2 init:)
			(tableTop init:)
			(altar init:)
			(rack init:)
			(bar init:)
			(bar2 init:)
		)
		(if (== gPrevRoomNum 50) ; interrogation
			(ClearFlag 435)
		else
			(self setScript: gabeAndWolfEnter)
		)
	)

	(method (doit)
		(if (not local0)
			(cond
				((== picture 720)
					(if (> (gEgo x:) 315)
						(= local0 1)
						(gCurRoom setScript: goEast)
					)
				)
				((< (gEgo x:) 5)
					(= local0 1)
					(gCurRoom setScript: goWest)
				)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(if (!= 50 gNewRoomNum) ; interrogation
			(gGkMusic1 fade:)
		)
		(= gNarrator local5)
		(= local5 0)
		(gWalkHandler release:)
		(gEgo setScale: 0 scaleSignal: 0)
		(UnLoad 129 720)
		(UnLoad 128 720)
		(UnLoad 128 7322)
		(DisposeScript 64969)
		(if (gTalkers size:)
			(gMessager cue: 1)
		)
		(if (GK keepBar:)
			(gTheIconBar draw:)
		)
		(super dispose:)
	)
)

(instance gabeAndWolfEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= gNarrator local5)
				(= seconds 2)
			)
			(1
				(gEgo setMotion: MoveTo 159 136 self)
				(wolfgang setCycle: End self)
			)
			(2 1)
			(3
				(gMessager say: 13 0 1 1 self) ; "(SCENE:GABE AND WOLFY ENTER A SECRET ROOM OF THE SNAKE MOUND. AWED.)Wow! The inner wheel!"
			)
			(4
				(wolfgang loop: 1 cel: 0 setCycle: End self)
				(gMessager say: 13 0 1 2 self) ; "(GASPING. HAVING CHEST PAINS.)Yes. Wheel-within-a-wheel."
			)
			(5 1)
			(6
				(Face gEgo wolfgang self)
			)
			(7
				(gMessager sayRange: 13 0 1 3 5 self) ; "(CONCERNED)Are you okay? You don't look so hot."
			)
			(8
				(wolfgang loop: 2 cel: 0 setCycle: End self)
			)
			(9
				(wolfgang
					view: 720
					loop: 0
					cel: 0
					posn: 133 120
					setCycle: Walk
					setMotion: MoveTo 189 113 self
				)
			)
			(10
				(Face gEgo wolfgang self)
				(wolfgang view: 7322 loop: 0 cel: 0 setCycle: 0)
				(= gNarrator snakeNarrator)
				(gMessager say: 13 0 1 6 self) ; "Yes. I must congratulate you on the 'three snakes' connection. I had missed it. You will make a wonderful Schattenj\84ger."
			)
			(11
				(UnLoad 128 721)
			)
			(12
				(gMessager sayRange: 13 0 1 7 9 self) ; "Who, me?"
			)
			(13
				(gGame handsOn:)
				(SetFlag 427)
				(self dispose:)
			)
		)
	)
)

(instance goEast of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(for ((= temp0 100)) (> temp0 0) ((-= temp0 2))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(gEgo posn: 5 130)
				(if (gEgo scaler:)
					((gEgo scaler:) doit:)
				)
				(torchLeft loop: 1 x: (- 320 (torchLeft x:)))
				(torchRight loop: 3 x: (- 319 (torchRight x:)))
				(UpdateScreenItem gEgo)
				(UpdateScreenItem torchLeft)
				(UpdateScreenItem torchRight)
				((gCurRoom obstacles:) eachElementDo: #dispose release:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 285 145 246 129 186 121 125 114 0 114 0 145
							yourself:
						)
						(if (IsFlag 425)
							((Polygon new:)
								type: PBarredAccess
								init: 92 123 193 124 198 140 161 143 122 143 94 139
								yourself:
							)
						else
							(= local4
								((Polygon new:)
									type: PBarredAccess
									init: 107 119 180 123 183 137 161 141 122 141 108 136
									yourself:
								)
							)
						)
				)
				(gCurRoom drawPic: 730 0)
				(gCurRoom picture: 730)
				(if (gGame keepBar:)
					(gTheIconBar draw:)
				)
				(wayout dispose:)
				(gWalkHandler delete: wayout)
				(deadGuy dispose:)
				(vines dispose: init:)
				(muralMask dispose: init: 1)
				(muralSnake dispose: init: 1)
				(otherSnake init:)
				(otherMask init:)
				(vineView1 init:)
				(vineView2 init:)
				(tableTop init:)
				(altar init:)
				(rack init:)
				(bar init:)
				(bar2 init:)
				(if local2
					(self setScript: wolfChangesSides self 0)
				else
					(wolfgang show:)
					(for ((= temp0 0)) (< temp0 100) ((+= temp0 2))
						(Palette 2 0 256 temp0) ; PalIntensity
						(FrameOut)
					)
					(= cycles 1)
				)
			)
			(1
				(gGame handsOn:)
				(= local0 0)
				(ClearFlag 427)
				(SetFlag 436)
				(self dispose:)
			)
		)
	)
)

(instance goWest of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(for ((= temp0 100)) (> temp0 0) ((-= temp0 2))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(gEgo posn: 315 130)
				(if (gEgo scaler:)
					((gEgo scaler:) doit:)
				)
				((gCurRoom obstacles:) eachElementDo: #dispose release:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 23 145 319 145 319 114 188 114 134 124 103 115 92 116 94 123
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 200 127 255 126 273 135 231 142 192 139
							yourself:
						)
				)
				(torchLeft loop: 0 x: (- 320 (torchLeft x:)))
				(torchRight loop: 2 x: (- 319 (torchRight x:)))
				(UpdateScreenItem gEgo)
				(UpdateScreenItem torchLeft)
				(UpdateScreenItem torchRight)
				(gCurRoom drawPic: 720 0)
				(gCurRoom picture: 720)
				(if (gGame keepBar:)
					(gTheIconBar draw:)
				)
				(wayout init:)
				(gWalkHandler add: wayout)
				(deadGuy init:)
				(vines dispose: init:)
				(muralMask dispose: init: 1)
				(muralSnake dispose: init: 1)
				(otherSnake dispose:)
				(otherMask dispose:)
				(vineView1 dispose:)
				(vineView2 dispose:)
				(tableTop dispose:)
				(altar dispose:)
				(rack dispose:)
				(bar dispose:)
				(bar2 dispose:)
				(if local2
					(self setScript: wolfChangesSides self 1)
				else
					(wolfgang hide:)
					(for ((= temp0 0)) (< temp0 100) ((+= temp0 2))
						(Palette 2 0 256 temp0) ; PalIntensity
						(FrameOut)
					)
					(= cycles 1)
				)
			)
			(1
				(gGame handsOn:)
				(= local0 0)
				(SetFlag 427)
				(self dispose:)
			)
		)
	)
)

(instance wolfChangesSides of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(wolfgang hide:)
				(for ((= temp0 0)) (< temp0 100) ((+= temp0 2))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(1
				(wolfgang
					posn: (* 319 register) 113
					view: 720
					loop: register
					cel: 0
					show:
					setCycle: Walk
					setMotion: MoveTo (if register 290 else 30) 113 self
				)
			)
			(2
				(wolfgang view: 7322 loop: 0 cel: 0 setCycle: 0)
				(wolfgang approachX: (if register 285 else 35))
				(self dispose:)
			)
		)
	)
)

(instance moveBarToTable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (IsFlag 425))
				(if register
					(gEgo setScale: 0)
					(gEgo view: 731 loop: 1 cel: 0 setCycle: End self)
					(gMessager say: 7 12 7 1 self) ; "Let's get the other one."
				else
					(gMessager say: 7 12 12 1 self) ; "(GABE DECIDES TO MOVE IRON BARS FROM WALL INTO TABLE TOP)What about these iron bars?"
					(= cycles 1)
				)
			)
			(1
				(if register
					(+= state 2)
				)
			)
			(2
				(gEgo setScale: 0)
				(gEgo view: 731 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 7 12 12 2 self) ; "Good idea! Let me help you."
			)
			(4
				(= gNarrator local5)
				(self setScript: moveWolfgang self 1)
			)
			(5
				(wolfgang hide:)
				((if register bar2 else bar) dispose:)
				(gGkSound1 setLoop: 1 number: 728 play:)
				(gEgo
					view: 7311
					loop: 0
					cel: 0
					posn: (if register 149 else 136) 123
					setCycle: End self
				)
			)
			(6
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(7
				(gEgo
					view: 7312
					loop: 0
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 95 (if register 136 else 132) self
				)
			)
			(8
				(gEgo setCycle: 0)
				(if register
					(= cycles 1)
				else
					(gMessager say: 7 12 12 3 self) ; "(THOUGHTFUL)Perhaps these holes...."
				)
			)
			(9
				(gGkSound1 setLoop: 1 number: 725 play:)
				(if register
					(gEgo setPri: 138)
				)
				(gEgo view: 7323 loop: 0 cel: 0 setCycle: End self)
			)
			(10
				(if register
					(SetFlag 426)
				else
					(SetFlag 425)
				)
				((if register bar2 else bar) init:)
				(gMessager say: 7 12 12 4 self) ; "(THE BARS FIT. PLEASED)There!"
			)
			(11
				(gEgo setPri: -1 posn: 79 135 normalize: 4 901)
				(gEgo ignoreActors: 1)
				(gEgo setScaler: Scaler 100 84 137 121)
				(self setScript: moveWolfgang self 0)
			)
			(12
				(if local4
					((gCurRoom obstacles:)
						delete: local4
						add:
							((Polygon new:)
								type: PBarredAccess
								init: 92 123 193 124 198 140 161 143 122 143 94 139
								yourself:
							)
					)
					(local4 dispose:)
					(= local4 0)
				)
				(gEgo getPoints: -999 1)
				(= gNarrator snakeNarrator)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance struggleToRaiseTable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 432)
				(gGame handsOff:)
				(if (IsFlag 426)
					(gMessager say: 7 8 9 1 self) ; "(SCENE: GABE AND WOLFY ARE TRYING TO OPEN A SACRED TABLE IN THE SNAKE MOUND. CONFIDENT.)Let's try to lift this top...."
				else
					(gMessager say: 11 12 5 1 self) ; "(ABOUT TO TRY TO LIFT STONE LID OFF SACRIFICIAL TABLE)Shall we try this lid?"
				)
			)
			(1
				(= gNarrator local5)
				(self setScript: moveWolfgang self 1)
				(if (IsFlag 426)
					(= cycles 1)
				else
					(gMessager say: 11 12 5 2 self) ; "(WOLFY KNOWS THIS WON'T WORK)I suppose it wouldn't hurt."
				)
			)
			(2 1)
			(3
				(wolfgang hide:)
				(gEgo setScale: 0)
				(if (IsFlag 426)
					(bar2 hide:)
				)
				(gEgo
					view: (if (IsFlag 426) 735 else 7350)
					loop: 0
					cel: 0
					posn: 143 138
					setPri: 138
					setCycle: End self
				)
			)
			(4
				(gEgo setPri: -1)
				(if (IsFlag 426)
					(wolfgang
						view: 7352
						loop: 1
						cel: 0
						x: 178
						y: 135
						setPri: 138
						show:
					)
					(UpdateScreenItem wolfgang)
					(bar2 show:)
					(gGkSound1 setLoop: 1 number: 729 play:)
					(gEgo
						view: 7351
						loop: 0
						cel: 0
						posn: 108 137
						setCycle: End self
					)
				else
					(gEgo normalize: 0 901 posn: 106 136)
					(gEgo ignoreActors: 1)
					(gEgo setScaler: Scaler 100 84 137 121)
					(wolfgang
						show:
						view: 7351
						loop: 1
						cel: 0
						setCycle: End self
					)
				)
			)
			(5
				(if (IsFlag 426)
					(gMessager say: 7 8 9 2 self) ; "(THEY CAN'T OPEN IT. GABE IS FRUSTRATION--HE'S SPEAKING OF THE TALISMAN)I know it's in there!"
				else
					(gMessager say: 11 12 5 3 self) ; "(AFTER TRYING TO LIFT LID. IN PAIN)Sorry I'm not...<wheeze> more help, Gabriel. I don't think it would open so easily, though, were we ten strong men."
				)
			)
			(6
				(if (IsFlag 426)
					(gGkSound1 setLoop: 1 number: 729 play:)
					(gEgo cel: 0 setCycle: End self)
				else
					(self setScript: moveWolfgang self 0)
				)
			)
			(7
				(if (IsFlag 426)
					(gEgo view: 7352 loop: 0 cel: 0)
					(= register 2)
					(= cycles 1)
				else
					(gGame handsOn:)
					(= gNarrator snakeNarrator)
					(self dispose:)
				)
			)
			(8
				(if (< (++ register) 15)
					(-- state)
				)
				(if (mod register 2)
					(gEgo setCycle: 0)
					(if (== register 5)
						(gEgo normalize: 0 901)
						(gEgo ignoreActors: 1)
					)
					(wolfgang setCycle: Fwd)
				else
					(if (== register 4)
						(gEgo setCycle: Fwd)
					)
					(wolfgang setCycle: 0 cel: 0)
					(UpdateScreenItem wolfgang)
				)
				(gMessager say: 7 8 9 register self)
			)
			(9
				(gEgo normalize: 0 901 setScaler: Scaler 100 84 137 121)
				(gEgo ignoreActors: 1)
				(wolfgang setCycle: 0 cel: 0 approachX: 150 approachY: 143)
				(= cycles 3)
			)
			(10
				(gEgo setMotion: MoveTo 85 137 self)
			)
			(11
				(= local1 1)
				(= local2 0)
				(gGame handsOn:)
				(= gNarrator snakeNarrator)
				(self dispose:)
			)
		)
	)
)

(instance moveWolfgang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(switch caller
						(heyLookACoolAltar
							(wolfgang
								view: 720
								loop: 2
								cel: 0
								setCycle: Fwd
								setMotion: MoveTo 30 133 self
							)
						)
						(moveBarToTable
							(wolfgang
								view: 720
								loop: 0
								cel: 0
								setCycle: Fwd
								setMotion: MoveTo 98 133 self
							)
						)
						(struggleToRaiseTable
							(wolfgang
								view: 720
								loop: 2
								cel: 0
								setCycle: Fwd
								setMotion: MoveTo 45 145 self
							)
						)
					)
				else
					(switch caller
						(heyLookACoolAltar
							(wolfgang
								view: 720
								loop: 1
								cel: 0
								posn: 108 140
								setCycle: Fwd
								setMotion: MoveTo 30 133 self
							)
						)
						(moveBarToTable
							(wolfgang
								view: 720
								loop: 3
								cel: 0
								posn: 98 (if (IsFlag 425) 134 else 130)
								show:
								setCycle: Fwd
								setMotion: MoveTo 92 118 self
							)
						)
						(struggleToRaiseTable
							(wolfgang
								view: 720
								loop: 1
								cel: 0
								posn: 183 140
								show:
								setCycle: Fwd
								setMotion: MoveTo 98 148 self
							)
						)
					)
				)
			)
			(1
				(if register
					(switch caller
						(heyLookACoolAltar
							(wolfgang
								view: 720
								loop: 0
								cel: 0
								setCycle: Fwd
								setMotion: MoveTo 108 140 self
							)
						)
						(moveBarToTable
							(wolfgang
								view: 720
								loop: 3
								cel: 0
								setCycle: Fwd
								setMotion:
									MoveTo
									(if (IsFlag 425) 170 else 158)
									121
									self
							)
						)
						(struggleToRaiseTable
							(wolfgang
								view: 720
								loop: 0
								cel: 0
								setCycle: Fwd
								setMotion: MoveTo 183 140 self
							)
						)
					)
				else
					(switch caller
						(heyLookACoolAltar
							(wolfgang
								view: 720
								loop: 3
								cel: 0
								setCycle: Fwd
								setMotion: MoveTo 30 113 self
							)
						)
						(moveBarToTable
							(wolfgang
								view: 720
								loop: 1
								cel: 0
								setCycle: Fwd
								setMotion: MoveTo 30 113 self
							)
						)
						(struggleToRaiseTable
							(wolfgang
								view: 720
								loop: 1
								cel: 0
								setCycle: Fwd
								setMotion: MoveTo 30 113 self
							)
						)
					)
				)
			)
			(2
				(wolfgang setCycle: 0)
				(wolfgang view: 7322 loop: 0 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance heyLookACoolAltar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 428)
					(+= state 11)
					(gMessager say: 6 7 16 0 self) ; "What was the story on this table again?"
				else
					(gEgo getPoints: -999 1)
					(gMessager say: 6 7 2 1 self) ; "(LOOKING AT SACRIFICIAL TABLE IN SNAKE MOUND. IMPRESSED.)<whistle> Look at that table!"
				)
			)
			(1
				(= gNarrator local5)
				(self setScript: moveWolfgang self 1)
			)
			(2
				(wolfgang
					view: 730
					loop: 0
					cel: 0
					posn: 140 141
					ignoreActors:
					setCycle: End self
				)
				(gMessager sayRange: 6 7 2 2 3 self) ; "Yes! It is very old. There is a story being told through the carvings on the side."
			)
			(3 1)
			(4
				(gEgo normalize: 1 901)
				(gEgo ignoreActors: 1)
				(wolfgang loop: 1 cel: 0 setCycle: End self)
				(gMessager say: 15 0 17 1 self) ; "(READING TABLE ART)A tribesman discovers the snake mound hidden in the jungle...."
			)
			(5 1)
			(6
				(wolfgang
					view: 7300
					loop: 0
					cel: 0
					setPri: 120
					setCycle: End self
				)
				(gMessager say: 15 0 17 2 self) ; "(READING TABLE ART)He manages, after much time, to find the secret entrance to the inner wheel...."
			)
			(7 1)
			(8
				(wolfgang loop: 1 cel: 0 setCycle: End self)
				(gMessager say: 15 0 17 3 self) ; "(READING TABLE ART)In this room, he bows down to a small idol of some sort. The thing is radiating, like a sun."
			)
			(9 1)
			(10
				(gMessager sayRange: 6 7 2 5 6 self) ; "That explains the source of the Gedde's tribal power--they found this mound and the idol in it. Where the idol came from originally is hard to say, but it is definitely older than the Geddes."
			)
			(11
				(wolfgang ignoreActors: 0 setPri: -1)
				(self setScript: moveWolfgang self 0)
			)
			(12
				(gGame handsOn:)
				(= gNarrator snakeNarrator)
				(SetFlag 428)
				(self dispose:)
			)
		)
	)
)

(instance askWolf of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo wolfgang self)
			)
			(1
				(gMessager say: 10 10 15 0 self) ; "(TO WOLFGANG. SERIOUS)Can we talk?"
			)
			(2
				(= global178 46)
				(if (== (gCurRoom picture:) 720)
					(SetFlag 435)
					(gWalkHandler delete: wayout)
				)
				(gCurRoom newRoom: 50) ; interrogation
			)
		)
	)
)

(instance abortCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gEgo get: 69) ; talisman
				(gEgo getPoints: -999 10)
				(Platform 0 2 0)
				(gCurRoom newRoom: 216)
			)
		)
	)
)

(instance cutToTheHeart of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE))
			(Palette 2 0 256 100) ; PalIntensity
			(cond
				((SkipSceneDialog)
					(if (gTalkers size:)
						(gMessager cue: 1)
					)
					(gKeyDownHandler delete: self)
					(if (gEgo cycler:)
						(gEgo setCycle: 0)
					)
					(gCurRoom setScript: abortCartoon)
					(return 1)
				)
				((not (gNarrator dialog:))
					(Platform 0 2 0)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKeyDownHandler add: self)
				(gEgo normalize: 1 901)
				(gEgo ignoreActors: 1)
				(= seconds 1)
			)
			(1
				(gMessager say: 12 101 14 1 self) ; "(SCENE:GABE CUTS OUT HEART FROM DEAD BODY INSIDE SNAKE MOUND. SARCASTIC, GROSSED OUT)Great! My first job as Schattenj\84ger--cutting up dead monsters!"
			)
			(2
				(gEgo view: 722 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(for ((= temp0 100)) (> temp0 0) ((-= temp0 2))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(torchLeft dispose:)
				(torchRight dispose:)
				(gCurRoom drawPic: 630 0)
				(if (gGame keepBar:)
					(gTheIconBar draw:)
				)
				(gWalkHandler delete: wayout)
				(wayout dispose:)
				(deadGuy dispose:)
				((gCurRoom obstacles:) eachElementDo: #dispose release:)
				(vines dispose:)
				(muralMask dispose:)
				(muralSnake dispose:)
				(wolfgang hide:)
				(gEgo hide:)
				(gGkMusic1 fade:)
				(for ((= temp0 0)) (< temp0 100) ((+= temp0 2))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(5
				(Load rsVIEW 630)
				(Load rsVIEW 631)
				(Load rsVIEW 632)
				(= seconds 1)
			)
			(6
				(gGkMusic1 setLoop: -1 number: 101 play:)
				(= seconds 2)
			)
			(7
				(gGkSound1 setLoop: 1 number: 731 play:)
				(gabeWhatsThat init: setCycle: End self)
			)
			(8
				(grabHeart init:)
				(gMessager say: 12 101 14 2 self) ; "(WOLFGANG CUTS OUT HIS OWN HEART. PAIN.)Ummph!"
				(= seconds 3)
			)
			(9 0)
			(10
				(gGkSound1 setLoop: 1 number: 732 play:)
				(ohMyGod init:)
				(= seconds 2)
			)
			(11
				(gabeYouWimp init:)
				(= seconds 2)
			)
			(12
				(gGkSound1 setLoop: 1 number: 733 play:)
				(aaaaarghh init:)
				(= seconds 4)
			)
			(13
				(gGkMusic1 fade:)
				(for ((= temp0 100)) (> temp0 0) ((-= temp0 2))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(gCurRoom drawPic: 720 0)
				(if (gGame keepBar:)
					(gTheIconBar draw:)
				)
				(grabHeart dispose:)
				(ohMyGod dispose:)
				(aaaaarghh dispose:)
				(gabeWhatsThat dispose:)
				(gabeYouWimp dispose:)
				(torchLeft init:)
				(torchRight init:)
				(wayout init:)
				(deadGuy init:)
				(gEgo show:)
				(for ((= temp0 0)) (< temp0 100) ((+= temp0 2))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(14
				(gGkMusic1
					setLoop: -1
					number: 720
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 25 10 0
				)
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(15
				(gMessager say: 12 101 14 3 self) ; "(GABE TURNS AND SEES WOLFGANG KILLING HIMSELF)WOLFGANG! NO!!!"
			)
			(16
				(= register (gEgo cycleSpeed:))
				(gEgo loop: 4 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(17
				(for ((= temp0 100)) (> temp0 0) ((-= temp0 2))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(gEgo
					view: 7331
					loop: 0
					cel: 0
					posn: 17 138
					cycleSpeed: register
				)
				(torchLeft loop: 1 x: (- 320 (torchLeft x:)))
				(torchRight loop: 3 x: (- 319 (torchRight x:)))
				(gCurRoom drawPic: 730 0)
				(if (gGame keepBar:)
					(gTheIconBar draw:)
				)
				(wayout dispose:)
				(deadGuy dispose:)
				(vineView1 init:)
				(vineView2 init:)
				(altar init:)
				(rack init:)
				(bar init:)
				(bar2 init:)
				(wolfgang
					view: 733
					loop: 0
					cel: 0
					posn: 104 124
					show:
					setScale: 0
				)
				(heart init:)
				(UpdateScreenItem torchLeft)
				(UpdateScreenItem torchRight)
				(= cycles 1)
			)
			(18
				(UpdateScreenItem heart)
				(for ((= temp0 0)) (< temp0 100) ((+= temp0 2))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(gMessager say: 12 101 14 4 self) ; "(GABE RUNS OVER TO WOLFGANG'S BODY)NO!"
				(gEgo setCycle: End self)
				(heart setCycle: End self)
			)
			(19 1)
			(20 1)
			(21
				(for ((= temp0 100)) (> temp0 0) ((-= temp0 2))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(gEgo hide:)
				(heart dispose:)
				(vineView1 dispose:)
				(vineView2 dispose:)
				(torchLeft dispose:)
				(torchRight dispose:)
				(altar dispose:)
				(rack dispose:)
				(bar dispose:)
				(bar2 dispose:)
				(wolfgang dispose:)
				(gCurRoom drawPic: 635 0)
				(if (gGame keepBar:)
					(gTheIconBar draw:)
				)
				(for ((= temp0 0)) (< temp0 100) ((+= temp0 2))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(22
				(= cycles 10)
			)
			(23
				(stillBeating init: setCycle: End self)
			)
			(24
				(look init:)
				(gGkSound1 setLoop: 1 number: 734 play:)
				(= seconds 2)
			)
			(25
				(take init:)
				(= seconds 2)
			)
			(26
				(damnYouToHell init:)
				(gMessager say: 12 101 14 5 self) ; "(GABE GRABS TALISMAN FROM TABLE. FURIOUS, HALF-SOBBING)Tetelo, you're gonna pay for this, you bitch!"
				(gKeyDownHandler delete: self)
				(gEgo get: 69) ; talisman
			)
			(27
				(gEgo getPoints: -999 10)
				(gCurRoom newRoom: 216)
			)
		)
	)
)

(instance wolfgang of Actor
	(properties
		noun 10
		sightAngle 40
		approachX 194
		approachY 125
		x 112
		y 117
		view 721
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 10 31) ; Ask, crocMask
		(self setScaler: Scaler 100 84 137 121)
		(|= scaleSignal $0004)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Ask
				(if local1
					(gMessager say: 10 10 14 0) ; "(TO WOLFGANG. SERIOUS)Can we talk?"
				else
					(gCurRoom setScript: askWolf)
				)
			)
			(11 ; Talk
				(if local1
					(gMessager say: 10 11 14 0) ; "(TRYING TO WEASEL OUT OF SOMETHING UNPLEASANT)What if we try..."
				else
					(gMessager say: 10 11 18 0) ; "(TO WOLFGANG. CHATTING)It's nice to finally have someone around who knows what the hell's going on."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(self setScale: 0)
		(super dispose: &rest)
	)
)

(instance torchLeft of Prop
	(properties
		noun 8
		x 132
		y 73
		priority 32
		fixPriority 1
		view 723
	)
)

(instance torchRight of Prop
	(properties
		noun 8
		x 267
		y 70
		view 723
		loop 2
	)
)

(instance heart of Prop
	(properties
		x 137
		y 108
		view 733
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 160)
	)
)

(instance wayout of View
	(properties
		noun 9
		x 77
		y 35
		view 7201
	)
)

(instance vineView1 of View
	(properties
		noun 5
		x 45
		y 22
		priority 146
		fixPriority 1
		view 7301
	)
)

(instance vineView2 of View
	(properties
		noun 5
		x 174
		y 22
		priority 146
		fixPriority 1
		view 7301
		loop 2
	)
)

(instance altar of View
	(properties
		noun 6
		approachX 235
		approachY 142
		x 122
		y 103
		priority 137
		fixPriority 1
		view 7301
		loop 1
	)

	(method (init)
		(super init:)
		(self approachVerbs: 7) ; Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gCurRoom setScript: heyLookACoolAltar)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rack of View
	(properties
		x 132
		y 79
		view 7301
		loop 3
	)
)

(instance bar of View
	(properties
		noun 7
		approachX 129
		approachY 124
		x 137
		y 79
		view 7301
		loop 3
		cel 1
	)

	(method (init)
		(if (IsFlag 425)
			(self
				cel: 3
				x: 137
				y: 112
				approachX: 105
				approachY: 135
				fixPriority: 1
				priority: 134
			)
		)
		(super init:)
		(self approachVerbs: 9 12 8) ; Move, Pickup, Operate
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager
					say:
						7
						7
						(cond
							((IsFlag 426) 9)
							((IsFlag 425) 10)
							(else 25)
						)
						0
				)
			)
			(9 ; Move
				(if (IsFlag 424)
					(if (IsFlag 425)
						(gMessager say: 7 12 13 0) ; "The bar fits in the table top. Gabriel doesn't want to put it back in the rack until he figures out what purpose it serves with the table."
					else
						(gCurRoom setScript: moveBarToTable)
					)
				else
					(gMessager say: 7 9 22 0) ; "Gabriel isn't sure at the moment what he would do with those bars."
				)
			)
			(8 ; Operate
				(cond
					(local1
						(gMessager say: 7 8 14 0) ; "Those bars aren't going to do anything without some fleshy assistance."
					)
					((IsFlag 426)
						(gCurRoom setScript: struggleToRaiseTable)
					)
					(else
						(gMessager say: 7 8 (if (IsFlag 425) 10 else 11) 0)
					)
				)
			)
			(12 ; Pickup
				(if (IsFlag 424)
					(if (IsFlag 425)
						(gMessager say: 7 12 13 0) ; "The bar fits in the table top. Gabriel doesn't want to put it back in the rack until he figures out what purpose it serves with the table."
					else
						(gCurRoom setScript: moveBarToTable)
					)
				else
					(gMessager say: 7 12 22 0) ; "Gabriel isn't sure at the moment what he would do with those bars."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bar2 of View
	(properties
		noun 7
		approachX 141
		approachY 124
		x 149
		y 80
		view 7301
		loop 3
		cel 2
	)

	(method (init)
		(if (IsFlag 426)
			(self
				cel: 4
				x: 137
				y: 116
				approachX: 105
				approachY: 135
				fixPriority: 1
				priority: 139
			)
		)
		(super init:)
		(self approachVerbs: 9 12 8) ; Move, Pickup, Operate
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager
					say:
						7
						7
						(cond
							((IsFlag 426) 9)
							((IsFlag 425) 24)
							(else 25)
						)
						0
				)
			)
			(9 ; Move
				(if (IsFlag 424)
					(if (IsFlag 426)
						(gMessager say: 7 12 13 0) ; "The bar fits in the table top. Gabriel doesn't want to put it back in the rack until he figures out what purpose it serves with the table."
					else
						(gCurRoom setScript: moveBarToTable)
					)
				else
					(gMessager say: 7 9 22 0) ; "Gabriel isn't sure at the moment what he would do with those bars."
				)
			)
			(8 ; Operate
				(cond
					(local1
						(gMessager say: 7 8 14 0) ; "Those bars aren't going to do anything without some fleshy assistance."
					)
					((IsFlag 426)
						(gCurRoom setScript: struggleToRaiseTable)
					)
					(else
						(gMessager say: 7 8 11 0) ; "There doesn't seem to be a way to use the bar while it's on the wall."
					)
				)
			)
			(12 ; Pickup
				(if (IsFlag 424)
					(if (IsFlag 426)
						(gMessager say: 7 12 13 0) ; "The bar fits in the table top. Gabriel doesn't want to put it back in the rack until he figures out what purpose it serves with the table."
					else
						(gCurRoom setScript: moveBarToTable)
					)
				else
					(gMessager say: 7 12 22 0) ; "Gabriel isn't sure at the moment what he would do with those bars."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance deadGuy of View
	(properties
		noun 12
		approachX 276
		approachY 135
		x 206
		y 133
		view 722
		loop 2
	)

	(method (init)
		(super init:)
		(self approachVerbs: 101) ; knife
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(gMessager say: 12 6 (if local1 14 else 15) 0)
			)
			(101 ; knife
				(if local1
					(gCurRoom setScript: cutToTheHeart)
				else
					(gMessager say: 12 101 15 0) ; "Gabriel has no reason to do that at the moment."
				)
			)
			(7 ; Look
				(gMessager say: 12 7 0 0) ; "A mummy lies on the floor, apparently having fallen inanimate where it stood when the secret passageway door closed."
			)
			(11 ; Talk
				(gMessager say: 12 11 0 0) ; "The mummy is not going to say anything."
			)
			(8 ; Operate
				(gMessager say: 12 8 0 0) ; "(EXCITED)Gabriel has had enough of those creatures 'operating!'"
			)
			(10 ; Ask
				(gMessager say: 12 10 0 0) ; "The mummy is not going to say anything."
			)
			(9 ; Move
				(gMessager say: 12 9 0 0) ; "Doing that with the mummy won't help."
			)
			(else
				(gMessager say: 12 0 (if local1 14 else 15) 0)
			)
		)
	)
)

(instance gabeWhatsThat of Prop
	(properties
		x 5
		y 22
		view 631
		signal 16417
	)
)

(instance grabHeart of View
	(properties
		y 22
		view 630
	)
)

(instance gabeYouWimp of View
	(properties
		x 142
		y 89
		view 632
		cel 1
	)
)

(instance ohMyGod of View
	(properties
		x 43
		y 44
		view 630
		cel 1
	)
)

(instance aaaaarghh of View
	(properties
		x 164
		y 22
		view 630
		cel 2
	)
)

(instance look of View
	(properties
		x 116
		y 22
		view 635
	)
)

(instance take of View
	(properties
		x 102
		y 105
		view 635
		loop 1
	)
)

(instance stillBeating of Prop
	(properties
		x 50
		y 53
		view 636
		signal 16417
		cycleSpeed 12
	)
)

(instance damnYouToHell of View
	(properties
		x 211
		y 22
		view 635
		loop 2
	)
)

(instance vines of Feature
	(properties
		noun 5
		y 100
	)

	(method (init)
		(super init:)
		(if (== (gCurRoom picture:) 720)
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 98 21 94 35 64 85 78 144 40 143 34 105 31 23
						yourself:
					)
					((Polygon new:) type: PTotalAccess init: 25 21 17 88 3 21 yourself:)
					((Polygon new:) type: PTotalAccess init: 1 84 21 143 1 144 yourself:)
					((Polygon new:)
						type: PTotalAccess
						init: 147 118 144 37 149 22 174 32 199 21 281 22 298 44 319 41 309 73 294 108 291 58 279 40 231 58 229 36 208 47 161 41
						yourself:
					)
			)
		else
			(self
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 319 83 318 144 294 145
						yourself:
					)
					((Polygon new:)
						type: PTotalAccess
						init: 243 144 254 85 234 52 204 46 205 23 285 22 292 70 274 145
						yourself:
					)
					((Polygon new:)
						type: PTotalAccess
						init: 160 82 153 23 123 22 122 31 108 47 73 43 39 38 26 109 6 46 37 22 173 21 174 114
						yourself:
					)
			)
		)
	)
)

(instance muralMask of Feature
	(properties
		noun 3
		nsLeft 224
		nsTop 58
		nsRight 249
		nsBottom 77
		sightAngle 40
		approachX 240
		approachY 115
		approachDist 126
		x 236
		y 67
	)

	(method (init param1)
		(if (and argc param1)
			(= x (- 319 x))
			(= param1 nsLeft)
			(= nsLeft (- 319 nsRight))
			(= nsRight (- 319 param1))
			(= approachX (- 319 approachX))
		)
		(super init:)
	)
)

(instance muralSnake of Feature
	(properties
		noun 3
		nsLeft 216
		nsTop 79
		nsRight 253
		nsBottom 109
		sightAngle 40
		approachX 237
		approachY 115
		approachDist 80
		x 234
		y 94
	)

	(method (init param1)
		(if (and argc param1)
			(= x (- 319 x))
			(= param1 nsLeft)
			(= nsLeft (- 319 nsRight))
			(= nsRight (- 319 param1))
			(= approachX (- 319 approachX))
		)
		(super init:)
	)
)

(instance otherSnake of Feature
	(properties
		noun 3
		nsLeft 200
		nsTop 83
		nsRight 235
		nsBottom 118
		sightAngle 40
		approachX 201
		approachY 121
		approachDist 101
		x 217
		y 100
	)
)

(instance otherMask of Feature
	(properties
		noun 3
		nsLeft 209
		nsTop 53
		nsRight 232
		nsBottom 80
		sightAngle 40
		approachX 196
		approachY 123
		approachDist 154
		x 220
		y 66
	)
)

(instance tableTop of Feature
	(properties
		noun 11
		nsLeft 118
		nsTop 104
		nsRight 171
		nsBottom 118
		sightAngle 40
		approachX 105
		approachY 135
		x 145
		y 130
		z 10
	)

	(method (init)
		(super init:)
		(self approachVerbs: 9 6 12) ; Move, Open, Pickup
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: 11 7 (if (IsFlag 431) 4 else 3) 0)
				(SetFlag 431)
				(SetFlag 424)
			)
			(9 ; Move
				(if (IsFlag 432)
					(gMessager say: 11 12 6 0) ; "The lid won't open that way."
				else
					(gCurRoom setScript: struggleToRaiseTable)
				)
			)
			(6 ; Open
				(if (IsFlag 432)
					(gMessager say: 11 12 6 0) ; "The lid won't open that way."
				else
					(gCurRoom setScript: struggleToRaiseTable)
				)
			)
			(12 ; Pickup
				(if (IsFlag 432)
					(gMessager say: 11 12 6 0) ; "The lid won't open that way."
				else
					(gCurRoom setScript: struggleToRaiseTable)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance snakeNarrator of Narrator
	(properties
		x 0
		y 157
		talkWidth 314
		modeless 2
	)

	(method (init)
		(self fore: global220 back: global214 font: gUserFont)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0 temp1 temp2)
		(= fore
			(switch global180
				(1 54)
				(99 7)
				(46 11)
				(else global220)
			)
		)
		(= temp1 (+ 3 (/ (param1 size:) 10)))
		(switch global180
			(1
				(if
					(and
						(> (param1 size:) 10)
						(gCast contains: gEgo)
						(or (== (gEgo view:) 901) (== (gEgo view:) 900))
						(== (gEgo loop:) 8)
					)
					(if (or (== (gEgo cel:) 4) (== (gEgo cel:) 5))
						(= temp0 (+ (gEgo view:) 1000))
					else
						(if (== (gEgo view:) 900)
							(= temp0 (+ (gEgo view:) 1010 (gEgo cel:)))
						else
							(= temp0 (+ (gEgo view:) 1039 (gEgo cel:)))
						)
						(switch (Random 0 2)
							(0 1)
							(1
								(+= temp0 10)
							)
							(2
								(= temp0 (+ (gEgo view:) 1000))
							)
						)
					)
					(= local6 (gEgo cycleSpeed:))
					(= temp2 (gEgo cel:))
					(gEgo
						talking: 1
						oldView: (gEgo view:)
						oldLoop: (gEgo loop:)
						oldCel: (gEgo cel:)
						oldSig: (gEgo signal:)
						setCel: 0
						view: temp0
						setLoop: temp2
						cycleSpeed: 14
					)
					(if (or (< 1919 temp0 1930) (< 1949 temp0 1960))
						(gEgo setCycle: ForRepeat)
					else
						(gEgo setCycle: Fwd)
					)
				)
			)
			(46
				(if (== (wolfgang view:) 7322)
					(wolfgang loop: (Random 0 2) cel: 0 setCycle: ROsc temp1 0)
				else
					(wolfgang cel: 0 setCycle: Fwd)
				)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(switch global180
			(1
				(if (gEgo talking:)
					(gEgo
						view: (gEgo oldView:)
						setCel: 0
						setLoop: (gEgo oldLoop:)
						setCel: (gEgo oldCel:)
						signal: (gEgo oldSig:)
						cycleSpeed: local6
						setCycle: StopWalk -1
						talking: 0
					)
				)
			)
			(46
				(wolfgang cel: 0 setCycle: 0)
				(if (== (wolfgang view:) 7322)
					(wolfgang loop: 0)
				)
			)
		)
		(super dispose:)
	)
)

