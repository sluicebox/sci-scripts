;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use n079)
(use OccCyc)
(use LarryRoom)
(use CycleBet)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm280 0
)

(local
	local0
	local1
)

(instance rm280 of LarryRoom
	(properties
		noun 1
		picture 280
		horizon 0
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 178 61 214 65 229 71 269 72 269 66 286 56 214 61 183 56
					yourself:
				)
		)
		(super init: &rest)
		(windSFx loop: -1 play: 127)
		(gGlobalSound1 mute: 0 8)
		((ScriptID 0 8) enable:) ; icon5
		(= global170 gCurRoom)
		(gEgo view: 282 loop: 0 cel: 0 posn: 270 66 init:)
		(merrily init: approachVerbs: 4 2) ; Do, Talk
		(japan init:)
		(ladder init:)
		(beacon1 init: cycleSpeed: 14 setPri: 14 setCycle: Fwd)
		(beacon2 init: cycleSpeed: 14 setCycle: Fwd)
		(rope1 init: stopUpd:)
		(rope2 init: stopUpd:)
		(harness init: stopUpd:)
		(theShip init: stopUpd:)
		(gCurRoom setScript: egoEnters)
	)

	(method (cue)
		(if (gCurRoom script:)
			((gCurRoom script:) setScript: forwardScript)
		else
			(self setScript: forwardScript)
		)
	)

	(method (dispose)
		(gGlobalSound1 stop:)
		(gNarrator modeless: 0)
		(DisposeScript 956)
		(super dispose:)
	)
)

(instance forwardScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= cycles 2)
			)
			(1
				(= temp1 gTheCursor)
				(gGame setCursor: gNormalCursor)
				(SetCursor 225 90)
				(if
					(Print
						addTitle: 0 8 0 2 280
						addText: 0 8 0 1 0 2 280 ; "Do you really want to Fast Forward through this scene and miss out on what promises to be a unique experience, Larry?"
						addButton: 0 10 8 0 1 0 (proc79_4 50 45 45 45 45) 280 ; "Oops"
						addButton: 1 9 8 0 1 155 (proc79_4 50 45 45 45 45) 280 ; "Yes"
						init:
					)
					(self cue:)
				else
					(gGame setCursor: temp1)
					(= global170 gCurRoom)
					((ScriptID 0 8) enable:) ; icon5
					(self dispose:)
				)
			)
			(2
				((gInventory at: 35) owner: -1) ; swimsuit
				((gInventory at: 31) owner: -1) ; sunglasses
				((gInventory at: 20) owner: -1) ; towerkey
				((gInventory at: 2) owner: -1) ; beaver
				(gEgo get: 40) ; wordsOWisdom
				((ScriptID 0 8) disable:) ; icon5
				(gGame handsOff: changeScore: 20 174)
				(gGame hideControls:)
				(SetPort 0 0 190 320 10 0)
				(= cycles 2)
			)
			(3
				(ClearFlag 8)
				(gGlobalSound1 stop:)
				(DrawPic 98 6)
				(gCast eachElementDo: #hide)
				(= cycles 2)
			)
			(4
				(ClearFlag 74)
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance touchMerrily of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 8) disable:) ; icon5
				(gGame handsOff:)
				(gEgo
					view: 901
					loop: 3
					setCel: 0
					setSpeed: 12
					setCycle: CT 3 1 self
				)
			)
			(1
				(gEgo setCycle: CycleBet 3 4 -1)
				(= ticks 30)
			)
			(2
				(gMessager say: 6 4 register 0 self)
			)
			(3
				(switch local0
					(1
						(gGlobalSound1 mute: 0 9 mute: 0 4)
					)
					(2
						(gGlobalSound1 mute: 0 6 mute: 0 7)
					)
					(3
						(gEgo actions: egoActions)
						(gGlobalSound1 mute: 0 5)
					)
				)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo normalize: 900 1 setSpeed: 6)
				(gGame handsOn:)
				(self dispose:)
				((ScriptID 0 8) enable:) ; icon5
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 900)
				(= cycles 2)
			)
			(1
				(gMessager say: 1 0 8 0 self) ; "Ohmigawd! How high are we?!"
			)
			(2
				(= ticks 30)
			)
			(3
				(gEgo setSpeed: 12 setCycle: End self)
			)
			(4
				(gEgo
					normalize: 900 1
					setSpeed: 6
					setMotion: PolyPath 233 63 self
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance undress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 1)
				(merrily approachVerbs: 0)
				(gEgo setMotion: PolyPath 249 74 self)
			)
			(1
				(gEgo
					setSpeed: 12
					view: 282
					loop: 7
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo view: 282 loop: 8 setCel: 0 setCycle: End self)
			)
			(3
				(merrily
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 2 1 self
				)
			)
			(4
				(harness dispose:)
				(merrily setCycle: End self)
			)
			(5
				(merrily loop: 4 setCel: 0 cycleSpeed: 6 posn: 207 58)
				(SetFlag 74)
				(gGame handsOn:)
				(gTheIconBar disable: (ScriptID 0 3)) ; icon0
			)
		)
	)
)

