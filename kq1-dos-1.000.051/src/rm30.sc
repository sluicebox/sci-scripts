;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use StopWalk)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm30 0
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
	[local11 35]
)

(instance rm30 of Rm
	(properties
		picture 30
		horizon 80
		north 35
		east 31
		south 19
		west 29
	)

	(method (init &tmp temp0 temp1)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 2)
					(south 4)
				)
		)
		(if (>= global101 1)
			(Load rsVIEW 205)
		)
		(Load rsVIEW 230)
		(if (not (gEgo has: 18)) ; Walnut
			(Load rsVIEW 1)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo
					posn:
						(proc0_17 319 (proc0_18 272 (gEgo x:) 248) 41)
						(+ horizon 2)
				)
			)
			(south
				(gEgo y: 188)
			)
			(west
				(gEgo
					posn:
						3
						(proc0_17
							188
							(proc0_18 130 (gEgo y:) 125)
							(+ horizon 2)
						)
				)
			)
			(east
				(gEgo
					posn:
						317
						(proc0_17
							178
							(proc0_18 141 (gEgo y:) 113)
							(+ horizon 2)
						)
				)
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(proc0_1)
		(tree init:)
		(tree1 init:)
		(tree2 init:)
		(pineTree1 init:)
		(trunk init:)
		(smallBush init:)
		(farTree init:)
		(pineTree2 init:)
		(if (>= global101 1)
			(squirrel
				setStep: 5 5
				setCycle: Walk
				setAvoider: Avoid
				ignoreActors:
				illegalBits: 0
				ignoreHorizon:
				init:
				stopUpd:
			)
		)
		(= local0 (* (+ 1 global101) 8))
		(for ((= local6 0)) (< local6 local0) ((++ local6))
			(= [local11 local6] (Clone nutView))
			(while (< 36 (= temp0 (Random 10 190)) 130)
			)
			(while (< 164 (= temp1 (Random 145 185)) 172)
			)
			([local11 local6] posn: temp0 temp1 init: ignoreActors: stopUpd:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(self newRoom: temp0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look>')
				(cond
					((or (Said '<around,down') (Said '/grass'))
						(if (< local10 local0)
							(if (gEgo inRect: 10 145 190 185)
								(Print 30 0) ; "These are some of the largest, plumpest walnuts you have ever seen."
							else
								(Print 30 1) ; "There are some walnuts nearby, under the walnut tree."
							)
						else
							(Print 30 2) ; "There are no more walnuts to be seen!"
						)
					)
					((Said '[<at,around][/room,clearing,ceder]')
						(Print 30 3) ; "There is a large walnut tree surrounded by several pine trees."
					)
					((Said '/ceder<pine')
						(Print 30 4) ; "If you've seen one pine tree, you've seen them all."
					)
					((or (Said '/ceder') (Said '/ceder<nut'))
						(if (gEgo inRect: 10 145 190 185)
							(Print 30 5) ; "The tree is loaded with walnuts."
						else
							(Print 30 3) ; "There is a large walnut tree surrounded by several pine trees."
						)
					)
					((Said '/nut,nut')
						(cond
							((gEgo has: 18) ; Walnut
								((gInventory at: 18) showSelf: gEgo) ; Walnut
							)
							((< local10 local0)
								(if (gEgo inRect: 10 145 190 185)
									(Print 30 0) ; "These are some of the largest, plumpest walnuts you have ever seen."
								else
									(Print 30 6) ; "The walnuts are too hard to see from over here."
								)
							)
							(else
								(Print 30 2) ; "There are no more walnuts to be seen!"
							)
						)
					)
				)
			)
			((Said 'pick,get,get/nut<gold')
				(cond
					((IsFlag 66)
						(Print 30 7) ; "Actually, you were quite lucky: you picked the only gold walnut in the bunch! The rest are of no use to you."
					)
					((and (gEgo has: 18) (IsFlag 67)) ; Walnut
						(Print 30 8) ; "You already have a gold walnut."
					)
					(else
						(Print 30 9) ; "Where can you get a gold walnut?"
					)
				)
			)
			((Said 'pick,get,get/nut,nut')
				(cond
					((IsFlag 66)
						(Print 30 10) ; "You've already picked the only walnut worth getting, though you may not have realized it!"
					)
					((gEgo has: 18) ; Walnut
						(Print 30 11) ; "You already have one walnut, let's not be greedy."
					)
					((IsFlag 1)
						(Print 30 12) ; "You can't pick it up while you're invisible."
					)
					((>= local10 local0)
						(Print 30 2) ; "There are no more walnuts to be seen!"
					)
					(else
						(gEgo setScript: getWalnut)
					)
				)
			)
		)
	)
)

