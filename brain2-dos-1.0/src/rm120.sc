;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use Talker)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm120 0
	brainTalker120 1
)

(instance rm120 of Rm
	(properties
		picture 120
	)

	(method (init)
		(gTheIconBar disable:)
		(Load rsVIEW 120)
		(LoadMany rsSOUND 114 195)
		(screen1 init: setCycle: Fwd)
		(screen2 init: setCycle: Fwd)
		(screen3 init: setCycle: Fwd)
		(flashingButton init: setCycle: Fwd)
		(drBrain init: hide:)
		(feet init:)
		(super init:)
		(self setScript: moveToNext)
	)
)

(instance moveToNext of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gCMusic prevSignal:) -1)
					(gCMusic number: 3 loop: -1 play:)
					(= seconds 4)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(1
				(gCSoundFX number: 114 setLoop: -1 play: 127)
				(= ticks 45)
			)
			(2
				(gCSoundFX number: 195 setLoop: 0 play: 127)
				(= ticks 45)
			)
			(3
				(DrawPic 120 9 1)
				(drBrain show:)
				(Animate (gCast elements:) 0)
				(= register (gNarrator y:))
				(gNarrator y: 10)
				(gMessager say: 2 9 caller: self) ; "The last time you saw Dr. Thaddeus Egghead Brain, believed by many to be the greatest living eccentric mathematical genius to date, you'd just been promoted to lab assistant in the dark and dusty basement laboratory of his castle."
			)
			(4
				(gNarrator y: register)
				(gMessager say: 1 2 caller: self) ; "Recently while working very late in my lab, I was finishing the plans of my latest top-secret project. I heard a faint noise."
			)
			(5
				((= gFastCast (EventHandler new:))
					name: {fastCast}
					add: brainTalker120
				)
				((ScriptID 30) disposeWhenDone: 0) ; brainTalker
				(gMessager disposeWhenDone: 0 say: 5 9 0 1 self 20) ; "Hello? Testing...one, two. Is this thing on?"
			)
			(6
				((= gFastCast (EventHandler new:))
					name: {fastCast}
					add: brainTalker120
				)
				(gMessager say: 5 9 0 2 self 20) ; "All right. Here is your Hint Watch."
			)
			(7
				((= gFastCast (EventHandler new:))
					name: {fastCast}
					add: brainTalker120
				)
				(gMessager say: 5 9 0 3 self 20) ; "Should you get into any trouble--just give me a call. Questions?"
			)
			(8
				((= gFastCast (EventHandler new:))
					name: {fastCast}
					add: brainTalker120
				)
				(gMessager disposeWhenDone: 1 say: 5 9 0 4 self 20) ; "Good. Please be careful."
			)
			(9
				(= seconds 4)
			)
			(10
				(gCMusic fade: 0 10 10 0)
				(gCurRoom newRoom: 130)
			)
		)
	)
)

(instance screen1 of Prop
	(properties
		x 40
		y 39
		view 120
		cel 6
	)
)

(instance screen2 of Prop
	(properties
		x 250
		y 30
		view 120
		loop 1
		cel 3
	)
)

(instance screen3 of Prop
	(properties
		x 121
		y 50
		view 120
		loop 2
		priority 14
		signal 16
	)
)

(instance flashingButton of Prop
	(properties
		x 137
		y 21
		view 120
		loop 3
	)
)

(instance drBrain of Prop
	(properties
		x 86
		y 90
		view 122
		cel 1
		priority 1
		signal 16
	)
)

(instance brainMouth of Prop
	(properties
		view 122
		loop 1
	)
)

(instance feet of View
	(properties
		x 121
		y 163
		view 120
		loop 4
	)
)

(instance brainTalker120 of Talker
	(properties
		x 118
		y 119
		view 122
		loop 2
		cel 1
		talkWidth 280
		color 2
		back 19
		textX -80
		textY 160
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(gFastCast contains: (ScriptID 30)) ; brainTalker
				(!= (brainMouth cel:) (((ScriptID 30) mouth:) cel:)) ; brainTalker
			)
			(DrawCel
				(brainMouth view:)
				(brainMouth loop:)
				(((ScriptID 30) mouth:) cel:) ; brainTalker
				x
				y
			)
		)
	)

	(method (init)
		(= mouth brainMouth)
		(super init: &rest)
	)
)

