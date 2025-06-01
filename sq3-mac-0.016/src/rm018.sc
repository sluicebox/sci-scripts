;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Interface)
(use Wander)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm018 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 33]
	local39
	local40
	local41
)

(procedure (localproc_0 param1 param2 param3)
	(Display param1 dsWIDTH 50 dsCOORD param2 param3 dsCOLOR 14 dsFONT 600)
)

(procedure (localproc_1 param1 param2 param3)
	(if param1
		(Display param1 dsWIDTH 45 dsCOORD param2 param3 dsFONT 600 dsCOLOR 0)
		(vHair forceUpd:)
	)
)

(procedure (localproc_2)
	(FButton
		cel:
			(cond
				((< global174 2) 2)
				((== global205 1) 1)
				(else 0)
			)
		draw:
	)
	(BButton
		cel:
			(cond
				((< global174 2) 2)
				((== global205 2) 1)
				(else 0)
			)
		draw:
	)
	(switch global205
		(0
			(frontShield cel: 0)
			(backShield cel: 0)
		)
		(1
			(frontShield cel: (if (< global174 6) 1 else 2))
			(backShield cel: 0)
		)
		(2
			(frontShield cel: 0)
			(backShield cel: (if (< global174 6) 1 else 2))
		)
	)
)

(instance rm018 of Rm
	(properties
		style 0
	)

	(method (init &tmp [temp0 50])
		(self picture: 18)
		(self setRegions: 701) ; travrg
		(if (> global598 4)
			(Load rsVIEW 46)
		else
			(Load rsVIEW 146)
		)
		(Load rsVIEW 45)
		(Load rsVIEW 47)
		(Load rsVIEW 48)
		(Load rsVIEW 51)
		(Load rsVIEW 55)
		(Load rsPIC 121)
		(Load rsSOUND 27)
		(Load rsSOUND 39)
		(Load rsSOUND 31)
		(Load rsSOUND 33)
		(Load rsSOUND 200)
		(Load rsSOUND 201)
		(gEgo
			view: 45
			setLoop: 3
			setCel: 2
			setCycle: 0
			setStep: 4 4
			setPri: 10
			ignoreActors: 1
			posn: 160 88
			illegalBits: $4000
			init:
			setCycle: 0
		)
		(hHair init: stopUpd:)
		(vHair init: stopUpd:)
		(engage init:)
		(super init:)
		(HandsOff)
		(= global592 1)
		(= local5 {NEGATIVE})
		(gGame setCursor: gNormalCursor (HaveMouse))
		(gAddToPics add: shipShape eachElementDo: #init)
		(gAddToPics doit:)
		(frontShield init:)
		(backShield init:)
		(controls
			add: FButton BButton HButton fire exit
			eachElementDo: #init
			draw:
		)
		(localproc_2)
		(Display 18 0 dsCOORD 44 110 dsFONT 600 dsWIDTH 50 dsCOLOR 10) ; "TARGET:"
		(Display 18 1 dsCOORD 242 37 dsFONT 612 dsCOLOR 10 dsBACKGROUND 0 dsALIGN alLEFT) ; "SHIELDS"
		(Display 18 2 dsCOORD 48 96 dsFONT 612 dsCOLOR 10 dsBACKGROUND 0 dsALIGN alLEFT) ; "RADAR"
		(Display 18 3 dsCOORD 139 147 dsFONT 612 dsCOLOR 10 dsBACKGROUND 0 dsALIGN alLEFT) ; "SPACE BAR"
		(Display 18 4 dsCOORD 41 37 dsFONT 612 dsCOLOR 10 dsBACKGROUND 0 dsALIGN alLEFT) ; "CONTROLS"
		(if (> global598 4)
			(Display 18 5 dsCOORD 38 47 dsFONT 680 dsCOLOR 10 dsBACKGROUND 0 dsALIGN alLEFT) ; "H"
			(Display 18 6 dsCOORD 38 75 dsFONT 680 dsCOLOR 10 dsBACKGROUND 0 dsALIGN alLEFT) ; "O"
			(Display 18 7 dsCOORD 236 47 dsFONT 680 dsCOLOR 10 dsBACKGROUND 0 dsALIGN alLEFT) ; "F"
			(Display 18 8 dsCOORD 236 75 dsFONT 680 dsCOLOR 10 dsBACKGROUND 0 dsALIGN alLEFT) ; "B"
		)
		(= local3 0)
		(if global594
			(= global175 2)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look[/area]')
			(gCurRoom newRoom: 17)
		)
	)

	(method (newRoom newRoomNumber)
		(User canControl: 1)
		(if (and global218 (< global175 10))
			(= global175 10)
		)
		(gTimers eachElementDo: #dispose 84)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp [temp0 20])
		(if (and (< global174 2) (not local4))
			(= local4 1)
			(= global205 0)
			(localproc_2)
			(Depleted changeState: 1)
		)
		(if (== global175 1)
			(= global175 0)
			(zoomShip init: posn: 0 0)
			(gCurRoom
				setScript:
					(switch global594
						(0 ZoomScript)
						(1 ZoomScript)
						(2 ZScript)
					)
			)
		)
		(if local3
			(if (or (== local3 4) (== local3 5))
				(gEgo posn: (targShip x:) (targShip y:))
			)
			(if
				(and
					(gCast contains: targShip)
					(gEgo
						inRect:
							(- (targShip x:) 5)
							(- (targShip y:) 4)
							(+ (targShip x:) 5)
							(+ (targShip y:) 4)
					)
					(== local3 3)
					(== global209 3)
				)
				(HandsOff)
				(= local3 4)
				(gCurRoom setScript: CenterScript)
			)
		)
		(if (== local3 3)
			(if global219
				(-- local0)
			)
			(if (not local0)
				(trackSound stop:)
				(gCurRoom setScript: OutOfRange)
			)
		)
		(if (== local3 5)
			(if global219
				(-- local1)
			)
			(if (not local1)
				(lockSound stop:)
				(gCurRoom setScript: OutOfRange)
			)
		)
		(super doit:)
	)
)

(instance OutOfRange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local3 1)
				(= local39 1)
				(lockSign setCel: 3 init: forceUpd:)
				(engage setCel: 0 stopUpd:)
				(targShip
					view: 48
					setLoop: 4
					setCel: 5
					setMotion: 0
					cycleSpeed: 0
					setCycle: Beg self
				)
			)
			(1
				(targShip dispose:)
				(topArrow dispose:)
				(bottomArrow dispose:)
				(leftArrow dispose:)
				(rightArrow dispose:)
				(gEgo setMotion: qMoveTo 160 88 self)
			)
			(2
				(lockSign dispose:)
				(gEgo posn: 160 88 stopUpd:)
				(HandsOff)
				(vHair posn: 160 88 stopUpd:)
				(hHair posn: 160 88 stopUpd:)
				(= local39 0)
				(gCurRoom setScript: ZScript)
			)
		)
	)
)

