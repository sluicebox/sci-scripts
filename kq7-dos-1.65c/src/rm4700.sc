;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4700)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Plane)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm4700 0
)

(local
	local0
)

(instance rm4700 of KQRoom
	(properties
		picture 4700
	)

	(method (newRoom)
		(ClearFlag 192)
		((ScriptID 13 0) client: gEgo view: -1 loop: -1) ; aEgoTalker
		((ScriptID 7001 0) view: -1 loop: -1) ; kingTalker
		(tFirstTimer client: 0 dispose: delete:)
		(super newRoom: &rest)
	)

	(method (init)
		(gThePlane back: 0 drawPic: -1)
		(UpdatePlane gThePlane)
		(FrameOut)
		(gKqMusic1 number: 4700 loop: -1 play:)
		(SetFlag 192)
		((ScriptID 13 0) ; aEgoTalker
			client: trollKing
			loop: -1
			view: -1
			clientCel: -2
			mouth_x: -999
			mouth_y: -999
		)
		((ScriptID 7001 0) ; kingTalker
			client: littleGuy
			loop: -1
			view: -1
			clientCel: -2
			mouth_x: -999
			mouth_y: -999
		)
		(super init: &rest)
		(Load rsVIEW 4701)
		(Load rsVIEW 4702)
		(Load rsVIEW 4703)
		(Load rsVIEW 4704)
		(Load rsVIEW 4705)
		(Load rsVIEW 4706)
		(trollKing init:)
		(Palette 2 1 71 0) ; PalIntensity
		(Palette 2 104 235 0) ; PalIntensity
		(FrameOut)
		(gGame handsOff:)
		(self setScript: sStart)
	)
)

(instance trollKing of Prop
	(properties
		x 155
		y 132
		view 4701
		loop 2
	)
)

(instance branch1 of Prop
	(properties
		x 83
		y 103
		view 4705
	)

	(method (init)
		(super init: &rest)
		(self setPri: 200)
		(self setCycle: End self)
		(gKqSound1 number: 4704 play:)
	)

	(method (cue)
		(branch2 init:)
	)

	(method (dispose)
		(= cel 0)
		(super dispose:)
	)
)

(instance branch2 of Prop
	(properties
		x 211
		y 87
		view 4705
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 200)
		(self setCycle: End self)
		(gKqSound1 number: 4704 play:)
	)

	(method (cue)
		(tFirstTimer setReal: tFirstTimer 15)
	)

	(method (dispose)
		(= cel 0)
		(super dispose:)
	)
)

(instance frog of Prop
	(properties
		x 155
		y 138
		view 4704
		cycleSpeed 12
	)
)

(instance holeFront of View
	(properties
		x 155
		y 138
		priority 250
		fixPriority 1
		view 4704
		loop 2
	)
)

(instance tFirstTimer of Timer
	(properties)

	(method (cue)
		(if local0
			(if (gCurRoom script:)
				(tFirstTimer setReal: tFirstTimer 5)
			else
				(= local0 0)
				(gCurRoom setScript: sBranchDeath)
			)
		else
			(= local0 1)
			(branch1 init:)
		)
	)
)

