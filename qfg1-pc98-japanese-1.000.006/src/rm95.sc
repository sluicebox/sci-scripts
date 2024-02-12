;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use n105)
(use LoadMany)
(use RFeature)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm95 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6 = 1
	local7 = 1
	local8 = 1
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
)

(procedure (localproc_0 param1)
	(cond
		((Said 'look,look>')
			(cond
				((Said '[<at,around][/place,place,area]')
					(HighPrint 95 19) ; "Wooden tables, benches, and chairs fill the space of this brigand meeting area.  A chandelier lights the room and an unlit candelabra stands in the corner.  A rope hangs from the chandelier."
				)
				((or (Said '<up') (Said '/ceiling'))
					(HighPrint 95 20) ; "There is a chandelier with a rope attached."
				)
				((or (Said '<down') (Said '/floor'))
					(HighPrint 95 21) ; "The floor is strewn with flotsam and jetsam."
				)
				((Said '/west,north,east')
					(HighPrint 95 22) ; "You see a door ."
				)
				((Said '/south')
					(HighPrint 95 23) ; "The door you came through is the only object you see."
				)
				((Said '/table')
					(HighPrint 95 24) ; "Most of the tables are grimy with dried beer and such. The head table, though, is clean."
				)
				((Said '/chandelier,chandelier')
					(HighPrint 95 25) ; "The chandelier is firmly attached to the rope in order to lower it to light the candles."
				)
				((Said '/candelabra')
					(HighPrint 95 26) ; "The massive candelabra certainly seems to get in the way."
				)
				((Said '/sign,sign')
					(HighPrint 95 27) ; "It says, "Brigands over all" (only in German)."
				)
				((Said '/bandit')
					(HighPrint 95 28) ; "They remind you of a bunch of Knochelkopfs."
				)
				((Said '/rope')
					(HighPrint 95 29) ; "The rope is heavy and very sturdy. It is secured to the chandelier."
				)
			)
		)
		((Said 'cast>')
			(cond
				((!= (= local1 (SaidSpell param1)) 17)
					(param1 claimed: 0)
				)
				((gEgo inRect: 250 162 310 190)
					(if local3
						(HighPrint 95 30) ; "You don't dare; the brigands are coming."
					else
						(HighPrint 95 31) ; "The door is open."
					)
				)
				(
					(or
						(gEgo inRect: 263 82 320 93)
						(gEgo inRect: 0 90 47 100)
					)
					(HighPrint 95 32) ; "The door is barred on the other side."
				)
				((not (gEgo inRect: 34 75 73 95))
					(HighPrint 95 33) ; "You aren't near a door."
				)
				((CastSpell 17)
					(gEgo setScript: tryOpenSpell)
				)
			)
		)
		((Said 'get,get/boulder')
			(HighPrint 95 34) ; "There are no rocks in here."
		)
		((Said 'open,open,open[/gate,door]')
			(cond
				((gEgo inRect: 34 75 73 95)
					(gEgo setScript: openBDoor)
				)
				((gEgo inRect: 250 162 310 190)
					(if local3
						(HighPrint 95 30) ; "You don't dare; the brigands are coming."
					else
						(HighPrint 95 31) ; "The door is open."
					)
				)
				(
					(or
						(gEgo inRect: 263 82 320 93)
						(gEgo inRect: 0 90 47 100)
					)
					(HighPrint 95 35) ; "The door is locked from the other side."
				)
				(else
					(HighPrint 95 36) ; "You're not near a door."
				)
			)
		)
		(
			(or
				(Said
					'close,close,close,close,hasp,hasp,lock,bar,bar/gate,door'
				)
				(Said '/gate,door<bar,bar')
			)
			(cond
				((gEgo inRect: 34 75 73 95)
					(HighPrint 95 37) ; "The door is closed, but has no lock."
				)
				((gEgo inRect: 250 162 310 190)
					(if local3
						(HighPrint 95 38) ; "The door is locked."
					else
						(gEgo setScript: barFDoor)
					)
				)
				((gEgo inRect: 263 82 320 93)
					(HighPrint 95 35) ; "The door is locked from the other side."
				)
				((gEgo inRect: 0 90 47 100)
					(HighPrint 95 35) ; "The door is locked from the other side."
				)
				(else
					(HighPrint 95 36) ; "You're not near a door."
				)
			)
		)
		((Said 'force,move,move,get,get,use/chair')
			(cond
				(local2
					(HighPrint 95 39) ; "The door is already blocked."
				)
				((gEgo inRect: 228 106 320 124)
					(gEgo setScript: pushChair)
				)
				(
					(or
						(gEgo inRect: 273 88 282 106)
						(gEgo inRect: 237 96 273 106)
					)
					(= local5 1)
					(gEgo setScript: pushChair)
				)
				(else
					(HighPrint 95 40) ; "Get closer to the chair."
				)
			)
		)
		((Said 'bar,bar,block,block/door,entrance,door')
			(cond
				((gEgo inRect: 34 75 73 95)
					(HighPrint 95 41) ; "The door is closed but has no lock."
				)
				((gEgo inRect: 250 162 310 190)
					(if local3
						(HighPrint 95 38) ; "The door is locked."
					else
						(gEgo setScript: barFDoor)
					)
				)
				((gEgo inRect: 0 90 47 100)
					(HighPrint 95 35) ; "The door is locked from the other side."
				)
				(local2
					(HighPrint 95 39) ; "The door is already blocked."
				)
				((gEgo inRect: 228 106 320 124)
					(gEgo setScript: pushChair)
				)
				(
					(or
						(gEgo inRect: 273 88 282 106)
						(gEgo inRect: 237 96 273 106)
					)
					(= local5 1)
					(gEgo setScript: pushChair)
				)
				(else
					(HighPrint 95 40) ; "Get closer to the chair."
				)
			)
		)
		(
			(Said
				'hit,force,shove,use,move,move,knock/candelabra,candle,candlestick'
			)
			(cond
				(local4
					(HighPrint 95 42) ; "The candelabra won't budge."
				)
				((gEgo inRect: 227 83 320 115)
					(= local5 1)
					(gEgo setScript: pushCan)
				)
				((gEgo inRect: 271 0 320 96)
					(gEgo setScript: pushCan)
				)
				(else
					(HighPrint 95 43) ; "You're not in a good spot."
				)
			)
		)
		((Said 'get/candelabra,candle,candlestick')
			(HighPrint 95 44) ; "It's much too heavy to carry. You can barely move it."
		)
		((or (Said 'walk,sneak') (Said 'run[/!*]'))
			(HighPrint 95 45) ; "Just keep a cool head and be logical. You don't need to run or sneak."
		)
	)
)

