;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use n079)
(use OccCyc)
(use LarryRoom)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm380 0
)

(local
	local0
	local1
	local2 = 20
)

(instance rm380 of LarryRoom
	(properties
		noun 1
		picture 380
		horizon 0
	)

	(method (init)
		(if (== global100 380)
			(SetFlag 204)
			(ClearFlag 88)
		)
		(gGlobalSound1 stop:)
		(gGlobalSound2 stop:)
		(if (and (IsFlag 204) (not (IsFlag 88)))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 117 113 197 115 200 133 167 134 156 136 126 134 119 121
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 0 139 210 139 200 104 218 98 213 93 197 82 174 82 170 90 135 87 96 105 75 106 68 103 45 118 20 126 0 127
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 112 108 198 108 202 126 196 136 120 136 109 126
						yourself:
					)
			)
		)
		(super init: &rest)
		(gEgo posn: 181 79 init: setSpeed: 6 normalize:)
		(bathDoor init: approachVerbs: 4) ; Do
		(if (and (IsFlag 88) (not (IsFlag 197)))
			(pearl init: approachVerbs: 5 setCycle: OccCyc self 1 50 150) ; Take
		)
		(cables init: stopUpd:)
		(if (and (IsFlag 204) (not (IsFlag 88)))
			(grease init: stopUpd:)
			(meter init: stopUpd:)
			(if (< (gGame detailLevel:) 1)
				(toasterHeat init: setCycle: Fwd)
			)
			(SetFlag 86)
			(self setScript: doChardonnay)
		else
			(gGlobalSound1 number: 380 play: setLoop: -1)
			(cabinetTop init:)
			(cabinet init:)
			(table init:)
			(tanningBed init:)
			(transformer init:)
			(cables init:)
			(remoteCover init: stopUpd:)
			(if (IsFlag 88)
				(gCurRoom case: 2)
				(cabinet case: 2)
				(table case: 2)
				(tanningBed case: 2)
				(transformer case: 2)
				(cables case: 2)
			)
			(self setScript: enterRoom)
		)
	)

	(method (cue)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (gCurRoom script:)
			((gCurRoom script:) setScript: forwardScript)
		else
			(self setScript: forwardScript)
		)
	)

	(method (doit &tmp [temp0 30])
		(super doit:)
		(if
			(and
				local0
				(OneOf (gEgo cel:) 0 2)
				(not (Print dialog:))
				(not (sfx handle:))
				(!= local2 (gEgo cel:))
			)
			(= local2 (gEgo cel:))
			(larryShockFx play:)
		)
	)

	(method (dispose)
		((ScriptID 1811 12) modeless: 0) ; Char
		((ScriptID 1800 1) modeless: 0) ; You
		((ScriptID 1817 28) modeless: 0) ; You
		((ScriptID 1820 31) modeless: 0) ; You
		((ScriptID 1822 5) modeless: 0) ; Female_Voice
		(ClearFlag 86)
		(super dispose:)
	)
)

