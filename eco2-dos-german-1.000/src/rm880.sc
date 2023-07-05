;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 880)
(include sci.sh)
(use Main)
(use eRS)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm880 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(= temp0 (CelWide (param1 view:) 1 0))
	(= temp1 (CelHigh (param1 view:) 1 0))
	(param1
		x: (- 319 (+ temp0 5))
		y: (- 189 (+ temp1 5))
		textX: (- (+ (param1 talkWidth:) (param1 textSpacer:)))
		textY: 40
	)
)

(instance rm880 of Eco2Room
	(properties
		noun 16
		picture 880
		style 100
	)

	(method (init)
		(gGameSound1 number: 95 loop: -1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 52 151 9 151 50 176 88 189 196 189 232 181 287 168 294 158 288 154 278 155 262 164 242 167 219 171 211 171 199 180 189 181 181 176 174 169 144 169 126 172 87 166 77 162 58 163 51 156
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 135 177 155 177 163 174 179 179 164 184 157 187 137 187 128 184 126 180
					yourself:
				)
		)
		(shaman init:)
		(chief init:)
		(boy init:)
		(ground init:)
		(weaver init: setScript: weaverScript)
		(weavFeat init:)
		(potFeat init:)
		(Palette palSET_INTENSITY 0 255 0)
		(super init:)
		(gEgo
			posn: 87 180
			init:
			normalize: 0 4
			actions: egoActions
			setScale: 0
		)
		((ScriptID 1069) setupTalker: 2) ; Shaman
		(self setScript: enterScript)
	)

	(method (newRoom newRoomNumber)
		(gGameSound1 fade:)
		(gGameSound2 fade:)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(DisposeScript 938)
		(super dispose:)
	)
)

(instance treeATP of View
	(properties)
)

(instance plant of Prop
	(properties
		x 145
		y 183
		view 882
	)
)

(instance ground of Prop
	(properties
		x 147
		y 189
		view 881
		loop 3
		priority 1
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 51) ; seedling
			(gGame handsOff:)
			(shaman setScript: 0)
			(gCurRoom setScript: plantScript)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance chief of Actor
	(properties
		x 137
		y 92
		noun 7
		view 880
		loop 6
		detailLevel 3
	)
)

(instance weaver of Prop
	(properties
		x 44
		y 107
		z -40
		view 881
		loop 4
		cycleSpeed 10
		detailLevel 3
	)
)

(instance potFeat of Feature
	(properties
		x 17
		y 127
		noun 6
		nsTop 109
		nsLeft 8
		nsBottom 145
		nsRight 27
		sightAngle 40
	)
)

(instance weavFeat of Feature
	(properties
		x 38
		y 128
		noun 5
		nsTop 112
		nsLeft 30
		nsBottom 144
		nsRight 47
		sightAngle 40
	)
)

(instance shaman of Actor
	(properties
		x 189
		y 172
		noun 4
		view 880
		loop 3
		signal 16384
		detailLevel 3
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 2) (not (gEgo has: 19))) ; Talk
			(gMessager say: noun theVerb 3 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance boy of Actor
	(properties
		x 165
		y 178
		noun 8
		view 880
		loop 4
		signal 16384
		detailLevel 3
	)
)

(instance light1 of Prop
	(properties
		x 19
		y 9
		view 886
		signal 16384
	)
)

(instance light2 of Prop
	(properties
		x 64
		y 9
		view 886
		loop 1
		signal 16384
	)
)

(instance light3 of Prop
	(properties
		x 4
		y 9
		view 886
		loop 2
		signal 16384
	)
)

(instance paq of Actor
	(properties
		x 325
		y 50
		yStep 10
		view 50
		signal 24576
		xStep 10
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 2 1) ; Do, Talk, Look
			(gGame handsOff:)
			(paq setScript: 0)
			(gCurRoom setScript: babyScript)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance spark0 of Prop
	(properties
		x 47
		y 64
		view 887
		loop 3
	)
)

(instance spark1 of Prop
	(properties
		x 40
		y 70
		view 887
		loop 4
	)
)

(instance spark2 of Prop
	(properties
		x 85
		y 62
		view 887
		loop 5
	)
)

(instance spark3 of Prop
	(properties
		x 110
		y 45
		view 887
		loop 6
	)
)

(instance spark4 of Prop
	(properties
		x 88
		y 107
		view 887
		loop 7
	)
)

(instance spark5 of Prop
	(properties
		x 42
		y 20
		view 887
		loop 8
	)
)

(instance spark6 of Prop
	(properties
		x 54
		y 46
		view 887
		loop 9
	)
)

(instance spark7 of Prop
	(properties
		x 119
		y 67
		view 887
		loop 10
		cel 1
	)
)

(instance spark8 of Prop
	(properties
		x 54
		y 51
		view 887
		loop 11
	)
)

(instance spark9 of Prop
	(properties
		x 116
		y 53
		view 887
		loop 12
	)
)

(instance spark10 of Prop
	(properties
		x 68
		y 36
		view 887
		loop 12
	)
)

