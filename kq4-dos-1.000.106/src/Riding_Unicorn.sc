;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 333)
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
	Riding_Unicorn 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance Riding_Unicorn of Rm
	(properties
		name {Riding Unicorn}
	)

	(method (init)
		(User canControl: 0 canInput: 0)
		(= picture gPrevRoomNum)
		(if gNight
			(+= picture 100)
		)
		(gEgo edgeHit: EDGE_NONE)
		(gEgo xStep: 4 init:)
		(gSounds eachElementDo: #dispose)
		(super init:)
		(Load rsPIC 30)
		(Load rsPIC 29)
		(Load rsPIC 28)
		(Load rsPIC 20)
		(Load rsPIC 26)
		(Load rsPIC 27)
		(Load rsVIEW 142)
		(Load rsVIEW 143)
		(Load rsVIEW 144)
		(Load rsVIEW 146)
		(Load rsVIEW 140)
		(Load rsVIEW 390)
		(Load rsVIEW 387)
		(Load rsVIEW 60)
		(Load rsVIEW 80)
		(gEgo baseSetter: (ScriptID 0 1)) ; smallBase
		(= local4 (View new:))
		(self setScript: Turn_Unicorn)
	)

	(method (dispose)
		(if (gSounds contains: local3)
			(local3 dispose:)
		)
		(super dispose:)
	)
)

(instance From_Room_20 of Script
	(properties
		name {From Room 20}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 369 180 self)
			)
			(1
				(if gNight
					(gCurRoom drawPic: 127)
				else
					(gCurRoom drawPic: 27)
				)
				(gEgo posn: 30 97)
				(gEgo setMotion: MoveTo 369 100 self)
			)
			(2
				(if gNight
					(local4
						view: 600
						loop: 0
						cel: 0
						setPri: 10
						posn: 289 139
						init:
						stopUpd:
					)
					(gCurRoom drawPic: 128)
				else
					(gCurRoom drawPic: 28)
					(local4
						view: 600
						loop: 1
						cel: 0
						setPri: 9
						posn: 283 139
						ignoreActors:
						init:
						stopUpd:
					)
				)
				(gEgo posn: 30 187)
				(gCurRoom setScript: From_Room_28)
			)
		)
	)
)

(instance From_Room_26 of Script
	(properties
		name {From Room 26}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 369 162 self)
			)
			(1
				(if gNight
					(gCurRoom drawPic: 127)
				else
					(gCurRoom drawPic: 27)
				)
				(gEgo posn: 30 155)
				(gEgo setMotion: MoveTo 369 169 self)
			)
			(2
				(if gNight
					(local4
						view: 600
						loop: 0
						cel: 0
						setPri: 10
						posn: 289 139
						init:
						stopUpd:
					)
					(gCurRoom drawPic: 128)
				else
					(gCurRoom drawPic: 28)
					(local4
						view: 600
						loop: 1
						cel: 0
						setPri: 9
						posn: 283 139
						ignoreActors:
						init:
						stopUpd:
					)
				)
				(gCurRoom setScript: From_Room_28)
			)
		)
	)
)

(instance From_Room_27 of Script
	(properties
		name {From Room 27}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 369 162 self)
			)
			(1
				(if gNight
					(local4
						view: 600
						loop: 0
						cel: 0
						setPri: 10
						posn: 289 139
						init:
						stopUpd:
					)
					(gCurRoom drawPic: 128)
				else
					(gCurRoom drawPic: 28)
					(local4
						view: 600
						loop: 1
						cel: 0
						setPri: 9
						posn: 283 139
						ignoreActors:
						init:
						stopUpd:
					)
				)
				(gCurRoom setScript: From_Room_28)
			)
		)
	)
)

(instance From_Room_28 of Script
	(properties
		name {From Room 28}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 30 187 setMotion: MoveTo 369 187 self)
			)
			(1
				(if gNight
					(gCurRoom drawPic: 129)
				else
					(gCurRoom drawPic: 29)
				)
				(gEgo posn: 30 187 setMotion: MoveTo 369 187 self)
			)
			(2
				(if gNight
					(gCurRoom drawPic: 130)
				else
					(gCurRoom drawPic: 30)
				)
				(gEgo posn: 30 124 setMotion: MoveTo 194 129 self)
			)
			(3
				(gEgo setMotion: MoveTo 369 98 self)
			)
			(4
				(if gNight
					(gCurRoom drawPic: 179)
				else
					(gCurRoom drawPic: 79)
				)
				(gEgo posn: 65 186)
				(Henchmen_Pickup_Ego changeState: 1)
			)
		)
	)
)