(instance forwardScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp1 gTheCursor)
				(gGame setCursor: gNormalCursor)
				(SetCursor 230 83)
				(if
					(Print
						font: gUserFont
						addTitle: 0 8 0 2 380
						addText: 0 8 0 1 0 2 380 ; "Do you really want to Fast Forward and miss this "electric moment?""
						addButton: 0 13 8 0 1 0 (proc79_4 40 35 35 35 35) 380 ; "Oops"
						addButton: 1 12 8 0 1 155 (proc79_4 40 35 35 35 35) 380 ; "Yes"
						init:
					)
					(chardonnay setScript: 0)
					(chickInToaster setScript: 0)
					(gGlobalSound1 stop:)
					(SetFlag 88)
					(self cue:)
				else
					(gGame setCursor: temp1)
					((ScriptID 0 8) enable:) ; icon5
					(= global170 gCurRoom)
					(self dispose:)
				)
			)
			(1
				(SetPort 0)
				(SetPort 0 0 190 320 10 0)
				(gGame hideControls:)
				(if (not (IsFlag 196))
					(gGame changeScore: 10 196)
				)
				(if (not (gEgo has: 33)) ; sculpture
					(gEgo get: 33) ; sculpture
				)
				(= cycles 1)
			)
			(2
				(gCast eachElementDo: #hide)
				(DrawPic 98 6)
				(= cycles 1)
			)
			(3
				(ClearFlag 74)
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance doChardonnay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 172 94 self
				)
				((ScriptID 0 8) enable:) ; icon5
				(= global170 gCurRoom)
			)
			(1
				(bathDoor setCycle: Beg self)
			)
			(2
				(= cycles 2)
			)
			(3
				(sfx number: 33 play:)
				(= ticks 120)
			)
			(4
				(gEgo setMotion: MoveTo 146 106 self)
			)
			(5
				(= seconds 2)
			)
			(6
				(gMessager say: 0 0 1 1 self) ; "Well, I suppose I have plenty of time to explore this place."
			)
			(7
				(gEgo setHeading: 180 self)
			)
			(8
				(= ticks 90)
			)
			(9
				(gEgo setHeading: 125 self)
			)
			(10
				(= ticks 30)
			)
			(11
				(chardonnay init: setCycle: Walk)
				(= cycles 10)
			)
			(12
				(sfx number: 32 play:)
				(bathDoor setCycle: End self)
			)
			(13
				(gEgo setHeading: 45 self)
			)
			(14
				(gGlobalSound1
					number: 337
					play:
					setLoop: -1
					mute: 1 4
					mute: 1 5
					mute: 1 6
					mute: 1 7
					mute: 1 8
					mute: 1 9
				)
				(= cycles 2)
			)
			(15
				(chardonnay
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 182 94 self
				)
			)
			(16
				(if (gCast contains: toasterHeat)
					(toasterHeat stopUpd:)
				)
				((ScriptID 1811 12) modeless: 1) ; Char
				(= cycles 5)
			)
			(17
				(bathDoor setCycle: Beg self)
				(gMessager say: 0 0 1 2 self) ; "Here I am, Larry!"
			)
			(18
				(sfx number: 33 play:)
				(chardonnay setMotion: MoveTo 182 106 self)
			)
			(19)
			(20
				(if (gCast contains: toasterHeat)
					(toasterHeat startUpd:)
				)
				((ScriptID 1811 12) modeless: 0) ; Char
				(Face chardonnay gEgo self)
			)
			(21
				(chardonnay loop: 4 cel: 1)
				(= cycles 5)
			)
			(22
				(gEgo setHeading: 90)
				(gGlobalSound1 mute: 0 8)
				(= cycles 20)
			)
			(23
				(gMessager say: 0 0 1 3 self) ; "(INCREDULOUS) Hi, Char. That was fast!"
			)
			(24
				(gMessager say: 0 0 1 4 8 self) ; "I really rushed through my shower. I hope you don't mind; I'm still dripping wet and I didn't have time to put on any clothes."
				(gGame changeScore: 10 196)
				(gGlobalSound1 mute: 0 4 mute: 0 9)
			)
			(25
				(gEgo setPri: 8 setMotion: MoveTo 162 125 self)
			)
			(26
				(gEgo setHeading: 180)
				(= cycles 5)
			)
			(27
				(chardonnay setScript: sGreaseLarry)
				(= cycles 5)
			)
			(28
				(sfx number: 234 play:)
				(gEgo
					view: 382
					loop: 2
					setCel: 0
					posn: 162 106
					setSpeed: 6
					setCycle: End self
				)
				(UnLoad 128 900)
			)
			(29
				(SetFlag 74)
				(cables setPri: 11)
				(gEgo loop: 0 cel: 0 setSpeed: 8 setCycle: CT 2 1 self)
				(UnLoad 128 900)
				(UnLoad 128 903)
			)
			(30
				(gEgo setCycle: CT 6 1 self)
			)
			(31
				(sfx number: 814 play:)
				(gEgo setPri: 10 setCycle: End self)
			)
			(32
				(self dispose:)
			)
		)
	)
)

