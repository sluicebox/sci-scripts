;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use CyclingProp)
(use n957)
(use LoadMany)
(use QSnd)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	introRm 0
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
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
)

(procedure (localproc_0 param1 param2 param3 param4 param5)
	(views
		add:
			((View new:)
				view: param1
				loop: param2
				cel: param3
				x: param4
				y: param5
				init:
				setPri: 12
				yourself:
			)
	)
)

(instance introRm of Rm
	(properties
		picture 299
	)

	(method (init)
		(super init:)
		(gIceMouseDownHandler add: self)
		(gIceKeyDownHandler add: self)
		(LoadMany rsVIEW 56 60 400 500 600 700 800 899)
		(Load rsPIC 100)
		(HandsOff)
		((= local0 (CyclingProp new:))
			view: 899
			loop: 0
			x: 220
			y: 19
			cycleSpeed: 1
			init:
		)
		((= local2 (CyclingProp new:))
			view: 899
			loop: 2
			x: 285
			y: 11
			cycleSpeed: 1
			init:
		)
		((= local1 (CyclingProp new:))
			view: 899
			loop: 1
			x: 184
			y: 62
			cycleSpeed: 1
			init:
		)
		((= local3 (CyclingProp new:))
			view: 899
			loop: 3
			x: 118
			y: 82
			cycleSpeed: 1
			init:
		)
		((= local4 (CyclingProp new:))
			view: 899
			loop: 4
			x: 148
			y: 44
			cycleSpeed: 1
			init:
		)
		((= local5 (CyclingProp new:))
			view: 56
			loop: 6
			x: 140
			y: 182
			cycleSpeed: 1
			init:
		)
		((= local6 (CyclingProp new:))
			view: 56
			loop: 6
			x: 47
			y: 152
			cycleSpeed: 1
			init:
		)
		((= local7 (CyclingProp new:))
			view: 56
			loop: 8
			x: 129
			y: 184
			cycleSpeed: 1
			init:
		)
		(if (!= global132 2)
			(local0 addToPic:)
			(local2 addToPic:)
			(local1 addToPic:)
			(local3 addToPic:)
			(local4 addToPic:)
			(local5 addToPic:)
			(local6 addToPic:)
			(local7 addToPic:)
		)
		(self setScript: introScript)
	)

	(method (dispose)
		(views dispose:)
		(gIceMouseDownHandler delete: self)
		(gIceKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (cue)
		(if script
			((LastLink 118 self) cue:)
		)
	)

	(method (handleEvent)
		(global102 dispose:)
		(self newRoom: 1) ; openingScene
	)
)

(instance introScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(subBubbles init: 126 87)
				((= global102 (QSnd new:))
					number:
						(switch global139
							(1 401)
							(3 201)
							(else 1)
						)
					init:
					owner: gGame
					play: client
				)
				(= seconds 2)
			)
			(1
				(gGame setCursor: gTheCursor 0)
				((= local8 (Act new:))
					view: 600
					loop: 0
					setLoop:
					cel: 0
					x: 181
					y: 210
					setPri: 9
					ignoreActors: 1
					ignoreControl: -32768
					init:
				)
				(if (!= global132 2)
					(local8 posn: 181 129)
				else
					(local8 setMotion: MoveTo 181 129)
				)
				(= seconds 7)
			)
			(2
				((= local11 (Prop new:))
					view: 600
					loop: 2
					x: 123
					y: 130
					init:
					setPri: 12
					stopUpd:
				)
				((= local12 (Prop new:))
					view: 600
					loop: 3
					x: 141
					y: 145
					setPri: 12
					init:
					stopUpd:
				)
				((= local13 (Prop new:))
					view: 600
					loop: 4
					x: 157
					y: 145
					setPri: 12
					init:
					stopUpd:
				)
				((= local14 (Prop new:))
					view: 600
					loop: 5
					x: 180
					y: 145
					setPri: 12
					init:
					stopUpd:
				)
				((= local15 (Prop new:))
					view: 600
					loop: 5
					x: 207
					y: 145
					setPri: 12
					init:
					stopUpd:
				)
				((= local16 (Prop new:))
					view: 600
					loop: 6
					x: 236
					y: 145
					setPri: 12
					init:
					stopUpd:
				)
				(local8 dispose:)
				((= local9 (Act new:))
					view: 600
					setLoop: 1
					cel: 0
					posn: 212 210
					setPri: 12
					ignoreActors: 1
					ignoreControl: -32768
					init:
				)
				(if (!= global132 2)
					(local9 posn: 212 160)
				else
					(local9 setMotion: MoveTo 212 160)
				)
				(= seconds 2)
			)
			(3)
			(4
				(if (== global132 2)
					((= local10 (Act new:))
						view: 800
						loop: 0
						cel: 0
						x: 50
						y: 147
						xStep: 25
						init:
						setScript: missleScript
						setPri: 12
					)
					(= seconds 1)
				else
					(= cycles 1)
				)
			)
			(5
				(if (== global132 0)
					(local11 dispose:)
					(local12 dispose:)
					(local13 dispose:)
					(local14 dispose:)
					(local15 dispose:)
					(local16 dispose:)
					(local9 dispose:)
					(self changeState: 10)
				else
					(local11 setCycle: End)
					(= cycles (if (!= global132 2) 1 else 3))
				)
			)
			(6
				(local12 setCycle: End)
				(= cycles (if (!= global132 2) 1 else 3))
			)
			(7
				(if (== global132 2)
					(local10 xStep: 20)
				)
				(local13 setCycle: End)
				(= cycles (if (!= global132 2) 1 else 3))
			)
			(8
				(if (== global132 2)
					(local10 xStep: 18)
				)
				(local14 setCycle: End)
				(local9 setCycle: End)
				(= cycles (if (!= global132 2) 1 else 3))
			)
			(9
				(if (== global132 2)
					(local10 xStep: 16)
				)
				(local15 setCycle: End)
				(= cycles (if (!= global132 2) 1 else 3))
			)
			(10
				(switch global132
					(2
						(local10 xStep: 2)
						(local16 setCycle: End)
					)
					(1
						(local16 setCycle: End)
					)
					(0
						; COMPILER BUG: GAME WILL CRASH
					)
				)
			)
			(11
				(localproc_0 700 3 0 114 130)
			)
			(12
				(localproc_0 700 3 1 126 130)
			)
			(13
				(localproc_0 700 3 2 137 130)
			)
			(14
				(localproc_0 700 3 3 148 130)
			)
			(15
				(localproc_0 700 3 4 164 130)
			)
			(16
				(localproc_0 700 3 5 177 130)
			)
			(17
				(localproc_0 700 3 6 191 130)
			)
			(18
				(localproc_0 700 3 3 204 130)
			)
			(19
				(localproc_0 400 4 7 214 130)
			)
			(20
				(ice init:)
				(man init:)
			)
			(21
				(gCast eachElementDo: #dispose)
				(views release:)
				(gCurRoom drawPic: 100)
				(gCurRoom newRoom: 102) ; intro2Rm
			)
		)
	)
)

