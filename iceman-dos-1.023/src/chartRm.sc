;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n802)
(use Submarine_806)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	chartRm 0
)

(local
	local0
	local1
	local2
	local3
	[local4 20]
	[local24 27]
	local51 = 5
	local52
	local53
	local54
	local55
	[local56 5]
	local61 = 160
	local62 = 89
	local63 = 160
	local64 = 89
	local65 = 285
	local66 = 77
	[local67 28] = [0 15 30 45 60 75 90 105 120 130 135 140 145 150 155 141 129 116 104 94 83 69 55 41 37 28 16 4]
	[local95 42] = [0 15 30 45 60 75 90 105 120 135 150 165 180 195 210 225 235 285 315 316 298 282 270 260 250 235 223 209 195 180 165 155 143 128 118 106 67 37 0 0 0 0]
	local137
	local138
	local139
	local140
	local141
	local142
	[local143 12] = [151 83 151 39 226 12 301 19 274 48 285 77]
	[local155 14]
	local169
	local170
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (< [local95 37] param1 [local95 (+ 19 temp1)])
		(= temp0 temp1)
		(++ temp1)
	)
	(if (== temp0 temp1)
		(return 777)
	)
	(= temp0
		(+
			[local95 temp0]
			(/
				(*
					(- param1 [local95 (+ temp0 19)])
					(- [local95 temp1] [local95 temp0])
				)
				(- [local95 (+ temp1 19)] [local95 (+ temp0 19)])
			)
		)
	)
	(if (< 195 temp0)
		(return (- temp0 375))
	else
		(return (- temp0 15))
	)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (< [local95 temp1] param1 [local95 18])
		(= temp0 temp1)
		(++ temp1)
	)
	(if (== temp0 temp1)
		(return 777)
	)
	(return
		(+
			[local95 (+ temp0 19)]
			(/
				(*
					(- param1 [local95 temp0])
					(- [local95 (+ temp1 19)] [local95 (+ temp0 19)])
				)
				(- [local95 temp1] [local95 temp0])
			)
		)
	)
)

(procedure (localproc_2 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (<= [local67 27] param1 [local67 (+ 14 temp1)])
		(= temp0 temp1)
		(++ temp1)
	)
	(if (== temp0 temp1)
		(return 777)
	)
	(return
		(-
			(= temp0
				(+
					[local67 temp0]
					(/
						(*
							(- param1 [local67 (+ temp0 14)])
							(- [local67 temp1] [local67 temp0])
						)
						(- [local67 (+ temp1 14)] [local67 (+ temp0 14)])
					)
				)
			)
			60
		)
	)
)

(procedure (localproc_3 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (< [local67 temp1] param1 [local67 13])
		(= temp0 temp1)
		(++ temp1)
	)
	(if (== temp0 temp1)
		(return 777)
	)
	(return
		(+
			[local67 (+ temp0 14)]
			(/
				(*
					(- param1 [local67 temp0])
					(- [local67 (+ temp1 14)] [local67 (+ temp0 14)])
				)
				(- [local67 temp1] [local67 temp0])
			)
		)
	)
)

(procedure (localproc_4) ; UNUSED
	(gCurRoom drawPic: 40)
	(Display 40 11 dsCOORD 100 160 dsCOLOR 10 dsFONT 104) ; "LATITUDE =   LONGITUDE ="
)

(procedure (localproc_5 &tmp temp0)
	(if (<= (markerList size:) 1)
		(return)
	)
	(if (IsObject (= temp0 (NodeValue (markerList first:))))
		(courseMarker posn: (temp0 x:) (temp0 y:))
		(if
			(IsObject
				(= temp0 (NodeValue (markerList next: (markerList first:))))
			)
			(courseMarker
				penColor: 7
				setMotion: MoveTo (temp0 x:) (temp0 y:) temp0
			)
		)
	)
)

(procedure (localproc_6 &tmp temp0)
	(for ((= temp0 0)) (< temp0 7) ((++ temp0))
		(if (> (markerList size:) temp0)
			(Format ; "%3d %3d"
				@local4
				40
				12
				(Abs (localproc_2 ((markerList at: temp0) y:)))
				(Abs (localproc_0 ((markerList at: temp0) x:)))
			)
		else
			(Format @local4 40 12 0 0) ; "%3d %3d"
		)
		(Display @local4 dsCOORD 0 local51 dsBACKGROUND 0 dsCOLOR 15 dsFONT 30)
		(+= local51 15)
	)
	(= local51 11)
)

