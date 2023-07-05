;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 226)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm226 0
)

(local
	local0
)

(procedure (localproc_0)
	(return
		(cond
			((InRect 0 163 110 200 local0) box1)
			((InRect 111 163 216 200 local0) box2)
			((InRect 217 163 319 200 local0) box3)
			(else 0)
		)
	)
)

(procedure (localproc_1 &tmp [temp0 50])
	(Message msgGET 226 7 4 0 1 @temp0) ; "EXIT"
	(Display @temp0 dsCOORD 25 173 dsFONT 1605 dsWIDTH 60 dsALIGN alCENTER dsCOLOR global152)
	(Message msgGET 226 17 4 0 1 @temp0) ; "PUT IN INVENTORY"
	(Display @temp0 dsCOORD 133 169 dsFONT 1605 dsWIDTH 60 dsALIGN alCENTER dsCOLOR global152)
	(Message msgGET 226 3 4 0 1 @temp0) ; "CLEAN UP TOOLBOX"
	(Display @temp0 dsCOORD 240 169 dsFONT 1605 dsWIDTH 60 dsALIGN alCENTER dsCOLOR global152)
)

(instance rm226 of Rm
	(properties
		noun 2
		picture 50
	)

	(method (doit)
		(if (GameIsRestarting)
			(localproc_1)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(if local0
					(if (= temp0 (localproc_0))
						(temp0 doVerb: 4)
					else
						(local0 drop:)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(gCurRoom setRegions: 210) ; eureka
		(= local0 0)
		(vac init:)
		(fuse init:)
		(welder init:)
		(dropper init:)
		(gizmo1 init:)
		(drill1 init:)
		(wrench1 init:)
		(fuse2 init:)
		(cutter init:)
		(drill2 init:)
		(screwdriver init:)
		(antacids init:)
		(gizmo2 init:)
		(gizmo3 init:)
		(soldergun init:)
		(pliers init:)
		(hammer init:)
		(gizmo4 init:)
		(gizmo5 init:)
		(holePunch init:)
		(super init: &rest)
		(box1 addToPic:)
		(box2 addToPic:)
		(box3 addToPic:)
		(localproc_1)
		(gGame handsOn:)
		(gTheIconBar disable: 0 3 4 5 6)
	)
)

(class Tool of Actor
	(properties
		yStep 15
		view 234
		signal 22528
		xStep 15
		moveSpeed 0
		track 0
		origX 0
		origY 0
		invItem -1
	)

	(method (init)
		(if (or (== invItem -1) (not (gEgo has: invItem)))
			(super init: &rest)
			(self setCycle: 0)
			(= origX x)
			(= origY y)
			(self stopUpd:)
		)
	)

	(method (drop)
		(= track 0)
		(self stopUpd:)
		(= local0 0)
		(self setPri: -1)
		((gTheIconBar at: 2) cursor: 982)
		(gTheIconBar enable: 1 7 8)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)

	(method (pickUp)
		(= track 1)
		(self startUpd:)
		(= local0 self)
		(self setPri: 15)
		((gTheIconBar at: 2) cursor: 996)
		(gTheIconBar curIcon: (gTheIconBar at: 2))
		(gTheIconBar disable: 1 7 8)
		(gGame setCursor: 996)
	)

	(method (cue)
		(self track: 0 stopUpd:)
		(= local0 0)
	)

	(method (doit)
		(super doit: &rest)
		(if track
			(if (< 30 gMouseX 290)
				(self x: gMouseX)
			)
			(if (< 15 gMouseY 180)
				(self y: gMouseY)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(if local0
					(if (= temp0 (localproc_0))
						(temp0 doVerb: 4)
					else
						(local0 drop:)
					)
				else
					(self pickUp:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance putToolBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client gCurRoom)
					(gGame handsOn:)
					(gGame handsOff:)
					(gMessager say: 22 0 1 0 self) ; "You don't need this tool."
				else
					(= cycles 1)
				)
			)
			(1
				(local0
					track: 0
					setMotion: MoveTo (local0 origX:) (local0 origY:) self
				)
			)
			(2
				(local0 cue:)
				(if (== client gCurRoom)
					(gGame handsOn:)
					((gTheIconBar at: 2) cursor: 982)
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
					(gTheIconBar disable: 0 3 4 5 6)
				)
				(self dispose:)
			)
		)
	)
)

(instance putAllBack of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gGame handsOff:)
				(gMessager say: 22 0 2 0 self) ; "In order not to irk Cliffy, you put back the tools where you found them."
				(= register (- (gCast size:) 1))
			)
			(1
				(= local0 (gCast at: register))
				(if
					(or
						(!= (local0 origX:) (local0 x:))
						(!= (local0 origY:) (local0 y:))
					)
					(self setScript: putToolBack self)
				else
					(= cycles 1)
				)
			)
			(2
				(if register
					(-- register)
					(-= state 2)
				)
				(= cycles 1)
			)
			(3
				(= local0 0)
				(gGame handsOn:)
				((gTheIconBar at: 2) cursor: 982)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(gTheIconBar disable: 0 3 4 5 6)
				(self dispose:)
			)
		)
	)
)