(class nutView of View
	(properties
		description {nut}
		view 230
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((MousedOn self event 3)
				(Print 30 13) ; "It looks like a walnut of some sort."
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance squirrel of Actor
	(properties
		noun '/squirrel'
		closeRangeDist 320
		longRangeDist 320
		shiftClick 1
		view 205
	)

	(method (doit)
		(super doit: &rest)
		(if (and (< (Random 1 100) 3) (not (squirrel script:)) (not local2))
			(squirrel setScript: squirrelDash)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'throw,throw/boulder,pebble,pebble[/squirrel]')
				(cond
					((or (< x 0) (> x 320))
						(Print 30 14) ; "What are you throwing at?"
					)
					((gEgo has: 9) ; Pebbles
						(Print 30 15) ; "In the manner of a cruel schoolboy, you fling a pebble at the squirrel. Fortunately, the squirrel is too quick for you."
						(UpdatePebbles)
					)
					(else
						(Print 30 16) ; "You don't have any rocks to throw."
					)
				)
			)
			((Said 'give/nut,nut/squirrel')
				(if (or (< x 0) (> x 320))
					(Print 30 17) ; "There is no squirrel here."
				else
					(Print 30 18) ; "The squirrel doesn't want one that you've touched."
				)
			)
			((or (MousedOn self event 3) (Said 'look,look/squirrel'))
				(if (and (> (squirrel x:) 0) (< (squirrel x:) 320))
					(Print 30 19) ; "The squirrel seems hesitant about climbing its favorite walnut tree with you standing around!"
				else
					(Print 30 20) ; "There is no squirrel here at the moment."
				)
			)
			((Said 'get,get/squirrel')
				(if (or (< x 0) (> x 320))
					(Print 30 17) ; "There is no squirrel here."
				else
					(Print 30 21) ; "Please don't bother the squirrel, it has a lot of work to do before next winter."
				)
			)
			((Said 'shoot/squirrel[/shot]')
				(cond
					((not (gEgo has: 10)) ; Leather_Slingshot
						(Print 30 22) ; "You don't have anything to shoot the squirrel with."
					)
					((not (gEgo has: 9)) ; Pebbles
						(Print 30 23) ; "You'll have to have some sort of small, hard projectile in order to use the sling."
					)
					(else
						(Print 30 24) ; "What would a knight have to gain by murdering such a cute, inoffensive creature as a tiny squirrel?"
					)
				)
			)
			((Said 'kill,shoot/squirrel')
				(Print 30 25) ; "It would be cowardly to kill the squirrel, and it would serve no purpose. Act like a knight!"
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance squirrelDash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< local10 local0)
					(= local4 ([local11 local10] y:))
					(= local3 ([local11 local10] x:))
				else
					(if (Random 0 1)
						(= local4 (Random 145 163))
					else
						(= local4 (Random 169 185))
					)
					(if (Random 0 1)
						(= local3 (Random 10 47))
					else
						(= local3 (Random 118 190))
					)
				)
				(if (< local3 83)
					(squirrel posn: -30 local4)
					(= local5 1)
				else
					(squirrel posn: 350 (Random 140 170))
					(= local5 0)
				)
				(squirrel setMotion: MoveTo local3 local4 self)
			)
			(1
				(if (< local10 local0)
					([local11 local10] posn: -1 -1)
					([local11 local10] hide:)
					(++ local10)
				)
				(if local5
					(squirrel setMotion: MoveTo -30 local4 self)
				else
					(squirrel setMotion: MoveTo 350 (Random 140 170) self)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance getWalnut of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (> state 0) (== ([local11 local8] x:) -1) (not local1))
			(if (< local10 local0)
				(Print 30 26) ; "The squirrel took the walnut you wanted."
				(Print 30 27) ; "Pick another one instead."
				(= local1 1)
				(self changeState: 0)
			else
				(Print 30 28) ; "There are no more walnuts to pick."
				(self changeState: 5)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local7 9999)
				(for ((= local6 0)) (< local6 local0) ((++ local6))
					(if
						(<
							(= local9 (gEgo distanceTo: [local11 local6]))
							local7
						)
						(= local7 local9)
						(= local8 local6)
					)
				)
				(if (< (gEgo distanceTo: [local11 local8]) 25)
					(self cue:)
				else
					(Print 30 29) ; "You'll have to get closer to the nuts."
					(HandsOn)
					(self dispose:)
				)
			)
			(1
				(if (< (gEgo x:) ([local11 local8] x:))
					(gEgo
						view: 0
						setCycle: StopWalk 2
						setAvoider: (Avoid offScreenOK: 0)
						setMotion:
							MoveTo
							(- ([local11 local8] x:) 7)
							([local11 local8] y:)
							self
					)
				else
					(gEgo
						view: 0
						setCycle: StopWalk 2
						setAvoider: Avoid
						setMotion:
							MoveTo
							(+ ([local11 local8] x:) 7)
							([local11 local8] y:)
							self
					)
				)
			)
			(2
				(gEgo
					view: 1
					loop: (if (< (gEgo x:) ([local11 local8] x:)) 0 else 1)
					setMotion: 0
					setCycle: End self
				)
			)
			(3
				((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
				(Print 30 30) ; "You choose a big, meaty-looking walnut from the bunch scattered around."
				(gEgo get: 18) ; Walnut
				([local11 local8] hide:)
				(SetScore 66 3)
				(= cycles 4)
				(gEgo setAvoider: 0)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(proc0_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tree of NewFeature
	(properties
		x 104
		y 36
		noun '/ceder[<nut]'
		nsBottom 72
		nsRight 209
		description {walnut tree}
		sightAngle 360
		getableDist 320
		seeableDist 500
		shiftClick 369
		contClick 371
		lookStr {This large, healthy tree is chock full of plump walnuts.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 84
		y 115
		noun '/ceder[<nut]'
		nsTop 72
		nsLeft 67
		nsBottom 158
		nsRight 102
		description {walnut tree}
		sightAngle 360
		getableDist 320
		seeableDist 500
		shiftClick 369
		contClick 371
		lookStr {This large, healthy tree is chock full of plump walnuts.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 82
		y 162
		noun '/ceder[<nut]'
		nsTop 157
		nsLeft 56
		nsBottom 168
		nsRight 108
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 500
		shiftClick 369
		contClick 371
		lookStr {This large, healthy tree is chock full of plump walnuts.}
	)
)

(instance pineTree1 of NewFeature
	(properties
		x 272
		y 103
		noun '/ceder[<pine]'
		nsTop 71
		nsLeft 239
		nsBottom 135
		nsRight 306
		description {pineTree1}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These are just two garden-variety pine trees, with nothing to offer but shade.}
	)
)

(instance pineTree2 of NewFeature
	(properties
		x 265
		y 50
		noun '/ceder[<pine]'
		nsTop 31
		nsLeft 246
		nsBottom 70
		nsRight 284
		description {pine tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These are just two garden-variety pine trees, with nothing to offer but shade.}
	)
)

(instance trunk of NewFeature
	(properties
		x 20
		y 99
		noun '/chest'
		nsTop 72
		nsLeft 6
		nsBottom 127
		nsRight 35
		description {trunk}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There's nothing particularly interesting about this old gray tree.}
	)
)

(instance smallBush of NewFeature
	(properties
		x 255
		y 171
		noun '/chest'
		nsTop 159
		nsLeft 213
		nsBottom 183
		nsRight 298
		description {small bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Some typical Daventry bushes flourish in the shade of the nearby walnut tree.}
	)
)

(instance farTree of NewFeature
	(properties
		x 269
		y 13
		noun '/chest'
		nsTop -1
		nsLeft 220
		nsBottom 27
		nsRight 318
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {There are trees growing nearly everywhere you look in Daventry.}
	)
)