(instance ZoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global594 1)
				(localproc_1 local5 40 125)
				(if global207
					(= local5 { IN REAR})
				else
					(= local5 {NEGATIVE})
				)
				(RadarScript changeState: 0)
				(= seconds 3)
			)
			(1
				(boom play:)
				(ShakeScreen 5 ssFULL_SHAKE)
				(if (or (not (-- global174)) (!= global205 2))
					(client setScript: BlowShip)
				else
					(zoomShip
						posn: 135 79
						setLoop: 2
						cel: 0
						cycleSpeed: 0
						setCycle: End self
					)
				)
			)
			(2
				(localproc_1 local5 40 125)
				(if global207
					(= local5 {IN FRONT})
				else
					(= local5 {NEGATIVE})
				)
				(RadarScript changeState: 0)
				(= global594 2)
				(gCurRoom setScript: TrackScript)
			)
		)
	)
)

(instance ZScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global594 2)
				(= seconds 4)
			)
			(1
				(localproc_1 local5 40 125)
				(if global207
					(= local5 {IN FRONT})
				else
					(= local5 {NEGATIVE})
				)
				(RadarScript changeState: 0)
				(if (not (gCast contains: zoomShip))
					(zoomShip init:)
				)
				(zoomShip
					cel: 0
					setLoop: 0
					posn: 185 72
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(2
				(zoomShip cel: 0 setLoop: 1 posn: 195 80 setCycle: End self)
			)
			(3
				(zoomShip cel: 0 setCycle: End self)
			)
			(4
				(zoomShip cel: 0 setCycle: End self)
			)
			(5
				(zoomShip dispose:)
				(RedrawCast)
				(boom play:)
				(ShakeScreen 5 ssFULL_SHAKE)
				(if (or (not (-- global174)) (!= global205 1))
					(client setScript: BlowShip)
				else
					(localproc_1 local5 40 125)
					(= local5 {NEGATIVE})
					(RadarScript changeState: 0)
				)
				(= global594 0)
				(= global175 10)
			)
		)
	)
)

