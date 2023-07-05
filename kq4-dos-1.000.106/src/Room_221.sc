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
	Room_221 0
)

(local
	local0
	local1
	[local2 3]
	local5
	local6
	local7
	[local8 5]
	local13
	local14
	local15
	[local16 4]
	local20
	local21
	[local22 4]
	local26
	local27
	[local28 2]
	local30
	[local31 200]
)

(instance Room_221 of Rm
	(properties
		name {Room 221}
		picture 201
		style 8
	)

	(method (init)
		(Load rsVIEW 753)
		(Load rsVIEW 755)
		(Load rsVIEW 757)
		(Load rsVIEW 758)
		(Load rsVIEW 759)
		(Load rsVIEW 760)
		(Load rsVIEW 762)
		(Load rsVIEW 763)
		(Load rsVIEW 764)
		(Load rsVIEW 765)
		(Load rsVIEW 766)
		(Load rsVIEW 768)
		(Load rsVIEW 770)
		(Load rsVIEW 771)
		(Load rsPIC 201)
		(Load rsPIC 205)
		(Load rsPIC 207)
		(self setRegions: 520) ; KQ4_Intro
		(super init:)
		(gCurRoom setScript: PartTwo)
	)

	(method (newRoom newRoomNumber)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (gSounds contains: local1)
			(local1 dispose:)
		)
		((ScriptID 520) keep: 0) ; KQ4_Intro
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
				(= local20
					((Act new:)
						view: 768
						loop: 0
						posn: 158 65
						cycleSpeed: 4
						stopUpd:
						init:
						yourself:
					)
				)
				((View new:)
					view: 769
					loop: 3
					posn: 48 140
					setPri: 0
					ignoreActors:
					addToPic:
				)
				((View new:)
					view: 767
					setCel: 3
					setLoop: 0
					posn: 300 145
					addToPic:
				)
				(= local15
					((Act new:)
						view: 764
						loop: 1
						posn: 62 118
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
				(= local27
					(Print ; "Oh, father!" she sobs. "You're still young; you should have many years ahead of you! Oh, I wish I could help you, Father!"
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
				(local20 setLoop: 1 setCycle: Fwd)
				(= local27 (Print 221 1 #at 180 50 #width 110 #dispose)) ; ""Do you really mean that?" a soft voice asks."
				(= seconds 6)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local20 setLoop: 0 setCycle: 0)
				(local15 setLoop: 2 cycleSpeed: 20 setCycle: Fwd)
				(= local27
					(Print 221 2 #at 1 144 #title {Rosella} #width 150 #dispose) ; "Rosella looks up but sees no one. "Who's speaking to me?""
				)
				(= seconds 10)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local20 setLoop: 1 setCycle: Fwd)
				(= local27 (Print 221 3 #at 180 50 #width 110 #dispose)) ; "I am," the voice says. "Look in the magic mirror."
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
					posn: 230 121
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
				(= local15
					((Act new:)
						view: 763
						loop: 1
						cel: 0
						posn: 155 110
						setCycle: Fwd
						setPri: 15
						cycleSpeed: 3
						init:
						yourself:
					)
				)
				(= local21
					((Act new:)
						view: 766
						loop: 1
						cel: 0
						posn: 230 107
						setPri: 14
						cycleSpeed: 0
						setCycle: Fwd
						init:
						yourself:
					)
				)
				(= local27
					(Print 221 4 #at 1 161 #title {Rosella} #setPri 15 #width 200 #dispose) ; "Rosella sees an image in the mirror. "Wh-who are you?" she queries."
				)
				(= seconds 6)
			)
			(6
				(if (== ((ScriptID 520 1) state:) 3) ; KQ4MUSIC
					(-- state)
					(= seconds 2)
				else
					((ScriptID 520 1) keep: 0 dispose:) ; KQ4MUSIC
					(= local1 (Sound new:))
					(local1 number: 105 loop: 1 play:)
					(self cue:)
				)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local21 dispose:)
				(local15 dispose:)
				(gCurRoom drawPic: 205)
				((View new:)
					view: 762
					loop: 0
					name: {mirror}
					cel: 0
					posn: 149 111
					ignoreActors:
					setPri: 0
					addToPic:
				)
				(= local21
					((Act new:)
						view: 762
						cycleSpeed: 0
						loop: 1
						cel: 0
						posn: 148 97
						setPri: 6
						setCycle: Fwd
						init:
						yourself:
					)
				)
				(= local30
					((Act new:)
						view: 762
						loop: 4
						cel: 0
						ignoreHorizon:
						posn: 142 19
						setPri: 1
						init:
						yourself:
					)
				)
				(local30 setScript: doSparkle)
				(= local27
					(Print 221 5 #title {Genesta} #at -1 135 #width 300 #dispose) ; "I am the fairy, Genesta. In my land of Tamir there is a remarkable tree. This tiny tree needs one hundred years to bear a single fruit."
				)
				(= seconds 10)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= local27
					(Print 221 6 #title {Genesta} #at -1 135 #width 300 #dispose) ; "But, this is no ordinary fruit; for if a person were to eat it, they would find that good health and well-being would be theirs for many years."
				)
				(= seconds 12)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local21 dispose:)
				(local30 setScript: 0 dispose:)
				(gCurRoom drawPic: 207)
				((View new:)
					view: 766
					loop: 0
					cel: 0
					posn: 230 121
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
					posn: 230 110
					ignoreActors:
					setPri: 1
					addToPic:
				)
				(= local14
					((Act new:)
						view: 763
						loop: 1
						cel: 0
						posn: 155 110
						setCycle: Fwd
						cycleSpeed: 3
						setPri: 15
						init:
						yourself:
					)
				)
				(= local27
					(Print 221 7 #title {Rosella} #at 1 161 #width 200 #dispose) ; "Rosella is much heartened by this news! "Where is the land of Tamir?""
				)
				(= seconds 9)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local14 view: 766 loop: 3 cel: 0 posn: 230 72 setPri: 2)
				(= local27
					(Print 221 8 #title {Genesta} #at 100 161 #width 200 #dispose) ; "Genesta smiles. "Tamir is very far away. But with my magic, I can bring you here.""
				)
				(= seconds 12)
			)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local14
					view: 763
					setLoop: 1
					setCel: 0
					posn: 155 110
					setCycle: Fwd
					cycleSpeed: 3
				)
				(= local27
					(Print 221 9 #title {Rosella} #at 1 161 #width 200 #dispose) ; "Rosella senses that there is more to the story. "But, I suppose there are some problems?""
				)
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
					posn: 149 111
					ignoreActors:
					setPri: 0
					addToPic:
				)
				((View new:)
					view: 762
					loop: 2
					cel: 0
					posn: 149 99
					ignoreActors:
					setPri: 1
					addToPic:
				)
				(local14
					view: 762
					setLoop: 3
					setCel: 0
					posn: 149 60
					setCycle: Fwd
					cycleSpeed: 2
					setPri: 15
				)
				(= local30
					((Act new:)
						view: 762
						loop: 4
						cel: 0
						ignoreHorizon:
						posn: 142 19
						setPri: 1
						init:
						yourself:
					)
				)
				(local30 setScript: doSparkle)
				(= local27
					(Print 221 10 #title {Genesta} #at 1 145 #width 300 #dispose) ; "Again, Genesta smiles. "Yes, you are correct, Rosella. If you are willing to come to Tamir I will explain the situation.""
				)
				(= seconds 9)
			)
			(13
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= local27
					(Print 221 11 #title {Genesta} #at 1 145 #width 300 #dispose) ; "However, once I bring you here, I can't send you back; you will have to help me first."
				)
				(= seconds 8)
			)
			(14
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local30 setScript: 0 dispose:)
				(gCurRoom drawPic: 207)
				((View new:)
					view: 766
					loop: 0
					cel: 0
					posn: 230 121
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
					posn: 230 110
					ignoreActors:
					setPri: 1
					addToPic:
				)
				(local14
					view: 763
					loop: 1
					cel: 0
					posn: 155 110
					setCycle: Fwd
					cycleSpeed: 3
					setPri: 15
				)
				(= local13
					((Act new:)
						view: 766
						loop: 4
						cel: 0
						posn: 230 107
						setCycle: Fwd
						cycleSpeed: 3
						setPri: 15
						init:
						yourself:
					)
				)
				(= local27
					(Print 221 12 #title {Rosella} #at 1 161 #width 200 #dispose) ; "Confused, Rosella says, "I don't know! What if I can't help you; or find the tree?""
				)
				(= seconds 10)
			)
			(15
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local14 view: 766 loop: 3 cel: 0 posn: 230 72 setPri: 2)
				(= local27
					(Print 221 13 #title {Genesta} #at 100 161 #width 200 #dispose) ; "Genesta pleads, "You must decide NOW, Rosella. My powers are growing weaker by the minute.""
				)
				(= seconds 8)
			)
			(16
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local14 dispose:)
				(local13 dispose:)
				(gCurRoom drawPic: 201)
				(= local20
					((Act new:)
						view: 768
						loop: 1
						setCycle: Fwd
						posn: 158 65
						cycleSpeed: 4
						init:
						yourself:
					)
				)
				((View new:)
					view: 769
					loop: 3
					posn: 48 140
					setPri: 0
					ignoreActors:
					addToPic:
				)
				((View new:)
					view: 767
					setCel: 3
					setLoop: 0
					posn: 300 145
					addToPic:
				)
				(= local15
					((Act new:)
						view: 764
						loop: 0
						posn: 172 95
						cycleSpeed: 4
						stopUpd:
						init:
						yourself:
					)
				)
				(= seconds 3)
			)
			(17
				(= local27
					(Print 221 14 #title {Genesta} #at -1 140 #width 300 #dispose) ; "Now, the fairy is but a faint glimmer, and her voice barely audible. "If you care for your father, say `yes' now!..." And suddenly she's gone."
				)
				(= seconds 9)
			)
			(18
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local20
					setLoop: 2
					setCel: 0
					cycleSpeed: 2
					setCycle: End stopMirror
				)
				(= local27 (Print 221 15 #title {Rosella} #at 215 50 #dispose)) ; "YES!!"
				(= seconds 3)
			)
			(19
				(if
					(or
						(not (gSounds contains: local1))
						(>= (local1 prevSignal:) 46)
						(>= (local1 signal:) 46)
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
				(= local26
					((Act new:)
						view: 770
						loop: 0
						posn: (local15 x:) (local15 y:)
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
				(local15 dispose:)
				(local26 setLoop: 1 setCycle: End self)
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
		(local15 stopUpd:)
	)
)

(instance hideRosella of Script ; UNUSED
	(properties)

	(method (cue)
		(local15 hide:)
	)
)

(instance stopMirror of Script
	(properties)

	(method (cue)
		(local20 stopUpd:)
	)
)

(instance doSparkle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 4))
				(local30 hide:)
			)
			(1
				(local30 cel: 0 setCycle: End self show:)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance blinkEyes of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7
					((Act new:)
						view: 765
						loop: 3
						setCel: 0
						posn: 201 68
						setPri: 14
						cycleSpeed: 2
						ignoreActors:
						hide:
						init:
						yourself:
					)
				)
				(self changeState: 1)
			)
			(1
				(local7 hide:)
				(Timer setReal: self (Random 4 7))
			)
			(2
				(local7 show: setCycle: End self)
			)
			(3
				(self changeState: 1)
			)
			(4
				(if timer
					(timer dispose:)
				)
				(local7 show:)
				(local7 setLoop: 1 setCycle: End self)
			)
			(5
				(local7 setLoop: 3 hide:)
				(= local5 ((Act new:) view: 765 setLoop: 4 init: yourself:))
				(local5
					cel: 2
					setCel:
					posn: (+ (local7 x:) 9) (+ (local7 y:) 6)
					setPri: 15
					ignoreActors:
					setStep: 0 1
					setMotion: MoveTo (+ (local7 x:) 9) (+ (local7 y:) 30) self
				)
			)
			(6
				(local5 dispose:)
				(self changeState: 1)
			)
			(7
				(local7 dispose:)
			)
		)
	)
)

(instance rosellaBlinks of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7
					((Act new:)
						view: 753
						loop: 1
						setCel: 0
						posn: 50 65
						setPri: 14
						cycleSpeed: 5
						ignoreActors:
						init:
						yourself:
					)
				)
				(self changeState: 1)
			)
			(1
				(local7 hide:)
				(Timer setReal: self (Random 4 7))
			)
			(2
				(local7 show: setCycle: End self)
			)
			(3
				(self changeState: 1)
			)
			(4
				(if timer
					(timer dispose:)
				)
			)
		)
	)
)

