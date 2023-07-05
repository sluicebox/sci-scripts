;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 781)
(include sci.sh)
(use Main)
(use rgCastle)
(use n913)
(use Inset)
(use Conversation)
(use Scaler)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm781 0
)

(local
	local0
	local1
)

(instance rm781 of CastleRoom
	(properties
		noun 3
		picture 780
		style 10
		vanishingX 183
		vanishingY 98
	)

	(method (init)
		(LoadMany rsVIEW 787 785 786 724 726)
		(gEgo init: setPri: 13 setScale: Scaler 118 70 190 140)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -10 -10 329 -10 329 179 319 179 271 154 250 154 233 143 207 143 201 147 176 147 173 142 167 142 162 147 76 147 48 162 33 162 0 177 -10 177
					yourself:
				)
		)
		(gFeatures add: trunk box rug chandelier eachElementDo: #init)
		(door cel: (* (== gPrevRoomNum 850) 4) init: stopUpd: approachVerbs: 5) ; Do
		(super init: &rest)
		(trunkLid init:)
		(boxLid init:)
		(candles init:)
		(doorFrame1ATP addToPic:)
		(doorFrame2ATP addToPic:)
		(fireplaceATP addToPic:)
		(fireplace setCycle: Fwd init:)
		(wardrobeDoor init:)
		(bedATP addToPic:)
		(switch gPrevRoomNum
			(810
				(wardrobeDoor hide:)
				(self setScript: wardrobeEntrance)
			)
			(else
				(self setScript: hallDoorEntrance)
			)
		)
		(if (gEgo scaler:)
			((gEgo scaler:) doit:)
		)
		(if (not script)
			(gGame handsOn:)
		)
		(gGlobalSound fadeTo: 150 -1)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $4000)
				(gCurRoom newRoom: 850)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (gEgo has: 20) ; letter
					(gMessager say: noun theVerb 5) ; "Alexander is standing in an opulent bedroom that he believes--based on the contents of the trunk--must belong to the vizier. Knowing whose room it is makes Alexander feel even more ill-at-ease."
				else
					(gMessager say: noun theVerb 4) ; "Alexander is standing in a masculine bedroom. Polished marble walls rise to meet a tall ceiling, and the furnishings have an opulent feeling. He wonders whose bedroom this is."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (warnUser param1)
		(switch param1
			(2
				(if inset
					(script next: they_reBack)
					(inset dispose:)
				else
					(self setScript: they_reBack)
				)
			)
			(else
				(super warnUser: param1 &rest)
			)
		)
	)

	(method (dispose)
		(gEgo setPri: -1)
		(super dispose:)
	)
)

(instance hallDoorEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door cel: 4 forceUpd:)
				(gEgo
					setPri: -1
					posn: 306 157
					setMotion: MoveTo (door approachX:) (door approachY:) self
				)
			)
			(1
				(gEgo setPri: 13)
				(door setCycle: Beg self)
			)
			(2
				(gGlobalSound4 number: 902 loop: 1 play:)
				(door stopUpd:)
				(if ((ScriptID 80 0) tstFlag: #rFlag1 1) ; rgCastle
					((ScriptID 80 0) clrFlag: #rFlag1 1) ; rgCastle
					(= cycles 10)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(3
				(gCurRoom warnUser: 2)
			)
		)
	)
)

(instance openTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(not ((ScriptID 80 0) tstFlag: #rFlag3 4096)) ; rgCastle
						(OneOf register 64 35)
					)
					(gGame givePoints: 1)
				)
				(gEgo
					normal: 0
					view: 787
					loop: 0
					cel: 0
					cycleSpeed: 8
					setScale: 0
					scaleX: 128
					scaleY: 128
					posn: 151 154
					setCycle: CT 3 1 self
				)
			)
			(1
				(if ((ScriptID 80 0) tstFlag: #rFlag3 4096) ; rgCastle
					(if (OneOf register 64 35)
						(= state 4)
						(gMessager say: 4 35 14 0 self) ; "The trunk has already been unlocked."
					else
						(gMessager say: 4 5 14 0 self) ; "Alexander opens the unlocked trunk."
					)
				else
					(if (not (OneOf register 64 35))
						(= state 4)
					else
						(gGlobalSound4 number: 781 loop: 1 play:)
					)
					(gMessager say: 4 register 13 0 self)
				)
			)
			(2
				((ScriptID 80 0) setFlag: #rFlag3 4096) ; rgCastle
				(trunkLid hide:)
				(gGlobalSound4 number: 904 loop: 1 play:)
				(gEgo cel: 4 setCycle: End self)
			)
			(3
				(gGlobalSound4 stop:)
				(gGame handsOn:)
				(gTheIconBar disable: 0 3 4 5)
				(gTheIconBar disable: 0)
				(chestInset init: self gCurRoom)
			)
			(4
				(gGlobalSound4 number: 905 loop: 1 play:)
				(gEgo setCycle: CT 3 -1 self)
			)
			(5
				(trunkLid show:)
				(gGlobalSound4 stop:)
				(gEgo setCycle: Beg self)
			)
			(6
				(gGame handsOn:)
				(gEgo reset: 1 setPri: 13 posn: 171 148)
				(self dispose:)
			)
		)
	)
)

