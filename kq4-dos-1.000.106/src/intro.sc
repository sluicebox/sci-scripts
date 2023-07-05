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
	local1
	[local2 17]
	local19
	local20
	local21
	local22
	local23
	[local24 7]
	local31
	local32
	[local33 202]
	local235
)

(instance intro of Rm
	(properties
		horizon 40
	)

	(method (init)
		(Load rsVIEW 750)
		(Load rsVIEW 752)
		(Load rsVIEW 753)
		(Load rsVIEW 755)
		(Load rsVIEW 756)
		(Load rsVIEW 757)
		(Load rsVIEW 758)
		(Load rsVIEW 759)
		(Load rsVIEW 760)
		(Load rsVIEW 761)
		(Load rsVIEW 762)
		(Load rsVIEW 763)
		(Load rsVIEW 764)
		(Load rsVIEW 765)
		(Load rsVIEW 766)
		(Load rsVIEW 767)
		(Load rsVIEW 768)
		(Load rsVIEW 769)
		(Load rsVIEW 770)
		(Load rsVIEW 771)
		(Load rsVIEW 666)
		(Load rsVIEW 110)
		(Load rsVIEW 111)
		(Load rsVIEW 879)
		(Load rsPIC 201)
		(Load rsPIC 202)
		(Load rsPIC 203)
		(Load rsPIC 204)
		(Load rsPIC 205)
		(self setRegions: 520) ; KQ4_Intro
		(super init:)
		(= gIntroSc introSc)
		(gCurRoom setScript: introSc)
		(= gUserFont gSmallFont)
	)

	(method (newRoom newRoomNumber)
		(if (IsObject local31)
			(local31 dispose:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(cond
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_F2))
				(= local1 (DoSound sndSET_SOUND))
				(DoSound sndSET_SOUND (not local1))
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
				(= local235 (Sound new:))
				(local235 number: 103 loop: 1 play:)
				(= local20
					((Act new:)
						view: 750
						loop: 0
						posn: 130 131
						stopUpd:
						init:
						yourself:
					)
				)
				(= local21
					((Act new:)
						view: 769
						loop: 2
						posn: 140 120
						stopUpd:
						init:
						yourself:
					)
				)
				(= local22
					((Act new:)
						view: 760
						posn: 220 149
						loop: 1
						cel: 5
						stopUpd:
						init:
						yourself:
					)
				)
				(= local19
					((Act new:)
						view: 759
						loop: 1
						posn: 212 136
						stopUpd:
						init:
						yourself:
					)
				)
				(= local23
					((Act new:)
						view: 767
						posn: 48 121
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
					posn: 158 65
					setPri: 0
					ignoreActors:
					addToPic:
				)
				((View new:)
					view: 769
					loop: 3
					posn: 48 140
					setPri: 0
					ignoreActors:
					addToPic:
				)
				(Timer setReal: self 2)
			)
			(1
				(= local31 (Print 120 0 #at -1 20 #width 300 #dispose)) ; "With the return of his long-lost son, Alexander, and the rescue of his daughter, Rosella, from the terrible dragon, old King Graham decides it's time to pass on his adventurer's hat to younger blood."
				(Timer setReal: self 10)
			)
			(2
				(local20 setCycle: Walk setMotion: MoveTo 145 140 self)
			)
			(3
				(local20 setMotion: MoveTo 48 144 self)
			)
			(4
				(local23 hide:)
				(local20 setMotion: MoveTo 130 140 self)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local20 setMotion: MoveTo 134 131 self)
			)
			(6
				(local20 setLoop: 0)
				(= local31 (Print 120 1 #width 300 #at -1 22 #dispose)) ; "He flings the battered hat toward his children while his wife, Queen Valanice, proudly looks on."
				(= seconds 11)
			)
			(7
				(local20 view: 750 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(8
				(local23
					show:
					posn: (+ (local20 x:) 10) (- (local20 y:) 20)
					setCycle: Rev
					moveSpeed: 1
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 220 70 self
				)
				(local22
					view: 761
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 275 145
				)
				(local19
					view: 761
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 275 135
				)
			)
			(9
				(local20 setLoop: 3 setCycle: End stopKing)
				(= seconds 1)
			)
			(10
				(local23 stopUpd:)
				(= seconds 1)
			)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 202)
				(local23
					show:
					setLoop: 1
					setCel: 0
					posn: 105 100
					ignoreActors:
					setStep: 4 2
					moveSpeed: 0
					cycleSpeed: 0
					setCycle: Rev
					setMotion: MoveTo 275 120
				)
				(= local31 (Print 120 2 #mode 1 #at -1 160 #dispose)) ; "The hat arches through the air."
				(Timer setReal: self 3)
			)
			(12
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= local31 (Print 120 3 #at -1 160 #dispose)) ; "Suddenly...!"
				(Timer setReal: self 3)
			)
			(13
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local23 hide: stopUpd:)
				(= local32
					((Act new:)
						view: 769
						loop: 0
						posn: 160 115
						cycleSpeed: 5
						cel: 0
						setCycle: End stopKing
						init:
						yourself:
					)
				)
				(= local31 (Print 120 4 #at -1 150 #dispose)) ; "King Graham experiences a terrible squeezing pain in his chest."
				(Timer setReal: self 7)
			)
			(14
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local32 dispose:)
				(gCurRoom drawPic: 201)
				(local20
					cycleSpeed: 0
					view: 769
					posn: 135 131
					setLoop: 1
					cel: 0
					setCycle: End stopKing
					ignoreActors:
					show:
				)
				(local19
					show:
					view: 759
					setLoop: 1
					xStep: 2
					setCycle: Walk
					setMotion: MoveTo 227 136
				)
				(local22
					show:
					view: 760
					loop: 1
					xStep: 2
					setCycle: Walk
					setMotion: MoveTo 216 147 self
				)
				(local21
					show:
					view: 769
					cycleSpeed: 4
					setLoop: 2
					setCycle: End stopQueen
				)
				((View new:) view: 768 posn: 158 65 ignoreActors: addToPic:)
				((View new:)
					view: 769
					loop: 3
					posn: 48 140
					setPri: 0
					ignoreActors:
					addToPic:
				)
				(local23 show: setCel: 3 setLoop: 0 posn: 300 145 stopUpd:)
				(= local31 (Print 120 5 #title {King Graham} #at 53 165 #dispose)) ; ""Help me," he rasps."
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
				(local23 show: setCel: 0 setLoop: 2 posn: 180 100 stopUpd:)
				(= local31 (Print 120 6 #at -1 162 #dispose)) ; "The adventurer's hat lies, unclaimed, upon the floor...forgotten."
				(Timer setReal: self 5)
			)
			(17
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local23 dispose:)
				(gCurRoom drawPic: 204)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 123 90
					ignoreActors:
					setPri: 0
					addToPic:
				)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 204 90
					ignoreActors:
					setPri: 0
					addToPic:
				)
				((Prop new:)
					view: 752
					loop: 4
					posn: 123 64
					cycleSpeed: 0
					setCycle: Fwd
					init:
					yourself:
				)
				((Prop new:)
					view: 752
					loop: 4
					posn: 204 64
					cycleSpeed: 0
					setCycle: Rev
					init:
					yourself:
				)
				((View new:)
					view: 752
					loop: 3
					posn: 47 140
					ignoreActors:
					addToPic:
				)
				(local20
					show:
					setPri: 15
					view: 752
					setLoop: 0
					setCel: 0
					posn: 162 145
					stopUpd:
				)
				(local21
					show:
					view: 756
					setPri: 9
					setLoop: 1
					setCel: 0
					ignoreActors:
					posn: 85 178
					stopUpd:
				)
				(local22
					show:
					view: 756
					setPri: 9
					loop: 0
					cel: 0
					ignoreActors:
					posn: 228 177
					stopUpd:
				)
				(local19
					show:
					view: 756
					setPri: 10
					loop: 2
					cel: 0
					posn: 251 178
					stopUpd:
				)
				(= local0 (Timer setReal: checkHang 15))
				(self cue:)
			)
			(18
				(if
					(and
						(gSounds contains: local235)
						(!= (local235 signal:) -1)
					)
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
				(if (gSounds contains: local235)
					(local235 dispose:)
				)
				((ScriptID 520 1) play:) ; KQ4MUSIC
				(local20
					show:
					view: 752
					setLoop: 1
					setCel: 0
					posn: 162 120
					setPri: 8
				)
				(= local31 (Print 120 7 #at -1 144 #dispose)) ; "King Graham lies weakly in bed, Father Death hovering near."
				(Timer setReal: self 7)
			)
			(20
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom drawPic: 204)
				(gCast eachElementDo: #show)
				((View new:)
					view: 752
					loop: 3
					posn: 47 140
					ignoreActors:
					addToPic:
				)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 123 90
					ignoreActors:
					setPri: 0
					addToPic:
				)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 204 90
					ignoreActors:
					setPri: 0
					addToPic:
				)
				(local20
					view: 752
					setPri: 15
					setLoop: 0
					setCel: 0
					posn: 163 138
					stopUpd:
				)
				(local21 setCel: 255 stopUpd:)
				(local22 setCel: 255 stopUpd:)
				(local19 setStep: 4 -1 setCycle: End setMotion: MoveTo 340 176)
				(= local31 (Print 120 8 #at -1 20 #width 300 #dispose)) ; "Grief suddenly overwhelming her, Rosella runs from the room."
				(Timer setReal: self 4)
			)
			(21
				(= global205 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom newRoom: 221) ; Room_221
			)
		)
	)
)

(instance stopKing of Script
	(properties)

	(method (cue)
		(local20 stopUpd:)
	)
)

(instance stopQueen of Script
	(properties)

	(method (cue)
		(local21 stopUpd:)
	)
)

(instance stopSon of Script ; UNUSED
	(properties)

	(method (cue)
		(local22 stopUpd:)
	)
)

(instance stopRosella of Script ; UNUSED
	(properties)

	(method (cue)
		(local19 stopUpd:)
	)
)

(instance checkHang of Script
	(properties)

	(method (cue)
		(gTimers eachElementDo: #dispose 192)
		(introSc changeState: 19)
	)
)

