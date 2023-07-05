;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 111)
(include sci.sh)
(use Main)
(use DLetter)
(use KQ5Room)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	hermit2 0
)

(instance hermit2 of KQ5Room
	(properties
		picture 87
		style 30
	)

	(method (init)
		(LoadMany rsVIEW 832 626 828 826 0 824)
		(self setRegions: 763) ; cartoonRegion
		(if (!= (gGlobalSound number:) 820)
			(gGlobalSound number: 820 loop: -1 vol: 127 playBed:)
		)
		(if (== gPrevRoomNum 112) ; hermit3
			(hermit view: 626 posn: 136 118 moveSpeed: 1 init:)
			(gEgo view: 0 normal: 1 posn: 158 121 setLoop: 5 init:)
			(= global320 201)
			(= global321 110)
			(= global325
				{"Come on, Graham! Let's explore someplace else!"}
			)
			(gCurRoom setRegions: 202) ; owl
			(self setScript: cartoon2)
		else
			(hermit posn: 146 118 moveSpeed: 1 setLoop: 0 init:)
			(gEgo
				posn: 185 132
				setLoop: 0
				signal: 16384
				illegalBits: 0
				moveSpeed: 2
				view: 832
				normal: 0
				init:
			)
			((gEgo head:) hide:)
			(self setScript: cartoon)
		)
		(if (== global361 46)
			(sailBoat
				init:
				y: (if (== gCurRoomNum 44) 153 else 173)
				stopUpd:
				ignoreActors:
			)
			(sail
				posn: (+ (sailBoat x:) 7) (sailBoat y:)
				setPri: (sailBoat priority:)
				setLoop: 2
				init:
			)
		)
		(chimney init: setCycle: Fwd cycleSpeed: 3)
		(if (!= (gGame detailLevel:) 3)
			(chimney setCycle: 0)
		)
		(super init:)
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(cls)
				(PrintDC 111 0 #at 10 10 #dispose) ; "Lay him on the bed there."
				(= seconds 4)
			)
			(2
				(gEgo setScript: putDownOwl)
				(hermit cycleSpeed: 2 setCycle: End self)
			)
			(3
				(hermit setLoop: 1 setCycle: End self)
			)
			(4
				(hermit setLoop: 2 setCycle: Fwd)
				(= cycles 10)
			)
			(5
				(hermit setCycle: End self)
			)
			(6
				(hermit setLoop: 1 setCycle: Beg self)
			)
			(7
				(hermit setLoop: 0 setCycle: Beg self)
			)
			(8
				(cls)
				(hermit view: 626 setLoop: 0 cel: 2)
				(= cycles 4)
			)
			(9
				(hermit view: 626 setLoop: 2 cel:)
				(= cycles 1)
			)
			(10
				(hermit_mouth
					init:
					setPri: (+ (hermit priority:) 1)
					cycleSpeed: 2
					posn: (- (hermit x:) 2) (- (hermit y:) 39)
				)
				(= cycles 1)
			)
			(11
				(hermit_mouth setCycle: Fwd)
				(PrintDC 111 1 #at 10 10 #dispose) ; "These poultices should fix the little feller up good as new."
				(= seconds 4)
			)
			(12
				(putDownOwl cue:)
				(hermit_mouth setCycle: 0 hide:)
				(hermit
					view: 626
					setCycle: Walk
					setLoop: 2
					signal: 18432
					illegalBits: 0
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo 141 130 self
				)
			)
			(13
				(hermit setLoop: -1 setMotion: MoveTo 175 127 self)
			)
			(14
				(hermit view: 828 setLoop: 2 cycleSpeed: 2 setCycle: End self)
			)
			(15
				(hermit setLoop: 3 setCycle: Fwd)
				(= cycles 20)
			)
			(16
				(hermit setCycle: End self)
			)
			(17
				(hermit setLoop: 4 setCycle: End self)
			)
			(18
				(cls)
				(= seconds 3)
			)
			(19
				(self setScript: getBetterScript self)
			)
			(20
				(owlHead setCycle: Fwd)
				(PrintDC 111 2 #at 100 145 #dispose) ; "I'm feeling better already! Tell me, what was in those poultices? My employer would be very interested in them."
				(= seconds 8)
			)
			(21
				(owlHead setCycle: Beg self)
			)
			(22
				(cls)
				(shell init:)
				(hermit
					view: 624
					loop: 4
					cycleSpeed: 2
					cel: 0
					setCycle: End self
				)
				(hermit_mouth
					setPri: (+ (hermit priority:) 1)
					cycleSpeed: 2
					posn: (+ (hermit x:) 3) (- (hermit y:) 37)
					show:
				)
			)
			(23
				(hermit_mouth setCycle: Fwd)
				(PrintDC 111 3 #at 10 10 #dispose) ; "Eh? What was that?"
				(= seconds 3)
			)
			(24
				(hermit_mouth setCycle: 0)
				(cls)
				(owlHead setCycle: Fwd)
				(PrintDC 111 4 #at 100 145 #dispose) ; "I said, what was in those poultices? My employer would be interested in them."
				(= seconds 6)
			)
			(25
				(owlHead setCycle: Beg self)
			)
			(26
				(cls)
				(hermit_mouth setCycle: Fwd)
				(PrintDC 111 5 #at 10 10 #dispose) ; "Gifts from the sea, lad. Gifts from the sea. Ain't nothin' special. You just gotta know how to use 'em. I don't think he'd find them particularly interestin'."
				(= seconds 11)
			)
			(27
				(cls)
				(hermit_mouth dispose:)
				(hermit
					view: 626
					setCycle: Walk
					setStep: 3 1
					setLoop: 1
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo 141 130 self
				)
			)
			(28
				(hermit setLoop: 3 setMotion: MoveTo 136 118 self)
			)
			(29
				(gEgo setLoop: 1)
				(shell init:)
				(hermit
					view: 624
					loop: 4
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(30
				(gEgo moveSpeed: 0 setLoop: -1)
				(hermit setLoop: -1)
				(gCurRoom newRoom: 112) ; hermit3
			)
		)
	)
)

(instance cartoon2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global320 201)
				(= global321 110)
				(gCurRoom setRegions: 202) ; owl
				(gEgo view: 0 ignoreActors: illegalBits: 0 setLoop: 7 cel: 1)
				(= cycles 1)
			)
			(1
				(hermit
					illegalBits: 0
					setStep: 3 2
					setCycle: Walk
					setLoop: -1
					ignoreActors: 1
					setMotion: MoveTo 169 188 self
				)
			)
			(2
				(hermit dispose:)
				(gEgo
					setCycle: SyncWalk
					setLoop: -1
					setMotion: MoveTo 169 188 self
				)
			)
			(3
				(global322 view: 138 setLoop: 8 setCycle: End self)
			)
			(4
				(gGlobalSound fade:)
				(gCurRoom newRoom: 110) ; hermitRoom
			)
		)
	)
)

(instance hermit of Actor
	(properties
		view 826
	)
)

(instance owl of Actor
	(properties
		view 832
	)
)

(instance putDownOwl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(owl setLoop: 1 posn: 201 115 cycleSpeed: 2 cel: 0 init:)
				(gEgo view: 0 posn: 177 128 illegalBits: 0 normal: 1)
				((gEgo head:) show:)
				(client cue:)
			)
			(3
				(gEgo
					setStep: 3 2
					cycleSpeed: 0
					setCycle: SyncWalk
					setLoop: -1
					setMotion: MoveTo 158 121 self
				)
			)
			(4
				(gEgo setLoop: 2)
				(= cycles 1)
			)
			(5
				(gEgo setLoop: -1)
				(= cycles 1)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance getBetterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(owl view: 824 cel: 0 setLoop: 0 setCycle: End self)
			)
			(1
				(owl setLoop: 1 cel: 0)
				(owlHead
					cycleSpeed: 2
					setLoop: 2
					cel: 0
					posn: (- (owl x:) 1) (- (owl y:) 9)
					setCycle: Fwd
					init:
				)
				(= cycles 10)
			)
			(2
				(owlHead setCycle: End self)
			)
			(3
				(owl setLoop: 3 cel: 0 setCycle: End self)
			)
			(4
				(owl setLoop: 4 cel: 0 setCycle: End self)
			)
			(5
				(owlHead setPri: (+ (owl priority:) 1) setLoop: 5)
				(self dispose:)
			)
		)
	)
)

(instance owlHead of Prop
	(properties
		view 824
	)
)

(instance chimney of Prop
	(properties
		x 18
		y 70
		z 20
		view 625
		loop 2
	)
)

(instance hermit_mouth of Prop
	(properties
		view 624
		loop 15
	)
)

(instance shell of Prop
	(properties
		view 624
		loop 5
	)

	(method (doit)
		(super doit:)
		(if (== (hermit view:) 624)
			(self setPri: (+ (hermit priority:) 1))
			(cond
				((== (hermit cel:) 0)
					(self posn: (+ (hermit x:) 8) (- (hermit y:) 20))
				)
				((== (hermit cel:) 1)
					(self posn: (+ (hermit x:) 13) (- (hermit y:) 23))
				)
				((== (hermit cel:) 2)
					(self posn: (+ (hermit x:) 15) (- (hermit y:) 35))
				)
			)
		else
			(self dispose:)
		)
	)
)

(instance sailBoat of Actor
	(properties
		x 280
		y 173
		view 618
		cel 1
		priority -1
		signal 16385
	)
)

(instance sail of Actor
	(properties
		z 15
		view 618
		loop 3
		signal 16385
	)
)