(instance sGreaseLarry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chardonnay setMotion: PolyPath 114 134 self)
			)
			(1
				(chardonnay loop: 4 cel: 2 posn: 114 134 stopUpd:)
				(if (gCast contains: toasterHeat)
					(toasterHeat stopUpd:)
				)
				(= cycles 20)
			)
			(2
				(gGlobalSound1 mute: 0 6 mute: 0 7)
				(gMessager say: 0 0 1 9 10 self) ; "Now lie flat on your back so I can have total access to your body!"
			)
			(3
				(if (gCast contains: toasterHeat)
					(toasterHeat startUpd:)
				)
				(gEgo loop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(gEgo view: 381 loop: 0 setCel: 0 setCycle: End self)
				(UnLoad 128 382)
			)
			(5
				(chardonnay
					view: 385
					loop: 0
					cel: 0
					posn: 114 134
					setPri: 10
					setSpeed: 6
					setCycle: CT 6 1 self
				)
				(grease hide:)
				(UnLoad 128 383)
			)
			(6
				(sfx number: 632 play:)
				(chardonnay setCycle: End self)
			)
			(7
				(grease show: stopUpd:)
				(chardonnay loop: 1 cel: 0 posn: 109 134 setCycle: End self)
			)
			(8
				(chardonnay loop: 2 cel: 0 posn: 114 134 setCycle: CT 6 1 self)
			)
			(9
				(sfx number: 632 play:)
				(chardonnay setCycle: CT 0 -1 self)
			)
			(10
				(sfx number: 632 play:)
				(chardonnay setCycle: CT 6 1 self)
			)
			(11
				(sfx number: 632 play:)
				(chardonnay setCycle: End self)
			)
			(12
				(chardonnay stopUpd:)
				(if (gCast contains: toasterHeat)
					(toasterHeat stopUpd:)
				)
				(= ticks 30)
			)
			(13
				(gGlobalSound1 mute: 0 5)
				(gMessager say: 0 0 1 11 self) ; "To begin, I'll just smear some randomly-selected appendages with some of this electro-conductive jelly!"
			)
			(14
				(= ticks 30)
			)
			(15
				(if (gCast contains: toasterHeat)
					(toasterHeat startUpd:)
				)
				(chardonnay startUpd: setCycle: End self)
			)
			(16
				(chardonnay
					view: 383
					loop: 4
					cel: 2
					posn: 113 134
					setCycle: Walk
					setMotion: PolyPath 147 138 self
				)
				(UnLoad 128 385)
			)
			(17
				(Face chardonnay 147 50)
				(= cycles 5)
			)
			(18
				(cables setPri: 10)
				(chardonnay
					view: 385
					loop: 3
					cel: 0
					posn: 149 138
					setSpeed: 9
					setCycle: End self
				)
				(UnLoad 128 383)
				(sfx setLoop: -1)
			)
			(19
				(chardonnay loop: 4 posn: 149 138 cel: 15 setCycle: Beg self)
				(sfx number: 632 play:)
			)
			(20
				(sfx stop:)
				(= ticks 30)
			)
			(21
				(chardonnay cel: 15 setCycle: Beg self)
				(sfx number: 632 play:)
			)
			(22
				(sfx stop: setLoop: 1)
				(= ticks 30)
			)
			(23
				(chardonnay loop: 3 cel: 3 setCycle: Beg self)
			)
			(24
				(= ticks 90)
			)
			(25
				(gCurRoom setScript: sHookUpLarry)
				(self dispose:)
			)
		)
	)
)

