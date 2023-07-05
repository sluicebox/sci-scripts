;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use Main)
(use Interface)
(use DCIcon)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room47 0
)

(synonyms
	(stair downstair upstair)
	(armoire armoire)
	(balcony balcony banister)
	(room hall)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance Room47 of Rm
	(properties
		picture 47
	)

	(method (init)
		(super init:)
		(= global61 0)
		(= south 37)
		(= north 43)
		(= horizon 100)
		(gAddToPics
			add:
				cabL
				cabR
				cat
				vase
				post1
				post2
				chain2
				chain3
				table1
				table2
				wardR
				wardL
			eachElementDo: #init
			doit:
		)
		(self setRegions: 211 setFeatures: Stair table1 table2 wardL wardR Rail) ; stairReg
		(LoadMany rsVIEW 9 38 651)
		(LoadMany rsSOUND 38 43 44 47 57 87 109)
		(if (and gGertieRoomState (not (IsFlag 0)))
			(= local5 1)
			(gEgo loop: 2)
			(Load rsPIC 11)
			(Load rsVIEW 507)
		)
		(if gDetailLevel
			(chand setPri: 15 init: stopUpd: setScript: jiggle)
			(lampL setPri: 8 setCycle: Fwd init:)
			(lampR setPri: 8 setCycle: Fwd init:)
			(lamp3 setPri: 15 setCycle: Fwd ignoreActors: 1 init:)
			(lamp4 setPri: 15 setCycle: Fwd ignoreActors: 1 init:)
		else
			(chand setPri: 15 init: stopUpd:)
			(lampL setPri: 8 init: stopUpd:)
			(lampR setPri: 8 init: stopUpd:)
			(lamp3 setPri: 15 ignoreActors: 1 init: stopUpd:)
			(lamp4 setPri: 15 ignoreActors: 1 init: stopUpd:)
		)
		(Ldoor init: stopUpd:)
		(rail1 setPri: 11 ignoreActors: 1 init: stopUpd:)
		(rail2 setPri: 11 ignoreActors: 1 init: stopUpd:)
		(if (and (== gAct 1) (not (gEgo has: 23))) ; handkerchief
			(Load rsVIEW 17)
			(hanky init:)
		)
		(switch gPrevRoomNum
			(48
				(gEgo posn: 228 106)
			)
			(46
				(gEgo posn: 105 109)
			)
			(43
				(cond
					((< (gEgo x:) 99)
						(gEgo posn: 110 105)
					)
					((> (gEgo x:) 222)
						(gEgo posn: 205 105)
					)
					(else
						(gEgo posn: (gEgo x:) 105)
					)
				)
			)
			(74
				(gEgo setPri: 9 posn: 254 114 setMotion: MoveTo 258 131)
			)
			(37
				(= local3 1)
				(if (< (gEgo x:) 160)
					(gEgo posn: 39 188 setMotion: MoveTo 60 139)
				else
					(gEgo posn: 280 188 setMotion: MoveTo 261 136)
				)
			)
		)
		(gEgo view: 0 illegalBits: -32768 init:)
	)

	(method (doit &tmp temp0)
		(if (IsFirstTimeInRoom)
			(Print 47 0) ; "This is the front upstairs hallway of the plantation house. A grand staircase leads down to the lower level."
		)
		(if (and global216 (== local5 1))
			(= local5 2)
			(self setScript: (ScriptID 408 0)) ; ShdwyFig
		)
		(if (and (== local5 2) (IsFlag 0))
			(= local5 0)
			(gAddToPics
				add:
					cabL
					cabR
					cat
					vase
					post1
					post2
					chain2
					chain3
					table1
					table2
					wardR
					wardL
				eachElementDo: #init
				doit:
			)
			(self setFeatures: Stair table1 table2 wardL wardR Rail)
			(gCast eachElementDo: #show)
		)
		(if (not local4)
			(if
				(or
					(& (gEgo onControl: 0) $0008)
					(& (gEgo onControl: 0) $0010)
				)
				(= temp0 9)
			else
				(= temp0 -1)
			)
			(gEgo setPri: temp0)
		)
		(switch (gEgo onControl: 1)
			(4
				(gCurRoom newRoom: 46)
			)
			(2
				(gCurRoom newRoom: 48)
			)
			(16
				(if (== (gEgo loop:) 3)
					(gCurRoom newRoom: 74)
				)
			)
			(2048
				(if (not local3)
					(= local3 1)
					(gEgo setMotion: MoveTo 39 190)
				)
			)
			(4096
				(if (not local3)
					(= local3 1)
					(gEgo setMotion: MoveTo 280 190)
				)
			)
			(1
				(if local3
					(= local3 0)
				)
			)
			(128
				(if
					(and
						(== local2 0)
						(> (gEgo heading:) 134)
						(< (gEgo heading:) 226)
					)
					(= local2 1)
					(= north (= south 0))
					(if (< (gEgo x:) 160)
						(rail1 setScript: falling)
					else
						(rail2 setScript: falling)
					)
				)
			)
		)
		(if (< (gEgo y:) 145)
			(cond
				((< (gEgo x:) 130)
					(= vertAngle 15)
				)
				((< (gEgo x:) 190)
					(= vertAngle 0)
				)
				(else
					(= vertAngle 160)
				)
			)
		else
			(= vertAngle 0)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 46) (or (== gGertieRoomState 1) (== gGertieRoomState 3)))
			(= gGertieRoomState 2)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look<down[/!*]')
						(Print 47 1) ; "It's a long way down. Be careful!"
					)
					((Said 'look>')
						(cond
							((Said '[<around,at,down][/room]')
								(Print 47 0) ; "This is the front upstairs hallway of the plantation house. A grand staircase leads down to the lower level."
							)
							((Said '/door<hidden')
								(Print 47 2) ; "You don't see anything!"
							)
							((or (Said '/door<bathroom') (Said '/bathroom'))
								(Print 47 3) ; "The bathroom is down the hall."
							)
							((Said '/bird,post[<newel]')
								(Print 47 4) ; "Finely carved eagles adorn the top of the stairway's newel posts."
							)
							((Said '/curtain')
								(Print 47 5) ; "Two tiffiny shades cover the lamps on the tables."
							)
						)
					)
					((Said 'get,force,rotate,detach/bird,post[<newel]')
						(Print 47 6) ; "The wooden eagles are firmly attached to the newel posts. They do not move."
					)
					((Said '*/armoire')
						(NotClose) ; "You're not close enough."
					)
				)
			)
			(evMOUSEBUTTON
				(if
					(or
						(== (User controls:) 0)
						(& (gEgo onControl: 0) $0001)
						(& (gEgo onControl: 0) $0008)
						(& (gEgo onControl: 0) $0080)
					)
					(return)
				)
				(switch (gEgo onControl: 0)
					(512
						(gEgo
							setMotion:
								MoveTo
								(cond
									((< (event y:) (gEgo y:)) 60)
									((> (event y:) (gEgo y:)) 39)
								)
								(cond
									((< (event y:) (gEgo y:)) 136)
									((> (event y:) (gEgo y:)) 190)
								)
						)
					)
					(1024
						(gEgo
							setMotion:
								MoveTo
								(cond
									((< (event y:) (gEgo y:)) 261)
									((> (event y:) (gEgo y:)) 280)
								)
								(cond
									((< (event y:) (gEgo y:)) 136)
									((> (event y:) (gEgo y:)) 190)
								)
						)
					)
				)
				(event claimed: 1)
			)
			($0040 ; direction
				(if
					(or
						(== (User controls:) 0)
						(& (gEgo onControl: 0) $0001)
						(& (gEgo onControl: 0) $0008)
						(& (gEgo onControl: 0) $0020)
						(& (gEgo onControl: 0) $0080)
					)
					(return)
				)
				(switch (event message:)
					(JOY_UP
						(switch (gEgo onControl: 0)
							(512
								(gEgo setMotion: MoveTo 60 136)
							)
							(1024
								(gEgo setMotion: MoveTo 261 136)
							)
						)
						(event claimed: 1)
					)
					(JOY_DOWN
						(switch (gEgo onControl: 0)
							(512
								(gEgo setMotion: MoveTo 39 190)
							)
							(1024
								(gEgo setMotion: MoveTo 280 190)
							)
						)
						(event claimed: 1)
					)
					(else
						(event claimed: 1)
						(return)
					)
				)
			)
		)
	)
)

