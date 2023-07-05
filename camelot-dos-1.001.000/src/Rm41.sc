;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	Rm41 0
	muleDrinks 1
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 12] = [287 278 265 253 242 231 220 208 197 187 177 166]
	[local17 12] = [62 67 73 79 84 89 94 100 105 110 115 121]
	[local29 12] = [0 4 3 2 2 2 3 2 1 1 2 1]
	[local41 12] = [0 1 1 0 0 0 1 0 0 1 2 2]
	local53
)

(instance ripple1 of Prop
	(properties
		y 157
		x 160
		view 141
	)
)

(instance ripple2 of Prop
	(properties
		y 159
		x 39
		view 141
		loop 1
	)
)

(instance muleRipple of Prop
	(properties
		y 148
		x 99
		view 424
		loop 1
	)
)

(instance Rm41 of eRoom
	(properties
		picture 41
		style 8
	)

	(method (init)
		(Load rsVIEW 57)
		(Load rsVIEW 80)
		(if (IsFlag 20)
			(Load rsVIEW 403)
			(Load rsVIEW 404)
			(Load rsVIEW 422)
			(Load rsVIEW 424)
		)
		(Load rsVIEW 59)
		(Load rsVIEW 58)
		(Load rsSCRIPT 144)
		(Load rsSCRIPT 130)
		(Load rsSOUND 88)
		(super init:)
		(gRmMusic number: 88 priority: 1 loop: -1 play:)
		(self setRegions: 146) ; aqueduct
		(SetFlag 111)
		(if (== gPrevRoomNum 0)
			(SetFlag 20)
		)
		(if (IsFlag 20)
			(= local0 1)
			(self setRegions: 116) ; muleReg
		)
		(if global124
			(= global124 0)
		)
		(SetMenu 1283 112 0)
		(switch gPrevRoomNum
			(50
				(= local1 1)
				(gEgo view: 41 init:)
				(self enterRoom: -10 150 25 150)
				(if local0
					(gMuleObj setScript: muleDrinks)
				)
			)
			(else
				(gEgo view: (if (IsFlag 98) 57 else 0) illegalBits: 0 init:)
				(if local0
					(gEgo setScript: comeDownStairs)
					(gMuleObj setScript: oneStepAtATime)
				else
					(self enterRoom: 320 38 148 126)
				)
			)
		)
		(= global112 2)
		(ripple1 setPri: 0 ignoreActors: 1 init: cycleSpeed: 2 setCycle: Fwd)
		(ripple2 setPri: 0 ignoreActors: 1 init: cycleSpeed: 2 setCycle: Fwd)
		(proc0_13 80)
		(gAddToPics doit:)
	)

	(method (doit)
		(if (and (> (gEgo x:) 275) (self goingOut:))
			(gRmMusic fade:)
		)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(if (not local2)
				(if local1
					(cond
						((!= (gEgo priority:) 10)
							(gEgo setPri: 10)
						)
						(
							(or
								(and
									(<= (gEgo y:) 146)
									(!= (gEgo loop:) 3)
								)
								(and
									local0
									(<= 77 (gEgo x:) 116)
									(<= (gEgo y:) 146)
								)
							)
							(gEgo y: (+ (gEgo y:) 1) setMotion: 0)
						)
						((and (>= (gEgo y:) 158) (!= (gEgo loop:) 2))
							(gEgo y: (- (gEgo y:) 1) setMotion: 0)
						)
						((<= (gEgo y:) 146)
							(gEgo setScript: stepOutUp)
							(= local1 0)
							(= local2 1)
						)
						((>= (gEgo y:) 158)
							(gEgo setScript: stepOutDown)
							(= local1 0)
							(= local2 1)
						)
					)
				else
					(if (IsFlag 92)
						(ClearFlag 92)
						(gEgo
							y: (+ (gEgo y:) 4)
							illegalBits: 0
							setScript: (ScriptID 144 0) ; crawler
						)
					)
					(cond
						((>= 150 (gEgo y:) 138)
							(= local1 1)
							(= local2 1)
							(gEgo setScript: walkInDown)
						)
						((>= 164 (gEgo y:) 151)
							(= local1 1)
							(= local2 1)
							(gEgo setScript: walkInUp)
						)
					)
				)
			)
			(cond
				(
					(and
						local0
						(not local1)
						(< gPrevRoomNum 50)
						(not local3)
						(not (gEgo script:))
					)
					(= local3 1)
					(HandsOff)
					(gEgo setMotion: MoveTo 148 135)
				)
				((and (== (gEgo onControl: 1) 8192) (== (gEgo loop:) 0))
					(gEgo y: (- (gEgo y:) 3) illegalBits: 0)
					(= local4 1)
					(self leaveRoom: 40 320 38)
				)
				((< (gEgo x:) 10)
					(self leaveRoom: 50 -10 (gEgo y:))
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((Said 'look<in,in/tunnel,aquaduct,arch')
				(if (IsFlag 106)
					(Print 41 0) ; "You have seen enough of this tunnel for now."
				else
					(Print 41 1) ; "The tunnel is quite small and soon becomes pitch black inside."
				)
			)
			((Said 'look<down')
				(if local1
					(Print 41 2) ; "The water is not very deep."
				else
					(Print 41 3) ; "The ground is paved with stone."
				)
			)
			((Said 'look/dirt')
				(Print 41 3) ; "The ground is paved with stone."
			)
			((or (Said 'drink[/water]') (Said 'get/water,drink'))
				(SetScore 289 1 1)
				(if local1
					(gEgo setScript: (ScriptID 146 1)) ; drink
				else
					(gEgo setScript: getReady)
				)
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
							(Said '/pool,water,chamber')
							(Said '//pool,water,chamber')
						)
						(if (IsFlag 106)
							(Print 41 4) ; "You are once more at the Pool of Siloam. The hike back to Jerusalem awaits you."
						else
							(Print 41 5) ; "The walls and ground are paved with stone. The water flows from a tunnel carved into the rock of the hill above it."
							(if (not (IsFlag 104))
								(SetFlag 104)
								(Print 41 6) ; "Wait! At last I know where you are. This is the Pool of Siloam."
							)
						)
					)
					((or (Said '/slab,wall') (Said '//slab,wall'))
						(Print 41 7) ; "The pool is enclosed upon four sides by stone walls. In one wall there is a tunnel opening."
					)
					(
						(or
							(Said '/plant,aloe')
							(Said '//plant,aloe')
							(OnButton event 118 13 151 25)
						)
						(Print 41 8) ; "There are some aloe plants around the outside of the Pool's upper platform."
					)
					(
						(or
							(OnButton event 56 14 103 26)
							(OnButton event 153 16 241 26)
							(OnButton event 241 6 265 25)
						)
						(Print 41 9) ; "There are sections of old tumbled-down wall on the platform above the Pool."
					)
					(
						(or
							(Said '/hill')
							(Said '//hill')
							(OnButton event 0 0 128 27)
						)
						(Print 41 10) ; "There is a large hill through which the aqueduct is carved."
					)
					(
						(or
							(Said '/tunnel,arch,aquaduct')
							(Said '//tunnel,arch,aquaduct')
							(OnButton event 0 84 15 156)
						)
						(Print 41 11) ; "The tunnel is known as Hezekiah's Aqueduct."
					)
					(
						(or
							(Said '/stair')
							(Said '//stair')
							(OnButton event 160 111 176 126)
							(OnButton event 176 98 195 116)
							(OnButton event 196 87 215 106)
							(OnButton event 215 77 239 94)
							(OnButton event 240 65 260 84)
							(OnButton event 260 57 282 73)
							(OnButton event 281 49 302 62)
							(OnButton event 301 43 310 52)
						)
						(if local0
							(Print 41 12) ; "I doubt your mule would have attempted those narrow stone stairs had she not been so desperate for water."
						else
							(Print 41 13) ; "There is one set of narrow stone stairs."
						)
					)
					(
						(or
							(Said '/niche,bookshelf,hole')
							(Said '//niche,bookshelf,hole')
							(OnButton event 270 77 310 94)
						)
						(Print 41 14) ; "The niche is empty."
					)
					(
						(or
							(Said '/ass')
							(Said '//ass')
							(MouseClaimed gMuleObj event)
						)
						(if local0
							(Print 41 15) ; "Your mule delights in the fresh water and is ready to go on."
						else
							(Print 41 16) ; "Mohammed has your mule."
						)
					)
					(
						(or
							(Said '/water')
							(Said '//water')
							(OnButton event 8 143 301 156)
						)
						(Print 41 17) ; "It is pure and cold, flowing through the aqueduct from the Spring of Gihon."
						(if local0
							(Print 41 18) ; "Your mule certainly seems to enjoy it."
						)
					)
					(
						(or
							(Said '<up')
							(Said '/sky')
							(OnButton event 126 7 310 27)
						)
						(Print 41 19) ; "The sun burns no less fiercely overhead, though this cool pit provides some relief."
					)
				)
			)
		)
	)
)

