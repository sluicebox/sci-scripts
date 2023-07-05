;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use GloryWindow)
(use OccasionalCycle)
(use GloryTalker)
(use Messager)
(use Talker)
(use IconBar)
(use LoadMany)
(use GameControls)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm340 0
	speakerTalker 1
	warriorTalker 2
	motherTalker 4
	haramiTalker 5
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0) ; UNUSED
	(yWarrior setCel: 2)
	(speaker setCel: 2)
	(mother setCel: 2)
	(youth setCel: 3)
	(kreesha setCel: 2)
	(priestess setCel: 3)
)

(procedure (localproc_1)
	(rajah init:)
	(yWarrior init:)
	(mother init:)
	(youth init:)
	(kreesha init:)
	(priestess init:)
	(warriorTail init: setCycle: OccasionalCycle self 1 70 180)
	(speaker init:)
	(speakerStuff init: setCycle: OccasionalCycle self 1 70 180)
)

(procedure (localproc_2 &tmp temp0 temp1)
	(= temp1 gTheCursor)
	(= temp0 (Message msgSIZE 340 11 60 51 1)) ; "Yes"
	(= local1 (Memory memALLOC_NONCRIT temp0))
	(Message msgGET 340 11 60 51 1 local1) ; "Yes"
	(= temp0 (Message msgSIZE 340 11 60 52 1)) ; "No"
	(= local2 (Memory memALLOC_NONCRIT temp0))
	(Message msgGET 340 11 60 52 1 local2) ; "No"
	(quest init: show: dispose:)
	(Memory memFREE local1)
	(Memory memFREE local2)
	(gGame setCursor: temp1)
)

