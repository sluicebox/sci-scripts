;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use Village)
(use Inset)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	inDrums 0
)

(local
	[local0 12]
	[local12 12]
	local24 = 20479
	local25 = -1
	local26
	local27
	[local28 12]
	local40
)

(procedure (localproc_0)
	(= [local12 0] smallMaleNote)
	(= [local12 1] largeMaleNote)
	(= [local12 2] smallMaleNote)
	(= [local12 3] mediumMaleNote)
	(= [local12 4] largeMaleNote)
	(= [local12 5] largeMaleNote)
	(= [local12 6] mediumMaleNote)
	(= [local12 7] smallFemaleNote)
	(= [local12 8] mediumMaleNote)
	(= [local12 9] largeFemaleNote)
	(= [local12 10] smallFemaleNote)
	(= [local12 11] smallFemaleNote)
)

(procedure (localproc_1 param1)
	(switch param1
		(mediumMaleNote
			(return 334)
		)
		(largeMaleNote
			(return 335)
		)
		(smallMaleNote
			(return 336)
		)
		(largeFemaleNote
			(return 332)
		)
		(smallFemaleNote
			(return 333)
		)
	)
)

(procedure (localproc_2 param1)
	(switch param1
		(0
			(return note1)
		)
		(1
			(return note2)
		)
		(2
			(return note3)
		)
		(3
			(return note4)
		)
		(4
			(return note5)
		)
		(5
			(return note6)
		)
		(6
			(return note7)
		)
		(7
			(return note8)
		)
		(8
			(return note9)
		)
		(9
			(return note10)
		)
		(10
			(return note11)
		)
		(11
			(return note12)
		)
	)
)

(procedure (localproc_3 param1 &tmp temp0)
	(= temp0
		(switch param1
			(largeFemaleNote
				(= temp0 8)
			)
			(smallFemaleNote
				(= temp0 7)
			)
			(smallMaleNote
				(= temp0 4)
			)
			(mediumMaleNote
				(= temp0 6)
			)
			(largeMaleNote
				(= temp0 5)
			)
		)
	)
	(= [local28 (+ local25 1)]
		((Note new:)
			view: 12
			loop: temp0
			cel: 0
			y: 67
			x: (+ local26 94)
			init:
			yourself:
		)
	)
	(+= local26 (- (CelWide 12 temp0 0) 1))
)

(procedure (localproc_4) ; UNUSED
	(if (== [local12 local25] [local0 local25])
		((localproc_2 local25) show:)
	else
		((localproc_2 local25) show: setCycle: Fwd)
	)
	(aNote number: (localproc_1 [local0 local25]) loop: 1 play:)
	(++ local25)
	(playBack ticks: 15)
)

(procedure (localproc_5 param1 &tmp temp0)
	(= temp0
		(switch param1
			(largeFemaleNote
				(= temp0 8)
			)
			(smallFemaleNote
				(= temp0 7)
			)
			(smallMaleNote
				(= temp0 4)
			)
			(mediumMaleNote
				(= temp0 6)
			)
			(largeMaleNote
				(= temp0 5)
			)
		)
	)
	(= [local28 (+ local25 1)]
		((Prop new:)
			view: 12
			loop: temp0
			cel: 0
			y: 67
			x: (+ local26 94)
			init:
			stopUpd:
			yourself:
		)
	)
	(+= local26 (- (CelWide 12 temp0 0) 1))
)

(class Note of Prop
	(properties
		view 12
		priority 7
		signal 16400
		maxScale 0
	)

	(method (init)
		(super init:)
		(self hide:)
	)

	(method (hide)
		(= maxScale 0)
		(self setCycle: 0)
		(super hide:)
	)

	(method (show)
		(cond
			((!= gCurRoomNum 330)
				(super show:)
				(if (>= argc 1)
					(self setCycle: Fwd)
				)
			)
			(maxScale
				(super show:)
				(if (>= argc 1)
					(self setCycle: Fwd)
				)
			)
			(else
				(= maxScale 1)
				(super show:)
			)
		)
	)
)