(instance TrackScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(engage setCycle: Fwd)
				(trackSound play:)
				(zoomShip
					setLoop: 4
					cel: 0
					posn: 140 70
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(targShip
					view: 47
					illegalBits: $4000
					setPri: 8
					setStep: 4 4
					cel: 5
					ignoreActors: 1
					setCycle: 0
					setMotion: Wander 30
					posn: (zoomShip x:) (zoomShip y:)
					init:
				)
				(zoomShip dispose:)
				(HandsOn)
				(= local3 3)
				(if (not global124)
					(= local0 12)
				else
					(= local0 10)
				)
				(vHair startUpd:)
				(hHair startUpd:)
				(lockSign setCel: 1 init: stopUpd:)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance CenterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(targShip setMotion: MoveTo 160 88 self)
			)
			(1
				(trackSound stop:)
				(lockSound play:)
				(= local3 5)
				(if (not global124)
					(= local1 7)
				else
					(= local1 5)
				)
				(lockSign setCel: 0 forceUpd:)
				(topArrow init: stopUpd:)
				(bottomArrow init: stopUpd:)
				(leftArrow init: stopUpd:)
				(rightArrow init: stopUpd:)
				(targShip setStep: 2 2 setMotion: Wander 10 illegalBits: $ffdf)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance shotScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== local3 5)
					(targShip setMotion: 0 stopUpd:)
				)
				(if (not (= local2 (/ (Abs (- (gEgo y:) 88)) 4)))
					(= local2 1)
				)
				(if (not (= local40 (Abs (/ (- (gEgo x:) 120) 3))))
					(= local40 1)
				)
				(if (not (= local41 (Abs (/ (- 198 (gEgo x:)) 3))))
					(= local41 1)
				)
				(rShot cel: 255 init:)
				(lShot cel: 255 init:)
				(lockSound stop:)
				(RedrawCast)
				(laser play:)
				(lShot
					setStep: local40 local2
					setCycle: End
					setMotion: MoveTo (gEgo x:) (gEgo y:) self
				)
				(rShot
					setStep: local41 local2
					setCycle: End
					setMotion: MoveTo (gEgo x:) (gEgo y:)
				)
			)
			(1
				(lShot dispose:)
				(rShot dispose:)
				(engage setCel: 0 stopUpd:)
				(if (== local3 5)
					(= local1 -1)
					(targShip dispose:)
					(blast init: setCycle: End self)
					(lockSound stop:)
					(enemyBoom play:)
				else
					(if (== global210 0)
						(gCurRoom newRoom: 20)
					)
					(fire cel: 0 state: 1 draw:)
					(= local39 0)
					(if (== local3 3)
						(HandsOn)
					)
				)
			)
			(2
				(blast dispose:)
				(lockSign setCel: 2 forceUpd:)
				(RedrawCast)
				(fire cel: 0 state: 1 draw:)
				(= local3 2)
				(topArrow dispose:)
				(bottomArrow dispose:)
				(leftArrow dispose:)
				(rightArrow dispose:)
				(gEgo setMotion: MoveTo 160 88 self)
			)
			(3
				(= local39 0)
				(= local3 1)
				(lockSign dispose:)
				(gEgo posn: 160 88 stopUpd:)
				(vHair posn: 160 88 stopUpd:)
				(hHair posn: 160 88 stopUpd:)
				(if (== (++ global176) 5)
					(localproc_1 local5 40 125)
					(= local5 {NEGATIVE})
					(RadarScript changeState: 0)
					(Print 18 9) ; "The remaining enemy ships have given up and are heading back to the planet. It looks like you were just too much for 'em."
					(gCurRoom setScript: 0)
					(gGame changeScore: 100)
					(= global218 0)
					(= global175 0)
					(= global594 0)
					(= global167 0)
				else
					(gCurRoom setScript: ZScript)
				)
			)
		)
	)
)