(instance bungeeJump of Script
	(properties)

	(method (doit)
		(cond
			((not (== (self state:) 20)))
			((== (gEgo cel:) 0)
				(sFx number: 291 play:)
			)
			((and (== (sFx number:) 291) (== (gEgo cel:) 5))
				(sFx number: 292 play:)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 6 6 4 0 self) ; "Come and get me, Larry! I'm bound up, and bound for, love!"
			)
			(1
				(gMessager say: 6 6 7 1 self) ; "(PUNCH LINE) Not without me, I hope!"
			)
			(2
				(gEgo
					view: 282
					loop: 1
					setCel: 0
					setSpeed: 6
					setCycle: Walk
					setMotion: PolyPath 195 63 self
				)
			)
			(3
				(gEgo loop: 2 setCel: 0)
				(= cycles 2)
			)
			(4
				(Palette palSET_FROM_RESOURCE 280 2)
				(gMessager say: 6 6 7 2 8 self) ; "Merr, I hope you're not going to jump tonight... and leave me alone up here!"
			)
			(5
				(merrily view: 281 setLoop: 5 setCel: 0 setCycle: End self)
			)
			(6
				(gGame changeScore: 20 174)
				(gEgo get: 40) ; wordsOWisdom
				(= ticks 60)
			)
			(7
				(merrily setCycle: Beg self)
			)
			(8
				(gEgo
					setLoop: 9
					setCycle: Walk
					setSpeed: 6
					setMotion: MoveTo 178 60 self
				)
			)
			(9
				(gMessager say: 6 6 7 9 self) ; "WHAT!!?? My God, Merrily! I'm dumbfounded. That's amazing! You are so wise. An ultimate truth! I'm... I'm..."
			)
			(10
				(gEgo setMotion: MoveTo 166 59 self)
			)
			(11
				(gGlobalSound1 number: 338 loop: 1 play: 127)
				(merrily setLoop: 6 setCel: 0 setCycle: End)
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(12
				(gEgo loop: 4 setCel: 0 setSpeed: 4 setCycle: Fwd)
				(= seconds 4)
			)
			(13
				(rope1 dispose:)
				(gEgo loop: 5 setSpeed: 12 setCel: 0 setCycle: End self)
				(sFx number: 271 loop: 1 play: 127)
			)
			(14
				(gEgo loop: 6 setCel: 0 setPri: 5 setCycle: Fwd)
				(merrily
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 163 62 self
				)
			)
			(15
				(merrily setLoop: 7 setCel: 0 setCycle: End)
				(= seconds 5)
			)
			(16
				(beacon1 addToPic:)
				(gMessager say: 6 6 7 11 self) ; "Isn't that just like a man? Always has to get off first!"
			)
			(17
				(gGlobalSound1 number: 295 play: setLoop: -1)
				(gEgo view: 290 setCel: 0)
				(merrily dispose:)
				(rope2 dispose:)
				(beacon2 dispose:)
				(theShip dispose:)
				(Palette palSET_FROM_RESOURCE 999 2)
				(gCurRoom drawPic: 290)
				(windSFx stop:)
				(= cycles 1)
			)
			(18
				(Palette palSET_FROM_RESOURCE 999 2)
				(gEgo init: setCycle: 0 setCel: 0 setSpeed: 12 posn: 165 21)
				(sFx2 number: 385 loop: 1 play: 127)
				(= cycles 2)
			)
			(19
				(gMessager say: 6 6 7 12 self) ; "Quiet, Larry! You'll wake the entire resort!!"
			)
			(20
				(Palette palSET_FROM_RESOURCE 999 2)
				(sFx number: 291 play:)
				(gEgo setCycle: ForwardCounter 3 self)
			)
			(21
				(gEgo dispose:)
				(gCurRoom drawPic: 295)
				(= cycles 2)
			)
			(22
				(self setScript: lightsOn)
				(spotLight init: cycleSpeed: 14 setCycle: OccCyc self 1 1 10)
				(spotLight2 init: cycleSpeed: 16 setCycle: OccCyc self 1 1 10)
				(gEgo
					view: 295
					loop: 3
					posn: 158 1
					init:
					setScale: 0
					setSpeed: 8
					setCel: 0
					setCycle: Fwd
				)
				(larryLight init: cycleSpeed: 8 setCel: 0 setCycle: Fwd)
				(gNarrator modeless: 1)
				(= seconds 5)
			)
			(23
				(gMessager say: 6 6 7 13 self) ; "Now you've done it! You've awakened the entire resort. Everybody is staring out their windows at you, foolishly bungee jumping in the middle of the night, wearing nothing but embarrassment!"
			)
			(24
				(= seconds 5)
			)
			(25
				((gInventory at: 35) owner: -1) ; swimsuit
				((gInventory at: 31) owner: -1) ; sunglasses
				((gInventory at: 20) owner: -1) ; towerkey
				(gEgo put: 2) ; beaver
				((ScriptID 0 8) disable:) ; icon5
				(gGame hideControls:)
				(SetPort 0 0 190 320 10 0)
				(= cycles 2)
			)
			(26
				(gGlobalSound1 fade:)
				(= global170 0)
				(DrawPic 98 6)
				(gCast eachElementDo: #hide)
				(= ticks 180)
			)
			(27
				(gMessager say: 6 6 7 14 self) ; "The Next Morning..."
			)
			(28
				(= ticks 180)
			)
			(29
				(ClearFlag 8)
				(ClearFlag 74)
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance lightsOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(windowLight init: addToPic:)
				(= ticks (Random 10 30))
			)
			(1
				(windowLight2 init: addToPic:)
				(= ticks (Random 10 30))
			)
			(2
				(windowLight3 init: addToPic:)
				(= ticks (Random 10 30))
			)
			(3
				(windowLight4 init: addToPic:)
				(= ticks (Random 10 30))
			)
			(4
				(windowLight5 init: addToPic:)
				(= ticks (Random 10 30))
			)
			(5
				(windowLight6 init: addToPic:)
				(= ticks (Random 10 30))
			)
			(6
				(windowLight7 init: addToPic:)
				(= ticks (Random 10 30))
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance windowLight of View
	(properties
		x 189
		y 95
		view 295
		loop 4
	)
)

(instance windowLight2 of View
	(properties
		x 162
		y 98
		view 295
		loop 4
	)
)

(instance windowLight3 of View
	(properties
		x 163
		y 69
		view 295
		loop 4
	)
)

(instance windowLight4 of View
	(properties
		x 162
		y 55
		view 295
		loop 4
	)
)

(instance windowLight5 of View
	(properties
		x 134
		y 86
		view 295
		loop 4
	)
)

(instance windowLight6 of View
	(properties
		x 167
		y 62
		view 295
		loop 4
	)
)

(instance windowLight7 of View
	(properties
		x 118
		y 98
		view 295
		loop 4
	)
)

(instance theShip of View
	(properties
		x 65
		y 123
		noun 4
		view 280
		loop 4
	)
)

(instance spotLight of Prop
	(properties
		x 144
		y 101
		view 295
		loop 2
		cycleSpeed 12
	)
)

(instance spotLight2 of Prop
	(properties
		x 138
		y 105
		view 295
		loop 1
		cel 11
		cycleSpeed 8
	)
)

(instance larryLight of Prop
	(properties
		x 193
		y 106
		view 295
		loop 5
		signal 16384
	)
)

(instance rope1 of View
	(properties
		x 171
		y 69
		noun 13
		view 280
	)
)

(instance rope2 of View
	(properties
		x 208
		y 55
		noun 13
		view 280
		loop 1
	)
)

(instance harness of View
	(properties
		x 205
		y 58
		noun 14
		view 280
		loop 2
	)
)

(instance beacon1 of Prop
	(properties
		x 252
		y 36
		noun 2
		view 283
	)

	(method (doit)
		(cond
			((== (self cel:) 3)
				(Palette palSET_FROM_RESOURCE 282 2)
			)
			((== (self cel:) 4)
				(Palette palSET_FROM_RESOURCE 280 2)
			)
		)
		(super doit: &rest)
	)
)

(instance beacon2 of Prop
	(properties
		x 300
		y 26
		noun 2
		view 283
		loop 1
	)
)

(instance merrily of Actor
	(properties
		x 215
		y 58
		noun 6
		approachX 233
		approachY 63
		view 281
		loop 1
		cel 4
	)

	(method (doVerb theVerb &tmp temp0)
		(switch local0
			(0
				(= temp0 1)
			)
			(1
				(= temp0 2)
			)
			(else
				(= temp0 3)
			)
		)
		(switch theVerb
			(4 ; Do
				(if local1
					(gCurRoom setScript: bungeeJump)
					(return 1)
				else
					(++ local0)
					(gCurRoom setScript: touchMerrily 0 temp0)
					(return 1)
				)
			)
			(5 ; Take
				(if local1
					(gMessager say: 6 2 4) ; "Don't just stand over there in all your nakedness; get over here!"
				else
					(switch local0
						(0
							(gMessager say: 6 5 1) ; "Go ahead, Honey. "Take" a chance."
						)
						(1
							(gMessager say: 6 5 2) ; "Go ahead. I'm yours for the taking!"
						)
						(else
							(gMessager say: 6 5 3) ; "The idea is to take YOUR clothes off."
						)
					)
				)
				(return 1)
			)
			(1 ; Look
				(switch local0
					(0
						(gMessager say: 6 1 1) ; "Merr's beautiful hair is sparkling in the moonlight; and at this height, there's very little air to cloud your view."
					)
					(1
						(gMessager say: 6 1 2) ; "Merr is looking better and better."
					)
					(else
						(gMessager say: 6 1 3) ; "Merr looks like she's ready!"
					)
				)
				(return 1)
			)
			(2 ; Talk
				(if local1
					(gMessager say: 6 2 4) ; "Don't just stand over there in all your nakedness; get over here!"
				else
					(gMessager say: 6 2 temp0)
				)
				(return 1)
			)
			(6 ; Zipper
				(if local1
					(gCurRoom setScript: bungeeJump)
					(return 1)
				else
					(gMessager say: 6 theVerb temp0)
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
				(return 1)
			)
		)
	)
)

(instance japan of Feature
	(properties
		noun 3
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 48 87 105 64 99 88 37 118
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ladder of Feature
	(properties
		noun 8
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 264 136 259 108 278 68 286 61 264 107 264 135
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local1
					(gMessager say: 7 6) ; "Perhaps a little "warm-up" first would be in order. Sure, Merr's excited, but exercise a little self-control, Larry!"
				else
					(gCurRoom setScript: undress)
				)
				(return 1)
			)
			(6 ; Zipper
				(if local1
					(gMessager say: 7 6) ; "Perhaps a little "warm-up" first would be in order. Sure, Merr's excited, but exercise a little self-control, Larry!"
				else
					(gCurRoom setScript: undress)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFx of Sound
	(properties)
)

(instance sFx2 of Sound
	(properties)
)

(instance windSFx of Sound
	(properties
		number 270
	)
)