(instance inDrums of Inset
	(properties
		picture 888
		view 12
		x 83
		y 53
		priority 2
		hideTheCast 1
		disposeNotOnMe 1
		modNum 16
		noun 1
	)

	(method (hideCast param1 &tmp temp0 temp1)
		(= temp0 0)
		(= temp1 (if param1 1000 else -1000))
		(while (< temp0 (gCast size:))
			((gCast at: temp0) z: (+ ((gCast at: temp0) z:) temp1))
			(++ temp0)
		)
		(if (and (> picture 0) param1)
			(DrawPic
				picture
				(if anOverlay 100 else style)
				(if anOverlay 0 else 1)
			)
		)
		(Animate (gCast elements:) 0)
	)

	(method (drawInset)
		(if view
			(= insetView
				((iView new:)
					view: view
					loop: loop
					cel: cel
					x: x
					y: y
					setPri: priority
					ignoreActors: 1
					init:
					yourself:
				)
			)
		)
	)

	(method (init)
		(Load rsVIEW 12)
		(Load rsSOUND 332 333 335 334 336)
		(super init: &rest)
		(baton init:)
		(if (= local27 (== gCurRoomNum 330))
			(musicalScore init:)
			(note1 init:)
			(note2 init:)
			(note3 init:)
			(note4 init:)
			(note5 init:)
			(note6 init:)
			(note7 init:)
			(note8 init:)
			(note9 init:)
			(note10 init:)
			(note11 init:)
			(note12 init:)
		)
		(maleDrum init:)
		(mediumMaleNote init:)
		(smallMaleNote init:)
		(largeMaleNote init:)
		(largeFemaleNote init:)
		(smallFemaleNote init:)
		(femaleDrum init:)
		(batonHolder init:)
		(localproc_0)
		(self setScript: prep)
	)

	(method (doit)
		(super doit:)
		(return
			(if (User canInput:)
				(cond
					((self onMe: gMouseX (- gMouseY 10))
						(if (& local24 $4000)
							(&= local24 $bfff)
							(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
						)
					)
					((or (not (& local24 $4000)) (!= (gTheCursor loop:) 11))
						(|= local24 $4000)
						(gTheCursor view: 960 loop: 11 cel: 0 init:)
						(return 1)
					)
				)
				(if
					(and
						(& local24 $8000)
						(== ((gTheIconBar curIcon:) message:) 4)
						(== (gTheCursor view:) 960)
						(not (& local24 $4000))
					)
					(gTheCursor view: 12 loop: 1 cel: 0 init:)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator x: 70 y: 15)
				(if (== gCurRoomNum 400)
					(gMessager say: 1 1 5 1 0 16) ; "The drum stand is set up near Forest Heart."
				else
					(gMessager say: 1 1 0 1 0 16) ; "The drum stand is lashed to the side of the Long house."
				)
			)
			(4 ; Do
				(aNote number: 337 setLoop: 1 play:)
			)
		)
	)

	(method (dispose)
		(aNote dispose:)
		(super dispose:)
		(ClearFlag 7)
		(gNarrator x: -1 y: -1)
		(gGame handsOn:)
		(DisposeScript 16)
	)
)

(instance prep of Script
	(properties)

	(method (cue param1)
		(if (>= argc 1)
			(= register param1)
		else
			(= register 0)
		)
		(super cue:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 1 canInput: 1)
				(gTheIconBar enable: 2 1 curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
				(SetFlag 7)
				(= cycles 5)
			)
			(1 0)
			(2
				(aNote play:)
				(if (not register)
					(note1 show:)
				)
			)
			(3
				(aNote play:)
				(if (not register)
					(note2 show:)
				)
			)
			(4
				(aNote play:)
				(if (not register)
					(note3 show:)
				)
			)
			(5
				(aNote play:)
				(if (not register)
					(note4 show:)
				)
			)
			(6
				(aNote play:)
				(if (not register)
					(note5 show:)
				)
			)
			(7
				(aNote play:)
				(if (not register)
					(note6 show:)
				)
			)
			(8
				(aNote play:)
				(if (not register)
					(note7 show:)
				)
			)
			(9
				(aNote play:)
				(if (not register)
					(note8 show:)
				)
			)
			(10
				(aNote play:)
				(if (not register)
					(note9 show:)
				)
			)
			(11
				(aNote play:)
				(if (not register)
					(note10 show:)
				)
			)
			(12
				(aNote play:)
				(if (not register)
					(note11 show:)
				)
			)
			(13
				(aNote play:)
				(if (not register)
					(note12 show:)
				)
				(gGame handsOff:)
				(= seconds 2)
			)
			(14
				(if local27
					(self setScript: playBack self)
				else
					(self setScript: grovePlayBack self)
				)
			)
			(15
				(gNarrator x: 72 y: 10)
				(if (not (& local24 $0fff))
					(if local27
						(Village points: 5 45)
						(gMessager say: 1 0 2 1 self 16) ; "Adam has played the melody painted on the hide!"
					else
						(gGame points: 10)
						(gMessager say: 1 0 4 1 self 16) ; "Adam feels a great stirring among the giant tree's branches."
					)
				else
					(gMessager say: 1 0 1 1 self 16) ; "That doesn't seem to be the correct melody."
				)
			)
			(16
				(if (not (& local24 $0fff))
					(inDrums dispose:)
					(if (not local27)
						(gCurrentRegionFlags set: 23)
					)
				else
					(if local27
						(note1 hide:)
						(note2 hide:)
						(note3 hide:)
						(note4 hide:)
						(note5 hide:)
						(note6 hide:)
						(note7 hide:)
						(note8 hide:)
						(note9 hide:)
						(note10 hide:)
						(note11 hide:)
						(note12 hide:)
					)
					(= local25 -1)
					(|= local24 $0fff)
					(self changeState: 0)
				)
			)
		)
		(if (and (< state 13) (> local26 127))
			(gGame handsOff:)
			(= state 13)
			(= seconds 2)
		)
	)
)