(instance Henchmen_Pickup_Ego of Script
	(properties
		name {Henchmen Pickup Ego}
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= local0 (Act new:))
				(Henchman_1_Actions changeState: 1)
				(= global120 (Print 333 0 #at -1 20 #dispose)) ; "The unicorn seems paralyzed with fear at the sight of Lolotte's henchmen."
			)
			(2
				(= gUnicornActor (Act new:))
				(gUnicornActor
					posn: (- (gEgo x:) 7) (gEgo y:)
					view: 381
					loop: 0
					cel: 0
					setPri: (gEgo priority:)
					ignoreActors:
					init:
				)
				(gEgo
					view: 60
					setLoop: 0
					cel: 0
					posn: (- (gUnicornActor x:) 4) (- (gUnicornActor y:) 25)
					setPri: 14
					ignoreActors:
					setCycle: End self
				)
				(local1 hide:)
				(local2 hide:)
			)
			(3
				(gEgo
					view: 80
					setLoop: 5
					setCycle: Fwd
					setMotion: MoveTo 24 60 self
				)
			)
			(4
				(gEgo setLoop: 3)
				(Timer setReal: self 2)
			)
			(5
				(gEgo setLoop: 2)
				(Timer setReal: self 2)
			)
			(6
				(gEgo setLoop: 1 setMotion: MoveTo 72 29)
				(Timer setReal: self 2)
			)
			(7
				(gEgo setLoop: 0 setMotion: MoveTo 72 29 self)
			)
			(8
				(gEgo setLoop: -1 setCel: -1)
				(User canControl: 1)
				(User canInput: 1)
				(gCurRoom newRoom: 92)
			)
		)
	)
)

(instance Henchman_1_Actions of Script
	(properties
		name {Henchman 1 Actions}
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(if (gSounds contains: local5)
					(local5 dispose:)
				)
				(= local3 (Sound new:))
				(local3 number: 29 play:)
				(local0
					ignoreHorizon:
					posn: 57 7
					view: 142
					setCycle: Walk
					setMotion: MoveTo -10 22 self
					ignoreActors:
					illegalBits: 0
					setPri: 13
					init:
				)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(local0 xStep: 4 yStep: 3 setMotion: MoveTo -10 50 self)
				(= local1 (Act new:))
				(local1 setScript: Henchman_2_Actions)
			)
			(3
				(local0
					view: 143
					xStep: 6
					yStep: 4
					setMotion: MoveTo 252 66 self
				)
			)
			(4
				(local0
					view: 144
					xStep: 8
					yStep: 6
					setMotion: MoveTo 89 178 self
				)
				(Henchman_2_Actions changeState: 1)
			)
			(5
				(local0 view: 146 loop: 1 cel: 0 setCycle: End self)
			)
		)
	)
)

(instance Henchman_2_Actions of Script
	(properties
		name {Henchman 2 Actions}
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(local1
					ignoreHorizon:
					posn: 57 7
					view: 142
					setCycle: Walk
					xStep: 4
					yStep: 3
					setMotion: MoveTo 26 65 self
					ignoreActors:
					illegalBits: 0
					setPri: 15
					init:
				)
			)
			(2
				(local1
					view: 143
					xStep: 6
					yStep: 4
					setMotion: MoveTo 42 120 self
				)
				(= local2 (Act new:))
				(local2 setScript: Henchman_3_Actions)
				(Henchman_3_Actions changeState: 1)
			)
			(3
				(local1
					view: 144
					xStep: 8
					yStep: 6
					setMotion: MoveTo 10 185 self
				)
			)
			(4
				(local1
					xStep: 8
					yStep: 6
					setMotion:
						MoveTo
						(+ (gEgo x:) 21)
						(- (gEgo y:) 28)
						self
				)
			)
			(5
				(LookAt local1 gEgo)
				(local1 setCycle: Fwd)
			)
		)
	)
)

(instance Henchman_3_Actions of Script
	(properties
		name {Henchman 3 Actions}
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(local2
					ignoreHorizon:
					posn: 57 7
					view: 142
					setCycle: Walk
					xStep: 4
					yStep: 3
					setMotion: MoveTo 26 65 self
					ignoreActors:
					illegalBits: 0
					setPri: 15
					init:
				)
			)
			(2
				(local2
					view: 143
					xStep: 6
					yStep: 4
					setMotion: MoveTo 42 120 self
				)
			)
			(3
				(local2
					view: 144
					xStep: 8
					yStep: 6
					setMotion: MoveTo 10 185 self
				)
			)
			(4
				(local2
					setMotion:
						MoveTo
						(- (gEgo x:) 15)
						(- (gEgo y:) 25)
						self
				)
			)
			(5
				(Henchmen_Pickup_Ego changeState: 2)
			)
		)
	)
)

(instance Turn_Unicorn of Script
	(properties
		name {Turn Unicorn}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(gEgo setCycle: End self)
				(= local5 (Sound new:))
				(local5 number: 32 loop: 1 play:)
			)
			(1
				(Print 333 1) ; "You nimbly mount the magnificent unicorn, grab the golden reins, and set off toward Lolotte's castle."
				(if (== (gEgo loop:) 1)
					(gEgo view: 390 cel: 0 loop: 0 setCycle: End self)
				else
					(self changeState: 2)
				)
			)
			(2
				(= gUnicornRoom 999)
				(gEgo view: 387 setCycle: Walk)
				(switch gPrevRoomNum
					(20 ; Room_20
						(gCurRoom setScript: From_Room_20)
					)
					(26
						(gCurRoom setScript: From_Room_26)
					)
					(27 ; Room_27
						(gCurRoom setScript: From_Room_27)
					)
				)
			)
		)
	)
)