(instance spark11 of Prop
	(properties
		x 126
		y 70
		view 887
		loop 14
		cel 1
	)
)

(instance spark12 of Prop
	(properties
		x 57
		y 105
		view 887
		loop 15
	)
)

(instance paqInset of Prop
	(properties
		x 10
		y 10
		view 883
		priority 10
		signal 16
	)
)

(instance paqEyes of Prop
	(properties
		view 883
		loop 4
		priority 14
		signal 16
	)
)

(instance babyEyes of Prop
	(properties
		view 883
		loop 1
		priority 14
		signal 16
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 45) ; whistle
				(return 0)
			)
			((not local0)
				(gMessager say: 9 0 6 1) ; "It's not the right time to blow the whistle."
				(return 1)
			)
			(local1
				(return 0)
			)
			(else
				(gGame handsOff:)
				(shaman setScript: 0)
				(gCurRoom setScript: whistleScript)
				(return 1)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 1)
				(= local3 71)
				(= local4 10)
				(self setScript: palScript self 0)
			)
			(1
				(= seconds 3)
			)
			(2
				(gMessager say: 16 0 1 0 self) ; "Oh, Sinchi! The village!"
			)
			(3
				(shaman setScript: timeScript 0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance timeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(switch register
					(0
						(gMessager say: 16 0 2 0 self) ; "It is time for Forest Heart's life to begin again. Plant the seedling with Taquia!"
					)
					(1
						(gMessager say: 16 0 5 0 self) ; "I feel Paquita is very near. And there is more, but I will not tell you."
					)
					(2
						(gMessager say: 9 0 8 0 self) ; "Come look! It is a little surprise! (GIGGLES)"
					)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance audioTest of Sound
	(properties
		number 883
	)
)

(instance plantScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 122 182 self)
			)
			(1
				(gGame points: 25)
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo view: 881 setLoop: 0 cel: 0 setCycle: End self)
				(boy view: 881 setLoop: 8 cel: 0 setCycle: End self)
				(gGameSound1 number: 882 loop: -1 play: hold: 1)
			)
			(3 0)
			(4
				(plant init:)
				(gEgo
					setLoop: 1
					cel: 0
					posn: (+ (gEgo x:) 16) (+ (gEgo y:) 2)
					setCycle: Fwd
				)
				(boy setCycle: ROsc -1 4 7)
				(ground cycleSpeed: 30 setCycle: End self)
			)
			(5
				(gEgo
					setLoop: 2
					posn: (- (gEgo x:) 16) (- (gEgo y:) 2)
					cel: 0
					setCycle: End self
				)
				(boy setCycle: Beg self)
				(weaver setScript: 0 setCycle: Beg)
			)
			(6 0)
			(7
				(= local2 1)
				(= local3 101)
				(= local4 1)
				(self setScript: palScript self 71)
			)
			(8
				(gGameSound1 release:)
				(light1 init: setCycle: End self)
				(light2 init: setCycle: End self)
				(light3 init: setCycle: End self)
			)
			(9 0)
			(10 0)
			(11
				(light1 addToPic:)
				(light2 addToPic:)
				(light3 addToPic:)
				(spark0 init: setCycle: Fwd)
				(spark1 init: setCycle: Fwd)
				(spark2 init: setCycle: Fwd)
				(spark3 init: setCycle: Fwd)
				(spark4 init: setCycle: Fwd)
				(spark5 init: setCycle: Fwd)
				(spark6 init: setCycle: Fwd)
				(spark7 init: setCycle: Fwd)
				(spark8 init: setCycle: Fwd)
				(spark9 init: setCycle: Fwd)
				(spark10 init: setCycle: Fwd)
				(spark11 init: setCycle: Fwd)
				(spark12 init: setCycle: Fwd)
				(plant
					view: 882
					setLoop: 0
					cel: 0
					cycleSpeed: 20
					setCycle: End self
				)
			)
			(12
				(boy view: 882 setLoop: 4 cel: 0 setCycle: End self)
			)
			(13
				(weaver view: 882 setLoop: 2 setCycle: End self)
				(chief cel: 1)
			)
			(14
				(= seconds 2)
			)
			(15
				(shaman view: 882 setLoop: 3 cel: 0 setCycle: End self)
				(gGameSound1 number: 884 loop: -1 play:)
			)
			(16
				(audioTest play:)
				(gMessager say: 16 0 3 1 self) ; "Forest Heart begins again! It is done!"
			)
			(17
				(shaman setCycle: Beg self)
			)
			(18
				(gMessager say: 16 0 3 2 self) ; "The cloth of life is mended!"
			)
			(19
				(gMessager say: 16 0 3 3 self) ; "We take up our work again!"
			)
			(20
				(gMessager say: 16 0 3 4 self) ; "We will care for this new Forest Heart as our ancestors have done from the beginning."
			)
			(21
				(gMessager say: 16 0 3 5 self) ; "Perhaps one day my children will see her bloom!"
			)
			(22
				(gEgo put: 19 normalize: 0 0)
				(= seconds 2)
			)
			(23
				(gTheIconBar disable:)
				(= local2 -1)
				(= local3 -1)
				(= local4 10)
				(self setScript: palScript self 100)
			)
			(24
				(spark0 dispose:)
				(spark1 dispose:)
				(spark2 dispose:)
				(spark3 dispose:)
				(spark4 dispose:)
				(spark5 dispose:)
				(spark6 dispose:)
				(spark7 dispose:)
				(spark8 dispose:)
				(spark9 dispose:)
				(spark10 dispose:)
				(spark11 dispose:)
				(spark12 dispose:)
				(weaver dispose:)
				(chief dispose:)
				(boy dispose:)
				(weavFeat dispose:)
				(potFeat dispose:)
				(= cycles 1)
			)
			(25
				(gCurRoom drawPic: 880 100)
				(ground
					view: 885
					loop: 5
					cel: 0
					x: 147
					y: 189
					ignoreActors: 1
					addToPic:
				)
				(treeATP
					view: 885
					loop: 3
					cel: 0
					x: 131
					y: 133
					ignoreActors: 1
					setPri: 14
					noun: 11
					addToPic:
					yourself:
				)
				(plant view: 885 loop: 2 cel: 0 setPri: 14 x: 140 y: 136)
				(gEgo x: (- (gEgo x:) 30))
				(= local2 1)
				(= local3 101)
				(= local4 10)
				(self setScript: palScript self 0)
			)
			(26
				(gTheIconBar enable:)
				(gGameSound1 number: 885 loop: -1 play:)
				(= cycles 10)
			)
			(27
				(gMessager say: 16 0 4 0 self) ; "I cannot stay, Sinchi. I think it's time for me to find my Dad."
			)
			(28
				(= local0 1)
				(shaman setScript: timeScript 0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance palScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette palSET_INTENSITY 1 255 register)
				(= ticks 1)
			)
			(1
				(+= register (* local4 local2))
				(if
					(or
						(and (== local2 1) (>= register local3))
						(and (== local2 -1) (<= register local3))
					)
					(self dispose:)
				else
					(self init:)
				)
			)
		)
	)
)