(instance myDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (== (gEgo x:) 86) (== (gEgo y:) 131))
					(= cycles 1)
				else
					(gEgo setMotion: MoveTo 86 131 self)
				)
			)
			(1
				(LookAt gEgo Ldoor)
				(Ldoor ignoreActors: 1 cycleSpeed: 2 setCycle: End self)
				(myMusic number: 43 loop: 1 play:)
			)
			(2
				(gEgo setMotion: MoveTo 66 131 self)
			)
			(3
				(gEgo loop: 3)
				(= local1 1)
				(if (and (> gAct 0) (< gAct 7) (< (Random 1 100) 25))
					(= state 6)
				)
				(= seconds 2)
			)
			(4
				(Print 47 7) ; "It's just an empty closet."
				(gEgo setMotion: MoveTo 86 131 self)
			)
			(5
				(gEgo loop: 1)
				(Ldoor ignoreActors: 0 cycleSpeed: 2 setCycle: Beg self)
				(myMusic number: 44 loop: 1 play:)
				(= local1 0)
			)
			(6
				(HandsOn)
				(client setScript: 0)
			)
			(7
				(hand setCycle: End self init:)
				(myMusic number: 87 loop: 1 play:)
				(gEgo hide:)
			)
			(8
				(myIcon view: 651 cycler: End)
				(= global128 myIcon)
				(= global129 0)
				(= global130 0)
				(= global132 1)
				(EgoDead 47 8) ; "That's what you get for being such a snoop, Laura!"
			)
		)
	)
)