(instance rm95 of Rm
	(properties
		picture 95
		style 8
		horizon 80
	)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 465)
		(Load rsVIEW 510)
		(Load rsVIEW 195)
		(Load rsVIEW 525)
		(Load rsVIEW 295)
		(Load rsVIEW 196)
		(Load rsVIEW 95)
		(LoadMany rsVIEW 187 186 188)
		(super init:)
		(self setFeatures: onDrunk onSign onRope onCandelabra onChandelier)
		(gMouseHandler add: self)
		(SolvePuzzle 706 8)
		(SL enable:)
		(NormalEgo)
		(EgoGait 0 0) ; walking
		(brigSign init: setPri: 3 addToPic:)
		(chairs init: setPri: 6 addToPic:)
		(rDoor init: stopUpd:)
		(lDoor init: stopUpd:)
		(candelabra init: stopUpd:)
		(drunk init: setPri: 12 stopUpd:)
		(chandelier init: setPri: 5 stopUpd:)
		(rope init: setPri: 3)
		(ropeHolder init: setPri: 3 addToPic:)
		(flames init: setPri: 6 setCycle: Fwd)
		(chair init: stopUpd:)
		(brig1 init: hide:)
		(brig4 init: hide:)
		(moe init:)
		(moeHead init:)
		(curly init:)
		(curlyHead init:)
		(larry init:)
		(larryHead init:)
		(bDoor init: setPri: 1 stopUpd:)
		(fDoor setCel: 1 init: setPri: 14 stopUpd:)
		(= local3 0)
		(gEgo posn: 302 194 init: setScript: egoEntersSouth)
	)

	(method (doit)
		(if (and local0 (& (gEgo onControl: 1) $1000))
			(gCurRoom newRoom: 94)
		)
		(if
			(and
				local6
				(or (< (gEgo x:) 210) (< (gEgo y:) 135))
				(== (brig1 script:) 0)
			)
			(brig1 setScript: brigandsSouth)
		)
		(if
			(and
				local7
				(not local2)
				(< (gEgo x:) 250)
				(== (brig4 script:) 0)
				(not local2)
			)
			(brig4 setScript: brigandsEast)
		)
		(if (and local3 local2 local8)
			(= local8 0)
			(moe setScript: brigandsWest)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((super handleEvent: event))
					((MouseClaimed gEgo event 3)
						(HighPrint 95 0) ; "The flying Wallendas have nothing on you."
					)
				)
			)
			(evSAID
				(if (Said 'rest,rest,nap,nap')
					(EgoDead ; "The Brigands oblige you by making your pleasant rest permanent!"
						95
						1
						80
						{Z-Z-Z-Z-Z-Z-Z-Z-Z-Z}
						82
						800
						0
						0
					)
				)
				(cond
					(
						(or
							(Said 'japaneseclimbup,climb,climb,hop[/table]')
							(Said
								'use,swing,get,get,grab/rope,chandelier,chandelier'
							)
							(Said 'get,get/table')
						)
						(cond
							(local16
								(HighPrint 95 2) ; "No time for that again (although it WAS fun). Just get the heck outta here."
							)
							((gEgo inRect: 100 108 217 120)
								(gEgo setScript: climb)
							)
							(else
								(HighPrint 95 3) ; "You're not in a good spot."
							)
						)
					)
					((and local4 (not local16))
						(HighPrint 95 4) ; "It's too late for that."
						(event claimed: 1)
					)
					((not (super handleEvent: event))
						(localproc_0 event)
					)
				)
			)
		)
	)
)