(instance BlowShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(boom play:)
				(ShakeScreen 20 ssFULL_SHAKE)
				(RadarScript changeState: 3)
				(localproc_1 local5 40 125)
				(gCast eachElementDo: #dispose)
				(cls)
				(gCurRoom drawPic: 121)
				(if (not global174)
					(Print 18 10) ; "With your shield depleted, the final hit shreds the side of your ship. In the sudden vacuum, your body fluids expand beyond the capacity of your tissues. Your desiccated body will drift forever, a grim testament to your blundering stupidity."
				else
					(Print 18 11) ; "Having the correct shield up could have prevented this!  The final shot shreds the side of your ship. In the sudden vacuum, your body fluids expand beyond the capacity of your tissues. Your desiccated body will drift forever, a grim testament to your blundering stupidity."
				)
				(EgoDead 0 0 4 5) ; "Sudden Decompression Sucks!"
			)
		)
	)
)

(instance RadarScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 local5 40 125)
				(Timer setCycle: self 5)
			)
			(1
				(localproc_1 local5 40 125)
				(Timer setCycle: self 5)
			)
			(2
				(self changeState: 0)
			)
			(3
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance Depleted of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(shWarn play:)
				(depleted init: setCycle: Fwd)
			)
			(2
				(depleted setCel: 0 stopUpd:)
				(shWarn dispose:)
			)
		)
	)

	(method (doit)
		(if (and (== (shWarn state:) -1) (!= (self state:) 2))
			(self changeState: 2)
		)
		(super doit:)
	)
)

(instance zoomShip of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 48 ignoreActors: 1 setPri: 6 illegalBits: 0)
	)
)

(instance frontShield of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: (if (> global598 4) 46 else 146)
			loop: 6
			posn: 258 119
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance backShield of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: (if (> global598 4) 46 else 146)
			loop: 7
			posn: 258 127
			setPri: 15
			ignoreActors: 1
		)
	)
)

(instance targShip of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 47
			illegalBits: $4000
			setPri: 8
			setStep: 4 4
			cel: 5
			ignoreActors: 1
			setCycle: 0
			setMotion: Wander 30
		)
	)

	(method (doit)
		(if (!= (self view:) 48)
			(switch (self onControl: 1)
				(2
					(self cel: 1)
				)
				(4
					(self cel: 2)
				)
				(8
					(self cel: 3)
				)
				(16
					(self cel: 4)
				)
				(32
					(self cel: 5)
				)
				(64
					(self cel: 6)
				)
				(128
					(self cel: 7)
				)
				(256
					(self cel: 8)
				)
				(512
					(self cel: 9)
				)
			)
		)
		(super doit:)
	)
)

(instance hHair of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 3
			setCel: 0
			posn: 160 88
			setPri: 9
			ignoreActors: 1
			setCycle: 0
		)
	)

	(method (doit)
		(if local3
			(self y: (gEgo y:))
		)
		(super doit:)
	)
)

(instance vHair of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 3
			setCel: 1
			posn: 160 88
			setPri: 9
			ignoreActors: 1
			setCycle: 0
		)
	)

	(method (doit)
		(if local3
			(self x: (gEgo x:))
		)
		(super doit:)
	)
)

(instance lockSign of View
	(properties)

	(method (init)
		(super init:)
		(self view: 45 loop: 1 posn: 159 43 setPri: 15 ignoreActors: 1)
	)
)

(instance topArrow of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 2
			setCel: 0
			posn: 160 61
			setPri: 9
			ignoreActors: 1
		)
	)
)

(instance bottomArrow of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 2
			setCel: 1
			posn: 160 126
			setPri: 9
			ignoreActors: 1
		)
	)
)

(instance leftArrow of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 2
			setCel: 2
			posn: 110 98
			setPri: 9
			ignoreActors: 1
		)
	)
)