(procedure (localproc_7 param1 &tmp temp0 temp1)
	(if
		(and
			(= temp0 (markerList first:))
			(IsObject (= temp1 (NodeValue temp0)))
		)
		(Submarine param1: (temp1 x:))
	)
)

(procedure (localproc_8 param1 &tmp temp0 temp1)
	(if
		(and
			(= temp0 (markerList first:))
			(IsObject (= temp1 (NodeValue temp0)))
		)
		(Submarine param1: (temp1 y:))
		(markerList delete: temp1)
	)
)

(procedure (localproc_9 param1 param2 param3)
	(OnControl
		CONTROL
		(- param1 param3)
		(- param2 param3)
		(+ param1 param3)
		(+ param2 param3)
	)
)

(procedure (localproc_10 &tmp temp0 temp1)
	(localproc_15)
	(= local169 0)
	(for ((= temp0 0)) (and (< temp0 14) (!= [local155 temp0] 0)) ((++ temp0))
		(if
			(<
				local169
				(= temp1 (localproc_11 [local155 temp0] [local155 (++ temp0)]))
			)
			(= local169 temp1)
		)
	)
	(Printf 40 22 (* 50 local169)) ; "Your course has a maximum deviation of %d nautical miles from an optimal course."
	(if (< 12 local169)
		(return 0)
	else
		(return 1)
	)
)

(procedure (localproc_11 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 90)
	(= temp0 0)
	(while (< temp0 10)
		(if
			(<
				(= temp2
					(localproc_12
						[local143 temp0]
						[local143 (++ temp0)]
						[local143 (++ temp0)]
						[local143 (+ temp0 1)]
						param1
						param2
					)
				)
				temp1
			)
			(= temp1 temp2)
		)
	)
	(return temp1)
)

(procedure (localproc_12 param1 param2 param3 param4 param5 param6)
	(if
		(and
			(<=
				0
				(localproc_13
					(- param3 param1)
					(- param4 param2)
					(- param5 param1)
					(- param6 param2)
				)
			)
			(<=
				0
				(localproc_13
					(- param1 param3)
					(- param2 param4)
					(- param5 param3)
					(- param6 param4)
				)
			)
		)
		(return
			(/
				(Abs
					(localproc_13
						(- param4 param2)
						(- param1 param3)
						(- param5 param1)
						(- param6 param2)
					)
				)
				(localproc_14 param1 param2 param3 param4)
			)
		)
	else
		(return
			(Min
				(localproc_14 param5 param6 param1 param2)
				(localproc_14 param5 param6 param3 param4)
			)
		)
	)
)

(procedure (localproc_13 param1 param2 param3 param4)
	(return (+ (* param1 param3) (* param2 param4)))
)

(procedure (localproc_14 param1 param2 param3 param4 &tmp temp0 temp1)
	(return
		(if
			(or
				(< 90 (= temp0 (Abs (- param3 param1))))
				(< 90 (= temp1 (Abs (- param4 param2))))
			)
			90
		else
			(Sqrt (+ (*= temp0 temp0) (*= temp1 temp1)))
		)
	)
)

(procedure (localproc_15 &tmp temp0 temp1 temp2)
	(= temp0 0)
	(if (IsObject (= temp2 (NodeValue (= temp1 (markerList first:)))))
		(while (< temp0 14)
			(= [local155 temp0] (temp2 x:))
			(++ temp0)
			(if (< 90 (= [local155 temp0] (temp2 y:)))
				(= local170 1)
			)
			(if
				(IsObject
					(= temp2 (NodeValue (= temp1 (markerList next: temp1))))
				)
				(++ temp0)
			else
				(= temp0 14)
			)
		)
	)
)