(instance brigSign of View
	(properties
		y 54
		x 154
		view 95
	)
)

(instance chairs of View
	(properties
		y 76
		x 160
		view 95
		cel 1
	)
)

(instance rDoor of Prop
	(properties
		y 93
		x 290
		view 95
		loop 1
	)
)

(instance lDoor of Prop
	(properties
		y 93
		x 15
		view 95
		loop 2
	)
)

(instance bDoor of Prop
	(properties
		y 83
		x 46
		view 95
		loop 3
	)
)

(instance fDoor of Prop
	(properties
		y 178
		x 274
		view 95
		loop 8
	)
)

(instance candelabra of Prop
	(properties
		y 93
		x 239
		view 95
		loop 4
	)
)

(instance chandelier of Prop
	(properties
		y 48
		x 155
		view 95
		loop 5
	)
)

(instance rope of Prop
	(properties
		y 63
		x 211
		view 195
		loop 4
	)
)

(instance ropeHolder of Prop
	(properties
		y 48
		x 208
		view 95
		cel 2
	)
)

(instance drunk of View
	(properties
		y 138
		x 61
		view 95
		loop 9
	)
)

(instance flames of Prop
	(properties
		y 29
		x 160
		view 95
		loop 6
	)
)

(instance chair of Prop
	(properties
		y 104
		x 306
		view 95
		loop 7
		cel 1
	)
)

(instance brig1 of Act
	(properties
		view 465
	)
)

(instance brig2 of Act
	(properties
		view 465
	)
)

(instance brig3 of Act
	(properties
		view 465
	)
)

(instance brig4 of Act
	(properties
		view 465
	)
)

(instance brig5 of Act
	(properties
		view 465
	)
)

(instance brig6 of Act
	(properties
		view 465
	)
)

(instance curly of Act
	(properties
		view 196
	)
)

(instance moe of Act
	(properties
		view 196
	)
)

