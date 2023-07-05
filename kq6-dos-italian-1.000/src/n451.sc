;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 451)
(include sci.sh)
(use Main)
(use rm450)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	proc451_0 0
)

(procedure (proc451_0 param1)
	(gCurRoom setScript: boreTheOyster 0 param1)
)

(instance boreTheOyster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gMessager say: 1 42 5 1 self 450) ; "Would you like me to read to you again?"
				else
					(gMessager say: 1 42 1 1 self 451) ; "If you're having trouble sleeping, perhaps you'd like me to read to you."
				)
			)
			(1
				(gMessager say: 1 42 1 2 self 451) ; "Hey! That would be great!"
			)
			(2
				(gEgo setMotion: PolyPath 132 141 self)
			)
			(3
				(SetFlag 59)
				(gEgo
					view: 451
					loop: 0
					cel: 0
					posn: 115 143
					normal: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(4
				(= cycles 3)
			)
			(5
				(gEgo
					loop: 2
					cel: 0
					posn: 104 146
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(6
				(OI init:)
				((ScriptID 450 1) hide: view: 2002) ; oyster
				(gEgo dispose:)
				(= seconds 3)
			)
			(7
				(gGame handsOn:)
				(gTheIconBar disable: 0 3 4 5)
				(book setCycle: End self)
			)
			(8
				(book cel: 0)
				(= cycles 3)
			)
			(9
				(gMessager say: 1 42 1 4 self 451) ; "Two dulcimas raised to the degree of forty halfdulcimas, divided into equal parts by the third of a cackle of grouse geese, put over the result of ten finemackels (albeit small finemackels), stretched over the total of fifty-three and an eighth bottles of wildebeast lard...."
			)
			(10
				(book setCycle: End self)
			)
			(11
				(book cel: 0)
				(= cycles 3)
			)
			(12
				(pearl y: 184 z: 80)
				(gGlobalSound3 number: 961 setLoop: 1 play:)
				(insetOyster view: 4532 setLoop: 0 cycleSpeed: 1 setCycle: End)
				(= seconds 2)
			)
			(13
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetOyster setCycle: Beg self)
			)
			(14
				(pearl y: 104 z: 0)
				(insetOyster view: 453 setLoop: 1 cel: 0)
				(= seconds 2)
			)
			(15
				(book setCycle: End self)
			)
			(16
				(book cel: 0)
				(= cycles 3)
			)
			(17
				(gMessager say: 1 42 1 6 self 451) ; "....yields a gilded minnow of precise measurements; two thousand sixty-nine centidrils by three million twenty-three and six-sevenths punds (NOT punts, as might be expected). This is not to say, however, in any sense, whatsoever, that deviations in mean temperature of five or six dregs or so...."
			)
			(18
				(pearl y: 184 z: 80)
				(gGlobalSound3 number: 961 setLoop: 1 play:)
				(insetOyster view: 4532 setLoop: 0 setCycle: End)
				(= seconds 3)
			)
			(19
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetOyster setCycle: Beg self)
			)
			(20
				(pearl y: 104 z: 0)
				(insetOyster view: 453 setLoop: 1)
				(= seconds 2)
			)
			(21
				(book setCycle: End self)
			)
			(22
				(book cel: 0)
				(= cycles 3)
			)
			(23
				(gMessager say: 1 42 1 8 self 451) ; "....indicate a fabrication or derivation sufficiently broad enough to exacerbate the conclusions uncovered, in due course, with regards to the dimensions, consistency, mass, or thickness inherent in the menial suckling grouse."
			)
			(24
				(pearl y: 184 z: 80)
				(gGlobalSound3 number: 961 setLoop: 1 play:)
				(insetOyster view: 4532 setLoop: 0 setCycle: End)
				(= seconds 6)
			)
			(25
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetOyster setCycle: Beg self)
			)
			(26
				(pearl y: 104 z: 0)
				(insetOyster view: 453 setLoop: 1)
				(= seconds 1)
			)
			(27
				(gGame handsOff:)
				(book setCycle: End self)
			)
			(28
				(book cel: 0)
				(= cycles 3)
			)
			(29
				(gGlobalSound3 setLoop: 5 play:)
				(insetOyster view: 4533 cycleSpeed: 0 setLoop: 5 setCycle: Fwd)
				(= seconds 5)
			)
			(30
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gMessager say: 1 42 1 11 self 451) ; "The poor little oyster falls into an uneasy sleep, though it's clear he is still not resting easy."
			)
			(31
				(OI dispose:)
				((ScriptID 450 1) ; oyster
					view: 4531
					setLoop: 2
					show:
					cycleSpeed: 50
					setCycle: End
				)
				(gEgo
					view: 451
					loop: 2
					cel: 2
					posn: 104 146
					cycleSpeed: 6
					normal: 0
					setScale: Scaler 100 30 126 70
					init:
				)
				(= cycles 4)
			)
			(32
				(gMessager say: 1 42 1 12 self 451) ; "Alexander decides to leave him to his nap."
			)
			(33
				(gEgo
					view: 451
					loop: 0
					cel: 7
					posn: 115 143
					setCycle: Beg self
				)
			)
			(34
				(gEgo reset: 1 posn: 132 141)
				(gCurRoom notify:)
				((ScriptID 40 0) oysterDozing: 1) ; rWonder
				(= cycles 6)
			)
			(35
				(ClearFlag 59)
				(gGame handsOn:)
				(DisposeScript 1038)
				(proc450_8 0)
				(= cycles 4)
			)
			(36
				(self dispose:)
				(DisposeScript 451)
			)
		)
	)
)