(instance chartRm of Rm
	(properties
		picture 40
		north 25
	)

	(method (init &tmp temp0)
		(= global54 0)
		(= local0 (gEgo x:))
		(= local1 (gEgo y:))
		(= local2 (gEgo view:))
		(= local3 (gEgo loop:))
		(super init:)
		(self setFeatures: mapArea setRegions: 314 setScript: delayedInit) ; subMarine
		(locationMarker init:)
		(courseMarker init: penDown: 1)
		(User canControl: 0)
		(gIceKeyDownHandler addToFront: self)
		(gIceDirectionHandler addToFront: self)
		(= local63 (localproc_1 185))
		(= local64 (localproc_3 90))
		(= local61 (localproc_1 (+ (Submarine longitude:) 15)))
		(= local62 (localproc_3 (+ (Submarine latitude:) 60)))
		(gEgo
			view: 40
			setLoop: 4
			cel: 0
			xStep: 1
			yStep: 1
			posn: local63 local64
			ignoreActors: 1
			init:
			setScript: stealMouse
		)
		(subMarker x: local61 y: local62 init: setCycle: Fwd)
		(destMarker x: local65 y: local66 init: setCycle: Fwd)
		(markerList
			addToEnd:
				((locationMarker new:)
					view: 40
					loop: 1
					x: local63
					y: local64
					init:
					setCycle: Fwd
					yourself:
				)
		)
		(self replay:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<!*][/map,table,chart]')
				(Print 40 0) ; "This is the electronic map table."
				(Print 40 1) ; "You must plot an acceptable course before embarking on your mission. The command "Plot Course" will allow you to plot or replot a course to your destination (just off the coast of Portugal). Once plotting a course, you may change the last waypoint with the command "Change Point"."
				(Print 40 2) ; "A course is a series of waypoints by which the sub can travel in straight lines to arrive at the set destination.  The number of waypoints is limited to five. To set a waypoint, use the direction arrows to set the desired longitude and latitude, then press the ENTER key. When your course is complete except for the last leg to your destination, use the ENTER key twice."
				(Print 40 3) ; "Shift along with a direction key will alter the rate of change of the latitude and longitude."
				(Print 40 4) ; "The course will then be reviewed by the on-board navigation computer and either rejected or accepted.  Use the map enclosed with your game to aid you in establishing the proper longitude and latitude for each waypoint. Good luck on your mission."
			)
			((Said 'exit,exit,stop,stand')
				(if
					(or
						local142
						(!= local61 (localproc_1 185))
						(!= local62 (localproc_3 90))
					)
					(localproc_7 374)
					(localproc_8 375)
					(localproc_7 374)
					(localproc_8 375)
					(localproc_7 376)
					(localproc_8 377)
					(localproc_7 378)
					(localproc_8 379)
					(localproc_7 380)
					(localproc_8 381)
					(localproc_7 382)
					(localproc_8 383)
					(self newRoom: 25) ; controlRm
				else
					(Print 40 5) ; "You must plot a course which will take you to your destination!"
					(Print 40 6) ; "Consult the map enclosed with your game to get proper coordinates."
				)
			)
		)
	)

	(method (dispose)
		(gIceDirectionHandler delete: self)
		(gIceKeyDownHandler delete: self)
		(= global54 1)
		(gGame setCursor: gNormalCursor 1)
		(markerList release: dispose:)
		(gEgo
			view: local2
			loop: local3
			x: local0
			y: local1
			xStep: 3
			yStep: 2
		)
		(super dispose:)
	)

	(method (replay &tmp temp0)
		(= local55 local54)
		(= local54 0)
		(= local51 5)
		(for ((= temp0 0)) (<= temp0 6) ((++ temp0))
			(Format @local4 40 7 temp0) ; "WP %d"
			(Display @local4 dsCOORD 0 local51 dsCOLOR 10 dsFONT 30)
			(+= local51 15)
		)
		(= local51 11)
		(Display 40 8 dsCOORD 100 172 dsCOLOR 10 dsFONT 104) ; "LATITUDE =     LONGITUDE ="
		(if (Submarine wayPoint1X:)
			(= local142 1)
			(markerList
				addToEnd:
					((locationMarker new:)
						x: (Submarine wayPoint1X:)
						y: (Submarine wayPoint1Y:)
						init:
						setCycle: Fwd
						yourself:
					)
			)
			(Submarine wayPoint1X: 0)
		)
		(if (Submarine wayPoint2X:)
			(markerList
				addToEnd:
					((locationMarker new:)
						x: (Submarine wayPoint2X:)
						y: (Submarine wayPoint2Y:)
						init:
						setCycle: Fwd
						yourself:
					)
			)
			(Submarine wayPoint2X: 0)
		)
		(if (Submarine wayPoint3X:)
			(markerList
				addToEnd:
					((locationMarker new:)
						x: (Submarine wayPoint3X:)
						y: (Submarine wayPoint3Y:)
						init:
						setCycle: Fwd
						yourself:
					)
			)
			(Submarine wayPoint3X: 0)
		)
		(if (Submarine wayPoint4X:)
			(markerList
				addToEnd:
					((locationMarker new:)
						x: (Submarine wayPoint4X:)
						y: (Submarine wayPoint4Y:)
						init:
						setCycle: Fwd
						yourself:
					)
			)
			(Submarine wayPoint4X: 0)
		)
		(if (Submarine wayPoint5X:)
			(markerList
				addToEnd:
					((locationMarker new:)
						x: (Submarine wayPoint5X:)
						y: (Submarine wayPoint5Y:)
						init:
						setCycle: Fwd
						yourself:
					)
			)
			(Submarine wayPoint5X: 0)
		)
		(if (Submarine wayPoint1X:)
			(markerList
				addToEnd:
					((locationMarker new:)
						view: 40
						loop: 2
						x: local65
						y: local66
						init:
						setCycle: Fwd
						yourself:
					)
			)
		)
		(if local142
			(localproc_10)
		)
		(localproc_6)
		(localproc_5)
		(= local53 (= local52 0))
	)
)