(instance larry of Act
	(properties
		view 196
	)
)

(instance curlyHead of Prop
	(properties
		z 29
		view 188
	)

	(method (doit)
		(self
			posn: (curly x:) (curly y:)
			setPri: (curly priority:)
			setCel: (curly cel:)
			setLoop: (curly loop:)
		)
		(super doit:)
	)
)

(instance moeHead of Prop
	(properties
		z 29
		view 187
	)

	(method (doit)
		(self
			posn: (moe x:) (moe y:)
			setPri: (moe priority:)
			setCel: (moe cel:)
			setLoop: (moe loop:)
		)
		(super doit:)
	)
)

(instance larryHead of Prop
	(properties
		z 29
		view 186
	)

	(method (doit)
		(self
			posn: (larry x:) (larry y:)
			setPri: (larry priority:)
			setCel: (larry cel:)
			setLoop: (larry loop:)
		)
		(super doit:)
	)
)

(instance stars of Prop
	(properties
		view 295
		loop 2
	)
)

(instance onDrunk of RFeature
	(properties
		nsTop 114
		nsLeft 47
		nsBottom 138
		nsRight 72
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onDrunk event 3)
				(HighPrint 95 5) ; "He's been drinking Troll's sweat all night."
			)
		)
	)
)

(instance onSign of RFeature
	(properties
		nsTop 45
		nsLeft 104
		nsBottom 52
		nsRight 196
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onSign event 3)
				(HighPrint 95 6) ; ""Brigands over all!" Egotistical bunch, aren't they?"
			)
		)
	)
)

(instance onRope of RFeature
	(properties
		nsTop 45
		nsLeft 204
		nsBottom 61
		nsRight 213
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onRope event 3)
				(HighPrint 95 7) ; "The rope holds up the chandelier. It's used to lower the chandelier so that it can be lit."
			)
		)
	)
)

(instance onCandelabra of RFeature
	(properties
		nsTop 48
		nsLeft 233
		nsBottom 92
		nsRight 261
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onCandelabra event 3)
				(HighPrint 95 8) ; "Sturdy-looking device for holding candles."
			)
		)
	)
)

(instance onChandelier of RFeature
	(properties
		nsTop 19
		nsLeft 133
		nsBottom 41
		nsRight 174
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onChandelier event 3)
				(HighPrint 95 9) ; "Chandelier, used to hold up the rope."
			)
		)
	)
)

(instance egoEntersSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: -32768 setMotion: MoveTo 302 170 self)
			)
			(1
				(= local0 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openBDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bDoor setCel: 1)
				(= cycles 4)
			)
			(1
				(gEgo setPri: 2 illegalBits: 0 setMotion: MoveTo 66 79 self)
			)
			(2
				(NormalEgo)
				(gCurRoom newRoom: 96)
			)
		)
	)
)

(instance tryOpenSpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(CastOpen self self)
			)
			(2
				(client setScript: openBDoor)
			)
		)
	)
)

(instance barFDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fDoor setScript: closeFDoor self)
			)
			(1
				(HandsOff)
				(gEgo
					setPri: 14
					illegalBits: 0
					setMotion: MoveTo 295 175 self
				)
			)
			(2
				(gEgo loop: 2)
				(HighPrint 95 10) ; "You close and bar the door."
				(= cycles 1)
			)
			(3
				(NormalEgo)
				(gEgo illegalBits: -28672)
				(= local3 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance closeFDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: 12
					illegalBits: 0
					setMotion: MoveTo 284 182 self
				)
			)
			(1
				(gEgo loop: 2 setPri: 14)
				(fDoor setPri: 15 ignoreActors: 1 setCel: 0 stopUpd:)
				(= cycles 2)
			)
			(2
				(NormalEgo)
				(gEgo illegalBits: -28672)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance finalEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 80)
			)
			(1
				(lDoor setCel: 1)
				(brig1
					show:
					setPri: 3
					posn: 31 90
					ignoreActors: 1
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 55 90
				)
				(= cycles 4)
			)
			(2
				(brig2
					init:
					setPri: 3
					ignoreActors:
					illegalBits: 0
					posn: 31 90
					setCycle: Walk
					setMotion: MoveTo 46 92
				)
				(= cycles 3)
			)
			(3
				(brig3
					init:
					setPri: 3
					ignoreActors:
					illegalBits: 0
					posn: 31 90
					setCycle: Walk
					setMotion: MoveTo 40 94 self
				)
			)
			(4
				(EgoDead ; "You're hopelessly outnumbered. You should have left this room when you had a chance."
					95
					11
					82
					516
					0
					9
					80
					{Molasses in January.}
				)
			)
		)
	)
)

