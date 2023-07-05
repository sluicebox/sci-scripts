;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 602)
(include sci.sh)
(use Main)
(use n814)
(use LoadMany)
(use Window)
(use Path)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	EndGame2 0
)

(local
	local0
	[local1 29] = [159 90 154 86 158 85 162 83 174 82 184 84 193 86 206 88 219 90 233 85 248 81 264 78 283 74 295 68 -32768]
	[local30 15] = [274 94 261 100 245 108 238 114 228 120 214 125 199 128 -32768]
	[local45 28] = [128 145 149 139 175 131 199 123 223 115 247 107 271 99 295 91 319 83 -32768 140 145 122 122 137 127 129 139 0]
	local73
	local74
	[local75 10] = [66 66 3 3 3 2 160 120 0 0]
)

(procedure (localproc_0)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(gCast eachElementDo: #dispose 81)
	(switch (gCurRoom script:)
		(awardScript
			(gCurRoom setScript: heroScript)
		)
		(heroScript
			(gCurRoom setScript: bigScript)
		)
		(bigScript
			(localproc_1)
		)
	)
)

(procedure (localproc_1)
	(gGame setCursor: gNormalCursor)
	(DisposeScript 983)
	(gCurRoom newRoom: 601) ; CharSave
)

(instance creditWindow of SysWindow ; UNUSED
	(properties)
)

(instance hairL of Prop
	(properties
		x 126
		y 42
		view 148
	)
)

(instance hairR of Prop
	(properties
		x 124
		y 99
		view 148
		loop 3
	)
)

(instance hairM of Prop
	(properties
		x 81
		y 151
		view 148
		loop 1
		signal 18432
	)
)

(instance cape of Prop
	(properties
		x 223
		y 160
		view 148
		loop 2
		signal 18432
	)
)

(instance bck of Actor
	(properties
		x -48
		y 182
		view 101
		loop 8
		signal 18448
	)
)

(instance mid of Actor
	(properties
		x -24
		y 182
		view 101
		loop 8
		cel 1
		signal 18432
	)
)

(instance frt of Actor
	(properties
		x -2
		y 180
		view 101
		loop 8
		cel 2
		signal 18448
	)
)

(instance carpet of Actor
	(properties)
)

(instance upPath of Path
	(properties)

	(method (at param1)
		(return [local1 param1])
	)
)

(instance waterTurn of Path
	(properties)

	(method (at param1)
		(return [local30 param1])
	)
)

(instance awayPath of Path
	(properties)

	(method (at param1)
		(return [local45 param1])
	)
)

(instance bigCarpet of Actor ; UNUSED
	(properties)
)

(instance claw1 of Prop ; UNUSED
	(properties
		x 51
		y 92
		view 906
		priority 3
	)
)

(instance claw2 of Prop ; UNUSED
	(properties
		x 127
		y 87
		view 906
		loop 1
		cel 1
		priority 3
	)
)

(instance head of Prop ; UNUSED
	(properties
		x 87
		y 49
		view 906
		loop 2
	)
)

(instance flame of Actor ; UNUSED
	(properties
		view 907
	)
)

(instance EndGame2 of Rm
	(properties
		picture 39
		style 1
	)

	(method (dispose)
		(SL disable:)
		(super dispose:)
	)

	(method (init)
		(Load rsSOUND 99)
		(LoadMany rsPIC 148 101 750)
		(LoadMany rsVIEW 139 101 148 906 907)
		(super init: &rest)
		(SolvePuzzle 734 25)
		(DoSound sndSET_SOUND 1)
		(gGame setSpeed: 6)
		(HandsOff)
		(cond
			((IsFlag 273)
				((gInventory at: 0) amount: (+ ((gInventory at: 0) amount:) 1100)) ; silver, silver
			)
			((IsFlag 309)
				((gInventory at: 0) amount: (+ ((gInventory at: 0) amount:) 600)) ; silver, silver
			)
		)
		(if (IsFlag 310)
			((gInventory at: 0) amount: (+ ((gInventory at: 0) amount:) 300)) ; silver, silver
		)
		(self setScript: awardScript)
	)
)

(instance awardScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
			)
		)
	)
)

(instance post1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(if (and (IsFlag 325) (IsFlag 170))
					(gMessager say: 1 0 9) ; "Thus the hero from the East Freed the man from form of beast Saved beauty from the brigand's band And forced the Ogress to flee the land."
				else
					(= seconds 5)
				)
			)
		)
	)
)

(instance post2 of Script
	(properties)

	(method (dispose)
		(if (and (>= state 1) gModelessDialog)
			(gModelessDialog dispose:)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (IsFlag 325)
					(= local74 (gMessager say: 1 0 1)) ; "The brigand band has been dispersed, Their treasure has been reimbursed."
				else
					(= local74 (gMessager say: 1 0 12)) ; "And so with Kattas and Abdulla Doo, You bid the valley a fond adieu."
				)
				(= seconds 9)
			)
			(2
				(if (IsFlag 325)
					(gMessager say: 1 0 12) ; "And so with Kattas and Abdulla Doo, You bid the valley a fond adieu."
				else
					(gMessager say: 1 0 6) ; "Unfortunately, since the Baron is still cursed, and Baba Yaga remains to work her evil deeds, terror will continue to rule the land."
				)
				(= seconds 8)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance heroScript of Script
	(properties)

	(method (init)
		(hairL setCycle: Fwd cycleSpeed: 6)
		(hairM setCycle: Fwd cycleSpeed: 6)
		(cape setCycle: Fwd cycleSpeed: 6)
		(hairL setPri: 5 init:)
		(hairR setPri: 5 init:)
		(hairM setPri: 5 init:)
		(cape setPri: 2 init:)
		(= local73 55)
		(super init: &rest)
		(SL disable:)
		(gCurRoom style: 0 drawPic: 148)
		(self setScript: post1)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local0 0)
				(= ticks 5)
			)
			(1
				(if local73
					(-- local73)
					(self changeState: 0)
				else
					(localproc_0)
				)
			)
		)
	)
)

