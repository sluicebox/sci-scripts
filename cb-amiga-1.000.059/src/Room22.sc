;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room22 0
)

(synonyms
	(lamp ignite)
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(Print &rest #at 160 80 #font 4 #width 125 #mode 1 #draw #dispose)
)

(procedure (localproc_1)
	(Print &rest #at 10 80 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance Room22 of Rm
	(properties
		picture 22
	)

	(method (init)
		(= south 28)
		(= west 21)
		(= east 23)
		(= horizon 135)
		(= global102 0)
		(super init:)
		(Load rsFONT 4)
		(gAddToPics add: statue eachElementDo: #init doit:)
		(self setRegions: 206 setFeatures: statue House) ; houseOReg
		(if (== gAct 1)
			(self setRegions: 381) ; walkabout
		)
		(Thunder number: 17 loop: 0)
		(if gDetailLevel
			(strike init:)
			(Treflect init:)
			(Greflect init: setScript: showers)
			(cloud init:)
		)
		(if
			(and
				(or
					(== global114 8)
					(== gJeevesChoresState 8)
					(== [gCycleTimers 3] 1)
					(== [gCycleTimers 1] 1)
				)
				(== gAct 3)
				(!= global114 10)
			)
			(Load rsFONT 41)
			(LoadMany rsMESSAGE 406)
			(LoadMany rsVIEW 380 389 400 406 414 642)
			(LoadMany rsSOUND 19 29 94 95 96)
			(CHead setPri: 15 init: hide:)
			(Clarence
				posn: 292 161
				loop: 1
				setAvoider: ((Avoid new:) offScreenOK: 1)
				setCycle: Walk
				init:
			)
			(Rudy
				posn: 40 161
				setAvoider: ((Avoid new:) offScreenOK: 1)
				setCycle: Walk
				init:
			)
			(self setScript: fight)
		)
		(switch gPrevRoomNum
			(16
				(gEgo posn: 161 139)
			)
			(15
				(gEgo posn: 61 139)
			)
			(17
				(gEgo posn: 261 139)
			)
			(21
				(if (> (gEgo y:) 150)
					(gEgo posn: 1 162)
				else
					(gEgo posn: 1 139)
				)
			)
			(23
				(if (> (gEgo y:) 150)
					(gEgo posn: 305 162)
				else
					(gEgo posn: 305 139)
				)
			)
		)
		(gEgo view: 0 illegalBits: -32768 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 22 0) ; "What a wonderful view of the old plantation house! From here you can almost imagine what it must have been like during its glory days."
		)
		(if
			(and
				(< gJeevesChoresState 10)
				(not script)
				(== gAct 3)
				(or (== [gCycleTimers 3] 1) (== [gCycleTimers 1] 1))
				(or (< (gEgo x:) 60) (> (gEgo x:) 250))
			)
			(= gJeevesChoresState 17)
			(CHead setPri: 15 init: hide:)
			(Clarence
				posn: 340 161
				loop: 1
				setAvoider: ((Avoid new:) offScreenOK: 1)
				setCycle: Walk
				init:
			)
			(Rudy
				posn: -20 161
				setAvoider: ((Avoid new:) offScreenOK: 1)
				setCycle: Walk
				init:
			)
			(self setScript: fight)
		)
		(switch (gEgo onControl: 0)
			(2
				(gCurRoom newRoom: 16)
			)
			(4
				(gCurRoom newRoom: 15)
			)
			(8
				(gCurRoom newRoom: 17)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 22 0) ; "What a wonderful view of the old plantation house! From here you can almost imagine what it must have been like during its glory days."
						)
						((Said '/path')
							(Print 22 1) ; "A stone path leads toward the house."
						)
						((Said '/door,(lamp[<gallery])')
							(Print 22 2) ; "Porch lights highlight the mansion's front door."
						)
					)
				)
				((Said 'open/door')
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance showers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (= local0 (Random 0 100)) 50)
					(strike setCycle: Fwd)
					(if gDetailLevel
						(Treflect setCycle: Fwd)
						(Greflect setCycle: Fwd)
					)
				else
					(cloud setCycle: Fwd)
				)
				(= cycles 7)
			)
			(1
				(if (< local0 50)
					(strike setCycle: End self)
					(if gDetailLevel
						(Treflect setCycle: End)
						(Greflect setCycle: End)
					)
				else
					(cloud setCycle: End self)
				)
			)
			(2
				(Thunder loop: 1 play: self)
			)
			(3
				(if (< (Random 1 100) 25)
					(= state -1)
				else
					(= state 2)
				)
				(= seconds 5)
			)
		)
	)
)