(instance rightArrow of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 2
			setCel: 3
			setPri: 9
			ignoreActors: 1
			posn: 207 98
		)
	)
)

(instance lShot of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 0
			setCel: 0
			setPri: 14
			ignoreActors: 1
			posn: 120 88
		)
	)
)

(instance rShot of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 45
			setLoop: 0
			setCel: 0
			setPri: 14
			ignoreActors: 1
			posn: 198 88
		)
	)
)

(instance blast of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 55
			setCel: 0
			posn: (gEgo x:) (gEgo y:)
			setPri: 9
			cycleSpeed: 1
			ignoreActors: 1
		)
	)
)

(instance depleted of Prop
	(properties)

	(method (init)
		(super init:)
		(= view (if (> global598 4) 46 else 146))
		(self setLoop: 0 setCel: 0 posn: 259 70 setPri: 15 ignoreActors: 1)
	)
)

(instance engage of Prop
	(properties)

	(method (init)
		(super init:)
		(= view (if (> global598 4) 46 else 146))
		(self setLoop: 4 setCel: 0 x: 67 y: 70 setPri: 15 ignoreActors: 1)
	)
)

(instance shipShape of PV
	(properties
		y 127
		x 258
		loop 5
		priority 14
		signal 16384
	)

	(method (init)
		(= view (if (> global598 4) 46 else 146))
		(super init:)
	)
)

(instance shWarn of Sound
	(properties
		number 27
		priority 1
	)
)

(instance laser of Sound
	(properties
		number 39
		priority 3
	)
)

(instance trackSound of Sound
	(properties
		number 200
		priority 1
		loop -1
	)
)

(instance lockSound of Sound
	(properties
		number 201
		priority 2
		loop -1
	)
)

(instance boom of Sound
	(properties
		number 33
		priority 1
	)
)

(instance enemyBoom of Sound
	(properties
		number 31
		priority 1
	)
)

(instance HButton of DIcon
	(properties
		state 1
		nsTop 44
		nsLeft 47
		key 104
		loop 3
	)

	(method (init)
		(= view (if (> global598 4) 46 else 146))
		(super init:)
	)

	(method (doit)
		(Print 18 12) ; "When the enemy ship comes from behind, you will automatically begin tracking. Use the direction keys or mouse to move the target cross-hairs onto the target. When you are locked on, use the space bar to fire."
	)
)

(instance exit of DIcon
	(properties
		state 1
		nsTop 72
		nsLeft 47
		key 111
		loop 9
	)

	(method (init)
		(= view (if (> global598 4) 46 else 146))
		(super init:)
	)

	(method (doit)
		(self cel: 1 draw:)
		(gCurRoom newRoom: 17)
	)
)

(instance FButton of DIcon
	(properties
		state 1
		nsTop 44
		nsLeft 245
		key 102
		loop 1
	)

	(method (init)
		(= view (if (> global598 4) 46 else 146))
		(super init:)
	)

	(method (doit)
		(switch (self cel:)
			(0
				(= global205 1)
			)
			(1
				(= global205 0)
			)
			(2
				(return)
			)
		)
		(localproc_2)
	)
)

(instance BButton of DIcon
	(properties
		state 1
		nsTop 72
		nsLeft 245
		key 98
		loop 2
	)

	(method (init)
		(= view (if (> global598 4) 46 else 146))
		(super init:)
	)

	(method (doit)
		(switch (self cel:)
			(0
				(= global205 2)
			)
			(1
				(= global205 0)
			)
			(2
				(return)
			)
		)
		(localproc_2)
	)
)

(instance fire of DIcon
	(properties
		state 1
		nsTop 135
		nsLeft 137
		key 32
		loop 8
	)

	(method (init)
		(= view (if (> global598 4) 46 else 146))
		(super init:)
	)

	(method (doit)
		(if (not local39)
			(= local39 1)
			(self cel: 1 draw:)
			(gEgo setScript: shotScript)
		)
	)
)

(instance qMoveTo of MoveTo
	(properties)

	(method (dispose)
		(if (and (not completed) caller)
			(caller cue:)
		)
		(super dispose:)
	)
)