(instance walkInDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetMenu 1283 112 0)
				(SetMenu 1281 112 0)
				(gEgo
					view: 80
					setPri: 10
					setLoop: 0
					cel: 0
					illegalBits: 0
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 41
					setLoop: -1
					setCycle: Walk
					y: (+ (gEgo y:) 5)
				)
				(self cue:)
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self)
			)
			(3
				(HandsOn)
				(= local2 0)
				(gEgo illegalBits: -32768)
				(self dispose:)
			)
		)
	)
)

(instance walkInUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetMenu 1283 112 0)
				(SetMenu 1281 112 0)
				(gEgo
					illegalBits: 0
					setPri: 10
					view: 80
					setLoop: 1
					cel: 4
					y: (- (gEgo y:) 5)
					setCycle: Beg self
				)
			)
			(1
				(gEgo
					view: 41
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self
				)
			)
			(2
				(HandsOn)
				(= local2 0)
				(gEgo illegalBits: -32768)
				(self dispose:)
			)
		)
	)
)

(instance stepOutUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 80
					illegalBits: 0
					setLoop: 1
					cel: 0
					y: (- (gEgo y:) 5)
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 0
					setPri: -1
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self
				)
			)
			(2
				(HandsOn)
				(SetMenu 1283 112 1)
				(SetMenu 1281 112 1)
				(= local2 0)
				(gEgo illegalBits: -32768)
				(self dispose:)
			)
		)
	)
)