(instance ice of Act
	(properties
		y 225
		x 140
		view 700
		loop 2
	)

	(method (init)
		(super init:)
		(self setLoop: loop setPri: 11)
		(if (!= global132 2)
			(self posn: 140 172 cue:)
		else
			(self setMotion: MoveTo 140 172 self)
		)
	)

	(method (cue)
		(self stopUpd:)
		(bubbles init:)
		(ray init:)
		(subBubbles init: 166 66)
	)
)

(instance man of Act
	(properties
		y 224
		x 226
		view 700
		loop 2
		cel 1
	)

	(method (init)
		(super init:)
		(self setLoop: loop setPri: 11)
		(if (!= global132 2)
			(self posn: 226 171 cue:)
		else
			(self setMotion: MoveTo 226 171 self)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance ray of Act
	(properties
		y 179
		x 139
		view 60
		loop 2
		xStep 5
	)

	(method (init)
		(super init:)
		(self
			setPri: 12
			setLoop: loop
			setCycle: Walk
			ignoreActors: 1
			ignoreControl: -32768
			setScript: rayScript
		)
	)
)

(instance rayScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: MoveTo 87 158 self)
			)
			(1
				(client setLoop: 4 setCel: 0 setPri: 10 setCycle: End self)
			)
			(2
				(client
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 340 143 self
				)
			)
			(3
				(client hide: setScript: 0)
			)
		)
	)
)

(instance missleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setPri: 14
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 400 (client y:)
					setCycle: End self
				)
			)
			(1
				(client setLoop: 1 setCycle: End self)
			)
			(2
				((= register (Prop new:))
					view: 800
					loop: 2
					x: 152
					y: 152
					init:
					setCycle: End self
				)
				(client hide:)
			)
			(3
				(register dispose:)
			)
		)
	)
)

(instance bubbles of Act
	(properties
		y 179
		x 139
		view 899
	)

	(method (init)
		(super init:)
		(self
			setLoop: 5
			ignoreActors: 1
			setPri: 12
			setCycle: Walk
			ignoreControl: -32768
			setMotion: MoveTo 139 -10 self
		)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance subBubbles of Act
	(properties
		view 899
	)

	(method (init param1 param2)
		(super init:)
		(self
			posn: param1 param2
			setLoop: 6
			setPri: 3
			ignoreActors: 1
			setCycle: Walk
			ignoreControl: -32768
			setMotion: MoveTo param1 -10 self
		)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance views of Collect
	(properties)
)