(instance sHookUpLarry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: toasterHeat)
					(toasterHeat stopUpd:)
				)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 0 1 12 self) ; "Next, I'll attach these little alligator clips to various parts of your body..."
			)
			(2
				(if (gCast contains: toasterHeat)
					(toasterHeat startUpd:)
				)
				(chardonnay
					view: 386
					loop: 0
					cel: 0
					posn: 151 138
					cycleSpeed: 8
					setCycle: CT 4 1 self
				)
				(UnLoad 128 385)
			)
			(3
				(cables hide: dispose:)
				(chardonnay setCycle: End self)
			)
			(4
				(chardonnay loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(5
				(sfx number: 383 play: self)
				(gMessager say: 0 0 1 13 self) ; "OW!"
			)
			(6
				(sfx number: 383 play:)
			)
			(7
				(chardonnay setCycle: CT 8 1 self)
			)
			(8
				(sfx number: 383 play: self)
				(gMessager say: 0 0 1 14 self) ; "OUCH!"
			)
			(9
				(sfx number: 383 play:)
			)
			(10
				(chardonnay setCycle: CT 11 1 self)
			)
			(11
				(sfx number: 383 play:)
				(gMessager say: 0 0 1 15 self) ; "YEOW!!"
			)
			(12
				(= ticks 60)
			)
			(13
				(chardonnay setCycle: End self)
			)
			(14
				(gEgo loop: 1 cel: 0 x: 156 y: 126)
				(= ticks 90)
			)
			(15
				(gMessager say: 0 0 1 16 18 self) ; "Char, you didn't tell me this was going to hurt. Besides, if I'm on the table and you're on the floor, how can this be any fun?"
			)
			(16
				(= ticks 90)
			)
			(17
				(chardonnay
					view: 387
					loop: 0
					cel: 0
					x: 150
					y: 136
					cycleSpeed: 12
					setCycle: End self
				)
				(UnLoad 128 386)
			)
			(18
				(gMessager say: 0 0 1 19 self) ; "Okay, now let me turn on the machine."
			)
			(19
				(chardonnay
					loop: 1
					cel: 0
					x: 150
					y: 136
					cycleSpeed: 8
					setCycle: End self
				)
				(sfx number: 330 play:)
			)
			(20
				(switch1 init: cel: 0 setCycle: CT 5 1 self)
			)
			(21
				(sfx number: 383 play:)
				(switch1 setCycle: End self)
			)
			(22
				(sfxMachine play: hold: 1)
				(if (gCast contains: toasterHeat)
					(toasterHeat dispose:)
				)
				((ScriptID 1811 12) modeless: 1) ; Char
				((ScriptID 1800 1) modeless: 1) ; You
				((ScriptID 1817 28) modeless: 1) ; You
				((ScriptID 1820 31) modeless: 1) ; You
				((ScriptID 1822 5) modeless: 1 x: 20 y: 30) ; Female_Voice
				(= ticks 180)
			)
			(23
				(gMessager say: 0 0 1 20 self) ; "I'm ready to crank up the voltage a little. Tell me when you start to feel it."
			)
			(24
				(= next sStartTheMachine)
				(self dispose:)
			)
		)
	)
)

