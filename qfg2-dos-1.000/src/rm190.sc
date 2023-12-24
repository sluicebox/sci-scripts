;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use Interface)
(use LoadMany)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm190 0
)

(local
	whichElem
	Now
	honorGain
	enchTime
	morning
	evening
	[str 100]
)

(procedure (AzizaPrint &tmp aR aL) ; UNUSED
	(= aR (BotWindow brRight:))
	(= aL (BotWindow brLeft:))
	(BotWindow color: 13 back: 0)
	(Print
		&rest
		#font
		gUserFont
		#title
		{Aziza:}
		#window
		BotWindow
		#width
		(- aR (+ aL 16))
	)
)

(procedure (EgoPrint &tmp aR aL [aT 20])
	(= aR (BotWindow brRight:))
	(= aL (BotWindow brLeft:))
	(Format @aT {%s:} @gUserName)
	(BotWindow color: 9 back: 15)
	(Print
		&rest
		#font
		gUserFont
		#title
		@aT
		#window
		BotWindow
		#width
		(- aR (+ aL 16))
	)
)

(instance rm190 of Rm
	(properties
		picture 190
		style 8
	)

	(method (init)
		(LoadMany rsVIEW 0 190 192 193 183)
		(LoadMany rsTEXT 191)
		(closeupSound init: play:)
		(if (< (= enchTime gTimeODay) 2)
			(= morning 1)
		)
		(if (or (== enchTime 4) (== enchTime 5))
			(= evening 1)
		)
		(= Now (+ (* gDay 100) enchTime))
		(super init:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(gGame setCursor: gNormalCursor (HaveMouse))
		(gEgo view: 192 loop: 0 posn: 96 167 init:)
		(InitAddToPics azizaBody)
		(if (== gDay 16)
			(saurusHead stopUpd: init:)
			(clawLeft init:)
			(clawRight init:)
			(saurusTail init:)
			(InitAddToPics saurusBody)
		)
		(azizaVoice init: hide:)
		(azizaArm init:)
		(switch gCloseUpSubject
			(-1
				(self setScript: lookAtSaurus self)
			)
			(0
				(self setScript: fireElem self)
			)
			(1
				(self setScript: waterElem self)
			)
			(3
				(self setScript: airElem self)
			)
			(2
				(self setScript: earthElem self)
			)
			(4
				(self setScript: allElem self)
			)
			(5
				(SolvePuzzle 612 7)
				(self setScript: talkAboutPlant self)
			)
			(else
				(Say azizaVoice self 190 0) ; "The portents are clouded. There is nothing I can show you."
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(closeupSound stop: dispose:)
		(super dispose:)
	)

	(method (cue)
		(super cue:)
		(self newRoom: 180)
	)
)

(instance fireElem of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(azizaVoice showText: 0)
				(self setScript: enterElemental self 3)
				(elemental_1
					lookStr: {The Fire Elemental fears the Water Elemental.}
				)
			)
			(1
				(azizaVoice caller: self showMany: 1 2)
			)
			(2
				(azizaVoice showText: 3)
				(self setScript: chaseElemental self 0)
				(elemental_2
					lookStr:
						{The Water Elemental can devour the Fire Elemental.}
				)
			)
			(3
				(azizaVoice caller: self showMany: 4 5)
				(self setScript: killElemental)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance waterElem of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(azizaVoice showText: 6)
				(self setScript: enterElemental self 0)
				(elemental_1
					lookStr: {The Water Elemental fears the Air Elemental.}
				)
			)
			(1
				(azizaVoice caller: self showMany: 7 9)
			)
			(2
				(azizaVoice showText: 10)
				(self setScript: chaseElemental self 2)
				(elemental_2
					lookStr: {The Air Elemental can devour the Water Elemental.}
				)
			)
			(3
				(azizaVoice caller: self showText: 11)
				(self setScript: killElemental)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance airElem of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(azizaVoice showText: 12)
				(self setScript: enterElemental self 2)
				(elemental_1
					lookStr: {The Air Elemental fears the Earth Elemental.}
				)
			)
			(1
				(azizaVoice showText: 13)
				(self setScript: chaseElemental self 1)
				(elemental_2
					lookStr: {The Earth Elemental can devour the Air Elemental.}
				)
			)
			(2
				(azizaVoice caller: self showText: 14)
				(self setScript: killElemental)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance earthElem of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(azizaVoice showText: 15)
				(self setScript: enterElemental self 1)
				(elemental_1
					lookStr: {The Earth Elemental fears the Fire Elemental.}
				)
			)
			(1
				(azizaVoice showText: 16)
				(self setScript: chaseElemental self 3)
				(elemental_2
					lookStr:
						{The Fire Elemental can devour the Earth Elemental.}
				)
			)
			(2
				(azizaVoice caller: self showText: 17)
				(self setScript: killElemental)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance allElem of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(azizaArm setCycle: End self)
			)
			(1
				(sparkle posn: 182 100 setCycle: End self init:)
			)
			(2
				(Say azizaVoice self 191 (+ whichElem 37))
				(elemental_1
					posn: 182 115
					setLoop: whichElem
					setCycle: Fwd
					setMotion: MoveTo 128 110
					init:
				)
			)
			(3
				(sparkle
					posn: (elemental_1 x:) (- (elemental_1 y:) 30)
					setCycle: End self
				)
				(elemental_1 dispose:)
			)
			(4
				(sparkle dispose:)
				(if (< whichElem 3)
					(++ whichElem)
					(self changeState: 0)
				else
					(= cycles 2)
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance enterElemental of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(azizaArm setCycle: End self)
			)
			(1
				(sparkle posn: 182 100 setCycle: End self init:)
			)
			(2
				(elemental_1
					posn: 182 115
					setLoop: register
					setCycle: Fwd
					setMotion: MoveTo 158 112 self
					init:
				)
				(sparkle dispose:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance chaseElemental of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(azizaArm setCycle: End self)
			)
			(1
				(sparkle posn: 182 100 setCycle: End self init:)
			)
			(2
				(elemental_1 setMotion: MoveTo 142 100)
				(elemental_2
					posn: 182 115
					setLoop: register
					setCycle: Fwd
					setMotion: MoveTo 142 100 self
					init:
				)
				(sparkle dispose:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance killElemental of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sparkle posn: 142 85 setCycle: End self init:)
			)
			(1
				(sparkle dispose:)
				(elemental_1 dispose:)
				(= cycles 4)
			)
			(2
				(sparkle posn: 142 85 setCycle: End self init:)
			)
			(3
				(sparkle dispose:)
				(elemental_2 dispose:)
				(= cycles 4)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance talkAboutPlant of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(azizaVoice caller: self showMany: 18 19)
			)
			(1
				(azizaArm setCycle: End)
				(julanar init:)
				(= cycles 3)
			)
			(2
				(julanar palette: 2 forceUpd:)
				(= cycles 3)
			)
			(3
				(julanar palette: 1 forceUpd:)
				(= cycles 5)
			)
			(4
				(if gSillyClowns
					(EgoPrint 190 1) ; "Just the facts, Ma'am."
					(= cycles 1)
				else
					(self cue:)
				)
			)
			(5
				(azizaVoice caller: self showMany: 20 21)
			)
			(6
				(azizaArm setCycle: End)
				(julanar palette: 2 forceUpd:)
				(= cycles 3)
			)
			(7
				(julanar palette: 3 forceUpd:)
				(= cycles 3)
			)
			(8
				(julanar hide:)
				(= cycles 3)
			)
			(9
				(azizaArm setCycle: End)
				(julanar cel: 1 show: forceUpd:)
				(= cycles 3)
			)
			(10
				(julanar palette: 2 forceUpd:)
				(= cycles 3)
			)
			(11
				(julanar palette: 1 forceUpd:)
				(= cycles 3)
			)
			(12
				(if gSillyClowns
					(EgoPrint 190 2) ; "Right."
					(= cycles 1)
				else
					(self cue:)
				)
			)
			(13
				(azizaVoice caller: self showMany: 22 25)
			)
			(14
				(azizaVoice caller: self showMany: 26 27)
			)
			(15
				(azizaArm setCycle: End)
				(julanar palette: 2 forceUpd:)
				(= cycles 3)
			)
			(16
				(julanar palette: 3 forceUpd:)
				(= cycles 3)
			)
			(17
				(julanar hide:)
				(= cycles 3)
			)
			(18
				(azizaArm setCycle: End)
				(julanar cel: 2 show: forceUpd:)
				(= cycles 3)
			)
			(19
				(julanar palette: 2 forceUpd:)
				(= cycles 3)
			)
			(20
				(julanar palette: 1 forceUpd:)
				(= cycles 3)
			)
			(21
				(Say azizaVoice self 190 3 190 4) ; "You could be the one to give her back her soul and free her heart from wood."
			)
			(22
				(if gSillyClowns
					(EgoPrint 190 2) ; "Right."
					(= cycles 1)
				else
					(self cue:)
				)
			)
			(23
				(azizaVoice caller: self showMany: 30 33)
			)
			(24
				(if (< gElementalState 6)
					(self changeState: 32)
				else
					(azizaVoice caller: self showMany: 34 36)
				)
			)
			(25
				(if gSillyClowns
					(EgoPrint 190 2) ; "Right."
					(= cycles 1)
				else
					(self cue:)
				)
			)
			(26
				(if gSillyClowns
					(EgoPrint 190 5) ; "What's a pomegranate?"
					(= cycles 1)
				else
					(self cue:)
				)
			)
			(27
				(azizaArm setCycle: End)
				(julanar palette: 2 forceUpd:)
				(= cycles 3)
			)
			(28
				(julanar palette: 3 forceUpd:)
				(= cycles 3)
			)
			(29
				(julanar dispose:)
				(= cycles 3)
			)
			(30
				(Say azizaVoice self (Format @str 190 6 @gUserName)) ; "You will find her within a day's ride to the east, at the base of the mountains. May you heal the healer, %s."
			)
			(31
				(SetFlag 44) ; fHeardPlant
				(self dispose:)
			)
			(32
				(Say azizaVoice self 190 7) ; "I know you can achieve the gift of Kindness, but you do not yet have a suitable gift of Sacrifice. Perhaps you will be able to do this another time."
			)
			(33
				(self dispose:)
			)
		)
	)
)

(instance lookAtSaurus of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say azizaVoice self 190 8) ; "You are obviously enchanted, so we need now to see what is your true form."
			)
			(1
				(azizaArm setCycle: End self)
			)
			(2
				(saurusTail setCycle: End)
				(self setScript: makeWaves self pool)
			)
			(3
				(= cycles 2)
			)
			(4
				(self setScript: makeWaves self emirReflect)
			)
			(5
				(Say azizaVoice self 190 9) ; "Water of Wisdom, Liquid of Life, I call upon thee three times three, Mirror without what lies within, So we shall have the true to see."
			)
			(6
				(azizaArm setCycle: Beg)
				(Say azizaVoice self 190 10) ; "Look into the water, and we shall see your true form."
			)
			(7
				(saurusHead setCycle: CT 3 1 self)
				(= cycles 10)
			)
			(8
				(saurusHead cel: 4)
				(= cycles 4)
			)
			(9
				(saurusTail setCycle: Fwd)
				(saurusHead cel: 6)
				(= cycles 15)
			)
			(10
				(saurusTail setCycle: 0)
				(saurusHead cel: 0 cycleSpeed: 3 setCycle: CT 3 1 self)
			)
			(11
				(Say azizaVoice self 190 11 190 12) ; "Ah, the Emir Arus al-Din. There was good reason why my spell could not locate you in Raseir."
			)
			(12
				(saurusHead cycleSpeed: 1 setCycle: Beg)
				(= cycles 8)
			)
			(13
				(saurusHead stopUpd:)
				(self setScript: lookAtDark self darkReflect)
			)
			(14
				(self dispose:)
			)
		)
	)
)