(instance grabPearl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame givePoints: 1)
				(insetOyster setCycle: 0)
				(book dispose:)
				(= ticks 4)
			)
			(1
				(gMessager say: 4 5 0 1 self 451) ; "Alexander makes a grab for the pearl."
			)
			(2
				(arm init: setCycle: CT 1 1 self)
			)
			(3
				(pearl dispose:)
				(arm setCycle: End self)
			)
			(4
				(arm dispose:)
				(insetOyster setCycle: Beg self)
			)
			(5
				(insetOyster view: 4533 cycleSpeed: 3 setLoop: 5 setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(OI dispose:)
				(ClearFlag 59)
				((ScriptID 450 1) ; oyster
					view: 4531
					setLoop: 2
					cel: 0
					show:
					cycleSpeed: 50
					setCycle: End
				)
				(gEgo
					view: 451
					loop: 2
					cel: 2
					posn: 104 146
					cycleSpeed: 6
					normal: 0
					cycleSpeed: 6
					get: 30 ; pearl
					init:
					setScale: Scaler 100 30 126 70
					setCycle: Beg self
				)
			)
			(7
				(gMessager say: 4 5 0 2 self 451) ; "Hey! You fixed my mouth! It feels great! I...."
			)
			(8
				(gGlobalSound3 number: 963 setLoop: 1 play:)
				(gCurRoom notify:)
				((ScriptID 40 0) oysterDozing: 1) ; rWonder
				(gEgo
					view: 451
					loop: 0
					cel: 7
					posn: 115 143
					cycleSpeed: 6
					setCycle: Beg self
				)
			)
			(9
				(gEgo reset: 1 posn: 132 141)
				(= cycles 6)
			)
			(10
				(gMessager say: 4 5 0 3 self 451) ; "Ah!, the little oyster drifts into peaceful slumber with the rest of his oyster friends."
			)
			(11
				(gGame handsOn:)
				(gGlobalSound3 setLoop: 5 play:)
				(proc450_8 0)
				(= cycles 4)
			)
			(12
				(self dispose:)
				(LoadMany 0 1038 451)
			)
		)
	)
)

(instance almostGotScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(arm init: setCycle: CT 1 1 self)
			)
			(1
				(arm setCycle: Beg self)
			)
			(2
				(arm dispose:)
				(= cycles 2)
			)
			(3
				(gMessager say: 3 5 2 1 self 451) ; "Drat! Just missed it!"
			)
			(4
				(gGame handsOn:)
				(gTheIconBar disable: 0 3 4 5)
				(insetOyster view: 453 setLoop: 1 cel: 0)
				(boreTheOyster start: 20)
				(gCurRoom setScript: boreTheOyster)
				(self dispose:)
			)
		)
	)
)

(instance myConv of Conversation ; UNUSED
	(properties)
)

(instance OI of View
	(properties
		x 122
		y 113
		noun 2
		view 453
		priority 11
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMessager say: noun theVerb 0 1 0 451) ; "Alexander doesn't want to mess with that while he's reading!"
			)
			(1 ; Look
				(gMessager say: noun theVerb 0 1 0 451) ; "Alexander is reading to the oyster that can't sleep."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(gGlobalSound2 number: 450 setLoop: -1 play:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(book init:)
		(pearl init:)
		(botShell init:)
		(insetOyster init:)
		(super init:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gCurRoom cue:)
		(gGlobalSound2 fade: 0 10 10)
		(book dispose:)
		(insetOyster dispose:)
		(botShell dispose:)
		(pearl dispose:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event modifiers:))
				(or
					(& (event type:) evMOUSEBUTTON)
					(and (& (event message:) KEY_RETURN) (& (event type:) evKEYBOARD))
				)
				(not gPrints)
				(not gFastCast)
				(!= (event type:) evVERB)
				(not (self onMe: event))
			)
			(event claimed: 1)
			(boreTheOyster start: 31 init:)
		else
			(super handleEvent: event)
		)
	)
)

(instance book of Prop
	(properties
		x 198
		y 87
		onMeCheck 0
		view 453
		loop 2
		priority 13
		signal 16400
	)
)

(instance arm of Prop
	(properties
		x 198
		y 87
		onMeCheck 0
		view 4532
		loop 1
		priority 14
		signal 16400
	)
)

(instance insetOyster of Prop
	(properties
		x 63
		y 171
		z 70
		noun 3
		view 453
		loop 1
		priority 14
		signal 16400
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMessager say: noun theVerb 0 1 0 451) ; "Alexander sees nothing of interest on that part of the oyster."
			)
			(1 ; Look
				(gMessager say: noun theVerb 0 1 0 451) ; "The oyster is trying to listen to Alexander, but he appears to be getting sleepy."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance botShell of View
	(properties
		x 87
		y 180
		z 90
		noun 3
		view 453
		cel 1
		priority 12
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMessager say: noun theVerb 0 1 0 451) ; "Alexander sees nothing of interest on that part of the oyster."
			)
			(1 ; Look
				(gMessager say: noun theVerb 0 1 0 451) ; "The oyster is trying to listen to Alexander, but he appears to be getting sleepy."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pearl of Prop
	(properties
		x 93
		y 104
		noun 4
		view 453
		loop 6
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (!= (insetOyster cel:) (insetOyster lastCel:))
					(gGame handsOff:)
					(gCurRoom setScript: almostGotScript)
				else
					(gGame handsOff:)
					(gCurRoom setScript: grabPearl)
				)
			)
			(1 ; Look
				(gMessager say: noun theVerb 0 1 0 451) ; "There's a large pearl inside the oyster's mouth. Perhaps the pearl is what's keeping the little fellow awake."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