(instance sStartTheMachine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chardonnay cel: 0 setCycle: End self)
				(++ local1)
				(sfx number: 330 play:)
			)
			(1
				(meter setCycle: CT (+ (meter cel:) 1) 1 self)
				(sfxMachine hold: (+ local1 1))
			)
			(2
				(switch local1
					(1
						(light1 init: setCycle: Fwd)
						(if (> (gGame detailLevel:) 1)
							(light2 init: setCycle: Fwd)
						)
						(= seconds 4)
					)
					(2
						(light3 init: setCycle: Fwd)
						(if (> (gGame detailLevel:) 1)
							(panel init: setCycle: Fwd)
						)
						(= seconds 4)
					)
					(3
						(if (> (gGame detailLevel:) 1)
							(bigshock init: setScript: sDoShock)
						)
						(switchSpark init: setCycle: OccCyc self 1 10 100)
						(switch1 dispose:)
						(= seconds 3)
					)
					(4
						(biglights init: setCycle: Fwd)
						(= seconds 3)
					)
					(5
						(if (> (gGame detailLevel:) 1)
							(motor init: setCycle: Fwd)
						)
						(= seconds 3)
					)
					(6
						(if (> (gGame detailLevel:) 1)
							(bigshake init: setCycle: OccCyc self 1 10 60)
						)
						(= seconds 3)
					)
				)
			)
			(3
				(switch local1
					(1
						(gMessager say: 0 0 1 21 23 self) ; "Doesn't that feel good?"
					)
					(2
						(gMessager say: 0 0 1 24 26 self) ; "There, now. How does that feel? Great, isn't it?"
					)
					(6
						(gMessager say: 0 0 1 27 28 self) ; "I know you can feel it now. It's up all the way!"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(= cycles 10)
			)
			(5
				(if (<= local1 5)
					(self changeState: 0)
				else
					(= next sPlugInCord)
					(self dispose:)
				)
			)
		)
	)
)

(instance sPlugInCord of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 1 29 30 self) ; "Something's wrong, Char. Why don't you disconnect me, and we'll just use this bench in the regular old way?"
			)
			(1
				(chardonnay loop: 0 cel: 6 setCycle: Beg self)
			)
			(2
				(chardonnay
					view: 383
					setSpeed: 6
					setCycle: Walk
					setMotion: PolyPath 220 137 self
				)
				(UnLoad 128 387)
			)
			(3
				(chardonnay
					view: 388
					loop: 0
					cel: 0
					setSpeed: 8
					setCycle: CT 2 1 self
				)
				(UnLoad 128 383)
			)
			(4
				(gMessager say: 0 0 1 31 self) ; "WAIT! There it is! Oh, silly me. Look, Larry. It's this cable. It isn't plugged in!"
			)
			(5
				(gMessager say: 0 0 3 1 self) ; "(SCREAMING IN FEAR) CHAR! NO!! STOP!!!"
				(chardonnay setCycle: CT 5 1 self)
				(gGlobalSound1 number: 338 setLoop: 1 play:)
			)
			(6
				(motor dispose:)
				(bigshake dispose:)
				(bigshock setScript: 0 dispose:)
				(sfxMachine2 stop:)
			)
			(7
				(sfx loop: 1 number: 385 play: self)
				(gEgo
					view: 384
					loop: 0
					cel: 0
					x: 137
					y: 60
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(8
				(= local0 1)
				(grease dispose:)
				(meter setCycle: End)
				(gEgo loop: 1 cel: 0 cycleSpeed: 20 setCycle: Fwd)
				(gMessager say: 0 0 3 2 self) ; "YYYYEEEEOOOOWWWW!!!"
			)
			(9
				(UnLoad 128 396)
				(UnLoad 128 381)
			)
			(10
				(= ticks 240)
			)
			(11
				(chickInToaster setScript: sGirlRunsOut)
			)
			(12
				(sfx number: 330 play:)
				(plug init:)
				(chardonnay setCycle: End self)
			)
			(13
				(chardonnay loop: 1 cel: 0 x: 217 y: 137 setCycle: CT 7 1 self)
			)
			(14
				(gMessager say: 0 0 3 5 self) ; "YES!"
			)
			(15
				(chardonnay setCycle: End)
				(= ticks 180)
			)
			(16
				(= global170 0)
				((ScriptID 0 8) disable:) ; icon5
				(gEgo get: 33) ; sculpture
				(SetFlag 88)
				(gMessager say: 0 0 3 6 self) ; "Didn't I tell you I would "turn you on?""
			)
			(17
				(= next sEndCartoon)
				(self dispose:)
			)
		)
	)
)