(instance lookAtDark of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say azizaVoice self 190 13) ; "Water of Wisdom, Liquid of Life, Knowledge now is what I seek, Reveal the caster of the spell, upon the one which I bespeak."
			)
			(1
				(azizaArm setCycle: End self)
			)
			(2
				(self setScript: makeWaves self darkReflect)
				(= register 2)
			)
			(3
				(emirReflect dispose:)
				(darkReflect show: cycleSpeed: 1)
				(= cycles 1)
			)
			(4
				(pool lookStr: {It is a reflection of darkness.})
				(darkReflect setCycle: CT 3 1 self)
			)
			(5
				(darkReflect setCycle: CT 0 -1 self)
			)
			(6
				(if (-- register)
					(self changeState: 4)
				else
					(self cue:)
				)
			)
			(7
				(darkReflect setCycle: End self)
			)
			(8
				(pool lookStr: {It is a reflection of a dark evil!})
				(saurusHead setCel: 6)
				(= cycles 4)
			)
			(9
				(darkReflect setCycle: Beg self)
			)
			(10
				(pool lookStr: {The magical water moves and ripples.})
				(saurusHead setCel: 0)
				(darkReflect dispose:)
				(= cycles 4)
			)
			(11
				(saurusHead setCel: -1)
				(self dispose:)
			)
		)
	)
)

