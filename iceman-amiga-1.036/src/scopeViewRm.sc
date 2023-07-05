;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Interface)
(use Submarine_806)
(use CyclingProp)
(use Game)
(use User)
(use Actor)
(use System)

(public
	scopeViewRm 0
)

(local
	[local0 2]
	local2
	local3
)

(instance scopeViewRm of Rm
	(properties
		picture 26
	)

	(method (init)
		(if (== (gEgo x:) 104)
			(= local3 1)
		)
		(self setRegions: 314) ; subMarine
		(super init:)
		(HandsOn)
		(scopeWaterSky init: setPri: 1)
		(scopeXHairs init: setPri: 15)
		(= local2 (Submarine absHeading:))
		(switch (((ScriptID 314) script:) state:) ; subMarine
			(15
				(rig init:)
				(harbor init:)
			)
			(8
				(ship init:)
			)
		)
		(headingGaugeView init: setPri: 14)
		(cloud1 init:)
		(cloud2 init:)
		(downButton init:)
		(leftButton init:)
		(rightButton init:)
		(headingGauge doit:)
		(sparkle1 init: setPri: 6)
		(sparkle2 init: setPri: 6)
		(sparkle3 init: setPri: 6)
		(movement1 init: setPri: 6)
		(movement2 init: setPri: 6)
		(movement3 init: setPri: 6)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'down/periscope')
				(self newRoom: 25) ; controlRm
			)
			((Said 'look[/periscope]')
				(Print 26 0) ; "You see nothing special."
			)
		)
	)
)

(class ScopeActor of Act
	(properties
		degreesFromSub 0
	)

	(method (init)
		(super init: &rest)
		(self setPri: priority setLoop: findX:)
	)

	(method (doit)
		(self findX:)
		(super doit: &rest)
	)

	(method (findX)
		(self x: (+ 161 (* 4 (- degreesFromSub local2))))
	)
)

(instance rig of ScopeActor
	(properties
		y 40
		x 161
		view 26
		cel 4
		priority 10
		degreesFromSub 282
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[/periscope,rig]')
				(if (< 129 x 189)
					(Print 26 1) ; "You see what appears to be an oil rig."
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance harbor of ScopeActor
	(properties
		y 38
		x 161
		view 26
		cel 5
		priority 10
		degreesFromSub 36
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[/periscope,harbor]')
				(if (< 119 x 199)
					(Print 26 2) ; "You see what appears to be a harbor."
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance cloud1 of ScopeActor
	(properties
		y 34
		view 26
		loop 5
		priority 9
	)

	(method (init)
		(self degreesFromSub: (Random 30 330) cel: (Random 0 1))
		(super init:)
	)
)

(instance cloud2 of ScopeActor
	(properties
		y 34
		view 26
		loop 6
		cel 1
		priority 9
	)

	(method (init)
		(self cel: (Random 0 1) degreesFromSub: (Random 30 330))
		(super init:)
	)
)

(instance scopeWaterSky of View
	(properties
		y 68
		x 159
		view 26
		loop 2
		cel 7
	)
)

(instance scopeXHairs of View
	(properties
		y 72
		x 159
		view 26
	)
)

(instance ship of ScopeActor
	(properties
		y 38
		view 26
		cel 3
		priority 10
		signal 16384
		illegalBits 0
	)
)

(instance headingGaugeView of View
	(properties
		y 160
		x 246
		view 26
		loop 2
		cel 6
	)
)

(instance headingGauge of Code
	(properties)

	(method (doit &tmp [temp0 3])
		(Display 26 3 dsCOORD 225 151 dsCOLOR 8 dsALIGN alRIGHT dsWIDTH 25 dsFONT 30) ; "888"
		(Display
			(Format @temp0 26 4 local2) ; "%d"
			dsCOORD
			225
			151
			dsCOLOR
			12
			dsALIGN
			alRIGHT
			dsWIDTH
			25
			dsFONT
			30
		)
	)
)

(instance leftButton of Prop
	(properties
		y 131
		x 73
		view 26
		loop 2
		cel 1
	)

	(method (init)
		(super init:)
		(self setPri: 15)
		(gIceMouseDownHandler add: self)
		(gIceDirectionHandler add: self)
	)

	(method (dispose)
		(gIceMouseDownHandler delete: self)
		(gIceDirectionHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) $0040) (== (event message:) JOY_LEFT)) ; direction
				(self setScript: (Clone upKeyScript) self 0 setCel: 4)
			)
			((MousedOn self event)
				(self setScript: upButtonScript self 0 setCel: 4)
			)
		)
	)

	(method (cue)
		(self setCel: 1)
	)
)

(instance rightButton of Prop
	(properties
		y 131
		x 246
		view 26
		loop 2
	)

	(method (init)
		(super init:)
		(self setPri: 15)
		(gIceMouseDownHandler add: self)
		(gIceDirectionHandler add: self)
	)

	(method (dispose)
		(gIceMouseDownHandler delete: self)
		(gIceDirectionHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) $0040) (== (event message:) JOY_RIGHT)) ; direction
				(self setScript: (Clone upKeyScript) self 1 setCel: 3)
			)
			((MousedOn self event)
				(self setScript: upButtonScript self 1 setCel: 3)
			)
		)
	)

	(method (cue)
		(self setCel: 0)
	)
)

(instance downButton of Prop
	(properties
		y 162
		x 73
		view 26
		loop 2
		cel 2
	)

	(method (init)
		(super init:)
		(gIceMouseDownHandler add: self)
		(gIceDirectionHandler add: self)
		(self setPri: 15)
	)

	(method (dispose)
		(gIceMouseDownHandler delete: self)
		(gIceDirectionHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== (event type:) $0040) (== (event message:) JOY_DOWN)) ; direction
				(self setScript: downScopeScript)
			)
			((MousedOn self event)
				(self setScript: downScopeScript)
			)
		)
	)
)

(instance downScopeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCel: 5)
				(= seconds 2)
			)
			(1
				(gCurRoom newRoom: 25) ; controlRm
			)
		)
	)
)

(instance upButtonScript of Script
	(properties)

	(method (doit)
		(if (== ((User curEvent:) type:) evMOUSERELEASE)
			(self dispose:)
		else
			(= local2
				(if register
					(umod (+ local2 1) 360)
				else
					(umod (- local2 1) 360)
				)
			)
			(headingGauge doit:)
		)
	)
)

(instance upKeyScript of Script
	(properties)

	(method (doit)
		(if
			(or
				(!= ((User curEvent:) type:) $0040) ; direction
				(!= ((User curEvent:) message:) (if register 3 else 7))
			)
			(self dispose:)
		else
			(= local2
				(if register
					(umod (+ local2 1) 360)
				else
					(umod (- local2 1) 360)
				)
			)
			(headingGauge doit:)
		)
	)
)

(instance sparkle1 of CyclingProp
	(properties
		y 39
		x 137
		view 26
		loop 1
	)
)

(instance sparkle2 of CyclingProp
	(properties
		y 40
		x 155
		view 26
		loop 1
	)
)

(instance sparkle3 of CyclingProp
	(properties
		y 38
		x 179
		view 26
		loop 1
	)
)

(instance movement1 of CyclingProp
	(properties
		y 61
		x 146
		view 26
		loop 3
	)
)

(instance movement2 of CyclingProp
	(properties
		y 59
		x 172
		view 26
		loop 3
	)
)

(instance movement3 of CyclingProp
	(properties
		y 54
		x 164
		view 26
		loop 3
	)
)