(instance sEndCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetPort 0)
				(SetPort 0 0 190 320 10 0)
				(gGame hideControls:)
				(= cycles 2)
			)
			(1
				(sfxMachine fade:)
				(gCast eachElementDo: #hide)
				(gEgo show:)
				(DrawPic 98 6)
				(= seconds 4)
			)
			(2
				(= local0 0)
				(larryShockFx play:)
				(gEgo hide:)
				(= seconds 4)
			)
			(3
				(gMessager say: 0 0 3 7 self) ; "The Next Morning..."
			)
			(4
				(= ticks 180)
			)
			(5
				(ClearFlag 74)
				(gCurRoom newRoom: 620)
				(self dispose:)
			)
		)
	)
)

(instance sGirlRunsOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sfx number: 386 play:)
				(chickInToaster init:)
				(gMessager say: 0 0 3 3 self) ; "EEEAAAAKKKKK!! OUCH!"
			)
			(1
				(chickInToaster setCycle: End self)
			)
			(2
				(toasterTop init:)
				(chickInToaster loop: 1 cel: 0 x: 97 y: 95 setCycle: End self)
			)
			(3
				(gMessager say: 0 0 3 4 self) ; "Lemme outta here!"
			)
			(4
				(chickInToaster
					setLoop: 2
					setCel: 0
					x: 97
					y: 95
					xStep: 10
					yStep: 2
					cycleSpeed: 2
					moveSpeed: 2
					setCycle: Walk
					setMotion: MoveTo 250 67 self
				)
				(pearl loop: 1 cel: 0 posn: 172 61 init: setCycle: End)
				(bathDoor setCycle: End self)
				(sfx number: 32 play:)
			)
			(5)
			(6
				(pearl loop: 0 cel: 0 posn: 116 95 setCycle: Fwd)
				(bathDoor setCycle: Beg self)
			)
			(7
				(sfx number: 33 play:)
				(toasterTop setCycle: Beg self)
			)
			(8
				(sPlugInCord cue:)
				(chickInToaster dispose:)
				(toasterTop dispose:)
				(= cycles 3)
			)
			(9
				(UnLoad 128 398)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 182 94 self)
			)
			(1
				(sfx number: 33 play:)
				(bathDoor setCycle: Beg self)
			)
			(2
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitToMudbaths of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo (gEgo x:) 0)
				(= cycles 10)
			)
			(1
				(sfx number: 32 play:)
				(bathDoor setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 181 79 self)
			)
			(3
				(= cycles 10)
			)
			(4
				(gCurRoom newRoom: 400)
				(self dispose:)
			)
		)
	)
)

(instance sDoShock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sfxMachine2 play:)
				(bigshock setCycle: Fwd)
				(= ticks (Random 30 60))
			)
			(1
				(bigshock setCycle: End self)
			)
			(2
				(= ticks (Random 50 150))
				(sfxMachine2 stop:)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance chardonnay of Actor
	(properties
		x 182
		y 79
		view 383
		loop 4
		cel 2
		xStep 5
	)
)

(instance chickInToaster of Actor
	(properties
		x 95
		y 95
		view 398
	)
)

(instance toasterHeat of Prop
	(properties
		x 125
		y 70
		view 380
		loop 5
	)
)

(instance bathDoor of Prop
	(properties
		x 185
		y 80
		noun 2
		sightAngle 40
		approachX 182
		approachY 94
		view 380
		loop 4
		cel 2
		priority 5
		signal 20497
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sExitToMudbaths)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance toasterTop of Prop
	(properties
		x 95
		y 95
		view 397
		cel 2
		priority 2
		signal 16400
	)
)

