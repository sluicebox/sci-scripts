;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use CueMe)
(use n64896)
(use Talker)
(use Motion)
(use Actor)
(use System)

(public
	roChapter3 0
)

(local
	bTalking
)

(instance soZipOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLycentia setCycle: End self)
			)
			(1
				(poLycentia dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soLycentiaNod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(voLycentiaMouth
					init:
					view: 30004
					setLoop: 0
					cel: 0
					posn: 347 253
					doit:
				)
				(poLycentia
					view: 30004
					setLoop: 1
					cel: 0
					posn: 347 253
					setPri: 500
					init:
				)
				(= ticks 220)
			)
			(1
				(poLycentia setCycle: End)
				(= ticks 660)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soLycentiaSecondHeadDrop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 120)
			)
			(1
				(poLycentia
					loop: 1
					cel: 1
					doit:
					cycleSpeed: 16
					setCycle: End self
				)
			)
			(2
				(poLycentia cycleSpeed: 7)
				(self dispose:)
			)
		)
	)
)

(instance soPlayChapter of TPScript
	(properties
		bHasFF 1
	)

	(method (ff)
		(goSound1 stop:)
		(goMusic1 stop: setRelVol: 100)
		(gCurRoom newRoom: 30100) ; roPergolaOpening
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette 1 30001) ; PalLoad
				(= gtKurtzwell toKurtzwell)
				(= gtLycentia toLycentia)
				(poKurtzwell init: setPri: 10)
				(voKurtzwellMouth init:)
				(poLycentia init: setPri: 20)
				(gMessager say: 0 0 0 1 self) ; "Before I pass judgment, have you anything to say?"
			)
			(1
				(poKurtzwell dispose:)
				(voKurtzwellMouth dispose:)
				(poLycentia dispose:)
				(voLycentiaMouth dispose:)
				(gCurRoom drawPic: 30005)
				(poLycentia view: 30002 setLoop: 0 cel: 0 posn: 347 253 init:)
				(voLycentiaMouth init:)
				(gMessager say: 0 0 0 2 self) ; "(YOUNG, THIN WOMAN'S VOICE) The child? Is he safe?"
			)
			(2
				(poKurtzwell dispose:)
				(voKurtzwellMouth dispose:)
				(poLycentia dispose:)
				(voLycentiaMouth dispose:)
				(gCurRoom drawPic: 30002)
				(poKurtzwell view: 30003 setLoop: 0 cel: 0 posn: 290 241 init:)
				(voKurtzwellMouth init:)
				(gMessager say: 0 0 0 3 self) ; "Far away, where he will come to no harm. Although we suspect your involvement in the murder of our beloved royal couple, we could not find enough evidence to convict you."
			)
			(3
				(= gtKurtzwell 0)
				(poKurtzwell dispose:)
				(voKurtzwellMouth dispose:)
				(poLycentia dispose:)
				(voLycentiaMouth dispose:)
				(gCurRoom drawPic: 30005)
				(self setScript: soLycentiaNod self)
				(gMessager say: 0 0 0 4 self) ; "But since you were clearly guilty of kidnapping the crown prince, you are hereby sentenced to spend the rest of your life... in The Lands Below!"
			)
			(4
				(if (self script:)
					((self script:) dispose:)
				)
			)
			(5
				(poLycentia
					setLoop: 2
					cycleSpeed: 16
					cel: 0
					doit:
					setCycle: End self
				)
				(gMessager say: 0 0 0 5 self) ; "(GASPS) Gasp!"
			)
			(6)
			(7
				(self setScript: soLycentiaSecondHeadDrop self)
				(= bTalking 1)
				(gMessager say: 0 0 0 6 coDoneTalking) ; "I therefore order an Ostracizing Collar be fabricated for you... and placed around your neck... never to be removed! And should you ever attempt to return to The Lands Above, the collar will tighten until it chokes you... to death!"
			)
			(8
				(= ticks 180)
			)
			(9
				(FadeToBlack 1 5 self)
			)
			(10
				(= ticks 1)
			)
			(11
				(poKurtzwell dispose:)
				(voKurtzwellMouth dispose:)
				(poLycentia dispose:)
				(voLycentiaMouth dispose:)
				(gCurRoom drawPic: 15300)
				(voPlatform init:)
				(goSound1 preload: 15202)
				(poGuard1 init:)
				(poGuard2 init:)
				(poLycentia
					view: 30005
					setLoop: 4
					posn: 274 197
					cel: 0
					setPri: 200
					init:
				)
				(FadeToBlack 0 5 self)
			)
			(12
				(= ticks 240)
			)
			(13
				(poLycentia cycleSpeed: 10 setCycle: End self)
			)
			(14
				(poLycentia cycleSpeed: 7)
				(goSound1 preload: 30001)
				(= ticks 50)
			)
			(15
				(voPlatform dispose:)
				(poGuard1 hide:)
				(poGuard2 hide:)
				(poLycentia hide:)
				(voLycentiaMouth hide:)
				(poKurtzwell hide:)
				(voKurtzwellMouth hide:)
				(= gtKurtzwell 0)
				(= gtLycentia 0)
				(gCurRoom picture: 30004 drawPic: 30004)
				(poLycentia view: 30006 setLoop: 0 cel: 0 posn: 277 299 show:)
				(poGuard1 view: 30006 setLoop: 1 cel: 0 posn: 25 313 show:)
				(poGuard2 view: 30006 setLoop: 2 cel: 0 posn: 536 304 show:)
				(= ticks 150)
			)
			(16
				(poGuard1 cel: 1)
				(poGuard2 cel: 1)
				(= ticks (poLycentia cycleSpeed:))
			)
			(17
				(poGuard1 cel: 2)
				(poGuard2 cel: 2)
				(= ticks (poLycentia cycleSpeed:))
			)
			(18
				(poGuard1 cel: 3)
				(poGuard2 cel: 3)
				(= ticks (poLycentia cycleSpeed:))
			)
			(19
				(goSound1 playSound: 30001)
				(poLycentia cel: 1)
				(poGuard1 cel: 4)
				(poGuard2 cel: 4)
				(= ticks (poLycentia cycleSpeed:))
			)
			(20
				(poLycentia setCycle: End self)
				(poGuard1 setCycle: End poGuard1)
				(poGuard2 setCycle: End poGuard2)
			)
			(21
				(poLycentia hide:)
				(gCurRoom picture: 15301 drawPic: 15301)
				(= gtKurtzwell 0)
				(poGuard1 view: 30007 cel: 0 setLoop: 2 posn: 262 313 show:)
				(poGuard2
					view: 30007
					cel: 0
					setLoop: 3
					posn: 43 293
					setPri: 1
					show:
				)
				(poLycentia
					view: 30007
					cel: 0
					setLoop: 4
					posn: 112 285
					setPri: 285
					show:
				)
				(self cue:)
			)
			(22
				(= cycles 1)
			)
			(23
				(if bTalking
					(-= state 2)
				)
				(= cycles 1)
			)
			(24
				(= ticks 60)
			)
			(25
				(poGuard2 setCycle: CT 4 1 self)
			)
			(26
				(poGuard2Magic
					view: 30007
					cel: 5
					setLoop: 3
					posn: 43 293
					setPri: 0
					init:
					setCycle: CT 12 1 self
				)
			)
			(27
				(goSound1 playSound: 15202)
				(poGuard2 setCycle: Beg)
				(poGuard2Magic setPri: 500 setCycle: CT 20 1 self)
			)
			(28
				(poGuard2Magic setCycle: End)
				(self setScript: soZipOut self)
			)
			(29
				(= ticks 180)
			)
			(30
				(goMusic1 fadeOut: 12 10 self)
				(FadeToBlack 1 15 self)
			)
			(31)
			(32
				(self ff:)
			)
		)
	)
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= bTalking 0)
	)
)