(instance fight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((not global216)
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
					((not (& gMustDos $0001))
						(|= gMustDos $0001)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((not (& gMustDos $0008))
						(|= gMustDos $0008)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(Rudy setMotion: MoveTo 135 183)
				(Clarence ignoreActors: 1 setMotion: MoveTo 175 183 self)
				(myMusic number: 19 loop: 1 play:)
			)
			(2
				(LookAt gEgo Rudy)
				(Rudy view: 389 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(localproc_1 22 3) ; "Get out of my sight, JERK!!"
				(Rudy loop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(localproc_0 22 4) ; "NO! YOU get out of MY sight!!"
				(Rudy setCycle: 0)
				(Clarence view: 406 loop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(localproc_1 22 5) ; "WHY, YOU...!!"
				(Clarence setCycle: 0)
				(Rudy loop: 1 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(6
				(cls)
				(Rudy
					setLoop: 3
					setCycle: Walk
					setPri: 13
					setMotion: MoveTo 142 183
				)
				(Clarence
					ignoreActors: 1
					setCycle: Walk
					setLoop: 2
					setMotion: MoveTo 165 183 self
				)
			)
			(7
				(Rudy loop: 4 cel: 0 cycleSpeed: 2 setCycle: Fwd)
				(Clarence loop: 3 cel: 0 cycleSpeed: 2 setCycle: Fwd)
				(= cycles 14)
			)
			(8
				(Clarence loop: 8 cel: 0 cycleSpeed: 0 setCycle: End self)
				(Rudy loop: 6 cel: 0 cycleSpeed: 1 setCycle: End)
			)
			(9
				(localproc_1 22 6) ; "You little PIPSQUEAK...!!"
				(Rudy setCycle: Beg)
				(Clarence setCycle: Beg self)
			)
			(10
				(Rudy loop: 5 cel: 0 cycleSpeed: 0 setCycle: End)
				(Clarence loop: 4 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(11
				(cls)
				(Rudy setPri: -1 setCycle: Beg self)
			)
			(12
				(Clarence
					loop: 5
					cel: 0
					x: (+ (Clarence x:) 5)
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(13
				(Clarence
					loop: 6
					cel: 0
					cycleSpeed: 0
					x: (+ (Clarence x:) 5)
					setCycle: Fwd
				)
				(Rudy loop: 1 cel: 0 setCycle: Fwd)
				(localproc_1 22 7) ; "Don't mess with me, BUD!! Just stay out of my way!!"
				(= seconds 4)
			)
			(14
				(cls)
				(Rudy
					view: 380
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo -20 163
				)
				(Clarence
					loop: 7
					cel: 0
					x: (+ (Clarence x:) 16)
					y: (+ (Clarence y:) 1)
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(15
				(CHead show: setCycle: Fwd)
				(localproc_0 22 8) ; "You ain't heard the last of me, RUDY! I'll get you for this!!"
				(Clarence view: 402 loop: 3 cel: 0 cycleSpeed: 0 setCycle: Fwd)
				(= seconds 4)
			)
			(16
				(cls)
				(CHead setCycle: 0 dispose:)
				(Clarence
					view: 400
					setLoop: -1
					cycleSpeed: 1
					setCycle: Walk
					setMotion: MoveTo 280 163 self
				)
			)
			(17
				(Clarence view: 414 loop: 1 cel: 0 cycleSpeed: 1 setCycle: End)
				(= seconds 4)
			)
			(18
				(Clarence
					view: 400
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 340 163 self
				)
			)
			(19
				(= gJeevesChoresState 12)
				(= global114 10)
				(= [gCycleTimers 3] 0)
				(= [gCycleTimers 1] 0)
				(SetFlag 45)
				(HandsOn)
				(Clarence dispose:)
				(Rudy dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance Clarence of Act
	(properties
		y 163
		x 340
		view 400
	)
)

(instance CHead of Prop
	(properties
		y 184
		x 191
		z 40
		view 404
		loop 2
	)
)

(instance Rudy of Act
	(properties
		y 163
		x -20
		view 380
	)
)

(instance strike of Prop
	(properties
		y 37
		x 295
		view 122
		loop 2
		cel 1
	)
)

(instance Treflect of Prop
	(properties
		y 53
		x 299
		view 122
		loop 3
		cel 1
		priority 2
	)
)

(instance Greflect of Prop
	(properties
		y 108
		x 299
		view 122
		loop 4
		cel 1
		priority 7
	)
)

(instance cloud of Prop
	(properties
		y 19
		x 25
		view 122
		loop 5
		cel 1
	)
)

(instance Thunder of Sound
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance statue of RPicView
	(properties
		y 147
		x 165
		view 122
		priority 13
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/monument'))
				(event claimed: 1)
				(Print 22 9) ; "The statue appears to resemble the Colonel in full officer's regalia."
			)
			((Said '/monument>')
				(cond
					((Said 'get')
						(Print 22 10) ; "You can't get the statue."
					)
					((Said 'press,move')
						(Print 22 11) ; "It's too heavy to move."
					)
					((Said 'rotate')
						(Print 22 12) ; "It doesn't turn."
					)
				)
			)
		)
	)
)

(instance House of RFeature
	(properties
		nsTop 6
		nsLeft 39
		nsBottom 96
		nsRight 284
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {house})
		)
	)
)