(instance sStart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 120)
				((= register (Prop new:))
					view: 4701
					loop: 0
					cel: 0
					x: 144
					y: 109
					setPri: 133
					init:
				)
			)
			(1
				(gKqSound1 number: 4701 play:)
				(Palette 2 1 71 500) ; PalIntensity
				(Palette 2 104 235 500) ; PalIntensity
				(FrameOut)
				(Palette 2 1 71 0) ; PalIntensity
				(Palette 2 104 235 0) ; PalIntensity
				(FrameOut)
				(= ticks 120)
			)
			(2
				(gKqSound1 number: 4701 play:)
				(Palette 2 1 71 500) ; PalIntensity
				(Palette 2 104 235 500) ; PalIntensity
				(FrameOut)
				(Palette 2 1 71 100) ; PalIntensity
				(Palette 2 104 235 100) ; PalIntensity
				(FrameOut)
				(= ticks 45)
			)
			(3
				(register setCycle: End self)
				(gKqSound1 number: 4702 setLoop: 1 play:)
			)
			(4
				(gKqSound1 fade: 0 10 2 1)
				(register loop: 1 cel: 0 cycleSpeed: 12 setCycle: Fwd)
				(trollKing setCycle: End self)
			)
			(5
				(trollKing loop: 3 cel: 0)
				(littleGuy init:)
				(gMessager sayRange: 0 0 1 1 3 self) ; "(NERVOUS)...so with Mathilde's help, I sought you out, Your Majesty."
			)
			(6
				(gKqSound1 number: 871 loop: 1 play: self)
			)
			(7
				(rumbleSound number: 4703 loop: 1 play: self)
			)
			(8
				(gMessager say: 0 0 1 4 self) ; "(STRAINED AND WORRIED)It seems we'd best hurry up about it!"
			)
			(9
				(gGame handsOn:)
				(tFirstTimer setReal: tFirstTimer 30)
				(self dispose:)
			)
		)
	)
)

(instance sGiveToadToKing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(littleGuy dispose:)
				(trollKing loop: 3 cel: 0 setCycle: CT 5 1 self)
			)
			(1
				(littleGuy init:)
				(gMessager sayRange: 1 39 0 0 2 self) ; "(SCARED TO PIECES, SHOUTING OVER THE NOISE)King Otar, Mathilde said this thing was magical."
			)
			(2
				(littleGuy dispose:)
				(trollKing setCycle: End self)
			)
			(3
				(trollKing view: 4702 setLoop: 0 cel: 0 setCycle: End self)
			)
			(4
				(= cycles 2)
			)
			(5
				((ScriptID 7001 0) hide_mouth: 1) ; kingTalker
				(gMessager say: 1 39 0 3 self) ; "(DESPERATE, SCARED, SHOUTING OVER THE NOISE)BLAST! I can't pull it loose!"
			)
			(6
				(littleGuy init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUseHammer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(littleGuy dispose:)
				(tFirstTimer client: 0 dispose: delete:)
				(trollKing setCycle: End self)
			)
			(1
				(trollKing
					view: 4702
					setLoop: 1
					x: 140
					y: 130
					cel: 0
					setCycle: End self
				)
			)
			(2
				(trollKing view: 4703 setLoop: 0 cel: 0)
				(gKqSound1 number: 874 play: self)
			)
			(3
				(trollKing setCycle: End self)
			)
			(4
				(gKqSound1 number: 874 play:)
				(trollKing cel: 0 setCycle: End self)
			)
			(5
				(trollKing cel: 0)
				(gKqSound1 number: 874 play: self)
			)
			(6
				(trollKing setLoop: 1 cel: 0 setCycle: End self)
			)
			(7
				(trollKing setLoop: 2 cel: 0 setCycle: End self)
			)
			(8
				(gKqSound1 number: 4705 setLoop: 1 play: self)
			)
			(9
				(gKqSound1 number: 4704 setLoop: 1 play:)
				(trollKing setLoop: 3 cel: 0 setCycle: CT 14 1 self)
			)
			(10
				((ScriptID 7001 0) ; kingTalker
					view: 4703
					loop: 23
					client: trollKing
					hide_mouth: 0
				)
				(trollKing cel: 15)
				(UpdateScreenItem trollKing)
				(frog init:)
				(trollKing setCycle: End self)
			)
			(11
				(gMessager say: 1 46 4 1 self) ; "(EXCITED, AFRAID, SHOUTING OVER THE NOISE)SAVE US! DIG! DIG!"
				(frog setCycle: End self)
			)
			(12)
			(13
				(gKqSound1 number: 4705 play:)
				(gMessager say: 1 46 4 2 self) ; "(SHOUTING URGENTLY OVER THE NOISE)Rosella! HURRY!"
			)
			(14
				(gKqSound1 number: 4406 play:)
				(frog setPri: 0)
				(holeFront init:)
				(trollKing
					view: 4704
					setLoop: 1
					cel: 0
					posn: 170 135
					setPri: 200
					cycleSpeed: 16
					setCycle: End self
				)
			)
			(15
				(trollKing hide:)
				(= cycles 5)
			)
			(16
				(gCurRoom newRoom: 4400)
			)
		)
	)
)

