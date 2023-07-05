;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 694)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room694 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance Room694 of Rm
	(properties
		picture 204
		style 8
	)

	(method (init)
		(super init:)
		(self setRegions: 521) ; RgEnd
		(= number gCurRoomNum)
		(gCurRoom setScript: actions)
	)
)

(instance actions of Script
	(properties)

	(method (changeState newState &tmp [temp0 12])
		(switch (= state newState)
			(0
				(= local6 1)
				(self changeState: 500)
			)
			(1
				(if (gEgo has: 25) ; Magic_Fruit
					(self changeState: 100)
				else
					((View new:)
						view: 786
						loop: 4
						cel: 0
						posn: 277 171
						setPri: 13
						ignoreActors:
						init:
						addToPic:
					)
					(= local4 (Prop new:))
					(local4
						view: 786
						loop: 5
						cel: 0
						posn: 277 138
						setPri: 14
						init:
					)
					(= seconds 6)
				)
			)
			(2
				(gCast eachElementDo: #dispose)
				(gAddToPics eachElementDo: #dispose)
				(gCurRoom drawPic: 991)
				(self changeState: 3)
			)
			(3
				(= local2 (View new:))
				(local2
					view: 752
					loop: 1
					cel: 0
					posn: 159 114
					setPri: 14
					init:
					addToPic:
				)
				(= global120 (Print 694 0 #at -1 117 #dispose)) ; "You made it just in time. Just in time, that is... to look your father in the eyes before he quietly dies. He must have been waiting for your return."
				(= local3 (Prop new:))
				(local3
					view: 752
					loop: 5
					cel: 2
					posn: 164 88
					cycleSpeed: 18
					setPri: 15
					init:
					setCycle: Beg self
				)
			)
			(4
				(local3
					view: 752
					loop: 5
					cel: 0
					posn: 164 88
					cycleSpeed: 8
					setPri: 15
					init:
					setCycle: End self
				)
				(= seconds 12)
			)
			(5
				(cls)
				(gCast eachElementDo: #dispose)
				(gAddToPics eachElementDo: #dispose)
				(local3 dispose:)
				(= local6 6)
				(self changeState: 500)
			)
			(6
				((View new:)
					view: 786
					loop: 4
					cel: 0
					posn: 277 171
					setPri: 13
					ignoreActors:
					init:
					addToPic:
				)
				(= local4 (Prop new:))
				(local4 view: 786 loop: 5 cel: 0 posn: 277 138 setPri: 14 init:)
				(= seconds 3)
			)
			(7
				(= global120 (Print 694 1 #at -1 25 #width 240 #dispose)) ; "Obviously, it would have been better if things had ended happily. If only you could have another chance..."
				(= seconds 2)
				(local0 cel: 1)
			)
			(8
				(local4 cel: 3)
				(local1 cel: 1)
				(if (== ((ScriptID 521 1) state:) 3) ; ENDMUSIC
					((ScriptID 521 1) client: actions) ; ENDMUSIC
					((ScriptID 0 4) setReal: self 10) ; timer1
				else
					(= seconds 10)
				)
			)
			(9
				(if
					(or
						(gTimers contains: (ScriptID 0 4)) ; timer1
						(== ((ScriptID 521 1) state:) 3) ; ENDMUSIC
					)
					(-- state)
				else
					(self changeState: 10)
				)
			)
			(10
				(= gDeathFlag 1)
				(cls)
			)
			(100
				(= local5 (Act new:))
				(= local4 (Act new:))
				(local4
					view: 786
					setLoop: 5
					cel: 2
					posn: 298 141
					setPri: 13
					ignoreActors:
					setMotion: MoveTo 250 142
					init:
				)
				(local5
					view: 786
					setLoop: 4
					cel: 0
					posn: 298 174
					setPri: 12
					setMotion: MoveTo 250 175 self
					init:
				)
			)
			(101
				(local4 cel: 4)
				(gEgo put: 25 999) ; Magic_Fruit
				(= global120 (Print 694 2 #at -1 35 #width 240 #dispose)) ; "You give the healing fruit to your dying father and strongly urge him to take a bite...which he weakly does."
				(= seconds 8)
			)
			(102
				(cls)
				(gCast eachElementDo: #dispose)
				(gAddToPics eachElementDo: #dispose)
				(gCurRoom drawPic: 991)
				((View new:)
					view: 752
					loop: 1
					cel: 0
					posn: 159 114
					setPri: 14
					init:
					addToPic:
				)
				(= local3 (Prop new:))
				(local3
					view: 752
					setLoop: 6
					cel: 0
					posn: 164 88
					cycleSpeed: 10
					setCycle: Fwd
					setPri: 15
					init:
				)
				(= seconds 8)
			)
			(103
				(local3 setLoop: 7 cel: 0 cycleSpeed: 18 setCycle: End self)
			)
			(104
				(local3 dispose:)
				((View new:)
					view: 786
					loop: 2
					cel: 0
					posn: 85 177
					setPri: 11
					ignoreActors:
					init:
					addToPic:
				)
				(= local0 (Prop new:))
				(local0
					view: 786
					loop: 3
					cel: 2
					posn: 85 147
					setPri: 12
					init:
					stopUpd:
				)
				((View new:)
					view: 786
					loop: 0
					cel: 0
					posn: 228 176
					setPri: 11
					ignoreActors:
					init:
					addToPic:
				)
				(= local1 (Prop new:))
				(local1
					view: 786
					loop: 1
					cel: 2
					posn: 228 101
					setPri: 12
					init:
					stopUpd:
				)
				((View new:)
					view: 752
					loop: 0
					cel: 1
					posn: 163 137
					setPri: 14
					ignoreActors:
					init:
					addToPic:
				)
				((View new:)
					view: 786
					setLoop: 5
					cel: 4
					posn: 250 141
					setPri: 13
					ignoreActors:
					init:
					addToPic:
				)
				((View new:)
					view: 786
					setLoop: 4
					cel: 0
					posn: 250 174
					setPri: 12
					init:
					addToPic:
				)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 204 89
					setPri: 6
					init:
					addToPic:
				)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 123 89
					setPri: 6
					init:
					addToPic:
				)
				((Prop new:)
					view: 752
					loop: 4
					cel: 1
					posn: 204 63
					setPri: 14
					ignoreActors:
					cycleSpeed: 1
					setCycle: Fwd
					init:
				)
				((Prop new:)
					view: 752
					loop: 4
					cel: 0
					posn: 123 63
					setPri: 14
					ignoreActors:
					cycleSpeed: 1
					setCycle: Fwd
					init:
				)
				((View new:)
					view: 752
					loop: 3
					cel: 0
					posn: 64 139
					setPri: 0
					init:
					addToPic:
				)
				(gCurRoom drawPic: 204)
				(= seconds 4)
			)
			(105
				(= global120 (Print 694 3 #at -1 20 #width 240 #title {Rosella} #dispose)) ; ""How are you feeling, Father?" you excitedly ask him."
				(= seconds 7)
			)
			(106
				(cls)
				(= global120
					(Print 694 4 #at -1 20 #width 240 #title {King Graham} #dispose) ; ""Never felt better in my life!" is his reply. "What is IN this fruit, anyway?" he wonders."
				)
				(= seconds 7)
			)
			(107
				(cls)
				(= global120 (Print 694 5 #at -1 20 #width 240 #title {Rosella} #dispose)) ; ""It is MAGIC, Father!" and you tell your excited family of your adventure in Tamir."
				(= seconds 8)
			)
			(108
				(cls)
				(gCast eachElementDo: #dispose)
				(gAddToPics eachElementDo: #dispose)
				(gCurRoom drawPic: 991)
				(= local3 (View new:))
				(local3
					view: 752
					setLoop: 0
					cel: 3
					posn: 159 114
					setPri: 14
					init:
				)
				(= global120 (Print 694 6 #at -1 138 #width 240 #title {Rosella} #dispose)) ; "I don't think you're through with this hat, yet!" you say. Your brother, Alexander, and your mother, Queen Valanice, readily agree. "You've got too much life ahead of you!"
				(= seconds 15)
			)
			(109
				(cls)
				(local3 dispose:)
				((View new:)
					view: 786
					loop: 2
					cel: 0
					posn: 85 177
					setPri: 11
					ignoreActors:
					init:
					addToPic:
				)
				(= local0 (Prop new:))
				(local0
					view: 786
					loop: 3
					cel: 2
					posn: 85 147
					setPri: 12
					init:
					stopUpd:
				)
				((View new:)
					view: 786
					loop: 0
					cel: 0
					posn: 228 176
					setPri: 11
					ignoreActors:
					init:
					addToPic:
				)
				(= local1 (Prop new:))
				(local1
					view: 786
					loop: 1
					cel: 2
					posn: 228 101
					setPri: 12
					init:
					stopUpd:
				)
				((View new:)
					view: 752
					loop: 0
					cel: 1
					posn: 163 137
					setPri: 14
					ignoreActors:
					init:
					addToPic:
				)
				((View new:)
					view: 752
					loop: 0
					cel: 2
					posn: 158 82
					ignoreActors:
					setPri: 15
					init:
				)
				((View new:)
					view: 786
					setLoop: 4
					cel: 0
					posn: 250 174
					setPri: 12
					init:
					addToPic:
				)
				((View new:)
					view: 786
					setLoop: 5
					cel: 4
					posn: 250 141
					setPri: 13
					ignoreActors:
					init:
					addToPic:
				)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 204 89
					setPri: 6
					init:
					addToPic:
				)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 123 89
					setPri: 6
					init:
					addToPic:
				)
				((Prop new:)
					view: 752
					loop: 4
					cel: 1
					posn: 204 63
					setPri: 14
					ignoreActors:
					cycleSpeed: 1
					setCycle: Fwd
					init:
				)
				((Prop new:)
					view: 752
					loop: 4
					cel: 0
					posn: 123 63
					setPri: 14
					ignoreActors:
					cycleSpeed: 1
					setCycle: Fwd
					init:
				)
				((View new:)
					view: 752
					loop: 3
					cel: 0
					posn: 64 139
					setPri: 0
					init:
					addToPic:
				)
				(gCurRoom drawPic: 204)
				(if (== ((ScriptID 521 1) state:) 3) ; ENDMUSIC
					((ScriptID 521 1) client: actions) ; ENDMUSIC
					((ScriptID 0 4) setReal: self 5) ; timer1
				else
					(= seconds 5)
				)
			)
			(110
				(if
					(or
						(gTimers contains: (ScriptID 0 4)) ; timer1
						(== ((ScriptID 521 1) state:) 3) ; ENDMUSIC
					)
					(-- state)
				else
					(self changeState: 111)
				)
			)
			(111
				(Print 694 7 #at -1 85 #icon 100 0 0 #dispose) ; "So, all's well, that ends well. Until next time...!           Good-bye!"
				(= global160 0)
				(= seconds 10)
			)
			(112
				(cls)
			)
			(500
				((View new:)
					view: 786
					loop: 2
					cel: 0
					posn: 85 177
					setPri: 11
					ignoreActors:
					init:
					addToPic:
				)
				((View new:)
					view: 786
					loop: 0
					cel: 0
					posn: 228 176
					setPri: 11
					ignoreActors:
					init:
					addToPic:
				)
				((View new:)
					view: 752
					loop: 0
					cel: 0
					posn: 163 137
					setPri: 15
					ignoreActors:
					init:
					addToPic:
				)
				(= local1 (Prop new:))
				(local1
					view: 786
					loop: 1
					cel: 0
					posn: 228 101
					setPri: 12
					init:
					stopUpd:
				)
				(= local0 (Prop new:))
				(local0
					view: 786
					loop: 3
					cel: 0
					posn: 85 147
					setPri: 12
					init:
					stopUpd:
				)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 204 89
					setPri: 6
					init:
					addToPic:
				)
				((View new:)
					view: 752
					loop: 2
					cel: 0
					posn: 123 89
					setPri: 6
					init:
					addToPic:
				)
				((Prop new:)
					view: 752
					loop: 4
					cel: 1
					posn: 204 63
					setPri: 14
					ignoreActors:
					cycleSpeed: 1
					setCycle: Fwd
					init:
				)
				((Prop new:)
					view: 752
					loop: 4
					cel: 0
					posn: 123 63
					setPri: 14
					ignoreActors:
					cycleSpeed: 1
					setCycle: Fwd
					init:
				)
				((View new:)
					view: 752
					loop: 3
					cel: 0
					posn: 64 139
					setPri: 0
					init:
					addToPic:
				)
				(gCurRoom drawPic: 204)
				(self changeState: local6)
			)
			(600
				(StrAt @temp0 10)
				(for ((= local7 0)) (<= local7 9) ((++ local7))
					(StrAt @temp0 local7 (+ (Random 0 25) 65))
				)
				(StrAt @temp0 10 0)
				(if (== gScore 230)
					(StrAt @temp0 2 69)
					(StrAt @temp0 6 52)
					(StrAt @temp0 9 65)
				)
				(Print
					(Format @global228 {Your Secret Code is:\n\n   %s} @temp0)
				)
			)
		)
	)
)