(instance pearl of Prop
	(properties
		x 116
		y 95
		noun 3
		approachX 110
		approachY 105
		view 380
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Take
				(Face gEgo 120 5 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(gEgo get: 29) ; pearl
		(gGame changeScore: 15 197)
		(self dispose:)
	)
)

(instance switch1 of Prop
	(properties
		x 241
		y 112
		view 395
		loop 3
		priority 9
		signal 16400
	)
)

(instance meter of Prop
	(properties
		x 242
		y 138
		view 395
		loop 5
		priority 9
		signal 16400
	)
)

(instance light1 of Prop
	(properties
		x 249
		y 115
		view 395
		priority 9
		signal 16400
	)
)

(instance light2 of Prop
	(properties
		x 226
		y 111
		view 395
		loop 1
		priority 9
		signal 16400
		detailLevel 2
	)
)

(instance light3 of Prop
	(properties
		x 219
		y 86
		view 395
		loop 2
		priority 9
		signal 16400
	)
)

(instance panel of Prop
	(properties
		x 234
		y 131
		view 395
		loop 7
		priority 9
		signal 16400
		detailLevel 2
	)
)

(instance bigshock of Prop
	(properties
		x 235
		y 54
		view 396
		priority 9
		signal 16400
		detailLevel 2
	)
)

(instance switchSpark of Prop
	(properties
		x 241
		y 112
		view 395
		loop 4
		priority 9
		signal 16400
	)
)

(instance biglights of Prop
	(properties
		x 274
		y 139
		view 395
		loop 6
		priority 9
		signal 16400
	)
)

(instance motor of Prop
	(properties
		x 263
		y 67
		view 396
		loop 1
		priority 9
		signal 16400
		detailLevel 2
	)
)

(instance bigshake of Prop
	(properties
		x 308
		y 79
		view 396
		loop 8
		priority 9
		signal 16400
		detailLevel 2
	)
)

(instance plug of View
	(properties
		x 221
		y 138
		view 380
		loop 7
		signal 16385
	)
)

(instance grease of View
	(properties
		x 122
		y 108
		view 380
		loop 2
		priority 9
		signal 16401
	)
)

(instance remoteCover of View
	(properties
		x 153
		y 124
		noun 4
		sightAngle 40
		view 380
		loop 3
		priority 9
		signal 16401
	)
)

(instance cables of View
	(properties
		x 144
		y 131
		z 67
		noun 6
		sightAngle 40
		view 380
		loop 8
		signal 16385
	)
)

(instance cabinetTop of Feature
	(properties
		x 37
		y 109
		noun 10
		sightAngle 40
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 3 98 3 88 15 85 16 93 20 91 21 87 25 87 26 91 33 89 27 82 30 80 37 87 39 87 40 77 51 73 53 83 65 79 64 83 56 88 41 93 11 101 0 101 0 98
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cabinet of Feature
	(properties
		x 37
		y 108
		noun 9
		sightAngle 40
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 101 65 81 68 95 58 106 38 116 14 122 0 123
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance table of Feature
	(properties
		x 154
		y 123
		noun 4
		sightAngle 40
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 124 109 127 104 131 100 132 103 188 104 193 113 179 132 136 132
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tanningBed of Feature
	(properties
		x 101
		y 79
		noun 7
		sightAngle 40
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 75 67 87 61 96 60 113 60 125 66 127 85 94 101 80 100 67 95 67 79 69 74
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance transformer of Feature
	(properties
		x 261
		y 109
		noun 5
		sightAngle 40
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 319 0 319 138 234 137 220 118 220 93 216 89 215 82 218 71 208 67 209 64 217 59 218 50 205 50 199 44 199 40 206 36 281 16 213 14 227 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sfx of Sound
	(properties
		flags 1
	)
)

(instance larryShockFx of Sound
	(properties
		flags 1
		number 651
	)
)

(instance sfxMachine of Sound
	(properties
		flags 1
		number 381
		loop -1
	)
)

(instance sfxMachine2 of Sound
	(properties
		flags 1
		number 822
		loop -1
	)
)

