;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 109)
(include sci.sh)
(use Main)
(use Talker)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	starCon 0
	sTestTimer 1
	sCrestTimer 2
	sExitSouth 3
	sExitNorth 4
	sEnterSouth 5
	sEnterNorth 6
	cadetsTalker 7
)

(local
	local0
	local1 = -1
)

(class starCon of Rgn
	(properties)

	(method (newRoom newRoomNumber)
		(= keep
			(OneOf
				newRoomNumber
				110
				115
				117
				119
				121
				122
				123
				125
				127
				132
				133
				135
				137
				165
				166
				195
			)
		)
		(= initialized 0)
		(if (OneOf gCurRoomNum 121 125 122 123)
			(hallPeople dispose:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (init)
		(super init: &rest)
		(gNarrator y: 20)
		(if (OneOf gCurRoomNum 121 125 122 123 117 115)
			(gEgo baseSetter: myBaseSetter)
		else
			(gEgo baseSetter: 0)
		)
		(cond
			((OneOf gCurRoomNum 115 117 119 121 122 123 125)
				(if (not (OneOf gPrevRoomNum 115 117 119 121 122 123 125 135))
					(gSq5Music1 number: 5 setLoop: -1 play:)
				)
			)
			((OneOf gPrevRoomNum 115 117 119 121 122 123 125)
				(gSq5Music1 fade: 0 10 5 1)
			)
		)
		(if (OneOf gCurRoomNum 121 122 123 125)
			(hallPeople init:)
			(bayFeature init: setOnMeCheck: 1 64)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (OneOf gCurRoomNum 121 122 123 125)
					(gMessager
						say: 3 1 0 (+ (= local1 (mod (++ local1) 4)) 1) 0 109
					)
				)
			)
			(18 ; Floor_Scrubber
				(gMessager say: 0 18 1 0 0 109) ; "You can't use the Scrub-O-Matic floor scrubber here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gNarrator y: -1)
		(super dispose: &rest)
	)
)

(instance hallPeople of Prop
	(properties
		noun 2
		view 147
		signal 16384
	)

	(method (init)
		(switch gCurRoomNum
			(121
				(self
					loop: 0
					cel: 0
					x: 110
					y: 146
					approachX: 130
					approachY: 151
				)
				(= local0 1)
			)
			(122
				(self
					loop: 1
					cel: 0
					x: 127
					y: 130
					approachX: 131
					approachY: 138
				)
				(= local0 2)
			)
			(123
				(self
					loop: 3
					cel: 0
					x: 219
					y: 135
					approachX: 218
					approachY: 142
				)
				(= local0 3)
				(super init:)
				(self approachVerbs: 4 24 2 setScript: sHallPeople) ; Do, Order, Talk
			)
			(125
				(self
					loop: 2
					cel: 0
					x: 105
					y: 148
					approachX: 126
					approachY: 142
				)
				(= local0 4)
			)
		)
		(if (and (IsFlag 1) (OneOf gCurRoomNum 121 122 125))
			(super init:)
			(self approachVerbs: 4 24 2 setScript: sHallPeople) ; Do, Order, Talk
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb 0 local0 0 109)
			)
			(1 ; Look
				(gMessager say: noun theVerb 0 local0 0 109)
			)
			(2 ; Talk
				(gMessager say: noun theVerb 0 local0 0 109)
			)
			(24 ; Order
				(gMessager say: noun theVerb 0 local0 0 109)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bayFeature of Feature
	(properties
		x 5
		y 5
		noun 1
		modNum 109
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 1 0 (+ (= local1 (mod (++ local1) 4)) 1) 0 109)
			)
			(18 ; Floor_Scrubber
				(gMessager say: 0 18 1 0 0 109) ; "You can't use the Scrub-O-Matic floor scrubber here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance myBaseSetter of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (/ (- (param1 nsBottom:) (param1 nsTop:)) 20))
		(= temp1
			(/
				(*
					(CelWide (param1 view:) (param1 loop:) (param1 cel:))
					(param1 scaleX:)
				)
				140
			)
		)
		(= temp2 (- (param1 x:) (/ temp1 2)))
		(= temp3 (- (param1 y:) (/ temp0 2)))
		(param1
			brLeft: temp2
			brRight: (+ temp2 temp1)
			brTop: temp3
			brBottom: (+ temp3 temp0)
		)
	)
)

(instance sHallPeople of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hallPeople setCycle: End self)
			)
			(1
				(= seconds (Random 1 2))
			)
			(2
				(hallPeople setCycle: Beg self)
			)
			(3
				(= state -1)
				(= seconds (Random 4 7))
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sTestTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 300)
			)
			(1
				(gMessager say: 4 0 2 1 self 109) ; "It might be a good idea for you to start thinking about going to class now, Rog."
			)
			(2
				(= seconds 180)
			)
			(3
				(gMessager say: 4 0 2 2 self 109) ; "You really ought to be getting to class about now, Rog."
			)
			(4
				(= seconds 60)
			)
			(5
				(gMessager say: 4 0 2 3 self 109) ; "If you don't get to class soon, you're gonna get tossed out of the Academy."
			)
			(6
				(= seconds 30)
			)
			(7
				(gCurRoom newRoom: 195)
				(self dispose:)
			)
		)
	)
)

(instance sCrestTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 300)
			)
			(1
				(gMessager say: 4 0 3 1 self 109) ; "Maybe you should go scrub the crest now..."
			)
			(2
				(= seconds 180)
			)
			(3
				(gMessager say: 4 0 3 2 self 109) ; "The commandant is gonna be mad if you don't scrub the crest soon, Rog."
			)
			(4
				(= seconds 60)
			)
			(5
				(gMessager say: 4 0 3 3 self 109) ; "If you don't get your butt down to the Rotunda and start scrubbing, you'll be tossed out of the academy."
			)
			(6
				(= seconds 30)
			)
			(7
				(gCurRoom newRoom: 195)
				(self dispose:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setPri: -1
					setLoop: 3
					posn: 160 160
					setMotion: MoveTo 160 140 self
				)
			)
			(1
				(gEgo setLoop: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 0 x: 115 y: 105 setMotion: MoveTo 143 107 self)
			)
			(1
				(gEgo setMotion: MoveTo 147 112 self)
			)
			(2
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 0 setMotion: MoveTo 115 105 self)
			)
			(1
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance cadetsTalker of Narrator
	(properties)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(switch gCurRoomNum
			(121
				(gSystemWindow tailX: 100 tailY: 90 xOffset: 0)
			)
			(122
				(gSystemWindow tailX: 110 tailY: 90 xOffset: 0)
			)
			(123
				(gSystemWindow tailX: 225 tailY: 90 xOffset: 1)
			)
			(125
				(gSystemWindow tailX: 104 tailY: 85 xOffset: 6)
			)
		)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