(instance openEbonyBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 14 5 0 0 self) ; "Alexander opens the ebony box and looks inside."
			)
			(1
				(gEgo
					normal: 0
					view: 787
					loop: 2
					cel: 0
					setScale: 0
					scaleX: 128
					scaleY: 128
					cycleSpeed: 8
					setCycle: CT 4 1 self
				)
			)
			(2
				(gTheIconBar disable: 0)
				(ebonyBoxInset init: self gCurRoom)
				(gGame handsOn:)
				(gTheIconBar disable: 0 3 4 5)
			)
			(3
				(gGame handsOff:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo
					reset: 6
					setPri: 13
					posn: (box approachX:) (box approachY:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wardrobeEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGlobalSound2 number: 783 loop: 1 play:)
				(gEgo
					normal: 0
					view: 785
					loop: 2
					cel: 9
					posn: 58 162
					cycleSpeed: 8
					setScale: 0
					scaleX: 128
					scaleY: 128
					setCycle: Beg self
				)
				(gGlobalSound4 number: 901 loop: 1 play:)
			)
			(1
				(gEgo loop: 1 cel: 5 setCycle: CT 2 -1 self)
			)
			(2
				(gEgo setCycle: Beg)
				(gGlobalSound4 number: 902 loop: 1 play:)
				(= ticks 60)
			)
			(3
				(gEgo
					posn: (wardrobeDoor approachX:) (wardrobeDoor approachY:)
					reset: 0
					setPri: 13
				)
				(wardrobeDoor show: stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance they_reBack of Script
	(properties
		name {they'reBack}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 0 3 1 self) ; "Alexander hears the sound of boots in the hallway. The guard dog patrol must have returned!"
			)
			(1
				(Face gEgo door self)
			)
			(2
				(gGlobalSound4 number: 901 loop: 1 play:)
				(door setCycle: CT 2 1 self)
			)
			(3
				(gGlobalSound4 stop:)
				(gMessager say: 1 0 3 2 self) ; "Wait a minute, Bay, while I check around in here like Captain...."
			)
			(4
				(gGlobalSound4 number: 901 loop: 1 play:)
				(door setCycle: End self)
			)
			(5
				(gGlobalSound4 stop:)
				((ScriptID 80 5) init: posn: 307 158 loop: 1) ; guard1
				((ScriptID 80 0) setupGuards:) ; rgCastle
				((ScriptID 80 5) setMotion: MoveTo 283 158 self) ; guard1
			)
			(6
				(gGlobalSound number: 710 loop: -1 play:)
				(gMessager say: 1 0 3 3 self oneOnly: 0) ; "HEY! There IS an intruder in the castle! Quick, Wolf!"
			)
			(7
				(gGlobalSound fade:)
				((ScriptID 80 0) setFlag: #rFlag1 8192) ; rgCastle
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance openWardrobe of Script
	(properties)

	(method (changeState newState)
		(if (not local1)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(wardrobeDoor hide:)
					(gEgo
						normal: 0
						view: 785
						setScale: 0
						scaleX: 128
						scaleY: 128
						loop: 1
						cel: 0
						posn: 58 162
						cycleSpeed: 8
						setCycle: CT 2 1 self
					)
				)
				(1
					(gGlobalSound2 number: 901 loop: 1 play:)
					(gEgo setCycle: End self)
				)
				(2
					(if (!= gPrevRoomNum 810)
						(gMessager say: 12 5 8 0 self) ; "The wardrobe is full of black cloaks and a rather sour smell. Alexander examines the clothes, but finds nothing of interest."
					else
						(+= state 2)
						(= cycles 1)
					)
				)
				(3
					(gEgo setCycle: CT 1 -1 self)
				)
				(4
					(= local1 1)
					(gEgo cel: 0)
					(gGlobalSound4 number: 902 loop: 1 play:)
					(= cycles 6)
				)
				(5
					(gGlobalSound2 number: 783 loop: 1 play:)
					(gEgo loop: 2 cel: 0 setCycle: CT 8 1 self)
				)
				(6
					(gEgo cel: 9)
					(gGlobalSound4 number: 902 loop: 1 play:)
					(= cycles 2)
				)
				(7
					(gMessager say: 12 5 9 0 self) ; "Alexander crawls back through the wardrobe to reach the secret passage."
				)
				(8
					(gCurRoom newRoom: 810)
				)
			)
		else
			(= local1 0)
			(gGame handsOn:)
			(wardrobeDoor show: stopUpd:)
			(gEgo
				posn: (wardrobeDoor approachX:) (wardrobeDoor approachY:)
				reset: 1
				setPri: 13
			)
			(self dispose:)
		)
	)
)

(instance door of Prop
	(properties
		x 298
		y 161
		noun 10
		sightAngle 40
		approachX 265
		approachY 157
		view 786
		loop 1
		priority 1
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gEgo setPri: -1)
				(gGlobalSound4 number: 901 loop: 1 play:)
				(self setCycle: End self)
			)
			(1 ; Look
				(if local0
					(gMessager say: noun theVerb 12) ; "Alexander peers through the keyhole."
					(gCurRoom setScript: (ScriptID 82) 0 hallScr) ; keyHoleScr
				else
					(++ local0)
					(|= _approachVerbs (gKq6ApproachCode doit: 1))
					(gMessager say: noun theVerb 11) ; "A door leads into the hall."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(gGlobalSound4 stop:)
		(proc80_2 2)
	)
)

(instance hallScr of Script
	(properties)

	(method (init)
		(if (= register (not ((ScriptID 80 0) tstFlag: #rFlag1 128))) ; rgCastle
			(tempGuard1
				view: ((ScriptID 80 6) view:) ; guard2
				posn: 192 126
				setSpeed: 8
				init:
			)
			(tempGuard2 posn: 200 128 setSpeed: 8 init:)
		)
		(super init: &rest)
		(client caller: self)
		((ScriptID 82 1) noun: 26 actions: keyHoleDoVerb init: 786 0 0 91 59) ; keyHoleView
	)

	(method (dispose)
		(if register
			(tempGuard1 dispose:)
			(tempGuard2 dispose:)
		)
		(super dispose:)
	)

	(method (cue)
		(if client
			(super cue: &rest)
		else
			(gEgo setPri: 13)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(if (< (tempGuard1 x:) 160)
						(tempGuard1 setMotion: MoveTo 192 126 self)
						(tempGuard2 setMotion: MoveTo 200 128)
					else
						((ScriptID 80 0) setFlag: #rFlag3 128) ; rgCastle
						(tempGuard1 setMotion: MoveTo 128 126 self)
						(tempGuard2 setMotion: MoveTo 120 128)
					)
				else
					(= cycles 4)
				)
			)
			(1
				(if register
					(if (< (tempGuard1 x:) 160)
						(= seconds 4)
					else
						(= seconds 10)
					)
				)
			)
			(2
				((ScriptID 80 0) clrFlag: #rFlag3 128) ; rgCastle
				(self changeState: 0)
			)
		)
	)
)

(instance keyHoleDoVerb of Actions
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 1)
		(switch theVerb
			(1 ; Look
				(if ((ScriptID 80 0) tstFlag: #rFlag1 128) ; rgCastle
					(gMessager say: 26 1 8) ; "Alexander sees no one in the hallway. The guard dogs are still gone."
				else
					(gMessager say: 26 1 9) ; "Two guard dogs are patrolling the hallway outside the bedroom."
				)
			)
			(else
				(= temp0 0)
			)
		)
		(return temp0)
	)
)

(instance tempGuard1 of Actor
	(properties
		noun 26
		sightAngle 180
		loop 4
		priority 14
		signal 16400
		scaleSignal 1
		scaleX 121
		scaleY 121
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Walk setStep: 4 2 actions: keyHoleDoVerb)
	)
)

(instance tempGuard2 of Actor
	(properties
		noun 26
		sightAngle 180
		view 724
		loop 4
		cel 1
		priority 14
		signal 16400
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Walk setStep: 4 2 actions: keyHoleDoVerb)
	)
)

(instance doorJam of View ; UNUSED
	(properties
		x 298
		y 161
		onMeCheck 0
		view 786
		loop 8
		cel 3
	)
)

(instance wardrobeDoor of Prop
	(properties
		x 40
		y 116
		noun 12
		approachX 55
		approachY 161
		view 785
		loop 3
		priority 12
		signal 16401
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gCurRoom setScript: openWardrobe)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance trunkLid of Prop
	(properties
		x 137
		y 134
		noun 4
		sightAngle 40
		approachX 166
		approachY 149
		view 787
		loop 3
		priority 12
		signal 20496
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 35 64) ; Do, skeletonKey, nail
	)

	(method (doVerb)
		(trunk doVerb: &rest)
	)
)

(instance boxLid of Prop
	(properties
		x 189
		y 127
		sightAngle 40
		onMeCheck 0
		view 787
		loop 4
		signal 20480
	)
)

(instance candles of Prop
	(properties
		x 165
		y 84
		noun 25
		view 785
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance doorFrame1ATP of View
	(properties
		x 298
		y 160
		onMeCheck 0
		view 786
		loop 8
		cel 2
		signal 20496
	)
)

(instance doorFrame2ATP of View
	(properties
		x 298
		y 160
		onMeCheck 0
		view 786
		loop 8
		cel 3
		signal 16384
	)
)

(instance bedATP of View
	(properties
		x 21
		y 100
		sightAngle 180
		view 786
		loop 8
		priority 12
		signal 20496
	)

	(method (onMe param1 &tmp temp0 temp1)
		(= temp0 (param1 x:))
		(= temp1 (param1 y:))
		(= approachY (= approachX (= _approachVerbs 0)))
		(return
			(and
				(super onMe: temp0 temp1)
				(-= temp0 nsLeft)
				(-= temp1 nsTop)
				(or
					(and
						(> temp0 41)
						(or
							(and
								(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
								(|= _approachVerbs (gKq6ApproachCode doit: 5))
								(= approachX 105)
								(= approachY 150)
							)
							1
						)
						(= noun 21)
					)
					(= noun 12)
				)
			)
		)
	)

	(method (doVerb)
		(if (== noun 12)
			(wardrobeDoor doVerb: &rest)
		else
			(super doVerb: &rest)
		)
	)
)

(instance fireplaceATP of View
	(properties
		x 224
		y 126
		view 786
		loop 8
		cel 1
		signal 20496
	)

	(method (onMe param1 &tmp temp0 temp1)
		(= temp0 (param1 x:))
		(= temp1 (param1 y:))
		(return
			(and
				(super onMe: temp0 temp1)
				(-= temp0 nsLeft)
				(-= temp1 nsTop)
				(or
					(and (<= 0 temp0 26) (<= 30 temp1 51) (= noun 20))
					(and (<= 63 temp0 98) (<= 44 temp1 60) (= noun 24))
					(= noun 23)
				)
			)
		)
	)
)

(instance fireplace of Prop
	(properties
		x 225
		y 117
		heading 180
		noun 23
		sightAngle 40
		view 786
		loop 9
		priority 1
		signal 16400
		cycleSpeed 8
		detailLevel 2
	)
)

(instance trunk of Feature
	(properties
		x 153
		y 145
		z 8
		noun 4
		nsTop 132
		nsLeft 138
		nsBottom 146
		nsRight 156
		sightAngle 40
		approachX 166
		approachY 149
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 35 64) ; Do, skeletonKey, nail
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 5 35 64) ; Do, skeletonKey, nail
				(gCurRoom setScript: openTrunk 0 theVerb)
			)
			((== (gKq6ApproachCode doit: theVerb) -32768)
				(switch theVerb
					(61 ; letter
						(super doVerb: theVerb)
					)
					(else
						(if ((ScriptID 80 0) tstFlag: #rFlag3 4096) ; rgCastle
							(gMessager say: noun 0 14) ; "There's no reason to use that on the unlocked trunk."
						else
							(gMessager say: noun 0 13) ; "Using that on the trunk will serve no purpose."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance box of Feature
	(properties
		x 191
		y 144
		z 19
		heading 180
		noun 14
		nsTop 122
		nsLeft 183
		nsBottom 128
		nsRight 199
		sightAngle 40
		approachX 179
		approachY 150
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: openEbonyBox)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rug of Feature
	(properties
		noun 22
		onMeCheck 2
	)
)

(instance chandelier of Feature
	(properties
		noun 25
		onMeCheck 4
	)
)

(instance chestInset of Inset
	(properties
		view 7861
		priority 13
		disposeNotOnMe 1
		noun 8
	)

	(method (init)
		(gTheIconBar disable: 6)
		(gEgo setPri: 0 stopUpd:)
		(= x (- 160 (/ (CelWide view loop cel) 2)))
		(= y (- 90 (/ (CelHigh view loop cel) 2)))
		(super init: &rest)
		(papers_ChestInset init: self)
		(books_ChestInset init: self)
		(vase_ChestInset init: self)
		(lid_ChestInset init: self)
	)

	(method (dispose)
		(gTheIconBar enable: 6)
		(if (== caller openTrunk)
			(gGame handsOff:)
		)
		(super dispose:)
		(gEgo setPri: 13 startUpd:)
	)
)

(instance ebonyBoxInset of Inset
	(properties
		view 7862
		disposeNotOnMe 1
		noun 15
	)

	(method (init)
		(gTheIconBar disable: 6)
		(gEgo stopUpd:)
		(= x (- 160 (/ (CelWide view loop cel) 2)))
		(= y (- 90 (/ (CelHigh view loop cel) 2)))
		(super init: &rest)
		(gGlobalSound4 number: 904 play:)
		(paper_BoxInset init: self)
		(pens_BoxInset init: self)
		(dice_BoxInset init: self)
		(lid_BoxInset cel: 1 init: self)
	)

	(method (dispose)
		(gTheIconBar enable: 6)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp [temp0 2])
		(cond
			((and inset (inset handleEvent: event)) 0)
			((& (event type:) evVERB)
				(cond
					((self onMe: event)
						(event claimed: 1)
						(self doVerb: (event message:))
					)
					(disposeNotOnMe
						(event claimed: 1)
						(lid_BoxInset doVerb: 5)
					)
					(else
						(return 0)
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager say: 14 theVerb) ; "The box has nothing to say."
			)
			(else
				(if (== (gKq6ApproachCode doit: theVerb) -32768)
					(gMessager say: 14) ; "Alexander doesn't want to put that in the ebony box."
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance letterInset of Inset
	(properties
		view 7863
		priority 15
		disposeNotOnMe 1
		noun 15
	)

	(method (init)
		(gTheIconBar disable: 6)
		(= x (- 160 (/ (CelWide view loop cel) 2)))
		(= y (- 100 (/ (CelHigh view loop cel) 2)))
		(super init: &rest)
	)

	(method (dispose)
		(gTheIconBar enable: 6)
		(super dispose:)
	)
)

(class InsetView of View
	(properties
		sightAngle 180
		priority 15
		signal 20497
		offsetX 0
		offsetY 0
	)

	(method (init param1)
		(= x (+ (param1 x:) offsetX))
		(= y (+ (param1 y:) offsetY))
		(super init: &rest)
		(self stopUpd:)
	)
)

(instance papers_ChestInset of InsetView
	(properties
		noun 5
		view 7861
		cel 1
		offsetX 64
		offsetY 50
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(if (gEgo has: 20) ; letter
					(= temp0 7)
				else
					(= temp0 6)
				)
				(gMessager say: noun theVerb temp0)
			)
			(5 ; Do
				(if (not (gEgo has: 20)) ; letter
					(gEgo get: 20) ; letter
					(gGame givePoints: 1)
					(openTrunk next: viewLetter)
					(chestInset dispose:)
				else
					(gMessager say: noun theVerb 7) ; "There's undoubtedly more unnerving information in those letters, but Alexander has already seen enough!"
				)
			)
			(61 ; letter
				(gMessager say: 4 61) ; "Alexander decides not to return the vizier's letter to the trunk. Who knows when such incriminating evidence might come in handy?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance viewLetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 5 5 6 1 self) ; "Alexander picks up the most recent letter and examines it."
			)
			(1
				(letterInset init: 0 gCurRoom)
				(= cycles 2)
			)
			(2
				(roomConv
					add: -1 5 5 6 2 ; "The letter is addressed to Abdul Alhazred from the Wizard Shadrack. It reads:"
					add: -1 5 5 6 3 ; "Greetings to a brother of the Black Cloak. I was sorry to hear of great Mordack's death, though he was a bit of a ninny at chess."
					add: -1 5 5 6 4 ; "It seems the plans for that little kingdom of yours are coming along. I must congratulate you on your handling of the king and queen. Isolating the islands so that no protest could develop was another brilliant stroke."
					add: -1 5 5 6 5 ; "It looks like there's not much left to stand in your way. Do as I recommended with the girl, and you shall have your crown."
					init: self
				)
			)
			(3
				(letterInset caller: self dispose:)
			)
			(4
				(= cycles 2)
			)
			(5
				(gMessager say: 5 5 6 6 self oneOnly: 0) ; "That fiend!"
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance books_ChestInset of InsetView
	(properties
		noun 6
		view 7861
		cel 2
		offsetX 81
		offsetY 42
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(papers_ChestInset doVerb: theVerb)
			)
			(61 ; letter
				(gMessager say: 4 61) ; "Alexander decides not to return the vizier's letter to the trunk. Who knows when such incriminating evidence might come in handy?"
			)
			(else
				(if (== (gKq6ApproachCode doit: theVerb) -32768)
					(gMessager say: 5) ; "Alexander doesn't want to leave that in the trunk."
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance vase_ChestInset of InsetView
	(properties
		noun 7
		view 7861
		cel 3
		offsetX 95
		offsetY 39
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(papers_ChestInset doVerb: theVerb)
			)
			(61 ; letter
				(gMessager say: 4 61) ; "Alexander decides not to return the vizier's letter to the trunk. Who knows when such incriminating evidence might come in handy?"
			)
			(else
				(if (== (gKq6ApproachCode doit: theVerb) -32768)
					(gMessager say: 5) ; "Alexander doesn't want to leave that in the trunk."
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance lid_ChestInset of InsetView
	(properties
		view 7861
		cel 4
		offsetX 75
		offsetY 6
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(chestInset dispose:)
		else
			(chestInset doVerb: theVerb)
		)
	)
)

(instance paper_BoxInset of InsetView
	(properties
		noun 19
		view 7862
		cel 1
		offsetX 68
		offsetY 39
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (not ((ScriptID 80 0) tstFlag: #rFlag1 64)) ; rgCastle
				(gGame givePoints: 1)
			)
			((ScriptID 80 0) setFlag: #rFlag1 64) ; rgCastle
		)
		(super doVerb: theVerb &rest)
	)
)

(instance pens_BoxInset of InsetView
	(properties
		noun 16
		view 7862
		cel 2
		offsetX 69
		offsetY 32
	)
)

(instance dice_BoxInset of InsetView
	(properties
		noun 17
		view 7862
		cel 3
		offsetX 98
		offsetY 35
	)

	(method (onMe param1 &tmp temp0 temp1)
		(= temp0 (param1 x:))
		(= temp1 (param1 y:))
		(return
			(and
				(super onMe: temp0 temp1)
				(-= temp0 nsLeft)
				(-= temp1 nsTop)
				(or (and (> temp0 17) (= noun 18)) (= noun 17))
			)
		)
	)
)

(instance lid_BoxInset of InsetView
	(properties
		view 7862
		loop 1
		cel 1
		offsetX 91
		offsetY 24
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self startUpd:)
				(= cel 0)
				(gGlobalSound4 number: 905 play:)
				(Animate (gCast elements:) 0)
				(Animate (gCast elements:) 0)
				(ebonyBoxInset dispose:)
			)
			(else
				(ebonyBoxInset doVerb: theVerb)
			)
		)
	)
)

(instance roomConv of Conversation
	(properties)
)

