;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 221)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room221 0
)

(local
	local0
	[local1 11]
	local12
	local13
	local14
	[local15 4]
	local19
	local20
	[local21 4]
	local25
	local26
	[local27 2]
	local29
	[local30 200]
)

(instance openMusic of Sound
	(properties)
)

(instance Room221 of Rm
	(properties
		picture 201
		style 8
	)

	(method (init)
		(Load rsVIEW 757)
		(Load rsVIEW 758)
		(Load rsVIEW 762)
		(Load rsVIEW 766)
		(Load rsVIEW 768)
		(Load rsVIEW 770)
		(Load rsVIEW 771)
		(Load rsPIC 201)
		(Load rsPIC 205)
		(Load rsPIC 207)
		(self setRegions: 520) ; kq4Intro
		(super init:)
		(gCurRoom setScript: PartTwo)
	)

	(method (newRoom newRoomNumber)
		(cls)
		((ScriptID 520) keep: 0) ; kq4Intro
		(super newRoom: newRoomNumber)
	)
)

(instance PartTwo of Script
	(properties)

	(method (handleEvent event)
		(cond
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_F2))
				(= local0 (DoSound sndSET_SOUND))
				(DoSound sndSET_SOUND (not local0))
			)
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				(gGame restart:)
			)
		)
	)

	(method (changeState newState)
		(gAddToPics dispose:)
		(switch (= state newState)
			(0
				(= local19
					((Act new:)
						view: 768
						loop: 0
						posn: 158 64
						cycleSpeed: 4
						stopUpd:
						init:
						yourself:
					)
				)
				((View new:)
					view: 769
					loop: 3
					posn: 48 139
					setPri: 0
					ignoreActors:
					addToPic:
				)
				((View new:)
					view: 767
					setCel: 3
					setLoop: 0
					posn: 300 144
					addToPic:
				)
				(= local14
					((Act new:)
						view: 764
						loop: 1
						posn: 62 117
						cycleSpeed: 4
						setCycle: Fwd
						setPri: 8
						init:
						yourself:
					)
				)
				(= seconds 2)
			)
			(1
				(= local26
					(Print ; "Oh, Father!" she sobs. "You're still young; you should have many years ahead of you! Oh, I wish I could help you, Father!"
						221
						0
						#title
						{Rosella}
						#at
						1
						150
						#width
						150
						#title
						{Rosella}
						#dispose
						#draw
					)
				)
				(= seconds 6)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local19 setLoop: 1 setCycle: Fwd)
				(= local26 (Print 221 1 #at 180 50 #width 110 #dispose)) ; ""Do you really mean that?" a soft voice asks."
				(= seconds 6)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local19 setLoop: 0 setCycle: 0)
				(local14 setLoop: 2 cycleSpeed: 20 setCycle: Fwd)
				(= local26 (Print 221 2 #at 1 144 #title {Rosella} #width 150 #dispose)) ; "Rosella looks up but sees no one. "Who's speaking to me?""
				(= seconds 10)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local19 setLoop: 1 setCycle: Fwd)
				(= local26 (Print 221 3 #at 180 50 #width 110 #dispose)) ; "I am," the voice says. "Look in the magic mirror."
				(= seconds 12)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 207)
				((View new:)
					view: 766
					loop: 0
					cel: 0
					posn: 230 120
					setPri: 0
					ignoreActors:
					addToPic:
				)
				((View new:)
					view: 763
					cel: 0
					loop: 0
					posn: 137 138
					ignoreActors:
					setPri: 0
					addToPic:
				)
				(= local14
					((Act new:)
						view: 763
						loop: 1
						cel: 0
						posn: 155 109
						setCycle: Fwd
						setPri: 15
						cycleSpeed: 3
						init:
						yourself:
					)
				)
				(= local20
					((Act new:)
						view: 766
						loop: 1
						cel: 0
						posn: 230 106
						setPri: 14
						cycleSpeed: 0
						setCycle: Fwd
						init:
						yourself:
					)
				)
				(= local26
					(Print 221 4 #at 1 161 #title {Rosella} #setPri 15 #width 200 #dispose) ; "Rosella sees an image in the mirror. "Wh-who are you?" she queries."
				)
				(= seconds 6)
			)
			(6
				(if (== ((ScriptID 520 1) state:) 3) ; KQ4MUSIC
					(-- state)
					(= seconds 2)
				else
					((ScriptID 520 1) dispose:) ; KQ4MUSIC
					(openMusic number: 105 play:)
					(self cue:)
				)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local20 dispose:)
				(local14 dispose:)
				(gCurRoom drawPic: 205)
				((View new:)
					view: 762
					loop: 0
					cel: 0
					posn: 149 110
					ignoreActors:
					setPri: 0
					addToPic:
				)
				(= local20
					((Act new:)
						view: 762
						cycleSpeed: 0
						loop: 1
						cel: 0
						posn: 148 96
						setPri: 6
						setCycle: Fwd
						init:
						yourself:
					)
				)
				(= local29
					((Act new:)
						view: 762
						loop: 4
						cel: 0
						ignoreHorizon:
						posn: 142 18
						setPri: 1
						init:
						yourself:
					)
				)
				(local29 setScript: doSparkle)
				(= local26 (Print 221 5 #title {Genesta} #at -1 135 #width 300 #dispose)) ; "I am the fairy, Genesta. In my land of Tamir there is a remarkable tree. This tiny tree needs one hundred years to bear a single fruit."
				(= seconds 10)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= local26 (Print 221 6 #title {Genesta} #at -1 135 #width 300 #dispose)) ; "But, this is no ordinary fruit; for if a person were to eat it, they would find that good health and well-being would be theirs for many years."
				(= seconds 12)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local20 dispose:)
				(local29 setScript: 0 dispose:)
				(gCurRoom drawPic: 207)
				((View new:)
					view: 766
					loop: 0
					cel: 0
					posn: 230 120
					setPri: 0
					ignoreActors:
					addToPic:
				)
				((View new:)
					view: 763
					cel: 0
					loop: 0
					posn: 137 138
					ignoreActors:
					setPri: 0
					addToPic:
				)
				((View new:)
					view: 766
					cel: 0
					loop: 2
					posn: 230 109
					ignoreActors:
					setPri: 1
					addToPic:
				)
				(= local13
					((Act new:)
						view: 763
						loop: 1
						cel: 0
						posn: 155 109
						setCycle: Fwd
						cycleSpeed: 3
						setPri: 15
						init:
						yourself:
					)
				)
				(= local26 (Print 221 7 #title {Rosella} #at 1 161 #width 200 #dispose)) ; "Rosella is much heartened by this news! "Where is the land of Tamir?""
				(= seconds 9)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local13 view: 766 loop: 3 cel: 0 posn: 230 71 setPri: 2)
				(= local26 (Print 221 8 #title {Genesta} #at 100 161 #width 200 #dispose)) ; "Genesta smiles. "Tamir is very far away. But with my magic, I can bring you here.""
				(= seconds 12)
			)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local13
					view: 763
					setLoop: 1
					setCel: 0
					posn: 155 109
					setCycle: Fwd
					cycleSpeed: 3
				)
				(= local26 (Print 221 9 #title {Rosella} #at 1 161 #width 200 #dispose)) ; "Rosella senses that there is more to the story. "But, I suppose there are some problems?""
				(= seconds 10)
			)
			(12
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom drawPic: 205)
				((View new:)
					view: 762
					loop: 0
					cel: 0
					posn: 149 110
					ignoreActors:
					setPri: 0
					addToPic:
				)
				((View new:)
					view: 762
					loop: 2
					cel: 0
					posn: 149 98
					ignoreActors:
					setPri: 1
					addToPic:
				)
				(local13
					view: 762
					setLoop: 3
					setCel: 0
					posn: 149 59
					setCycle: Fwd
					cycleSpeed: 2
					setPri: 15
				)
				(= local29
					((Act new:)
						view: 762
						loop: 4
						cel: 0
						ignoreHorizon:
						posn: 142 18
						setPri: 1
						init:
						yourself:
					)
				)
				(local29 setScript: doSparkle)
				(= local26 (Print 221 10 #title {Genesta} #at 1 145 #width 300 #dispose)) ; "Again, Genesta smiles. "Yes, you are correct, Rosella. If you are willing to come to Tamir I will explain the situation.""
				(= seconds 9)
			)
			(13
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= local26 (Print 221 11 #title {Genesta} #at 1 145 #width 300 #dispose)) ; "However, once I bring you here, I can't send you back; you will have to help me first."
				(= seconds 8)
			)
			(14
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local29 setScript: 0 dispose:)
				(gCurRoom drawPic: 207)
				((View new:)
					view: 766
					loop: 0
					cel: 0
					posn: 230 120
					setPri: 0
					ignoreActors:
					addToPic:
				)
				((View new:)
					view: 763
					cel: 0
					loop: 0
					posn: 137 139
					ignoreActors:
					setPri: 0
					addToPic:
				)
				((View new:)
					view: 766
					cel: 0
					loop: 2
					posn: 230 109
					ignoreActors:
					setPri: 1
					addToPic:
				)
				(local13
					view: 763
					loop: 1
					cel: 0
					posn: 155 109
					setCycle: Fwd
					cycleSpeed: 3
					setPri: 15
				)
				(= local12
					((Act new:)
						view: 766
						loop: 4
						cel: 0
						posn: 230 106
						setCycle: Fwd
						cycleSpeed: 3
						setPri: 15
						init:
						yourself:
					)
				)
				(= local26 (Print 221 12 #title {Rosella} #at 1 161 #width 200 #dispose)) ; "Confused, Rosella says, "I don't know! What if I can't help you; or find the tree?""
				(= seconds 10)
			)
			(15
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local13 view: 766 loop: 3 cel: 0 posn: 230 71 setPri: 2)
				(= local26 (Print 221 13 #title {Genesta} #at 100 161 #width 200 #dispose)) ; "Genesta pleads, "You must decide NOW, Rosella. My powers are growing weaker by the minute.""
				(= seconds 8)
			)
			(16
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local13 dispose:)
				(local12 dispose:)
				(gCurRoom drawPic: 201)
				(= local19
					((Act new:)
						view: 768
						loop: 1
						setCycle: Fwd
						posn: 158 64
						cycleSpeed: 4
						init:
						yourself:
					)
				)
				((View new:)
					view: 769
					loop: 3
					posn: 48 139
					setPri: 0
					ignoreActors:
					addToPic:
				)
				((View new:)
					view: 767
					setCel: 3
					setLoop: 0
					posn: 300 144
					addToPic:
				)
				(= local14
					((Act new:)
						view: 764
						loop: 0
						posn: 172 94
						cycleSpeed: 4
						stopUpd:
						init:
						yourself:
					)
				)
				(= seconds 3)
			)
			(17
				(= local26 (Print 221 14 #title {Genesta} #at -1 140 #width 300 #dispose)) ; "Now, the fairy is but a faint glimmer, and her voice barely audible. "If you care for your father, say `yes' now!..." And suddenly she's gone."
				(= seconds 9)
			)
			(18
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local19
					setLoop: 2
					setCel: 0
					cycleSpeed: 2
					setCycle: End stopMirror
				)
				(= local26 (Print 221 15 #title {Rosella} #at 215 50 #dispose)) ; "YES!!"
				(= seconds 3)
			)
			(19
				(if
					(or
						(== (openMusic prevSignal:) -1)
						(>= (openMusic prevSignal:) 46)
						(>= (openMusic signal:) 46)
					)
					(self cue:)
				else
					(-- state)
					(= seconds 1)
				)
			)
			(20
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= local25
					((Act new:)
						view: 770
						loop: 0
						posn: (local14 x:) (local14 y:)
						setPri: 15
						ignoreActors:
						cycleSpeed: 2
						setCycle: End self
						init:
						yourself:
					)
				)
			)
			(21
				(local14 dispose:)
				(local25 setLoop: 1 setCycle: End self)
			)
			(22
				(gCurRoom newRoom: 222)
			)
		)
	)
)

(instance stopRosella of Script ; UNUSED
	(properties)

	(method (cue)
		(local14 stopUpd:)
	)
)

(instance hideRosella of Script ; UNUSED
	(properties)

	(method (cue)
		(local14 hide:)
	)
)

(instance stopMirror of Script
	(properties)

	(method (cue)
		(local19 stopUpd:)
	)
)

(instance doSparkle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 4))
				(local29 hide:)
			)
			(1
				(local29 cel: 0 setCycle: End self show:)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

