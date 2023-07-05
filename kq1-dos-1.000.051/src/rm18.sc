;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Blk)
(use LoadMany)
(use Wander)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm18 0
)

(local
	local0
)

(instance elfCage of Cage
	(properties
		top 76
		left 1
		bottom 189
		right 319
	)
)

(instance rm18 of Rm
	(properties
		picture 18
		horizon 65
		north 31
		east 17
		south 15
		west 19
	)

	(method (init)
		(LoadMany rsVIEW 13 150)
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
				(gEgo posn: (proc0_17 184 (gEgo x:) 85) (+ horizon 2))
			)
			(south
				(gEgo y: 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 188 (gEgo y:) 79))
			)
			(east
				(if global130
					(gEgo posn: 317 (proc0_17 166 (gEgo y:) 96))
				else
					(gEgo posn: 317 (proc0_17 188 (gEgo y:) 170))
				)
			)
			(else
				(gEgo posn: 3 137)
				(= local0 1)
			)
		)
		(proc0_1)
		(if global130
			(gEgo view: 13)
		)
		(gEgo init:)
		(self setRegions: 603) ; waterReg
		(if
			(or
				(and local0 (not (IsFlag 11)) (not (IsFlag 65)))
				(and (not (IsFlag 11)) (not (IsFlag 65)) (Random 0 1))
			)
			(elf init: illegalBits: -32750 setCycle: Walk setMotion: Wander)
			(elfCage init:)
			(elf observeBlocks: elfCage)
			(Print 18 0) ; "Wandering along the banks of a beautiful lake, you see a cute little elf."
		)
		(hill1 init:)
		(hill2 init:)
		(bush init:)
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(Said 'look,look/ceder[<pine]')
					(proc0_14 event 142 78 201 133)
					(proc0_14 event 149 66 186 77)
					(proc0_14 event 159 57 177 66)
					(proc0_14 event 214 58 276 84)
					(proc0_14 event 223 40 271 58)
					(proc0_14 event 228 29 265 40)
					(proc0_14 event 242 19 258 29)
				)
				(Print 18 1) ; "Lush pine trees ring the lake."
			)
			(
				(or
					(Said 'look,look/lake,lake,water,cliff,bank')
					(proc0_14 event 287 95 320 113)
					(proc0_14 event 268 113 319 134)
					(proc0_14 event 239 116 268 128)
					(proc0_14 event 228 136 320 154)
					(proc0_14 event 252 154 320 165)
				)
				(Print 18 2) ; "On this side of the lake, the banks of the lake are low and rocky."
			)
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'climb,climb/hill')
				(Print 18 3) ; "The mountain is much too steep and rocky for you to climb."
			)
			((Said '/elf')
				(cond
					((IsFlag 11)
						(Print 18 4) ; "Since you were not very polite to the elf, he has departed."
					)
					((gCast contains: elf)
						(if ((Said 'aid,hug,kiss,touch,get,get/elf'))
							(Print 18 5) ; "This particular elf doesn't care for close physical contact with strangers."
						else
							(Print 18 6) ; "The elf has done nothing to you. Why hurt him?"
						)
					)
					(else
						(Print 18 7) ; "There is no elf here."
					)
				)
			)
			((Said 'look,look>')
				(if (Said '[<at,around][/room,clearing]')
					(if (gCast contains: elf)
						(Print 18 8) ; "There is a very pretty lake here; a small elf is wandering up and down the shore."
					else
						(Print 18 9) ; "This is a clear mountain lake with some low and rocky banks surrounding it."
					)
				)
			)
			((Said 'drink,get,get/water,drink')
				(cond
					((== (gEgo onControl: 1) 4)
						(Print 18 10) ; "You have to scoop the water with your hands, but you manage to satisfy your thirst."
					)
					((== (gEgo onControl: 1) 2)
						(Print 18 11) ; "That's a dangerous proposition from here."
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance elf of Actor
	(properties
		x 100
		y 150
		noun '/elf,man,boy'
		view 150
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(cond
			((< (= temp0 (gEgo distanceTo: elf)) 40)
				(elf setMotion: 0)
				(proc0_15 elf gEgo)
			)
			((< temp0 20)
				(elf dispose:)
				(Print 18 12) ; "You came too close to the shy little elf."
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (Said 'look,look/elf,man,boy') (MousedOn self event 3))
				(Print 18 13) ; "The small elf seems friendly enough."
			)
			((Said 'kiss,hug/elf,man,boy')
				(Print 18 14) ; "Silly! You can't get close enough to do that."
			)
			(
				(or
					(Said
						'shoot,kick,stab,punch,kill,kill,hit,hit,bite/elf,man,boy'
					)
					(Said 'throw/dagger')
				)
				(Print 18 15) ; "I'm surprised at you! That is very impolite!"
				(SetFlag 11)
				(gCurRoom setScript: elfish)
				(event claimed: 1)
			)
			((Said 'throw,throw/boulder,pebble,pebble')
				(if (gEgo has: 9) ; Pebbles
					(Print 18 15) ; "I'm surprised at you! That is very impolite!"
					(SetFlag 11)
					(gCurRoom setScript: elfish)
				else
					(Print 18 16) ; "You don't have anything to throw."
				)
				(event claimed: 1)
			)
			(
				(or
					(Said 'hello>')
					(Said 'talk,talk/elf,man,boy')
					(Said 'say/hello>')
				)
				(cond
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((< (gEgo distanceTo: elf) 30)
						(gCurRoom setScript: elfish)
						(event claimed: 1)
					)
					(else
						(Print 18 17) ; "You should get closer to the little elf."
						(event claimed: 1)
					)
				)
			)
			((Said '/elf,man,boy')
				(Print 18 18) ; "There's no need to do that to the elf."
				(event claimed: 1)
			)
			(else
				(event claimed: 0)
			)
		)
	)
)

(instance elfish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 11))
					((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
					(Print 18 19) ; "The elf is impressed by your friendliness and responds by handing you an elegant little ring."
					(Print 18 20) ; "ELF: "I've had my eye on ye, Sir Graham. Methinks you might enjoy this little trinket. For just a wee bit o' time, it has the power to make ye invisible.""
					(Print 18 21) ; "ELF: "May it give ye as much entertainment as ye has given me this day!"
					(Print 18 22) ; "With that, the elf vanishes."
					(gEgo get: 5) ; Magic_Ring
					(SetScore 65 3)
				)
				(elf
					setLoop: 4
					cel: 0
					cycleSpeed: 1
					setMotion: 0
					setCycle: End self
				)
			)
			(1
				(elf dispose:)
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance hill1 of NewFeature
	(properties
		x 44
		y 32
		noun '/hill'
		nsTop -1
		nsBottom 65
		nsRight 88
		description {mountain}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These are the foothills of a large mountain that towers above Daventry.}
	)
)

(instance hill2 of NewFeature
	(properties
		x 104
		y 44
		noun '/hill'
		nsTop 34
		nsLeft 87
		nsBottom 54
		nsRight 122
		description {mountain}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These are the foothills of a large mountain that towers above Daventry.}
	)
)

(instance bush of NewFeature
	(properties
		x 197
		y 142
		noun '/bush,bury'
		nsTop 133
		nsLeft 169
		nsBottom 151
		nsRight 225
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Small bushes like this one thrive near the fresh lake water.}
	)
)