(instance whistleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 5)
				(if (!= (gEgo heading:) 90)
					(gEgo setHeading: 90 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo view: 3 setLoop: 7 cel: 0 setCycle: End self)
			)
			(2
				(= cycles 10)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gGameSound1 number: 886 loop: -1 play: hold: 1)
				(gEgo normalize: 0 0)
				(= seconds 7)
			)
			(5
				(paq
					init:
					setLoop: -1
					scaleSignal: 1
					scaleX: 79
					scaleY: 79
					setCycle: Fwd
					setStep: 10 10
					setMotion: MoveTo 159 107 self
				)
			)
			(6
				(paq
					view: 885
					setLoop: 0
					cel: 0
					scaleSignal: 0
					scaleX: 128
					scaleY: 128
					posn: 148 128
					setCycle: CT 2 1 self
				)
			)
			(7
				(gGameSound1 loop: -1 release:)
				(plant setCycle: End self)
				(paq setCycle: End self)
			)
			(8 0)
			(9
				(gMessager say: 9 0 7 0 self) ; "Oh, Adam, I hoped you would not leave until I could show you my surprise. Look under my wing!"
			)
			(10
				(paq setScript: timeScript 0 2)
				(= local1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance babyScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame points: 10)
				(paqInset init:)
				(= temp0 (paqInset x:))
				(= temp1 (paqInset y:))
				(paqEyes
					init:
					posn: (+ temp0 87) (+ temp1 29)
					setScript: paqEyeScript
				)
				(babyEyes
					init:
					posn: (+ temp0 42) (+ temp1 40)
					setScript: babyEyeScript
				)
				((ScriptID 1009) setupTalker: 6) ; EgoTalker
				(localproc_0 (ScriptID 1069)) ; Shaman
				(= seconds 7)
			)
			(1
				(gMessager say: 16 0 9 0 self) ; "Wow, a baby!"
			)
			(2
				(paqEyes dispose:)
				(babyEyes dispose:)
				((ScriptID 1009) setupTalker: 8) ; EgoTalker
				((ScriptID 1069) setupTalker: 2) ; Shaman
				(= seconds 2)
			)
			(3
				(paqInset dispose:)
				(= seconds 2)
			)
			(4
				(gMessager say: 16 0 10 0 self) ; "I wish I could see him grow up, Paquita."
			)
			(5
				(= seconds 2)
			)
			(6
				(= local2 -1)
				(= local3 -1)
				(= local4 10)
				(self setScript: palScript self 100)
			)
			(7
				(= seconds 2)
			)
			(8
				(gCurRoom newRoom: 890)
			)
		)
	)
)

(instance paqEyeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 1)
				(= cycles 2)
			)
			(1
				(client cel: 0)
				(= seconds (Random 3 5))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance babyEyeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0)
				(= seconds (Random 2 4))
			)
			(1
				(client cel: 1)
				(= cycles 2)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance weaverScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(weaver setCycle: End self)
			)
			(2
				(weaver setCycle: Beg self)
			)
			(3
				(self init:)
			)
		)
	)
)

