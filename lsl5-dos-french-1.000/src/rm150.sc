;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm150 0
)

(local
	seenMsg
)

(instance rm150 of LLRoom
	(properties
		picture 145
	)

	(method (init)
		(LoadMany rsVIEW 145 146 1151 1145 1150 1215)
		(LoadMany rsSOUND 140 150 146 147)
		(HandsOff)
		(fScruemall init:)
		(pArm init:)
		(pLarry init:)
		(super init:)
		(SetFFRoom 155)
		(self setScript: sCartoon)
	)

	(method (dispose)
		(super dispose: &rest)
		(gTheMusic fade: 0 15 12 1)
	)
)

(instance fScruemall of Prop
	(properties
		x 153
		y 139
		view 145
		priority 10
		signal 16
	)
)

(instance fScruemallTopHalf of Prop
	(properties
		x 179
		y 95
		view 145
		loop 1
		priority 10
		signal 16
	)
)

(instance pLarry of Prop
	(properties
		x 96
		y 107
		view 146
		priority 9
		signal 16
		cycleSpeed 12
	)
)

(instance pArm of Prop
	(properties
		x 96
		y 109
		view 146
		loop 1
		priority 15
		signal 16
		cycleSpeed 12
	)
)

(instance light of Prop
	(properties
		x 200
		y 26
		view 145
		loop 2
		priority 15
		signal 16
	)
)

(instance larryCam of View
	(properties
		x 147
		y 170
		view 150
	)
)

(instance You_FToi_a of Talker
	(properties
		name {You}
		nsTop 88
		nsLeft 64
		view 1151
		loop 3
		talkWidth 314
	)

	(method (init)
		(= mouth You_FToi_b)
		(super init: &rest)
	)
)

(instance You_FToi_b of Prop
	(properties
		name {You}
		view 1151
		cycleSpeed 5
	)
)

(instance Silas_Scruemall_a of Talker
	(properties
		name {Silas Scruemall}
		x -1
		y 185
		nsTop 21
		nsLeft 154
		view 1150
		loop 3
		talkWidth 240
	)

	(method (init)
		(= mouth Silas_Scruemall_b)
		(= bust bossmallBust)
		(= eyes bossmallEyes)
		(super init: &rest)
	)
)

(instance bossmallBust of Prop
	(properties
		view 1150
		loop 1
	)
)

(instance bossmallEyes of Prop
	(properties
		nsTop 31
		nsLeft 16
		view 1150
		loop 2
		cycleSpeed 70
	)
)

(instance Silas_Scruemall_b of Prop
	(properties
		name {Silas Scruemall}
		nsTop 55
		nsLeft 6
		view 1150
		cycleSpeed 5
	)
)

(instance Silas_Scruemall_c of Talker
	(properties
		name {Silas Scruemall}
		x -1
		y 185
		nsTop 27
		nsLeft 167
		view 1145
		loop 3
		talkWidth 280
	)

	(method (init)
		(= bust ScruemallBust)
		(= eyes ScruemallEyes)
		(= mouth ScruemallMouth)
		(super init: &rest)
	)
)

(instance ScruemallBust of Prop
	(properties
		view 1145
		loop 1
	)
)

(instance ScruemallEyes of Prop
	(properties
		nsTop 15
		nsLeft 10
		view 1145
		loop 2
		cycleSpeed 70
	)
)

(instance ScruemallMouth of Prop
	(properties
		nsLeft 5
		view 1145
		cycleSpeed 5
	)
)

(instance breakPot of Sound
	(properties
		flags 1
		number 146
	)
)

(instance yeow of Sound
	(properties
		flags 1
		number 147
	)
)

