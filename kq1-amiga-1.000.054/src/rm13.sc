;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Chase)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm13 0
)

(local
	local0
	local1
	local2
)

(instance rm13 of Rm
	(properties
		picture 13
		horizon 72
		north 20
		east 14
		south 4
		west 12
		picAngle 60
	)

	(method (init)
		(LoadMany rsVIEW 125 20)
		(if (not (gEgo has: 16)) ; Magic_Shield
			(LoadMany rsSOUND 41 46)
		)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 2)
					(south 4)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_18 127 (gEgo x:) 12) (+ horizon 2))
			)
			(south
				(gEgo y: 188)
			)
			(west
				(gEgo
					posn:
						3
						(proc0_17
							189
							(proc0_18 112 (gEgo y:) 103)
							(+ horizon 2)
						)
				)
			)
			(east
				(gEgo
					posn: 317 (proc0_17 189 (proc0_18 175 (gEgo y:) 165) 149)
				)
			)
			(else
				(gEgo
					posn: 317 (proc0_17 189 (proc0_18 175 (gEgo y:) 165) 149)
				)
				(= local2 1)
			)
		)
		(gEgo init:)
		(proc0_1)
		(rock1 init:)
		(rock2 init:)
		(rock3 init:)
		(rock4 init:)
		(rock5 init:)
		(rock6 init:)
		(bush1 init:)
		(rock7 init:)
		(tree4 init:)
		(tree3 init:)
		(tree2 init:)
		(tree1 init:)
		(tree init:)
		((ScriptID 0 21) number: 91 loop: 1 init: play:) ; gameSound
		(if (or (Random 0 1) local2)
			(self setScript: waitOne)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((and script global103)
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
			(script
				(script doit:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,clearing]')
						(Print 13 0) ; "You are in a clearing in the forest. You have the uneasy feeling that someone or something is watching you."
					)
					((Said '/dog')
						(Print 13 1) ; "You don't see a wolf here."
					)
				)
			)
			((or (Said 'use,shoot/shot,shot') (Said 'shoot/dog'))
				(cond
					(
						(and
							(gEgo has: 9) ; Pebbles
							(gEgo has: 10) ; Leather_Slingshot
							(gCast contains: gMenace)
						)
						(Print 13 2) ; "By the time you got out your slingshot and pebbles, and aimed them, the wolf would be upon you!"
					)
					(
						(and
							(gEgo has: 9) ; Pebbles
							(not (gEgo has: 10)) ; Leather_Slingshot
							(gCast contains: gMenace)
						)
						(Print 13 3) ; "You have nothing with which to shoot the wolf...and even if you did, you probably couldn't."
					)
					((and (not (gEgo has: 9)) (gEgo has: 10)) ; Pebbles, Leather_Slingshot
						(Print 13 4) ; "You'd need some sort of ammunition to even attempt such an inadvisable feat."
					)
					((not (gCast contains: gMenace))
						(Print 13 5) ; "You're not talking about shooting yourself, are you?"
					)
					(else
						(Print 13 6) ; "You have neither projectiles nor the means with which to propel them, should you want to attempt such a folly."
					)
				)
			)
			((Said 'throw,throw/pebble,pebble,boulder')
				(cond
					((gEgo has: 9) ; Pebbles
						(Print 13 7) ; "You could scarcely hope to bother the wolf by tossing pebbles at it!"
					)
					((not (gCast contains: gMenace))
						(Print 13 8) ; "There's nothing interesting to throw your pebbles at here."
					)
					(else
						(Print 13 9) ; "You don't have any pebbles to throw."
					)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance rock1 of NewFeature
	(properties
		x 66
		y 69
		noun '/boulder'
		nsTop 54
		nsLeft 33
		nsBottom 84
		nsRight 99
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance rock2 of NewFeature
	(properties
		x 194
		y 138
		noun '/boulder'
		nsTop 126
		nsLeft 155
		nsBottom 150
		nsRight 234
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance rock3 of NewFeature
	(properties
		x 203
		y 120
		noun '/boulder'
		nsTop 114
		nsLeft 172
		nsBottom 126
		nsRight 235
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance rock4 of NewFeature
	(properties
		x 223
		y 106
		noun '/boulder'
		nsTop 98
		nsLeft 197
		nsBottom 114
		nsRight 250
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance rock5 of NewFeature
	(properties
		x 266
		y 92
		noun '/boulder'
		nsTop 87
		nsLeft 214
		nsBottom 98
		nsRight 319
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance rock6 of NewFeature
	(properties
		x 270
		y 76
		noun '/boulder'
		nsTop 65
		nsLeft 252
		nsBottom 87
		nsRight 288
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance bush1 of NewFeature
	(properties
		x 277
		y 124
		noun '/bush'
		nsTop 104
		nsLeft 235
		nsBottom 145
		nsRight 320
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {You see lush plants and bushes throughout the Kingdom of Daventry.}
	)
)

(instance rock7 of NewFeature
	(properties
		x 287
		y 168
		noun '/boulder'
		nsTop 157
		nsLeft 255
		nsBottom 179
		nsRight 320
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This is one of the countless rocks and boulders that dot the countryside.}
	)
)

(instance wolfStuff of Script
	(properties)

	(method (doit)
		(super doit:)
		(gGoat setLoop: (if (< (gGoat heading:) 180) 0 else 1))
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'kill,shoot,hit/dog')
				(Print 13 10) ; "The wolf's muscles are coiled steel springs. His massive jaws, razor-sharp teeth and long, wicked claws are a deadly blur. And you want to try to kill him? Better think again!"
			)
			((Said 'capture,get,get,get/dog')
				(Print 13 11) ; "The wolf's muscles are coiled steel springs. His massive jaws, razor-sharp teeth and long, wicked claws are deadly blur. And you want to get him? Better think again!"
			)
			((Said 'eat,eat/dog')
				(Print 13 12) ; "He's too lean and wiry to make a good meal. But he'll make a good meal out of you if you don't run!"
			)
			((Said 'ride/dog')
				(Print 13 13) ; "You'll be riding inside the wolf if you stand here."
			)
			((or (Said 'look,look/dog') (MousedOn gMenace event))
				(Print 13 14) ; "It looks like the wolf has his stomach set on you. Spend less time looking and more time escaping!"
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 13 15) ; "Without warning, a wolf darts out of the bushes and runs straight for you. Look out!  Don't let him catch you."
				((ScriptID 0 23) number: 41 loop: -1 playBed:) ; backSound
				(gMenace
					view: 125
					setCycle: Walk
					setAvoider: Avoid
					setStep: 8 6
					setPri: -1
					setLoop: -1
					ignoreActors:
					init:
				)
				(= local0 (gEgo x:))
				(= local1 (gEgo y:))
				(cond
					((and (>= local0 130) (<= local1 97))
						(gMenace posn: 340 75)
					)
					((<= local1 148)
						(gMenace posn: -20 150)
					)
					((<= local0 142)
						(gMenace posn: -20 170)
					)
					((<= local1 170)
						(gMenace posn: 340 163)
					)
					(else
						(gMenace posn: 340 163)
					)
				)
				(self cue:)
			)
			(1
				(gMenace setMotion: Chase gEgo 42 self)
			)
			(2
				(HandsOff)
				(gMenace hide:)
				(gEgo setMotion: 0 view: 20 cel: 0 loop: 0 setCycle: Fwd)
				(if (== (gCurRoom script:) (ScriptID 782 0)) ; fiddler
					((ScriptID 782 1) stop:) ; fiddleSound
				)
				((ScriptID 0 23) stop:) ; backSound
				((ScriptID 0 21) number: 46 loop: 1 init: play: self) ; gameSound
			)
			(3
				(gEgo loop: 1 cel: 0 setCycle: End)
				(gMenace
					loop: 2
					posn: (gEgo x:) (gEgo y:)
					show:
					setPri: (gEgo priority:)
				)
				(if (IsFlag 1)
					(Print 13 16) ; "Even your invisibility didn't hide you from the wolf's keen sense of smell."
				)
				(= cycles 38)
			)
			(4
				(EgoDead
					{How many times have you been told not to wolf down your food?}
				)
			)
		)
	)
)

(instance waitOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(if
					(and
						(not (IsFlag 2))
						(gEgo inRect: 25 (+ (gCurRoom horizon:) 12) 295 176)
						(not (IsFlag 1))
						(not global124)
						(not (gEgo has: 16)) ; Magic_Shield
						(not (gMenace script:))
						(or (> (gEgo x:) 130) (> (gEgo y:) 85))
					)
					(gMenace setScript: wolfStuff)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance tree4 of NewFeature
	(properties
		x 26
		y 27
		noun '/ceder'
		nsTop -1
		nsBottom 55
		nsRight 52
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of gorgeous trees dot the Daventry countryside.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 10
		y 82
		noun '/ceder'
		nsTop 55
		nsBottom 109
		nsRight 21
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of gorgeous trees dot the Daventry countryside.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 216
		y 13
		noun '/ceder'
		nsTop -1
		nsLeft 114
		nsBottom 27
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of gorgeous trees dot the Daventry countryside.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 222
		y 39
		noun '/ceder'
		nsTop 27
		nsLeft 124
		nsBottom 52
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of gorgeous trees dot the Daventry countryside.}
	)
)

(instance tree of NewFeature
	(properties
		x 236
		y 57
		noun '/ceder'
		nsTop 52
		nsLeft 153
		nsBottom 63
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {All sorts of gorgeous trees dot the Daventry countryside.}
	)
)