(instance grovePlayBack of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(for ((= temp0 0)) (<= temp0 local25) ((++ temp0))
					([local28 temp0] hide:)
				)
				(= register -1)
				(= cycles 2)
				(&= local24 $7fff)
			)
			(1
				([local28 (++ register)] show:)
				(if (!= [local12 register] [local0 register])
					([local28 register] setCycle: Fwd)
				)
				(aNote number: (localproc_1 [local0 register]) play:)
				(if (< register local25)
					(-- state)
				)
				(switch register
					(2
						(= ticks 45)
					)
					(5
						(= ticks 40)
					)
					(8
						(= ticks 35)
					)
					(else
						(= ticks 15)
					)
				)
			)
			(2
				(= ticks 140)
			)
			(3
				(|= local24 $8000)
				(= local26 0)
				(for ((= temp0 0)) (<= temp0 local25) ((++ temp0))
					([local28 temp0] dispose:)
				)
				(self dispose:)
			)
		)
	)
)

(instance playBack of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(note1 hide:)
				(note2 hide:)
				(note3 hide:)
				(note4 hide:)
				(note5 hide:)
				(note6 hide:)
				(note7 hide:)
				(note8 hide:)
				(note9 hide:)
				(note10 hide:)
				(note11 hide:)
				(note12 hide:)
				(= register -1)
				(= local40 0)
				(&= local24 $7fff)
				(= cycles 2)
			)
			(1
				(++ register)
				(if
					(and
						(not local40)
						(== [local12 register] [local0 register])
					)
					((localproc_2 register) show:)
				else
					(= local40 1)
					([local28 register] show:)
					([local28 register] setCycle: Fwd)
				)
				(aNote number: (localproc_1 [local0 register]) play:)
				(if (< register local25)
					(-- state)
				)
				(switch register
					(2
						(= ticks 45)
					)
					(5
						(= ticks 40)
					)
					(8
						(= ticks 35)
					)
					(else
						(= ticks 15)
					)
				)
			)
			(2
				(= ticks 80)
			)
			(3
				(|= local24 $8000)
				(= local26 0)
				(for ((= temp0 0)) (<= temp0 local25) ((++ temp0))
					([local28 temp0] dispose:)
				)
				(self dispose:)
			)
		)
	)
)