(instance sBrigBlocked of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(client setScript: brigBlocked)
			)
		)
	)
)

(instance sChandFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= local16 1)
				(client setScript: chandFall)
			)
		)
	)
)

(instance brigandsWest of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(lDoor setCel: 1)
				(moe
					setPri: 3
					posn: 31 90
					ignoreActors: 1
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 211 90
				)
				(= cycles 4)
			)
			(2
				(curly
					setPri: 3
					ignoreActors:
					illegalBits: 0
					posn: 31 90
					setCycle: Walk
					setMotion: MoveTo 175 90
				)
				(curlyHead ignoreActors: 1 setLoop: 6)
				(= cycles 3)
			)
			(3
				(larry
					setPri: 3
					ignoreActors:
					illegalBits: 0
					posn: 31 90
					setCycle: Walk
					setMotion: MoveTo 160 90
				)
				(larryHead ignoreActors: 1 setLoop: 5)
				(= cycles 5)
			)
			(4
				(lDoor setCel: 0)
				(= cycles 45)
			)
			(5
				(if local4
					(client setScript: sBrigBlocked)
				else
					(EgoDead ; "You're hopelessly surrounded. You should have stopped those brigands somehow. Maybe you'll see the light."
						95
						12
						82
						516
						0
						9
						80
						{Those guys look familiar.}
					)
				)
			)
		)
	)
)

(instance chandFall of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(= cycles 18)
			)
			(1
				(flames dispose:)
				(rope show: posn: 154 32)
				(chandelier
					view: 295
					setLoop: 3
					setCel: 0
					setPri: 7
					posn: 153 62
				)
				(= cycles 1)
			)
			(2
				(rope posn: 152 47)
				(chandelier setCel: 1 posn: 151 77)
				(= cycles 1)
			)
			(3
				(rope posn: 150 62)
				(chandelier setCel: 2 posn: 149 92)
				(= cycles 1)
			)
			(4
				(chandelier dispose:)
				(rope dispose:)
				(larry ignoreActors: 0 setCel: 1)
				(stars
					init:
					setPri: 10
					ignoreActors: 1
					posn: 147 100
					setCycle: Fwd
				)
				(brig1 setScript: finalEntry)
				(self dispose:)
			)
		)
	)
)

(instance brigandsSouth of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(brig1
					show:
					posn: 122 222
					setPri: 15
					illegalBits: 0
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 195 194 self
				)
			)
			(1
				(brig1 setMotion: MoveTo 295 194 self)
				(brig3
					init:
					posn: 286 224
					setPri: 15
					illegalBits: 0
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 286 190
				)
			)
			(2
				(if (gEgo inRect: 220 150 320 200)
					(self changeState: 9)
				else
					(brig1 loop: 3)
					(brig2
						init:
						posn: 340 194
						setPri: 15
						illegalBits: 0
						ignoreActors: 1
						setCycle: Walk
						setMotion: MoveTo 304 194 self
					)
				)
			)
			(3
				(brig2 loop: 3)
				(= cycles 4)
			)
			(4
				(if local3
					(brig3 loop: 0)
					(brig2 loop: 1)
					(= cycles 18)
				else
					(= local2 1)
					(= local6 0)
					(brig1 setPri: 14 setMotion: MoveTo 304 165)
					(brig2 setPri: 14 setMotion: MoveTo 310 163)
					(brig3 setPri: 14 setMotion: MoveTo 307 161)
					(if (gEgo inRect: 50 108 230 124)
						(HandsOff)
						(gEgo loop: 0)
						(self changeState: 7)
					else
						(self changeState: 9)
					)
				)
			)
			(5
				(brig1 setMotion: MoveTo 340 194)
				(brig2 setMotion: MoveTo 340 194)
				(brig3 setMotion: MoveTo 307 250 self)
			)
			(6
				(= local6 0)
				(brig2 dispose:)
				(brig3 dispose:)
				(self dispose:)
			)
			(7
				(gEgo
					view: 525
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo 50 110
				)
				(= cycles 2)
			)
			(8
				(brig1 setPri: 13 ignoreActors: 0 setMotion: MoveTo 280 165)
				(brig2 ignoreActors: 0 setMotion: MoveTo 310 150)
				(= cycles 20)
			)
			(9
				(EgoDead ; "You'd better find a way to prevent the brigands from getting at you from all sides if you want to survive this."
					95
					13
					82
					516
					0
					9
					80
					{Don't you feel a draft?}
				)
			)
		)
	)
)