(instance delayedInit of Script
	(properties
		cycles 5
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gGame setCursor: 40 0 330 200)
				(if (== ((subMarine script:) state:) 3)
					(subMarine cue: 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance mapArea of RFeature
	(properties
		y 80
		x 139
		nsTop 4
		nsLeft 37
		nsBottom 165
		nsRight 316
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'draw,draw,adjust,draw,chart,enter/course,coordinate')
					(and
						(not local54)
						(Said 'alter,change/course,coordinate,coordinate')
					)
				)
				(if
					(and
						(== local61 (localproc_1 185))
						(== local62 (localproc_3 90))
					)
					(if (== (chartRm script:) startPlot)
						(Print 40 9) ; "You are plotting a course!"
					else
						(if local142
							(gGame
								changeScore:
									(cond
										((< local169 2) -10)
										((< local169 3) -5)
										((< local169 5) -4)
										((< local169 8) -3)
										((< local169 11) -2)
										(else -1)
									)
							)
						)
						(= local142 0)
						(chartRm setScript: startPlot)
					)
				else
					(Print 40 10) ; "You cannot replot or change course once underway."
				)
			)
		)
	)
)

(instance markerList of List
	(properties)
)

(instance locationMarker of Prop
	(properties
		view 40
		loop 1
	)

	(method (cue &tmp temp0)
		(cond
			(
				(IsObject
					(= temp0 (markerList at: (+ (markerList indexOf: self) 1)))
				)
				(if (> (courseMarker distanceTo: temp0) 1)
					(courseMarker setMotion: MoveTo (temp0 x:) (temp0 y:) temp0)
				)
			)
			(local55
				(= local54 local55)
				(= local55 0)
			)
		)
	)
)

(instance subMarker of Prop
	(properties
		view 40
		loop 3
	)
)

(instance destMarker of Prop
	(properties
		view 40
		loop 2
	)
)

(class Turtle of Act
	(properties
		penColor 0
		penDown 0
	)

	(method (doit)
		(super doit:)
		(if penDown
			(DrawCel 40 1 (and (!= penColor 7) 2) x y 1)
		)
	)
)

(instance courseMarker of Turtle
	(properties
		view 40
		loop 1
		penColor 7
	)

	(method (doit)
		(if (and (& (proc802_0 self 3) $2000) (!= penColor 0))
			(= local141 1)
		)
		(super doit: &rest)
	)

	(method (init)
		(super init: &rest)
		(self setLoop: ignoreActors: 1 ignoreControl: -32768)
	)
)

(instance drawLastLine of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local139 (NodeValue (markerList last:)))
				(= temp0 (NodeValue (markerList prev: (markerList last:))))
				(courseMarker posn: (temp0 x:) (temp0 y:))
				(courseMarker
					penColor: 7
					setMotion: MoveTo (local139 x:) (local139 y:) self
				)
			)
			(1
				(localproc_6)
				(self dispose:)
			)
		)
	)
)

(instance backOneScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (<= (markerList size:) 1)
					(self dispose:)
				else
					(self setScript: unDrawLast self)
				)
			)
			(1
				(self setScript: unDrawLast self)
			)
			(2
				(PlotCourse start: 1)
				(chartRm setScript: PlotCourse)
				(self dispose:)
			)
		)
	)
)

(instance unDrawLast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(IsObject
						(= local140 (markerList at: (- (markerList size:) 2)))
					)
					(= local139 (NodeValue (markerList last:)))
					(courseMarker
						posn: (local140 x:) (local140 y:)
						penColor: 0
						setMotion: MoveTo (local139 x:) (local139 y:) self
					)
				else
					(self dispose:)
				)
			)
			(1
				(gEgo posn: (local140 x:) (local140 y:))
				(markerList delete: local139)
				(local139 dispose:)
				(localproc_6)
				(self dispose:)
			)
		)
	)
)

