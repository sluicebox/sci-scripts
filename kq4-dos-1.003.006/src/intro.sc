;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	intro 0
)

(local
	local0
	[local1 17]
	local18
	local19
	local20
	local21
	local22
	[local23 7]
	local30
	local31
	[local32 202]
)

(instance openMusic of Sound
	(properties)
)

(instance intro of Rm
	(properties
		horizon 40
	)

	(method (init)
		(Load rsVIEW 750)
		(Load rsVIEW 752)
		(Load rsVIEW 755)
		(Load rsVIEW 756)
		(Load rsVIEW 757)
		(Load rsVIEW 758)
		(Load rsVIEW 759)
		(Load rsVIEW 760)
		(Load rsVIEW 761)
		(Load rsVIEW 762)
		(Load rsVIEW 766)
		(Load rsVIEW 767)
		(Load rsVIEW 768)
		(Load rsVIEW 769)
		(Load rsPIC 201)
		(Load rsPIC 202)
		(Load rsPIC 203)
		(Load rsPIC 204)
		(Load rsPIC 205)
		(self setRegions: 520) ; kq4Intro
		(super init:)
		(= gIntroSc introSc)
		(gCurRoom setScript: introSc)
		(= gUserFont gSmallFont)
	)

	(method (newRoom newRoomNumber)
		(if (IsObject local30)
			(local30 dispose:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(cond
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_F2))
				(DoSound sndSET_SOUND (not (DoSound sndSET_SOUND)))
			)
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				(gGame restart:)
			)
		)
	)
)