(instance brigBlocked of Script
	(properties)

	(method (doit)
		(if (and (== state 3) local12)
			(self cue:)
		)
		(if (and (== state 4) local13)
			(self cue:)
		)
		(if (and (< (gEgo x:) 90) (< state 3))
			(self changeState: 3)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HighPrint 95 14) ; "Oh, a wise guy, eh."
				(moe setMotion: MoveTo 91 88 self)
				(curly loop: 2 setScript: curlyFollow)
				(larry loop: 2 setScript: larryFollow)
			)
			(1
				(if local9
					(EgoDead ; "Die drei Knochelkopfen grab you off the table. You should have waited until they were out of reach."
						95
						15
						82
						516
						0
						9
						80
						{Nyuk Nyuk Nyuk -- Mee Mee Mee Mee Mee...}
					)
				else
					(moe setMotion: MoveTo 76 106 self)
				)
			)
			(2
				(moe setPri: 8 setMotion: MoveTo 100 115 self)
			)
			(3
				(if local9
					(= local11 1)
				else
					(EgoDead ; "You're hopelessly surrounded. You should have taken quicker action against these Knochelkopfs.  Elevate your thoughts to a higher plane."
						95
						16
						82
						516
						0
						9
						80
						{Woo Woo Woo -- Ruff Ruff Ruff.}
					)
				)
			)
			(4
				(moe setMotion: MoveTo 174 124)
			)
			(5
				(moe
					view: 187
					setCel: 0
					setLoop: 4
					setMotion: MoveTo 165 124
					setCycle: End
				)
				(moeHead dispose:)
				(= local14 1)
				(= cycles 1)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance curlyFollow of Script
	(properties)

	(method (doit)
		(if (and (== state 4) local14)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 23)
			)
			(1
				(curly setMotion: MoveTo 89 88 self)
			)
			(2
				(curly setMotion: MoveTo 76 106 self)
			)
			(3
				(curly setPri: 8 setMotion: MoveTo 100 115 self)
			)
			(4
				(curly setMotion: MoveTo 162 124)
			)
			(5
				(= cycles 4)
			)
			(6
				(curly
					view: 188
					setCel: 0
					setLoop: 4
					setMotion: MoveTo 153 124
					setCycle: End
				)
				(curlyHead dispose:)
				(= local15 1)
				(= cycles 1)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance larryFollow of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (doit)
		(if (and local15 (== state 4))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 32)
			)
			(1
				(larry setMotion: MoveTo 89 88 self)
			)
			(2
				(larry setMotion: MoveTo 76 106 self)
			)
			(3
				(larry setPri: 8 setMotion: MoveTo 100 115 self)
			)
			(4
				(larry setMotion: MoveTo 150 124)
			)
			(5
				(= cycles 4)
			)
			(6
				(larry
					view: 186
					setCel: 0
					setLoop: 4
					setMotion: MoveTo 144 124
					setCycle: End
				)
				(larryHead dispose:)
				(= cycles 30)
			)
			(7
				(moe
					cycleSpeed: 7
					moveSpeed: 7
					setCycle: Beg
					setMotion: MoveTo 164 124
				)
				(curly
					cycleSpeed: 7
					moveSpeed: 7
					setCycle: Beg
					setMotion: MoveTo 152 124
				)
				(larry
					cycleSpeed: 7
					moveSpeed: 7
					setCycle: Beg
					setMotion: MoveTo 145 124 self
				)
			)
			(8
				(larry view: 295 setLoop: 1 setCel: 0)
				(chandelier setScript: sChandFall)
				(curly dispose:)
				(moe dispose:)
				(self dispose:)
			)
		)
	)
)