(class Head of View
	(properties
		face 2
	)

	(method (init)
		(= face cel)
		(super init: &rest)
	)

	(method (back)
		(heads eachElementDo: #setCel (self face:))
		(Animate (heads elements:) 0)
	)

	(method (cue param1)
		(heads eachElementDo: #setCel param1)
		(Animate (heads elements:) 0)
	)
)

(instance myMessager of Messager
	(properties)

	(method (say param1)
		(switch param1
			(5
				(speaker cue: 0)
			)
			(8
				(priestess cue: 1)
			)
			(9
				(mother cue: 2)
			)
			(1
				(speaker cue: 3)
			)
			(7
				(kreesha cue: 5)
			)
			(4
				(yWarrior cue: 6)
			)
			(else
				(speaker back:)
			)
		)
		(gMessager say: param1 &rest)
	)
)

(instance heads of List
	(properties)
)

(instance rm340 of Rm
	(properties
		picture 340
	)

	(method (init)
		(HandsOff)
		(heads add: priestess mother speaker youth kreesha yWarrior init:)
		((Prop new:) view: 340 loop: 0 cel: 1 x: 103 y: 41 init: setCycle: Fwd)
		((Prop new:) view: 340 loop: 0 cel: 1 x: 210 y: 41 init: setCycle: Fwd)
		(cond
			((or (== gPrevRoomNum 230) (== gPrevRoomNum 240))
				(SetFlag 36)
				(localproc_1)
				(gEgo
					view: 5
					loop: 6
					yStep: 2
					x: 28
					y: 240
					init:
					setCycle: Walk
					setScale: 175
				)
				(localHarami init: setScale: 175)
				(super init: &rest)
				(self setScript: doEvent1)
			)
			((and (== gPrevRoomNum 310) (not (IsFlag 12)))
				(gLongSong setLoop: -1 number: 340 play: 127)
				(SetFlag 35)
				(localproc_1)
				(rajah init: stopUpd:)
				((ScriptID 35 1) loop: 3 x: 162 y: 165 init: setScale: 175) ; Rakeesh
				(gEgo x: 185 y: 169 loop: 3 init: setScale: 175 normalize:)
				(super init: &rest)
				(self setScript: doEvent2)
			)
			(else
				(gLongSong setLoop: -1 number: 340 play: 127)
				(localproc_1)
				((ScriptID 35 1) ; Rakeesh
					x: 30
					y: 213
					loop: 3
					init:
					setScale: 175
					addToPic:
				)
				(gEgo
					x: 50
					y: 223
					setCel: 0
					loop: 3
					yStep: 4
					init:
					normalize:
					setScale: 175
					solvePuzzle: 252 20
				)
				(leopardman init: stopUpd:)
				(simbani init: stopUpd:)
				(yesufU init: setScale: 175)
				(super init: &rest)
				(self setScript: doEvent3)
			)
		)
	)

	(method (dispose)
		(LoadMany 0 35 42 48 49)
		(heads dispose:)
		(super dispose:)
	)
)

(instance doEvent1 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (!= gEgoGait 0) ; walking
					(gEgo changeGait: 0 0) ; walking
				)
				(= cycles 10)
			)
			(1
				(gMessager say: 3 6 1 0 self) ; "You are led by the guard to the Hall of Judgement to attend the judgement of the thief."
			)
			(2
				(myMessager say: 1 6 1 0 rajah)
			)
			(3
				(myMessager say: 2 6 3 0 rajah)
			)
			(4
				(myMessager say: 1 6 4 0 rajah)
			)
			(5
				(localHarami
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo (localHarami x:) 215 self
				)
			)
			(6
				(localHarami dispose:)
				(myMessager say: 1 6 5 0 rajah)
			)
			(7
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 35) self
				)
			)
			(8
				(gEgo normalize:)
				(= seconds 1)
			)
			(9
				(gEgo posn: 150 260 setMotion: MoveTo 150 180 self)
			)
			(10
				(= temp0 0)
				(cond
					((IsFlag 24)
						(= temp0 1)
					)
					((and (IsFlag 25) (not (IsFlag 28)))
						(gCurRoom setScript: thiefSolution)
					)
					((or (IsFlag 27) (IsFlag 26))
						(gCurRoom setScript: magicSolution)
					)
					((IsFlag 23)
						(gCurRoom setScript: chaseHarami)
					)
					(else
						(myMessager say: 1 6 32 0 rajah)
					)
				)
				(if temp0
					(gCurRoom setScript: doEvent1Alt self)
				)
			)
			(11
				(myMessager say: 5 6 9 0 rajah)
			)
			(12
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance chaseHarami of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myMessager say: 4 6 7 0 rajah)
			)
			(1
				(myMessager say: 1 6 8 0 rajah)
			)
			(2
				(myMessager say: 5 6 9 0 rajah)
			)
			(3
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance thiefSolution of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myMessager say: 4 6 27 0 rajah)
			)
			(1
				(myMessager say: 1 6 28 0 rajah)
			)
			(2
				(myMessager say: 8 6 29 0 rajah)
			)
			(3
				(myMessager say: 1 6 30 0 rajah)
			)
			(4
				(myMessager say: 5 6 31 0 rajah)
			)
			(5
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance magicSolution of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myMessager say: 4 6 16 0 rajah)
			)
			(1
				(myMessager say: 1 6 17 0 rajah)
			)
			(2
				(myMessager say: 7 6 18 0 rajah)
			)
			(3
				(if (IsFlag 28)
					(gMessager say: 4 6 26 0 rajah) ; "The Prince of Shapeir did use his magic to prevent the escape of the honorless one, thus aiding my guards."
				else
					(gCurRoom setScript: solution2)
				)
			)
			(4
				(gCurRoom setScript: forbidden)
			)
		)
	)
)

(instance solution2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 27)
					(gMessager say: 4 6 26 0 rajah) ; "The Prince of Shapeir did use his magic to prevent the escape of the honorless one, thus aiding my guards."
				else
					(myMessager say: 4 6 19 0 rajah)
				)
			)
			(1
				(if (IsFlag 27)
					(gCurRoom setScript: forbidden)
				else
					(myMessager say: 8 6 19 0 rajah)
				)
			)
			(2
				(myMessager say: 1 6 19 0 rajah)
			)
			(3
				(gCurRoom setScript: forbidden)
			)
		)
	)
)