(instance introSc of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(gAddToPics dispose:)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(gCurRoom drawPic: 201)
				(openMusic number: 103 play:)
				(= local19
					((Act new:)
						view: 750
						loop: 0
						posn: 130 130
						stopUpd:
						init:
						yourself:
					)
				)
				(= local20
					((Act new:)
						view: 769
						loop: 2
						posn: 140 119
						stopUpd:
						init:
						yourself:
					)
				)
				(= local21
					((Act new:)
						view: 760
						posn: 220 148
						loop: 1
						cel: 5
						stopUpd:
						init:
						yourself:
					)
				)
				(= local18
					((Act new:)
						view: 759
						loop: 1
						posn: 212 135
						stopUpd:
						init:
						yourself:
					)
				)
				(= local22
					((Act new:)
						view: 767
						posn: 48 120
						xStep: 4
						yStep: 2
						loop: 0
						cycleSpeed: 0
						cel: 3
						stopUpd:
						init:
						yourself:
					)
				)
				((View new:)
					view: 768
					posn: 158 64
					setPri: 0
					ignoreActors:
					addToPic:
				)
				((View new:)
					view: 769
					loop: 3
					posn: 48 139
					setPri: 0
					ignoreActors:
					addToPic:
				)
				(Timer setReal: self 2)
			)
			(1
				(= local30 (Print 120 0 #at -1 20 #width 300 #dispose)) ; "With the return of his long-lost son, Alexander, and the rescue of his daughter, Rosella, from the terrible dragon, old King Graham decides it's time to pass on his adventurer's hat to younger blood."
				(Timer setReal: self 10)
			)
			(2
				(local19 setCycle: Walk setMotion: MoveTo 145 140 self)
			)
			(3
				(local19 setMotion: MoveTo 48 144 self)
			)
			(4
				(local22 hide:)
				(local19 setMotion: MoveTo 130 140 self)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local19 setMotion: MoveTo 134 131 self)
			)
			(6
				(local19 setLoop: 0)
				(= local30 (Print 120 1 #width 300 #at -1 22 #dispose)) ; "He flings the battered hat toward his children while his wife, Queen Valanice, proudly looks on."
				(= seconds 11)
			)
			(7
				(local19 view: 750 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(8
				(local22
					show:
					posn: (+ (local19 x:) 10) (- (local19 y:) 20)
					setCycle: Rev
					moveSpeed: 1
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 220 70 self
				)
				(local21
					view: 761
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 275 145
				)
				(local18
					view: 761
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 275 135
				)
			)
			(9
				(local19 setLoop: 3 setCycle: End stopKing)
				(= seconds 1)
			)
			(10
				(local22 stopUpd:)
				(= seconds 1)
			)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 202)
				(local22
					show:
					setLoop: 1
					setCel: 0
					posn: 105 99
					ignoreActors:
					setStep: 4 2
					moveSpeed: 0
					cycleSpeed: 0
					setCycle: Rev
					setMotion: MoveTo 275 120
				)
				(= local30 (Print 120 2 #mode 1 #at -1 160 #dispose)) ; "The hat arches through the air."
				(Timer setReal: self 3)
			)
			(12
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= local30 (Print 120 3 #at -1 160 #dispose)) ; "Suddenly...!"
				(Timer setReal: self 3)
			)
			(13
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local22 hide: stopUpd:)
				(= local31
					((Act new:)
						view: 769
						loop: 0
						posn: 160 114
						cycleSpeed: 5
						cel: 0
						setCycle: End stopKing
						init:
						yourself:
					)
				)
				(= local30 (Print 120 4 #at -1 150 #dispose)) ; "King Graham experiences a terrible squeezing pain in his chest."
				(Timer setReal: self 7)
			)
			(14
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local31 dispose:)
				(gCurRoom drawPic: 201)
				(local19
					cycleSpeed: 0
					view: 769
					posn: 135 130
					setLoop: 1
					cel: 0
					setCycle: End stopKing
					ignoreActors:
					show:
				)
				(local18
					show:
					view: 759
					setLoop: 1
					xStep: 2
					setCycle: Walk
					setMotion: MoveTo 227 136
				)
				(local21
					show:
					view: 760
					loop: 1
					xStep: 2
					setCycle: Walk
					setMotion: MoveTo 216 147 self
				)
				(local20
					show:
					view: 769
					cycleSpeed: 4
					setLoop: 2
					setCycle: End stopQueen
				)
				((View new:) view: 768 posn: 158 64 ignoreActors: addToPic:)
				((View new:)
					view: 769
					loop: 3
					posn: 48 139
					setPri: 0
					ignoreActors:
					addToPic:
				)
				(local22 show: setCel: 3 setLoop: 0 posn: 300 144 stopUpd:)
				(= local30 (Print 120 5 #title {King Graham} #at 53 165 #dispose)) ; ""Help me," he rasps."
			)
			(15
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Timer setReal: self 3)
			)
			(16
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 203)
				(local22 show: setCel: 0 setLoop: 2 posn: 180 99 stopUpd:)
				(= local30 (Print 120 6 #at -1 162 #dispose)) ; "The adventurer's hat lies, unclaimed, upon the floor...forgotten."
				(Timer setReal: self 5)
			)
			(17
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local22 dispose:)
				(gCurRoom drawPic: 204)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 123 89
					ignoreActors:
					setPri: 0
					addToPic:
				)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 204 89
					ignoreActors:
					setPri: 0
					addToPic:
				)
				((Prop new:)
					view: 752
					loop: 4
					posn: 123 63
					cycleSpeed: 0
					setCycle: Fwd
					init:
					yourself:
				)
				((Prop new:)
					view: 752
					loop: 4
					posn: 204 63
					cycleSpeed: 0
					setCycle: Rev
					init:
					yourself:
				)
				((View new:)
					view: 752
					loop: 3
					posn: 47 139
					ignoreActors:
					addToPic:
				)
				(local19
					show:
					setPri: 15
					view: 752
					setLoop: 0
					setCel: 0
					posn: 162 144
					stopUpd:
				)
				(local20
					show:
					view: 756
					setPri: 9
					setLoop: 1
					setCel: 0
					ignoreActors:
					posn: 85 177
					stopUpd:
				)
				(local21
					show:
					view: 756
					setPri: 9
					loop: 0
					cel: 0
					ignoreActors:
					posn: 228 176
					stopUpd:
				)
				(local18
					show:
					view: 756
					setPri: 10
					loop: 2
					cel: 0
					posn: 251 177
					stopUpd:
				)
				(= local0 (Timer setReal: checkHang 15))
				(self cue:)
			)
			(18
				(if (!= (openMusic prevSignal:) -1)
					(-- state)
					(Timer setReal: self 2)
				else
					(Timer setReal: self 5)
					(if (IsObject local0)
						(local0 dispose:)
					)
				)
			)
			(19
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 205)
				(openMusic dispose:)
				((ScriptID 520 1) play:) ; KQ4MUSIC
				(local19
					show:
					view: 752
					setLoop: 1
					setCel: 0
					posn: 162 119
					setPri: 8
				)
				(= local30 (Print 120 7 #at -1 144 #dispose)) ; "King Graham lies weakly in bed, Father Death hovering near."
				(Timer setReal: self 7)
			)
			(20
				(cls)
				(gCurRoom drawPic: 204)
				(gCast eachElementDo: #show)
				((View new:)
					view: 752
					loop: 3
					posn: 47 139
					ignoreActors:
					addToPic:
				)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 123 89
					ignoreActors:
					setPri: 0
					addToPic:
				)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 204 89
					ignoreActors:
					setPri: 0
					addToPic:
				)
				(local19
					view: 752
					setPri: 15
					setLoop: 0
					setCel: 0
					posn: 163 137
					stopUpd:
				)
				(local20 setCel: 255 stopUpd:)
				(local21 setCel: 255 stopUpd:)
				(local18 setStep: 4 -1 setCycle: End setMotion: MoveTo 340 176)
				(= local30 (Print 120 8 #at -1 20 #width 300 #dispose)) ; "Grief suddenly overwhelming her, Rosella runs from the room."
				(Timer setReal: self 4)
			)
			(21
				(= global205 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom newRoom: 221)
			)
		)
	)
)

(instance stopKing of Script
	(properties)

	(method (cue)
		(local19 stopUpd:)
	)
)

(instance stopQueen of Script
	(properties)

	(method (cue)
		(local20 stopUpd:)
	)
)

(instance stopSon of Script ; UNUSED
	(properties)

	(method (cue)
		(local21 stopUpd:)
	)
)

(instance stopRosella of Script ; UNUSED
	(properties)

	(method (cue)
		(local18 stopUpd:)
	)
)

(instance checkHang of Script
	(properties)

	(method (cue)
		(gTimers eachElementDo: #dispose 96)
		(introSc changeState: 19)
	)
)