(instance climb of Script
	(properties)

	(method (doit)
		(if (and local11 (== state 6))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 178 108 self)
			)
			(1
				(= local9 1)
				(gEgo
					view: 195
					setLoop: 0
					setCel: 0
					setPri: 7
					illegalBits: 0
					posn: 173 108
				)
				(= cycles 2)
			)
			(2
				(gEgo setCel: 1 posn: 182 97)
				(= cycles 2)
			)
			(3
				(gEgo setCel: 2 posn: 188 99)
				(= cycles 2)
			)
			(4
				(gEgo setCel: 3 posn: 191 92)
				(= cycles 2)
			)
			(5
				(gEgo setCel: 4 posn: 212 100)
				(= cycles 3)
			)
			(6
				(= local12 1)
				(gEgo
					view: 4
					loop: 1
					setCel: 0
					posn: (- (gEgo x:) 9) (- (gEgo y:) 18)
				)
			)
			(7
				(gEgo
					view: 195
					setLoop: 0
					setCel: 5
					posn: 212 100
					cycleSpeed: 3
					setCycle: CT 7 1 self
				)
				(rope setLoop: 4 setCel: 0 posn: 211 63)
			)
			(8
				(gEgo setCel: 8)
				(rope setLoop: 4 setCel: 1 setPri: 11 posn: 206 50)
				(= cycles 3)
			)
			(9
				(gEgo
					setLoop: 1
					setCel: 0
					setPri: 12
					cycleSpeed: 0
					posn: 230 82
				)
				(rope setLoop: 3 setCel: 0 posn: 228 47)
				(= cycles 3)
			)
			(10
				(lDoor setCel: 1 stopUpd:)
				(gEgo setCel: 1 posn: 244 92)
				(rope setCel: 1 posn: 238 57)
				(= cycles 3)
			)
			(11
				(gEgo setCel: 2 posn: 260 114)
				(rope setCel: 2 posn: 246 68)
				(= cycles 3)
			)
			(12
				(gEgo setCel: 3 posn: 243 128)
				(rope setCel: 3 posn: 224 80)
				(= cycles 4)
			)
			(13
				(gEgo setCel: 4 posn: 183 130)
				(rope setCel: 4 posn: 183 88)
				(= cycles 2)
			)
			(14
				(= local13 1)
				(gEgo setCel: 5 posn: 119 132)
				(rope setCel: 5 posn: 117 88)
				(= cycles 3)
			)
			(15
				(gEgo setCel: 6 posn: 96 122)
				(rope setCel: 6 posn: 93 83)
				(= cycles 3)
			)
			(16
				(gEgo setCel: 7 posn: 62 106)
				(rope setCel: 7 posn: 75 74)
				(= cycles 3)
			)
			(17
				(gEgo setCel: 8 posn: 47 92)
				(rope setCel: 8 posn: 80 60)
				(= cycles 3)
			)
			(18
				(lDoor setCel: 0 stopUpd:)
				(gEgo setCel: 9 posn: 46 86)
				(rope hide:)
				(= cycles 3)
			)
			(19
				(gEgo setLoop: 2 setCel: 0 posn: 40 88)
				(= cycles 3)
			)
			(20
				(gEgo setCel: 1 posn: 59 93)
				(= cycles 3)
			)
			(21
				(NormalEgo)
				(if local3
					(gEgo illegalBits: -28672)
				)
				(gEgo loop: 2 posn: 63 93)
				(self dispose:)
			)
		)
	)
)