(instance makeWaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ripple new:) init: self)
			)
			(1
				((ripple new:) init: self)
			)
			(2
				(cond
					((== register pool)
						(pool setCycle: End init:)
					)
					((== register emirReflect)
						(emirReflect init:)
					)
					((== register darkReflect)
						(darkReflect init: hide:)
					)
				)
				(= cycles 4)
			)
			(3
				((ripple new:) init: self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance newRipple of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: CT 4 1 self)
			)
			(1
				(caller cue:)
				(= caller 0)
				(client setCycle: End self)
			)
			(2
				(client dispose:)
			)
		)
	)
)

(instance azizaVoice of Talker
	(properties
		tLoop -1
		title {Aziza:}
		color 13
		back 0
		msgFile 191
	)

	(method (init)
		(super init: &rest)
		(= tWindow BotWindow)
	)
)

(instance azizaBody of PicView
	(properties
		x 215
		y 153
		description {Aziza}
		lookStr {Aziza weaves her magic.}
		view 192
		loop 7
	)
)

(instance azizaArm of Prop
	(properties
		x 206
		y 109
		description {Aziza}
		lookStr {Aziza weaves her magic.}
		view 192
		loop 8
		priority 12
		signal 16
		cycleSpeed 1
	)
)

(instance ripple of Prop
	(properties
		x 159
		y 109
		description {the magical water}
		lookStr {The magical water moves and ripples.}
		view 190
		loop 1
		priority 13
		signal 16
	)

	(method (init whoCares)
		(super init:)
		(self setScript: (newRipple new:) whoCares)
	)
)