(instance startPlot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 6)
				(= start 1)
				(self cue:)
			)
			(1
				(if register
					(-- register)
					(= cycles 2)
				else
					(= start 0)
					(PlotCourse start: 1)
					(client setScript: PlotCourse)
				)
			)
			(2
				(self setScript: unDrawLast self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance PlotCourse of Script
	(properties)

	(method (handleEvent event)
		(if (& (event modifiers:) emSHIFT)
			(if (== (gEgo xStep:) 1)
				(gEgo xStep: 4)
				(gEgo yStep: 4)
			else
				(gEgo xStep: 1)
				(gEgo yStep: 1)
			)
		)
		(cond
			((super handleEvent: event))
			((and local54 (Said 'alter,change/course,coordinate,coordinate'))
				(self start: 0 init:)
				(self setScript: unDrawLast self)
			)
			((and local54 (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				(event claimed: 1)
				(User canControl: 0)
				(self cue:)
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(if
			(and
				local54
				(or (!= (gEgo x:) local52) (!= (gEgo y:) local53))
			)
			(= local52 (gEgo x:))
			(= local53 (gEgo y:))
			(if local24
				(Display @local24 dsCOORD 100 172 dsCOLOR 0 dsFONT 104)
			)
			(Display
				(Format ; "%3d %s          %3d %s"
					@local24
					40
					13
					(Abs (= temp1 (localproc_2 (gEgo y:))))
					(if (< 0 temp1) {N} else {S})
					(Abs (= temp0 (localproc_0 (gEgo x:))))
					(if (< 0 temp0) {W} else {E})
				)
				dsCOORD
				100
				172
				dsCOLOR
				10
				dsFONT
				104
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= local54 1)
				(User canControl: 1)
			)
			(2
				(= local54 0)
				(User canControl: 0)
				(cond
					((and (== local137 (gEgo x:)) (== local138 (gEgo y:)))
						(self changeState: 6)
					)
					(
						(or
							(& (OnControl CONTROL (gEgo x:) (gEgo y:)) $2000)
							(& (localproc_9 (gEgo x:) (gEgo y:) 1) $2000)
						)
						(Print 40 14) ; "Invalid location."
						(self start: 1 init:)
					)
					(else
						(= local137 (gEgo x:))
						(= local138 (gEgo y:))
						(markerList
							addToEnd:
								((locationMarker new:)
									x: local137
									y: local138
									init:
									setCycle: Fwd
									yourself:
								)
						)
						(= cycles 2)
					)
				)
			)
			(3
				(self setScript: drawLastLine self)
			)
			(4
				(if (== local141 1)
					(= local141 0)
					(Print 40 15) ; "Illegal course."
					(self setScript: unDrawLast self)
				else
					(= cycles 2)
				)
			)
			(5
				(if (>= (markerList size:) 6)
					(Print 40 16) ; "You have input the maximum number of waypoints."
					(= cycles 2)
				else
					(self changeState: 1)
				)
			)
			(6
				(markerList
					addToEnd:
						((locationMarker new:)
							x: local65
							y: local66
							init:
							setCycle: Fwd
							yourself:
						)
				)
				(self setScript: drawLastLine self)
			)
			(7
				(cond
					((== local141 1)
						(Print 40 15) ; "Illegal course."
						(self setScript: unDrawLast self)
					)
					((localproc_10)
						(Print 40 17) ; "Your course has been accepted by the on-board navigation computer."
						(gGame
							changeScore:
								(cond
									((< local169 2) 10)
									((< local169 3) 5)
									((< local169 5) 4)
									((< local169 8) 3)
									((< local169 11) 2)
									(else 1)
								)
						)
						(= cycles 2)
					)
					(else
						(if local170
							(= local170 0)
							(Print 40 18) ; "You are to use the polar route."
						else
							(Print 40 19) ; "Your course must be time efficient."
							(Print 40 20) ; "This course has been rejected by the on board navigation computer."
						)
						(Print 40 21) ; "If you want your dolphins, replot a better course."
						(self dispose:)
					)
				)
			)
			(8
				(if (== local141 1)
					(= local141 0)
					(= cycles 2)
				else
					(= local142 1)
					(self dispose:)
				)
			)
			(9
				(self setScript: unDrawLast self)
			)
			(10
				(self start: 1 init:)
			)
		)
	)
)

(instance stealMouse of Script
	(properties)

	(method (handleEvent event)
		(if (== (event type:) evMOUSEBUTTON)
			(event claimed: 1)
		)
	)
)