(instance pushChair of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(if local5
					(gEgo setMotion: MoveTo 276 106 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: MoveTo 303 106 self)
			)
			(2
				(gEgo loop: 3)
				(= cycles 1)
			)
			(3
				(HighPrint 95 17) ; "You move the chair in front of the door."
				(gEgo setPri: 7 setMotion: MoveTo 300 102 self)
				(chair setCel: 0 posn: 297 100)
			)
			(4
				(gEgo setMotion: MoveTo 297 98 self)
				(chair posn: 288 96)
			)
			(5
				(gEgo setMotion: MoveTo 300 110 self)
			)
			(6
				(NormalEgo)
				(if local3
					(gEgo illegalBits: -28672)
				)
				(= local2 1)
				(= local5 0)
				(brig4 dispose:)
				(brig5 dispose:)
				(brig6 dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pushCan of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local5
					(gEgo illegalBits: 0 setMotion: MoveTo 270 100 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setPri: 6 setMotion: MoveTo 274 92 self)
			)
			(2
				(gEgo illegalBits: 0 loop: 1)
				(= cycles 1)
			)
			(3
				(gEgo view: 510 setLoop: 1 setCel: 0 setPri: 6 posn: 272 91)
				(= cycles 1)
			)
			(4
				(gEgo setCel: 1 posn: 271 91)
				(= cycles 1)
			)
			(5
				(gEgo setCel: 2 posn: 267 91)
				(= cycles 1)
			)
			(6
				(gEgo setCel: 1 posn: 261 91)
				(candelabra setCel: 1)
				(= cycles 1)
			)
			(7
				(gEgo setCel: 0 posn: 256 91)
				(candelabra setCel: 2)
				(= cycles 1)
			)
			(8
				(gEgo view: 4 setLoop: 1 setCel: 0)
				(candelabra setCel: 3)
				(= cycles 1)
			)
			(9
				(candelabra setCel: 4)
				(NormalEgo)
				(if local3
					(gEgo illegalBits: -28672)
				)
				(= cycles 1)
			)
			(10
				(= local4 1)
				(= local5 0)
				(if local2
					(HandsOn)
					(self dispose:)
				else
					(brig4 setScript: brigandsEast)
				)
			)
		)
	)
)

(instance brigandsEast of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7 0)
				(rDoor setPri: 4 setCel: 1)
				(brig4
					show:
					setPri: 5
					illegalBits: 0
					ignoreActors: 1
					setCycle: Walk
					posn: 300 90
					setMotion: MoveTo 295 90 self
				)
			)
			(1
				(brig4 setMotion: MoveTo 282 100)
				(brig5
					init:
					setPri: 5
					illegalBits: 0
					ignoreActors: 1
					setCycle: Walk
					posn: 310 90
					setMotion: MoveTo 294 90 self
				)
			)
			(2
				(if (gEgo inRect: 50 108 230 124)
					(HandsOff)
					(gEgo loop: 0)
					(brig4 setPri: -1 setMotion: MoveTo 224 113)
					(brig5 setMotion: MoveTo 277 114 self)
					(brig6
						init:
						setPri: 5
						illegalBits: 0
						ignoreActors: 1
						setCycle: Walk
						posn: 310 90
						setMotion: MoveTo 294 90
					)
				else
					(self changeState: 5)
				)
			)
			(3
				(gEgo
					view: 525
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo 50 110
				)
				(brig4 ignoreActors: 0 setMotion: MoveTo 204 113)
				(brig5 setPri: -1 ignoreActors: 0 setMotion: MoveTo 268 111)
				(brig6 ignoreActors: 0 setMotion: MoveTo 287 102 self)
			)
			(4
				(brig6 setPri: -1 setMotion: MoveTo 253 104 self)
			)
			(5
				(EgoDead ; "There are still too many brigands for you to fight in here. You need to find some way to block one of the doors."
					95
					18
					82
					516
					0
					9
					80
					{You're half right but completely dead.}
				)
			)
		)
	)
)