(instance jiggle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (not local5) (< (Random 1 100) 10) (== local4 0))
					(= cycles 1)
				else
					(= state -1)
					(= seconds 5)
				)
			)
			(1
				(if (not local6)
					(= local6 1)
					(myMusic number: 109 loop: 1 play:)
				)
				(chand posn: 162 87 forceUpd:)
				(= cycles 2)
			)
			(2
				(chand posn: 161 87 forceUpd:)
				(= cycles 2)
			)
			(3
				(chand posn: 162 87 forceUpd:)
				(= cycles 2)
			)
			(4
				(chand posn: 161 87)
				(if (== (++ local0) 3)
					(chand stopUpd:)
					(= local6 0)
					(= local0 0)
					(= state -1)
				else
					(= state 0)
				)
				(= cycles 2)
			)
		)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local4 1)
				(Print 47 9) ; "Watch ooouuuuuuttttt!!!!"
				(gEgo view: 9 setLoop: 0 setCycle: End self)
			)
			(1
				(myMusic number: 38 loop: 1 play:)
				(gEgo setLoop: 1 setCycle: Fwd)
				(client view: 9 cel: 0 setLoop: 3 setCycle: End self)
			)
			(2
				(client
					illegalBits: 0
					setStep: 12 12
					setMotion: MoveTo (client x:) 250
				)
				(gEgo
					setLoop: 2
					setPri: 15
					setCycle: End self
					illegalBits: 0
				)
			)
			(3
				(gEgo
					setCel: 9
					setCycle: 0
					setStep: 10 10
					setMotion: MoveTo (gEgo x:) 250 self
				)
			)
			(4
				(myMusic stop:)
				(myMusic number: 47 loop: 1 play:)
				(= cycles 2)
			)
			(5
				(ShakeScreen 10 5) ; ssUPDOWN | $0004
				(= seconds 3)
			)
			(6
				(myMusic number: 57 loop: 1 play: self)
				(gEgo
					view: 38
					setCel: -1
					setLoop: 0
					setPri: 15
					setCycle: Fwd
					setStep: 3 3
					ignoreActors: 1
					illegalBits: 0
					ignoreHorizon: 1
					setMotion: MoveTo (gEgo x:) -50 self
				)
			)
			(7
				(= global128 myIcon)
				(= global129 0)
				(= global130 0)
				(= global132 1)
			)
			(8
				(EgoDead 47 10) ; "It's not a pretty sight."
			)
		)
	)
)

(instance post1 of PV
	(properties
		y 122
		x 78
		view 147
		loop 2
		priority 15
		signal 16384
	)
)

(instance post2 of PV
	(properties
		y 121
		x 243
		view 147
		loop 2
		cel 1
		priority 15
		signal 16384
	)
)

(instance cabL of PV
	(properties
		y 53
		x 124
		view 147
		loop 2
		cel 8
		priority 2
	)
)

(instance cabR of PV
	(properties
		y 53
		x 199
		view 147
		loop 2
		cel 9
		priority 2
	)
)

(instance cat of PV
	(properties
		y 53
		x 143
		view 147
		loop 2
		cel 6
		priority 2
	)
)

(instance vase of PV
	(properties
		y 52
		x 177
		view 147
		loop 2
		cel 7
		priority 1
	)
)

(instance wardR of RPicView
	(properties
		y 80
		x 220
		view 147
		loop 2
		cel 5
		priority 4
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/armoire'))
			(event claimed: 1)
			(Print 47 11) ; "There are two armoires in the back hallway."
		)
	)
)

(instance wardL of RPicView
	(properties
		y 80
		x 103
		view 147
		loop 2
		cel 4
		priority 4
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/armoire'))
			(event claimed: 1)
			(Print 47 11) ; "There are two armoires in the back hallway."
		)
	)
)

(instance chain2 of PV
	(properties
		y 47
		x 162
		view 147
		loop 2
		cel 3
		priority 15
	)
)

(instance chain3 of PV
	(properties
		y 65
		x 162
		view 147
		loop 2
		cel 3
		priority 15
	)
)

