;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20000)
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
	roChapter2 0
)

(local
	bTalking
)

(instance soPlayChapter of TPScript
	(properties
		bHasFF 1
	)

	(method (ff)
		(= gtSoldier 0)
		(= gtKurtzwell 0)
		(goMusic1 stop: setRelVol: 100)
		(gCurRoom newRoom: 20100) ; roCliffScroller
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette 1 20001) ; PalLoad
				(vRobes init:)
				(vSoldier1 init: cycleSpeed: 8 setCycle: End self)
				(= gtSoldier tSoldierTalker)
				(= gtKurtzwell tKurtzwellTalker)
			)
			(1
				(vRobes dispose:)
				(vSoldier1 dispose:)
				(gCurRoom drawPic: 20001)
				(vSoldier2 setPri: 5 init:)
				(vKurtzwellHead init:)
				(vKurtzwellBody init:)
				(gtSoldier x: (vSoldier2 x:) y: (vSoldier2 y:) priority: 200)
				(vSoldierStillTalker
					view: (gtSoldier view:)
					loop: (gtSoldier loop:)
					posn: (gtSoldier x:) (gtSoldier y:)
					setPri: (- (gtSoldier priority:) 1)
					init:
				)
				(gtKurtzwell
					x: (vKurtzwellHead x:)
					y: (vKurtzwellHead y:)
					priority: 255
				)
				(vKurtzwellStillTalker
					view: (gtKurtzwell view:)
					loop: (gtKurtzwell loop:)
					posn: (gtKurtzwell x:) (gtKurtzwell y:)
					setPri: (- (gtKurtzwell priority:) 1)
					init:
				)
				(gMessager say: 0 0 0 1 self) ; "Sir. They were both in there."
			)
			(2
				(gMessager say: 0 0 0 2 self) ; "And?"
			)
			(3
				(goSound1 preload: 20001)
				(gMessager say: 0 0 0 3 self) ; "They're gone."
			)
			(4
				(goSound1 playSound: 20001)
				(= ticks 60)
			)
			(5
				(vKurtzwellStillTalker hide:)
				(vKurtzwellHead
					cel: 0
					setLoop: 4
					cycleSpeed: 5
					doit:
					setCycle: End self
				)
			)
			(6
				(gtKurtzwell loop: 6 cel: 0)
				(vKurtzwellHead setLoop: 5 cel: 0 doit:)
				(vKurtzwellStillTalker
					loop: (gtKurtzwell loop:)
					cel: (gtKurtzwell cel:)
					show:
				)
				(gMessager say: 0 0 0 5 self) ; "And the child?"
			)
			(7
				(vKurtzwellHead dispose:)
				(vKurtzwellBody dispose:)
				(vSoldierStillTalker hide:)
				(vKurtzwellStillTalker hide:)
				(gCurRoom drawPic: 20002)
				(vSoldier2
					view: 20002
					loop: 2
					cel: 0
					cycleSpeed: 8
					posn: 396 302
					doit:
				)
				(= seconds 2)
			)
			(8
				(vSoldier2 setCycle: CT 4 1 self)
			)
			(9
				(= ticks 15)
			)
			(10
				(vSoldier2 setCycle: End self)
			)
			(11
				(vSoldier2 setLoop: 0 cel: 0 setPri: 10 doit:)
				(gtSoldier
					view: 20002
					loop: 1
					x: (vSoldier2 x:)
					y: (vSoldier2 y:)
					priority: 500
				)
				(vSoldierStillTalker
					view: (gtSoldier view:)
					loop: (gtSoldier loop:)
					posn: (gtSoldier x:) (gtSoldier y:)
					setPri: (- (gtSoldier priority:) 1)
					show:
				)
				(goSound1 preload: 20002)
				(gMessager say: 0 0 0 6 self) ; "Missing."
			)
			(12
				(goSound1 playSound: 20002)
				(= ticks 10)
			)
			(13
				(vSoldier2 dispose:)
				(vSoldierStillTalker dispose:)
				(gCurRoom drawPic: 20003)
				(vKurtzwellHead view: 20003 loop: 0 cel: 0 posn: 249 300 init:)
				(= ticks 20)
			)
			(14
				(vKurtzwellHead setCycle: End self)
			)
			(15
				(vKurtzwellHead setPri: 10 setLoop: 1 doit:)
				(gtKurtzwell
					view: 20003
					loop: 2
					cel: 0
					x: (vKurtzwellHead x:)
					y: (vKurtzwellHead y:)
					priority: 255
				)
				(vKurtzwellStillTalker
					view: (gtKurtzwell view:)
					loop: (gtKurtzwell loop:)
					posn: (gtKurtzwell x:) (gtKurtzwell y:)
					show:
				)
				(gMessager say: 0 0 0 8 self) ; "The child must be found! Immediately!"
			)
			(16
				(= seconds 1)
			)
			(17
				(goMusic1 fadeOut: 12 10 self)
				(FadeToBlack 1 15 self)
			)
			(18)
			(19
				(self ff:)
			)
		)
	)
)

(instance coDoneTalking of CueMe ; UNUSED
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
				(Load rsVIEW 20001)
				(Load rsPIC 20000)
				(Load rsVIEW 20002)
				(Load rsVIEW 20003)
			)
			(2
				(gCurRoom picture: 20000 drawPic: 20000 setScript: soPlayChapter)
			)
		)
	)
)

(instance roChapter2 of TPRoom
	(properties
		purge 2500
	)

	(method (init)
		(switch gnLanguage
			(1
				(= picture 61102)
			)
			(33
				(= picture 61112)
			)
			(49
				(= picture 61122)
			)
		)
		(super init: &rest)
		(goMusic1 relVolPercent: 150 setMusic: 20000)
		(= gnChapter 2)
		(gCurRoom setScript: soIntro)
	)
)

(instance vRobes of View
	(properties
		x 243
		y 253
		view 20000
	)
)

(instance vSoldier1 of Prop
	(properties
		x 613
		y 307
		view 20000
		loop 1
	)
)

(instance vSoldier2 of Prop
	(properties
		x 461
		y 306
		view 20001
	)
)

(instance vKurtzwellHead of Prop
	(properties
		x 178
		y 242
		view 20001
		loop 2
		cycleSpeed 5
	)
)

(instance vKurtzwellBody of View
	(properties
		x 178
		y 242
		view 20001
		loop 8
	)
)

(instance tKurtzwellTalker of Talker
	(properties
		view 20001
		loop 3
	)

	(method (init)
		(vKurtzwellStillTalker hide:)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(vKurtzwellStillTalker show:)
	)
)

(instance tSoldierTalker of Talker
	(properties
		view 20001
		loop 1
	)

	(method (init)
		(vSoldierStillTalker hide:)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(vSoldierStillTalker show:)
	)
)

(instance vSoldierStillTalker of Prop
	(properties)
)

(instance vKurtzwellStillTalker of Prop
	(properties)
)