(instance bigScript of Script
	(properties)

	(method (init &tmp temp0 temp1)
		(bck init:)
		(mid init:)
		(frt init:)
		(= temp0
			(switch gHowFast
				(0 4)
				(1 3)
				(else 2)
			)
		)
		(= temp1
			(switch gHowFast
				(0 2)
				(else 1)
			)
		)
		(bck setStep: temp0 temp1)
		(mid setStep: temp0 temp1)
		(frt setStep: temp0 temp1)
		(super init: &rest)
		(gCurRoom style: 7 drawPic: 750)
		(self setScript: post2)
	)

	(method (doit &tmp temp0)
		(frt
			priority: (- (mid priority:) 1)
			posn: (+ (mid x:) 22) (- (mid y:) 2)
		)
		(bck priority: (- (mid priority:) 1) posn: (- (mid x:) 24) (mid y:))
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mid setMotion: MoveTo 373 22 self)
			)
			(1
				(localproc_0)
			)
		)
	)
)

(instance flyScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom style: 1 drawPic: 101)
				(carpet
					view: 101
					setLoop: 0
					setCel: 0
					setStep: 1 1
					posn: 168 95
					ignoreActors: 1
					init:
					setScript: cornyCredits
					setMotion: upPath self
				)
			)
			(1
				(self changeState: 29)
			)
			(2
				(carpet cel: 1 setPri: 8 setMotion: MoveTo 312 72 self)
			)
			(3
				(carpet cel: 2 setMotion: MoveTo 301 82 self)
			)
			(4
				(carpet cel: 3 setMotion: MoveTo 292 86 self)
			)
			(5
				(carpet setMotion: waterTurn self)
			)
			(6
				(carpet setMotion: MoveTo 184 133 self)
			)
			(7
				(carpet setMotion: MoveTo 170 137 self)
			)
			(8
				(carpet cel: 4 setMotion: MoveTo 150 135 self)
			)
			(9
				(carpet cel: 5 setMotion: MoveTo 143 126 self)
			)
			(10
				(carpet cel: 6 setMotion: MoveTo 153 123 self)
			)
			(11
				(carpet setMotion: MoveTo 164 120 self)
			)
			(12
				(carpet cel: 7 setMotion: MoveTo 170 116 self)
			)
			(13
				(carpet cel: 8 setMotion: MoveTo 186 118 self)
			)
			(14
				(carpet cel: 9 setMotion: MoveTo 197 122 self)
			)
			(15
				(carpet cel: 10 setMotion: MoveTo 187 128 self)
			)
			(16
				(carpet cel: 11 setMotion: MoveTo 171 140 self)
			)
			(17
				(carpet cel: 12 setMotion: MoveTo 166 143 self)
			)
			(18
				(carpet cel: 13 setMotion: MoveTo 161 146 self)
			)
			(19
				(carpet cel: 14 setMotion: MoveTo 156 149 self)
			)
			(20
				(carpet cel: 3 setMotion: MoveTo 114 149 self)
			)
			(21
				(carpet setLoop: 2 cel: 0 setMotion: MoveTo 90 145 self)
			)
			(22
				(carpet setMotion: MoveTo 72 130 self)
			)
			(23
				(carpet setPri: 8 setMotion: MoveTo 61 122 self)
			)
			(24
				(carpet cel: 1 setMotion: MoveTo 64 135 self)
			)
			(25
				(carpet setMotion: MoveTo 75 141 self)
			)
			(26
				(carpet setMotion: MoveTo 85 143 self)
			)
			(27
				(carpet cel: 2 setMotion: MoveTo 95 145 self)
			)
			(28
				(carpet
					setLoop: 3
					cel: 0
					cycleSpeed: 16
					setCycle: Fwd
					setMotion: awayPath self
				)
			)
			(29
				(localproc_0)
			)
		)
	)
)

(instance cornyCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(gMessager say: 1 0 15 1 self) ; "Script and Whip: Lori Ann Cole"
			)
			(2
				(gMessager say: 1 0 13 1 self) ; "Vicious Art: Kenn Nishiuye"
			)
			(3
				(gMessager say: 1 0 10 1 self) ; "Silly Stuff: Jeff Crowe"
			)
			(4
				(gMessager say: 1 0 11 1 self) ; "Next Generation Graphics: Jerry Moore"
			)
			(5
				(gMessager say: 1 0 2 1 self) ; "Marathon Coding and Rude Puns: Bob Fischbach"
			)
			(6
				(gMessager say: 1 0 14 1 self) ; "Algorithmic Gyrations: Larry Scott"
			)
			(7
				(gMessager say: 1 0 18 1 self) ; "Cameo Coding: Jerry Shaw"
			)
			(8
				(gMessager say: 1 0 5 1 self) ; "Insidious System Software: Corey Cole"
			)
			(9
				(gMessager say: 1 0 16 1 self) ; "Magical Mystical Music: Mark Seibert"
			)
			(10
				(gMessager say: 1 0 4 1 self) ; "Underground Art: Cindy Walker"
			)
			(11
				(gMessager say: 1 0 7 1 self) ; "Yogic Sympathy and Support: Guruka Singh Khalsa"
				(= seconds 6)
			)
			(12
				(gMessager say: 1 0 17 1 self) ; "Promotional Considerations: Erasmus' Rootin' Tootin' Root Beer Spielburg Chamber of Commerce Shapeir Magic Carpet Tours Famous Adventurer's Correspondence School for Heroes"
			)
		)
	)
)