(instance forbidden of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myMessager say: 1 6 20 0 rajah)
			)
			(1
				(myMessager say: 7 6 21 0 rajah)
			)
			(2
				(myMessager say: 1 6 22 0 rajah)
			)
			(3
				(gMessager say: 3 6 23 0 self) ; "You agree, having no real choice other than banishment."
			)
			(4
				(myMessager say: 1 6 24 0 rajah)
			)
			(5
				(myMessager say: 5 6 31 0 rajah)
			)
			(6
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance doEvent1Alt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myMessager say: 4 6 10 0 rajah)
				((ScriptID 35 1) loop: 3 x: 180 y: 280 init: setScale: 175) ; Rakeesh
			)
			(1
				(myMessager say: 1 6 11 0 rajah)
			)
			(2
				(myMessager say: 6 6 12 0 rajah)
			)
			(3
				((ScriptID 35 1) setCycle: Walk setMotion: MoveTo 190 185 self) ; Rakeesh
			)
			(4
				(myMessager say: 1 6 13 0 rajah)
			)
			(5
				(myMessager say: 5 6 14 0 rajah)
			)
			(6
				(myMessager say: 6 6 15 0 rajah)
			)
			(7
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance doEvent2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 6)
				(= cycles 10)
			)
			(1
				(myMessager say: 1 6 33 0 rajah)
			)
			(2
				(myMessager say: 4 6 34 0 rajah)
			)
			(3
				(myMessager say: 8 6 35 0 rajah)
			)
			(4
				(myMessager say: 9 6 36 0 rajah)
			)
			(5
				(myMessager say: 4 6 37 0 rajah)
			)
			(6
				(myMessager say: 6 6 38 0 rajah)
			)
			(7
				(myMessager say: 7 6 38 0 rajah)
			)
			(8
				(myMessager say: 6 6 39 0 rajah)
			)
			(9
				(myMessager say: 1 6 40 0 rajah)
			)
			(10
				(localproc_2)
				(if local0
					(gEgo addHonor: 40 solvePuzzle: 251 5 8)
				else
					(gEgo addHonor: -100)
					(SetFlag 19)
				)
				(= cycles 1)
			)
			(11
				(myMessager say: 1 6 41 0 rajah)
			)
			(12
				(myMessager say: 5 6 42 0 rajah)
			)
			(13
				(SetFlag 48)
				(SetFlag 6)
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance doEvent3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(yesufU setScale:)
				((ScriptID 35 1) setScale:) ; Rakeesh
				(= cycles 10)
			)
			(1
				(gMessager say: 3 6 43 0 self) ; "You have been watching the conference for some time as they introduce everyone. It has been rather boring."
				(yesufU stopUpd:)
			)
			(2
				(myMessager say: 1 6 44 0 rajah)
			)
			(3
				(myMessager say: 10 6 45 0 rajah)
			)
			(4
				(simbani startUpd: loop: 0 setCel: 0 setCycle: End self)
			)
			(5
				(if (IsFlag 150)
					(gMessager say: 3 6 46 0 self) ; "You begin to sense danger."
				else
					(= cycles 1)
				)
			)
			(6
				(myMessager say: 6 6 47 0 rajah)
			)
			(7
				(leopardman startUpd: loop: 0 setCel: 0 setCycle: End self)
			)
			(8
				(= seconds 1)
			)
			(9
				(leopardman loop: 1 setCel: 0 setCycle: End self)
				(gLongSong2 number: 900 play: 127)
			)
			(10
				(leopardman setCel: 0)
				(yesufU forceUpd:)
				(= cycles 1)
			)
			(11
				(simbani loop: 1 setCel: 0 setCycle: End self)
			)
			(12
				(yesufU view: 984 setLoop: 3 setCel: 0 setCycle: End self)
				(gLongSong2 number: 916 play: 127)
				(simbani stopUpd:)
			)
			(13
				(leopardman setLoop: 2 setCel: 0 setCycle: End self)
				(gLongSong2 number: 920 play: 127)
				(yesufU stopUpd:)
			)
			(14
				(leopardman setLoop: 3 setCel: 0 setCycle: End self)
			)
			(15
				(= seconds 2)
			)
			(16
				(leopardman setLoop: 4 setCel: 0 setCycle: End self)
				(gLongSong2 number: 918 play: 127)
			)
			(17
				(myMessager say: 6 6 48 0 self)
			)
			(18
				(rajah startUpd: setCycle: End self)
				(leopardman stopUpd:)
			)
			(19
				(gMessager say: 5 6 49 0 self) ; "King Rajah is furious at these actions! This is terrible!"
				(rajah stopUpd:)
			)
			(20
				(gMessager say: 6 6 50 0 self) ; "My friend, you must leave Tarna immediately before Rajah declares a state of war and the gates of Tarna are shut. Seek out the Demons in the Lost City and I will join you if I can. Go quickly!"
			)
			(21
				(gEgo
					view: 1
					setLoop: 4
					setCycle: Walk
					setMotion:
						MoveTo
						(+ (gEgo x:) 5)
						(+ (gEgo y:) 10)
						self
				)
			)
			(22
				(SetFlag 43)
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance rajah of Prop
	(properties
		x 160
		y 79
		view 334
	)

	(method (cue)
		(speaker back:)
		(gCurRoom cue:)
	)
)