(instance table1 of RPicView
	(properties
		y 94
		x 101
		view 147
		loop 2
		cel 10
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance table2 of RPicView
	(properties
		y 94
		x 221
		view 147
		loop 2
		cel 11
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance chand of Prop
	(properties
		y 87
		x 161
		view 147
		loop 2
		cel 2
	)

	(method (handleEvent event)
		(if (not local5)
			(cond
				((Said 'get/chandelier')
					(Print 47 12) ; "You can't get that."
				)
				(
					(or
						(MousedOn self event 3)
						(Said 'look/chandelier,ceiling')
						(Said 'look<up')
					)
					(event claimed: 1)
					(Print 47 13) ; "A huge, crystal chandelier hangs precariously above the downstairs foyer."
				)
			)
		)
	)
)

(instance Ldoor of Prop
	(properties
		y 129
		x 53
		view 147
		loop 3
	)

	(method (handleEvent event)
		(if (not local5)
			(cond
				((Said 'close/door')
					(AlreadyClosed) ; "It is already closed."
				)
				((Said 'bang/door,closet')
					(Print 47 14) ; "Why would anyone be in the closet?"
				)
				((Said 'open,(look<in)/door,closet')
					(cond
						(local1
							(AlreadyOpen) ; "It is already open."
						)
						((& (gEgo onControl: 0) $0020)
							(self setScript: myDoor)
						)
						(else
							(NotClose) ; "You're not close enough."
						)
					)
				)
				(
					(or
						(MousedOn self event 3)
						(Said 'look/closet,(door<closet),(door[<!*])')
					)
					(event claimed: 1)
					(Print 47 15) ; "You notice a closet at the top of the stairs."
				)
			)
		)
	)
)

(instance rail1 of Act
	(properties
		y 141
		x 115
		view 147
		loop 2
		cel 13
	)
)

(instance rail2 of Act
	(properties
		y 141
		x 208
		view 147
		loop 2
		cel 14
	)
)

(instance lampL of Prop
	(properties
		y 82
		x 89
		view 147
		cel 1
	)

	(method (handleEvent event)
		(if (and (not local5) (MousedOn self event 3))
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance lampR of Prop
	(properties
		y 82
		x 234
		view 147
		loop 1
	)

	(method (handleEvent event)
		(if (and (not local5) (MousedOn self event 3))
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance lamp3 of Prop
	(properties
		y 177
		x 234
		view 147
		loop 1
	)

	(method (handleEvent event)
		(if (and (not local5) (MousedOn self event 3))
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance lamp4 of Prop
	(properties
		y 177
		x 88
		view 147
		cel 1
	)

	(method (handleEvent event)
		(if (and (not local5) (MousedOn self event 3))
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance hand of Prop
	(properties
		y 130
		x 66
		view 18
	)
)

(instance hanky of Prop
	(properties
		y 108
		x 103
		view 147
		loop 2
		cel 12
	)

	(method (handleEvent event)
		(if (not local5)
			(cond
				(
					(or
						(MousedOn self event 3)
						(Said 'look/handkerchief,dirt')
						(and (< (gEgo y:) 128) (Said 'look<down[/!*]'))
					)
					(event claimed: 1)
					(Print 47 16) ; "Looks like someone dropped a white handkerchief on the floor."
				)
				((Said 'get/handkerchief[/dirt]')
					(if (< (gEgo distanceTo: hanky) 20)
						(self setScript: pickUp)
					else
						(NotClose) ; "You're not close enough."
					)
				)
			)
		)
	)
)

(instance pickUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(LookAt gEgo hanky)
				(= cycles 2)
			)
			(1
				(gEgo view: 17 cel: 0 setMotion: 0 setCycle: End self)
			)
			(2
				(Ok) ; "Okay."
				(hanky hide:)
				(= global182 1)
				(gEgo get: 23) ; handkerchief
				(= cycles 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(HandsOn)
				(gEgo view: 0 setCycle: Walk)
				(client dispose: delete: setScript: 0)
			)
		)
	)
)

(instance Rail of RFeature
	(properties
		nsTop 120
		nsLeft 79
		nsBottom 143
		nsRight 241
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/balcony'))
			(Print 47 17) ; "The banister looks a bit rickety."
			(event claimed: 1)
		)
	)
)

(instance Stair of RFeature
	(properties
		nsTop 63
		nsLeft 244
		nsBottom 120
		nsRight 269
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(Print 47 18) ; "You see stairs leading up to a third level of the mansion."
			(event claimed: 1)
		)
	)
)

(instance myMusic of Sound
	(properties)
)

(instance myIcon of DCIcon
	(properties
		view 653
	)

	(method (init)
		((= cycler (Fwd new:)) init: self)
	)
)