(instance note1 of Note
	(properties
		x 94
		y 67
		loop 4
	)
)

(instance note2 of Note
	(properties
		x 104
		y 67
		loop 5
	)
)

(instance note3 of Note
	(properties
		x 112
		y 67
		loop 4
	)
)

(instance note4 of Note
	(properties
		x 122
		y 67
		loop 6
	)
)

(instance note5 of Note
	(properties
		x 131
		y 67
		loop 5
	)
)

(instance note6 of Note
	(properties
		x 140
		y 67
		loop 5
	)
)

(instance note7 of Note
	(properties
		x 149
		y 67
		loop 6
	)
)

(instance note8 of Note
	(properties
		x 158
		y 67
		loop 7
	)
)

(instance note9 of Note
	(properties
		x 173
		y 67
		loop 6
	)
)

(instance note10 of Note
	(properties
		x 182
		y 67
		loop 8
	)
)

(instance note11 of Note
	(properties
		x 199
		y 67
		loop 7
	)
)

(instance note12 of Note
	(properties
		x 214
		y 67
		loop 7
	)
)

(instance baton of View
	(properties
		x 98
		y 74
		noun 2
		modNum 16
		view 12
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self hide:)
				(|= local24 $8000)
			)
			(1 ; Look
				(gNarrator x: 90 y: 15)
				(gMessager say: 2 1 0 0 0 16) ; "The baton has a rubber tip."
			)
		)
	)
)