(instance takeTool of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 22 0 3 0 self) ; "Thinking this might be a handy item, you take it with you."
			)
			(1
				(gEgo get: (local0 invItem:))
				(local0 startUpd: hide: track: 0)
				(= cycles 4)
			)
			(2
				(local0 drop: dispose:)
				(= local0 0)
				(gGame handsOn:)
				((gTheIconBar at: 2) cursor: 982)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(gTheIconBar disable: 0 3 4 5 6)
				(self dispose:)
			)
		)
	)
)

(instance vac of Tool
	(properties
		x 154
		y 66
		noun 24
	)
)

(instance gizmo2 of Tool
	(properties
		x 162
		y 98
		noun 9
		cel 1
	)
)

(instance welder of Tool
	(properties
		x 126
		y 105
		noun 23
		loop 1
		invItem 7
	)
)

(instance dropper of Tool
	(properties
		x 112
		y 109
		noun 6
		loop 1
		cel 1
	)
)

(instance gizmo1 of Tool
	(properties
		x 189
		y 88
		noun 10
		loop 2
	)
)

(instance drill1 of Tool
	(properties
		x 154
		y 90
		noun 4
		loop 2
		cel 1
	)
)

(instance wrench1 of Tool
	(properties
		x 114
		y 75
		noun 25
		loop 3
	)
)

(instance fuse2 of Tool
	(properties
		x 160
		y 100
		noun 11
		loop 3
		cel 1
	)
)

(instance cutter of Tool
	(properties
		x 119
		y 81
		noun 18
		loop 4
	)
)

(instance drill2 of Tool
	(properties
		x 174
		y 102
		noun 5
		loop 4
		cel 1
	)
)

(instance screwdriver of Tool
	(properties
		x 182
		y 82
		noun 20
		loop 5
	)
)

(instance gizmo5 of Tool
	(properties
		x 103
		y 79
		noun 13
		loop 5
		cel 1
	)
)

(instance fuse of Tool
	(properties
		x 97
		y 92
		noun 8
		loop 11
		invItem 4
	)
)

(instance gizmo3 of Tool
	(properties
		x 164
		y 96
		noun 12
		loop 6
		cel 1
	)
)

(instance soldergun of Tool
	(properties
		x 203
		y 101
		noun 14
		loop 7
	)
)

(instance pliers of Tool
	(properties
		x 195
		y 61
		noun 19
		loop 7
		cel 1
	)
)

(instance hammer of Tool
	(properties
		x 188
		y 88
		noun 15
		loop 8
	)
)

(instance gizmo4 of Tool
	(properties
		x 136
		y 79
		noun 21
		loop 8
		cel 1
	)
)

(instance holePunch of Tool
	(properties
		x 103
		y 79
		noun 16
		loop 9
		invItem 11
	)
)

(instance antacids of Tool
	(properties
		x 187
		y 53
		noun 1
		loop 9
		cel 1
		invItem 5
	)

	(method (init)
		(if (not (IsFlag 170))
			(super init: &rest)
		)
	)
)

(instance box1 of View
	(properties
		x 17
		y 163
		noun 7
		view 234
		loop 10
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOn:)
				((gTheIconBar at: 2) cursor: 982)
				(gGame handsOff:)
				(gCurRoom newRoom: 225)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance box2 of View
	(properties
		x 123
		y 163
		noun 17
		view 234
		loop 10
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local0
					(if (!= (local0 invItem:) -1)
						(switch (local0 invItem:)
							(5
								(SetScore 170 15)
							)
							(7
								(SetScore 173 5)
							)
							(11
								(SetScore 172 5)
							)
							(4
								(SetScore 251 5)
							)
						)
						(gCurRoom setScript: takeTool)
					else
						(gCurRoom setScript: putToolBack)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance box3 of View
	(properties
		x 229
		y 163
		noun 3
		view 234
		loop 10
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: putAllBack)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