(instance localHarami of Actor
	(properties
		x 162
		y 152
		view 950
		loop 3
		signal 16384
	)
)

(instance leopardman of Prop
	(properties
		x 123
		y 165
		view 346
		loop 1
		signal 16384
	)
)

(instance simbani of Prop
	(properties
		x 196
		y 169
		view 347
	)
)

(instance yesufU of Prop
	(properties
		x 261
		y 189
		view 980
		loop 4
		cel 3
	)
)

(instance yWarrior of Head
	(properties
		x 240
		y 131
		view 335
		loop 1
		cel 1
		priority 15
		signal 16
	)
)

(instance warriorTail of Prop
	(properties
		x 273
		y 145
		view 335
	)
)

(instance speaker of Head
	(properties
		x 140
		y 91
		view 337
		loop 1
		cel 5
	)
)

(instance speakerStuff of Prop
	(properties
		x 146
		y 89
		view 337
		cel 4
	)
)

(instance mother of Head
	(properties
		x 117
		y 107
		view 341
		cel 1
	)
)

(instance youth of Head
	(properties
		x 184
		y 94
		view 344
		cel 1
	)
)

(instance kreesha of Head
	(properties
		x 202
		y 107
		view 348
		cel 1
		priority 14
		signal 16
	)
)

(instance priestess of Head
	(properties
		x 75
		y 131
		view 357
		cel 5
		priority 14
		signal 16
	)
)

(instance haramiTalker of GloryTalker
	(properties
		x 200
		y 2
		view 951
		loop 1
		talkWidth 260
		back 57
		textX -175
		textY 150
		backColor 26
	)

	(method (init)
		(super init: haramiBust haramiEyes haramiMouth &rest)
	)
)

(instance haramiMouth of Prop
	(properties
		nsTop 45
		nsLeft 26
		view 951
	)
)

(instance haramiEyes of Prop
	(properties
		nsTop 30
		nsLeft 24
		view 951
		loop 2
	)
)

(instance haramiBust of View
	(properties
		nsTop 20
		nsLeft 23
		view 951
		loop 3
	)
)

(instance speakerTalker of GloryTalker
	(properties
		x 5
		y 2
		view 338
		loop 1
		talkWidth 260
		back 57
		textX 20
		textY 150
		backColor 50
	)

	(method (init)
		(super init: speakerBust speakerEyes speakerMouth &rest)
	)
)

(instance speakerMouth of Prop
	(properties
		nsTop 47
		nsLeft 31
		view 338
	)
)

(instance speakerEyes of Prop
	(properties
		nsTop 38
		nsLeft 34
		view 338
		loop 2
	)
)

(instance speakerBust of View
	(properties
		nsTop 28
		nsLeft 33
		view 338
		loop 3
	)
)

(instance warriorTalker of GloryTalker
	(properties
		x 5
		y 2
		view 336
		loop 1
		talkWidth 260
		back 57
		textX 20
		textY 150
		backColor 9
	)

	(method (init)
		(super init: warriorBust warriorEyes warriorMouth &rest)
	)
)

(instance warriorMouth of Prop
	(properties
		nsTop 57
		nsLeft 46
		view 336
	)
)

(instance warriorEyes of Prop
	(properties
		nsTop 40
		nsLeft 44
		view 336
		loop 2
	)
)

(instance warriorBust of View
	(properties
		nsTop 28
		nsLeft 48
		view 336
		loop 3
	)
)

(instance motherTalker of Narrator
	(properties
		back 57
	)
)

(instance quest of GameControls
	(properties)

	(method (init)
		(gGame setCursor: 999)
		((= window (GloryWindow new:))
			top: 60
			left: (proc0_21 70 70 70 70 95)
			bottom: 105
			right: (proc0_21 250 250 250 250 225)
			priority: 15
			yourself:
		)
		(self add: titleIcon yesIcon noIcon)
		(super init: &rest)
	)
)

(instance titleIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 0
		signal 4
		maskView 361
		maskLoop 3
	)

	(method (show &tmp [temp0 20])
		(Message msgGET 340 11 60 53 1 @temp0) ; "Swear the Oath?"
		(Display @temp0 dsCOORD 5 3 dsCOLOR 17)
	)
)

(instance yesIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 15
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local0 1)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display local1 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display local1 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance noIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 30
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local0 0)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display local2 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display local2 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