(instance deadFallDude of Prop
	(properties
		x 124
		y 73
		priority 150
		fixPriority 1
		view 4706
	)

	(method (dispose)
		(= cel 0)
		(super dispose:)
	)
)

(instance sBranchDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqSound1 number: 4707 play:)
				(deadFallDude init: setCycle: End self)
				(= ticks 45)
			)
			(1
				(if (gCast contains: littleGuy)
					(littleGuy hide:)
				)
				(trollKing hide:)
				((= register (Prop new:))
					view: 4706
					loop: 1
					cel: 0
					x: (trollKing x:)
					y: (trollKing y:)
					init:
					setCycle: End
				)
				(gKqSound1 number: 2478 setLoop: 1 play: self)
			)
			(2)
			(3
				((= scratch (Plane new:))
					setRect: 0 0 319 (gThePlane bottom:)
					back: 0
					picture: -1
					priority: 500
					init:
				)
				(FrameOut)
				(gKqSound1 number: 4704 play: self)
			)
			(4
				(if (IsFlag 152)
					(EgoDead 70 self)
				else
					(EgoDead 58 self)
				)
			)
			(5
				(scratch dispose:)
				(tFirstTimer setReal: tFirstTimer 30)
				(if (gCast contains: littleGuy)
					(littleGuy show:)
				)
				(trollKing show:)
				(register dispose:)
				(deadFallDude dispose:)
				(branch1 dispose:)
				(branch2 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance littleGuy of Prop
	(properties
		noun 1
		view 4701
	)

	(method (init)
		(self x: (trollKing x:) y: (trollKing y:) setHotspot: 8 10 39 46 75) ; Do, Exit, Dragon_Toad, Hammer_and_Chisel, Shovel
		(|= signal $1000)
		(cond
			((== (trollKing view:) 4702)
				(self view: 4702 loop: 2)
			)
			((trollKing cel:)
				((ScriptID 13 0) view: 4701 loop: 26) ; aEgoTalker
				((ScriptID 7001 0) view: 4701 loop: 25) ; kingTalker
				(self loop: 5)
			)
			(else
				((ScriptID 13 0) view: 4701 loop: 24) ; aEgoTalker
				((ScriptID 7001 0) view: 4701 loop: 23) ; kingTalker
				(self loop: 4)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((IsFlag 152)
						(gMessager say: noun theVerb 4 0) ; "(DESPERATE, SHOUTING OVER THE NOISE)Do you have something that could pry the stone loose, Princess?"
					)
					((IsFlag 480)
						(gMessager say: noun theVerb 3 0) ; "(UPSET, SHOUTING OVER THE NOISE)I fear we are doomed, Princess!"
					)
					(else
						(SetFlag 480)
						(gMessager say: noun theVerb 2 0) ; "(SCARED BUT TRYING NOT TO SHOW IT; SHOUTING OVER THE NOISE)I hope you have a plan, Rosella. I'm at wit's end!"
					)
				)
			)
			(39 ; Dragon_Toad
				(gGame handsOff:)
				(SetFlag 152)
				(gEgo put: 31) ; Dragon_Toad
				(gCurRoom setScript: sGiveToadToKing)
			)
			(46 ; Hammer_and_Chisel
				(if (IsFlag 152)
					(gGame handsOff:)
					(gCurRoom setScript: sUseHammer)
				else
					(gMessager say: noun theVerb 2 0) ; "(SCARED, SHOUTING OVER THE NOISE)A good thought, Rosella, but that would take far too long to dug us out!"
				)
			)
			(75 ; Shovel
				(gMessager say: noun 46 2 0) ; "(SCARED, SHOUTING OVER THE NOISE)A good thought, Rosella, but that would take far too long to dug us out!"
			)
		)
	)
)

(instance rumbleSound of Sound
	(properties)
)