(instance stepOutDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 80
					illegalBits: 0
					setLoop: 0
					cel: 4
					setCycle: Beg self
				)
			)
			(1
				(gEgo view: 0 setPri: -1 setCycle: Walk setLoop: 2)
				(self cue:)
			)
			(2
				(gEgo
					setLoop: -1
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(3
				(HandsOn)
				(SetMenu 1283 112 1)
				(SetMenu 1281 112 1)
				(= local2 0)
				(gEgo illegalBits: -32768)
				(self dispose:)
			)
		)
	)
)

(instance getReady of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0)
				(HandsOff)
				(cond
					((> (gEgo y:) 150)
						(if (> (gEgo x:) 287)
							(gEgo setMotion: MoveTo 285 (gEgo y:) self)
						else
							(self cue:)
						)
					)
					((or (<= (gEgo x:) 63) (<= 78 (gEgo x:) 98))
						(gEgo setMotion: MoveTo 70 (gEgo y:) self)
					)
					((<= 99 (gEgo x:) 119)
						(gEgo setMotion: MoveTo 125 (gEgo y:) self)
					)
					((>= (gEgo x:) 286)
						(gEgo setMotion: MoveTo 280 (gEgo y:) self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(= local2 1)
				(= local1 1)
				(if (> (gEgo y:) 150)
					(gEgo setMotion: MoveTo (gEgo x:) 164 self)
				else
					(gEgo setMotion: MoveTo (gEgo x:) 138 self)
				)
			)
			(2
				(if (> (gEgo y:) 150)
					(self setScript: walkInUp self)
				else
					(self setScript: walkInDown self)
				)
			)
			(3
				(client setScript: (ScriptID 146 1)) ; drink
			)
		)
	)
)

(instance comeDownStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom comingIn: 1)
				(gEgo
					loop: 1
					illegalBits: 0
					posn: 199 102
					setMotion: MoveTo 148 125 self
				)
			)
			(1
				(gEgo illegalBits: -32768)
				(gCurRoom comingIn: 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance oneStepAtATime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMuleObj
					illegalBits: 0
					view: 422
					setLoop: 0
					cel: 0
					posn: 296 57
					setStep: 1 1
					setCycle: End self
				)
			)
			(1
				(gMuleObj
					cel: 0
					posn: [local5 local53] [local17 local53]
					setMotion:
						MoveTo
						(- [local5 local53] [local29 local53])
						(+ [local17 local53] [local41 local53])
					setCycle: End self
				)
				(++ local53)
			)
			(2
				(if (== local53 12)
					(self cue:)
				else
					(self changeState: 1)
				)
			)
			(3
				(gMuleObj setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gMuleObj
					view: 403
					setLoop: -1
					cel: 0
					posn: 140 125
					setStep: 3 2
					setCycle: Walk
					setMotion: MoveTo 100 127 self
				)
			)
			(5
				(Face gEgo gMuleObj)
				(gEgo illegalBits: -32768)
				(gMuleObj view: 404 loop: 1 cel: 0 setCycle: End self)
			)
			(6
				(gMuleObj
					view: 403
					loop: 2
					setCycle: Walk
					setMotion: MoveTo 100 137 self
				)
			)
			(7
				(if (not (gEgo script:))
					(HandsOn)
				)
				(client setScript: muleDrinks)
			)
		)
	)
)

(instance muleDrinks of Script
	(properties)

	(method (doit)
		(if (and (!= (gMuleObj cycler:) Beg) local4)
			(= local4 0)
			(client setScript: followEgo)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMuleObj
					view: 424
					x: (if global169 67 else 100)
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(muleRipple
					init:
					ignoreActors:
					setPri: 9
					x: (if global169 66 else 99)
					cycleSpeed: 1
					setCycle: Fwd
				)
				(if (IsFlag 107)
					(= seconds 10)
				else
					(= seconds 4)
				)
				(ClearFlag 107)
				(= global205 10000)
			)
			(2
				(muleRipple hide:)
				(gMuleObj setCycle: Beg)
				(= seconds (Random 3 8))
			)
			(3
				(gMuleObj setCycle: End self)
			)
			(4
				(muleRipple show: setCycle: Fwd)
				(= seconds (Random 2 6))
			)
			(5
				(self changeState: 2)
			)
		)
	)
)

(instance followEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(muleRipple setCycle: 0 dispose:)
				(if (== (gMuleObj cel:) 0)
					(self cue:)
				else
					(gMuleObj setCycle: Beg self)
				)
			)
			(1
				(= cycles 32)
			)
			(2
				(gMuleObj
					view: 404
					loop: 0
					cycleSpeed: 0
					cel: 5
					setCycle: Beg self
				)
			)
			(3
				(gMuleObj
					view: 403
					loop: 0
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 135 126 self
				)
			)
			(4
				(client setScript: 0)
			)
		)
	)
)