(instance musicalScore of View
	(properties
		x 81
		y 50
		noun 5
		modNum 16
		view 12
		loop 3
		priority 5
		signal 16400
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator x: 57 y: 10)
				(gMessager say: 5 1 0 0 0 16) ; "The hide has strange markings painted in a pattern."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance largeFemaleNote of Feature
	(properties
		x 185
		y 118
		noun 12
		modNum 16
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 184 113 203 113 219 139 193 139
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator x: 70 y: 15)
				(gMessager say: 15 1 0 1 0 16) ; "Each area of the drum has a unique tone."
			)
			(4 ; Do
				(if (& local24 $8000)
					(= [local0 (+ local25 1)] self)
					(if (not local27)
						(localproc_5 self)
					else
						(localproc_3 self)
					)
					(aNote number: 332 setLoop: 1)
					(if (== [local12 (++ local25)] self)
						(&= local24 (~ (<< $0001 local25)))
						(prep cue: (not local27))
					else
						(if local27
							(note10 show: 0)
						)
						(prep cue: 1)
					)
				else
					(aNote number: 338 setLoop: 1 play:)
				)
			)
			(1 ; Look
				(gNarrator x: 57 y: 10)
				(gMessager say: 12 1 0 1 0 16) ; "Each area of the drum has a unique tone."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smallFemaleNote of Feature
	(properties
		x 193
		y 98
		noun 15
		modNum 16
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 178 97 193 97 198 109 183 109
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator x: 70 y: 15)
				(gMessager say: 15 1 0 1 0 16) ; "Each area of the drum has a unique tone."
			)
			(4 ; Do
				(if (& local24 $8000)
					(= [local0 (+ local25 1)] self)
					(if (not local27)
						(localproc_5 self)
					else
						(localproc_3 self)
					)
					(aNote number: 333 setLoop: 1)
					(if (== [local12 (++ local25)] self)
						(&= local24 (~ (<< $0001 local25)))
						(prep cue: (not local27))
					else
						(if local27
							(note8 show: 0)
						)
						(prep cue: 1)
					)
				else
					(aNote number: 338 setLoop: 1 play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mediumMaleNote of Feature
	(properties
		x 98
		y 116
		noun 14
		modNum 16
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 150 94 144 117 133 117 142 94
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator x: 70 y: 15)
				(gMessager say: 14 1 0 1 0 16) ; "Each area of the drum has a unique tone."
			)
			(4 ; Do
				(if (& local24 $8000)
					(= [local0 (+ local25 1)] self)
					(if (not local27)
						(localproc_5 self)
					else
						(localproc_3 self)
					)
					(aNote number: 334 setLoop: 1)
					(if (== [local12 (++ local25)] self)
						(&= local24 (~ (<< $0001 local25)))
						(prep cue: (not local27))
					else
						(if local27
							(note4 show: 0)
						)
						(prep cue: 1)
					)
				else
					(aNote number: 338 setLoop: 1 play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance largeMaleNote of Feature
	(properties
		x 129
		y 111
		noun 13
		modNum 16
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 130 110 119 139 105 139 122 110
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator x: 70 y: 15)
				(gMessager say: 13 1 0 1 0 16) ; "Each area of the drum has a unique tone."
			)
			(4 ; Do
				(if (& local24 $8000)
					(= [local0 (+ local25 1)] self)
					(if (not local27)
						(localproc_5 self)
					else
						(localproc_3 self)
					)
					(aNote number: 335 setLoop: 1)
					(if (== [local12 (++ local25)] self)
						(&= local24 (~ (<< $0001 local25)))
						(prep cue: (not local27))
					else
						(if local27
							(note2 show: 0)
						)
						(prep cue: 1)
					)
				else
					(aNote number: 338 setLoop: 1 play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smallMaleNote of Feature
	(properties
		x 133
		y 125
		noun 16
		modNum 16
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 141 124 139 141 124 141 131 124
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator x: 70 y: 15)
				(gMessager say: 16 1 0 1 0 16) ; "Each area of the drum has a unique tone."
			)
			(4 ; Do
				(if (& local24 $8000)
					(= [local0 (+ local25 1)] self)
					(if (not local27)
						(localproc_5 self)
					else
						(localproc_3 self)
					)
					(aNote number: 336 setLoop: 1)
					(if (== [local12 (++ local25)] self)
						(&= local24 (~ (<< $0001 local25)))
						(prep cue: (not local27))
					else
						(if local27
							(note1 show: 0)
						)
						(prep cue: 1)
					)
				else
					(aNote number: 338 setLoop: 1 play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance maleDrum of Feature
	(properties
		x 103
		y 91
		noun 3
		modNum 16
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 137 84 150 84 159 93 159 139 94 139 128 90
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(aNote number: 338 setLoop: 1 play:)
			)
			(1 ; Look
				(gNarrator x: 70 y: 15)
				(gMessager say: 3 1 0 1 0 16) ; "This drum complements the other one."
			)
		)
	)
)

(instance femaleDrum of Feature
	(properties
		x 167
		y 87
		noun 4
		modNum 16
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 177 85 193 86 229 140 166 140 166 92
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(aNote number: 338 setLoop: 1 play:)
			)
			(1 ; Look
				(gNarrator x: 90 y: 15)
				(gMessager say: 4 1 0 1 0 16) ; "This drum is part of a pair."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance batonHolder of Feature
	(properties
		x 85
		y 59
		z 30
		noun 11
		modNum 16
		nsTop 89
		nsLeft 93
		nsBottom 125
		nsRight 107
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator x: 90 y: 15)
				(gMessager say: 11 1 0 1 0 16) ; "This is where the baton is kept."
			)
			(4 ; Do
				(baton show:)
				(&= local24 $7fff)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aNote of Sound
	(properties)

	(method (play)
		(if (& local24 $8000)
			(gTheCursor view: 12 loop: 1 cel: 1 init:)
			(super play: &rest)
			(gTheCursor view: 12 loop: 1 cel: 0 init:)
		else
			(super play: &rest)
		)
	)
)

(instance iView of View
	(properties)

	(method (handleEvent)
		(return 0)
	)
)