(instance pool of Prop
	(properties
		x 159
		y 109
		description {the magical water}
		lookStr {The magical water moves and ripples.}
		view 190
		priority 11
		signal 16
	)
)

(instance emirReflect of View
	(properties
		x 160
		y 106
		view 190
		loop 2
		priority 12
		signal 16
	)

	(method (doit)
		(if (!= cel (saurusHead cel:))
			(self cel: (saurusHead cel:))
			(RedrawCast)
		)
		(if (<= 2 cel 4)
			(pool lookStr: {It is the reflection of the Emir, Arus al-Din!})
		else
			(pool lookStr: {The magical water moves and ripples.})
		)
		(super doit:)
	)
)

(instance darkReflect of Prop
	(properties
		x 160
		y 106
		view 190
		loop 3
		priority 12
		signal 16
	)
)

(instance saurusHead of Prop
	(properties
		x 160
		y 82
		description {the saurus}
		lookStr {The saurus looks on in fascination.}
		view 192
		loop 2
		priority 9
		signal 16
	)
)

(instance saurusBody of PicView
	(properties
		x 162
		y 95
		description {the saurus}
		lookStr {The saurus looks on in fascination.}
		view 192
		loop 1
	)
)

(instance clawRight of Extra
	(properties
		x 180
		y 73
		description {the saurus}
		lookStr {The saurus looks on in fascination.}
		view 192
		loop 4
		priority 8
		signal 16
		cycleSpeed 2
		minPause 40
		maxPause 80
	)
)

(instance clawLeft of Extra
	(properties
		x 138
		y 74
		description {the saurus}
		lookStr {The saurus looks on in fascination.}
		view 192
		loop 3
		priority 8
		signal 16
		cycleSpeed 2
		minPause 40
		maxPause 80
	)
)

(instance saurusTail of Extra
	(properties
		x 193
		y 71
		description {the saurus}
		lookStr {The saurus looks on in fascination.}
		view 192
		loop 5
		minPause 30
		maxPause 60
	)
)

(instance elemental_1 of Actor
	(properties
		description {}
		yStep 1
		view 193
		priority 8
		signal 16400
		xStep 1
	)
)

(instance elemental_2 of Actor
	(properties
		description {}
		yStep 1
		view 193
		priority 8
		signal 16400
		xStep 1
	)
)

(instance julanar of View
	(properties
		x 160
		y 70
		description {}
		view 193
		loop 4
		priority 8
		signal 16400
		palette 3
	)
)

(instance sparkle of Prop
	(properties
		description {a sparkle}
		view 183
		priority 9
		signal 16
	)
)

(instance closeupSound of Sound
	(properties
		number 182
		priority 5
		loop -1
	)
)