(instance soIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(FrameOut)
				(= cycles 1)
			)
			(1
				(= ticks 400)
				(Load rsVIEW 30000)
				(Load rsVIEW 30001)
				(Load rsVIEW 30002)
				(Load rsVIEW 30003)
				(Load rsVIEW 30004)
				(Load rsVIEW 30005)
				(Load rsVIEW 30006)
				(Load rsVIEW 30007)
				(Load rsPIC 30000)
			)
			(2
				(gCurRoom picture: 30000 drawPic: 30000 setScript: soPlayChapter)
			)
		)
	)
)

(instance roChapter3 of TPRoom
	(properties
		purge 2500
	)

	(method (init)
		(switch gnLanguage
			(1
				(= picture 61103)
			)
			(33
				(= picture 61113)
			)
			(49
				(= picture 61123)
			)
		)
		(super init: &rest)
		(goMusic1 relVolPercent: 150 setMusic: 30000)
		(= gnChapter 3)
		(gCurRoom setScript: soIntro)
	)
)

(instance poKurtzwell of Prop
	(properties
		x 255
		y 65
		priority 10
		fixPriority 1
		view 30000
	)
)

(instance toKurtzwell of Talker
	(properties)

	(method (init)
		(= x (poKurtzwell x:))
		(= y (poKurtzwell y:))
		(= view (poKurtzwell view:))
		(= loop (+ (poKurtzwell loop:) 1))
		(= priority (+ (poKurtzwell priority:) 1))
		(voKurtzwellMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voKurtzwellMouth show:)
		(super dispose: &rest)
	)
)

(instance voKurtzwellMouth of Prop
	(properties)

	(method (init)
		(= x (poKurtzwell x:))
		(= y (poKurtzwell y:))
		(= view (poKurtzwell view:))
		(= loop (+ (poKurtzwell loop:) 1))
		(self setPri: (+ (poKurtzwell priority:) 1))
		(super init: &rest)
	)
)

(instance poLycentia of Prop
	(properties
		x 455
		y 277
		priority 20
		fixPriority 1
		view 30000
		loop 2
	)
)

(instance voLycentiaMouth of Prop
	(properties)

	(method (init)
		(= x (poLycentia x:))
		(= y (poLycentia y:))
		(= view (poLycentia view:))
		(= loop (+ (poLycentia loop:) 1))
		(self setPri: (+ (poLycentia priority:) 1))
		(super init: &rest)
	)
)

(instance toLycentia of Talker
	(properties)

	(method (init)
		(= x (poLycentia x:))
		(= y (poLycentia y:))
		(= view (poLycentia view:))
		(= loop (+ (poLycentia loop:) 1))
		(= priority (+ (poLycentia priority:) 1))
		(voLycentiaMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(voLycentiaMouth show:)
	)
)

(instance voPlatform of View
	(properties
		x 191
		y 204
		priority 1
		fixPriority 1
		view 15204
	)
)

(instance poGuard1 of Prop
	(properties
		x 151
		y 251
		view 30005
		loop 2
	)

	(method (cue)
		(self hide:)
	)
)

(instance poGuard2 of Prop
	(properties
		x 278
		y 147
		view 30005
		loop 3
	)

	(method (cue)
		(self hide:)
	)
)

(instance poGuard2Magic of Prop
	(properties
		x 278
		y 147
		view 30007
		loop 3
		cel 5
	)
)