(instance plink of Sound
	(properties
		flags 1
		number 148
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(fScruemall setCycle: CT 1 1 self)
			)
			(2
				(pLarry setCycle: End)
				(pArm setCycle: CT 1 1 self)
				(fScruemall setCycle: CT 2 1)
			)
			(3
				(breakPot play:)
				(pArm setCel: 2 setCycle: End)
				(fScruemall setCel: 3 setCycle: End self)
			)
			(4
				(yeow play:)
				(TPrint 150 0 67 -1 185) ; "Yooooooowwwwwww!!!!!!!!"
				(= seconds 3)
			)
			(5
				(fScruemall setCel: 0 setLoop: 3 stopUpd:)
				(fScruemallTopHalf init: stopUpd:)
				(= ticks 10)
			)
			(6
				(Say Silas_Scruemall_c 150 1 108 139 self) ; "You clumsy idiot! What a dolt!"
			)
			(7
				(= ticks 123)
			)
			(8
				(Say Silas_Scruemall_c 150 2 108 139 self) ; "Who hired this fool? Sexy women? Why even the sexiest woman in America wouldn't..."
			)
			(9
				(= ticks 123)
			)
			(10
				(fScruemallTopHalf startUpd: cycleSpeed: 12 setCycle: End self)
				(plink play:)
				(light init: cycleSpeed: 24 setCycle: End)
			)
			(11
				(= ticks 60)
			)
			(12
				(TPrint 150 3 80 {Silas Scruemall} 67 -1 185 108 self) ; "Hey, wait a minute! Wait just a minute...."
			)
			(13
				(= ticks 123)
			)
			(14
				(pLarry dispose:)
				(fScruemall dispose:)
				(fScruemallTopHalf dispose:)
				(pArm dispose:)
				(light dispose:)
				(gCurRoom style: 7 drawPic: 150 picture: 150 curPic: 150)
				(gTheMusic number: 150 flags: 1 setLoop: -1 play:)
				(Say Silas_Scruemall_a 150 4 108 139 self) ; "Mmmm," says Silas, thinking fast and furiously. "Uh, say buddy, er, nice leisure suit."
			)
			(15
				(= ticks 30)
			)
			(16
				(Say Silas_Scruemall_a 150 5 108 139 self) ; "I'm sure I know you, uh, but what exactly is your name?"
			)
			(17
				(= ticks 123)
			)
			(18
				(Say You_FToi_a 150 6 108 139 self) ; ""Why, my name is Larry; Larry Laffer," you reply."
			)
			(19
				(= ticks 123)
			)
			(20
				(Say Silas_Scruemall_a 150 7 108 139 self) ; "How quaint," he grumbles, "your first and middle names are exactly the same. Well, never mind about that. I have a proposal I'd like to make to you, Daffer. Now, here's the deal."
			)
			(21
				(= ticks 30)
			)
			(22
				(Say Silas_Scruemall_a 150 8 108 139 self) ; "You see, Luffner, I've got to find a hostess for our new television show."
			)
			(23
				(= ticks 123)
			)
			(24
				(Say You_FToi_a 150 9 108 139 self) ; "Yes, I know," you offer proudly, "I'm the Chief Tape Rewinder and Sterilizer on this project!"
			)
			(25
				(= ticks 30)
			)
			(26
				(TPrint 150 10 67 -1 185) ; "(You conveniently neglect to mention the "Betamax Division" portion of your job description!)"
				(= seconds 3)
			)
			(27
				(Say Silas_Scruemall_a 150 11 108 139 self) ; "And a fine job you're doing (I suppose). Well, Larcher, we've used those audition tapes to narrow the field down to three finalists, but we're, uh, um," he stumbles, "too ah, busy to hold their auditions here!"
			)
			(28
				(= ticks 30)
			)
			(29
				(Say Silas_Scruemall_a 150 12 108 139 self) ; "So I want you to visit them in their, ah, `home environments;' see them in their `natural habitat,' so to speak; catch them `au naturale' if you can."
			)
			(30
				(= ticks 30)
			)
			(31
				(TPrint 150 13 67 -1 185) ; "(You understand many of the words in that last sentence.)"
				(= seconds 3)
			)
			(32
				(Say Silas_Scruemall_a 150 14 108 139 self) ; "You do know how to audition girls, don't you, Loafer?"
			)
			(33
				(= ticks 123)
			)
			(34
				(Say You_FToi_a 150 15 108 139 self) ; "What? Audition three women? No problem, boss, I'm your guy!"
			)
			(35
				(= ticks 30)
			)
			(36
				(TPrint 150 16) ; "Why, it's like a dream come true! In fact, it's like several of your dreams come true! When those babes find out why you're visiting, they'll fall all over you! Not that you mind, of course. Anything for your company."
				(= seconds 3)
			)
			(37
				(Say Silas_Scruemall_a 150 17 108 139 self) ; "But, Loaner, if you tell them who you are, or of your powerful position here at PPC, it could easily invalidate the data. We want to see their reactions to a nice, normal guy like you, Lenny."
			)
			(38
				(= ticks 30)
			)
			(39
				(Say Silas_Scruemall_a 150 18 108 139 self) ; "I must be certain you don't `take advantage' of the situation. So, take this."
			)
			(40
				(larryCam init:)
				(Points 1 79)
				(= ticks 123)
			)
			(41
				(Say You_FToi_a 150 19 108 139 self) ; "Wow, Mr. Scruemall," you say, unable to contain your excitement, "I can always use another pocket protector. Mine's getting really vintage!"
			)
			(42
				(= seconds 3)
			)
			(43
				(Say Silas_Scruemall_a 150 20 108 139 self) ; "Lipper, you fool! This is no ordinary pocket protector! It's a brand new, imported, miniaturized, .5 lux, Rob Lowe Model 'Complete Video Studio' merely disguised as some dork's Pocket Protector!"
			)
			(44
				(= ticks 123)
			)
			(45
				(You_FToi_a talkWidth: 160)
				(Say You_FToi_a 150 21 108 139 self) ; ""I knew that," you pretend."
			)
			(46
				(= seconds 3)
			)
			(47
				(Say Silas_Scruemall_a 150 22 108 139 self) ; "You must never let a `client' suspect you are filming them or that you represent the show! They must each think of you only as plain Larry, Larry Limper!"
			)
			(48
				(= ticks 123)
			)
			(49
				(larryCam dispose:)
				(You_FToi_a talkWidth: 240)
				(Say You_FToi_a 150 23 108 139 self) ; ""I can handle it, Sir," you say excitedly."
			)
			(50
				(= seconds 3)
			)
			(51
				(Say Silas_Scruemall_a 150 24 108 139 self) ; "I hope so. If you can pull this off, Lipper, I promise you a really big promotion: perhaps even to Assistant Associate Director! What do you think of that?"
			)
			(52
				(= ticks 30)
			)
			(53
				(TPrint 150 25 67 -1 28) ; "You think, "Wow! This could be the big break I've been hoping for!""
				(You_FToi_a talkWidth: 240)
				(Say You_FToi_a 150 26 108 139 self) ; "I promise to give it everything I've got!"
			)
			(54
				(= ticks 123)
			)
			(55
				(Say Silas_Scruemall_a 150 27 108 139 self) ; "Good. I really want you to take charge, Larry. Take whatever you need from here in the office; you're really on your own. I'll look forward to personally viewing those audition tapes when you return."
			)
			(56
				(= ticks 30)
			)
			(57
				(Say Silas_Scruemall_a 150 28 108 139 self) ; "But remember: because this little guy is such a new model and because it's so tiny, its recording time and battery life are severely limited! Be sure you recharge after every girl!"
			)
			(58
				(= ticks 123)
			)
			(59
				(TPrint 150 29 67 -1 28) ; "Heh, heh. Always a good idea," you think."
				(Say Silas_Scruemall_a 150 30 108 139 self) ; "Okay, Wopner, you've got one, maybe two days max! You'd better grab the girls' bios and get going!"
				(SetFlag 7)
			)
			(60
				(= ticks 123)
			)
			(61
				(DrawPic 1 -32762)
				(= seconds 3)
			)
			(62
				(TPrint 150 31) ; "What a dream assignment! Travel across the United States, visiting three of the sexiest women in America, and you get paid for doing it!! Larry, it looks like things are really beginning to go your way."
				(= seconds 3)
			)
			(63
				(TPrint 150 32 67 -1 185) ; "(Of course, something makes you think you've had that thought before!)"
				(gCurRoom newRoom: 155) ; passwordTest
			)
		)
	)
)

