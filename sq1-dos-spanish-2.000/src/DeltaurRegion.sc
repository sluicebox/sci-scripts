;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 703)
(include sci.sh)
(use Main)
(use Interface)
(use RegionPath)
(use SQEgo)
(use RangeOsc)
(use PolyPath)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	DeltaurRegion 0
	proc703_1 1
	proc703_2 2
	sarienOfficer1 14
	sarienOfficer2 15
	sarienOfficer3 16
	sarienOfficer4 17
	shootTheEgo1 18
	gd1 21
	firePulsar 22
	countDown 23
)

(local
	[local0 31] = [32767 61 352 68 233 173 61 174 190 175 241 168 352 68 32767 62 -6 237 60 185 96 173 201 173 96 173 60 185 -6 237 -32768]
	[local31 47] = [32767 62 -5 77 179 77 103 120 32767 63 187 58 161 76 205 76 198 88 38 81 0 81 32767 61 319 79 121 79 121 67 146 46 32767 66 62 175 128 136 63 107 71 106 200 132 333 118 -32768]
	[local78 17] = [32767 60 -14 186 103 186 -14 186 32767 59 333 186 137 186 333 186 -32768]
	[local95 25] = [32767 60 0 79 130 79 151 53 293 52 151 53 130 79 0 79 32767 59 320 79 137 83 320 79 -32768]
	[local120 40]
	local160
	local161
	local162
	[local163 28] = [19 4 19 4 19 4 19 4 19 4 19 4 275 76 19 4 276 4 276 95 19 67 19 4 19 4 276 4]
	local191
	local192
	local193
	local194
	local195
	local196
	local197
	local198
)

(procedure (localproc_0 param1)
	(Display 703 0 dsRESTOREPIXELS local191)
	(Format @local120 703 1 (/ param1 60) (mod param1 60)) ; "%02u:%02u"
	(= local191
		(Display
			@local120
			dsCOORD
			(detonationWindow x:)
			(detonationWindow y:)
			dsCOLOR
			global142
			dsFONT
			2
			dsSAVEPIXELS
		)
	)
)

(procedure (localproc_1 param1)
	(if (IsObject param1)
		(return (param1 busy:))
	else
		(return 0)
	)
)

(procedure (proc703_2 param1 param2 param3 &tmp temp0 temp1)
	(if (< argc 2)
		(= temp0 gEgo)
	else
		(= temp0 param2)
	)
	(if (IsObject temp0)
		(= temp1 (GetAngle (param1 x:) (param1 y:) (temp0 x:) (temp0 y:)))
	else
		(= temp1 (GetAngle (param1 x:) (param1 y:) temp0 param3))
	)
	(cond
		((< temp1 44)
			(return 4)
		)
		((< temp1 134)
			(return 0)
		)
		((< temp1 179)
			(return 2)
		)
		((< temp1 224)
			(return 3)
		)
		((< temp1 314)
			(return 1)
		)
		((< temp1 359)
			(return 5)
		)
	)
)

(procedure (proc703_1 &tmp temp0)
	(switch (DeltaurRegion egoStatus:)
		(0
			(NormalEgo temp0 1 61) ; UNINIT
		)
		(1
			(NormalEgo temp0 416 65) ; UNINIT
		)
		(2
			(NormalEgo temp0 2 62) ; UNINIT
		)
	)
	(gEgo illegalBits: -32768)
)

(class RegionFeature of Feature
	(properties
		sightAngle 45
		level 0
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(self x: ((gUser curEvent:) x:) y: ((gUser curEvent:) y:))
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
					theInvItem:
						(and
							gTheIconBar
							(== (event message:) JOY_DOWNRIGHT)
							gInventory
							(gInventory indexOf: (gTheIconBar curInvIcon:))
						)
				)
				(event claimed: 1)
				(if
					(and
						(gUser canControl:)
						(!= _approachVerbs 26505)
						(& _approachVerbs (<< $0001 (- (event message:) 1)))
					)
					(gEgo
						setMotion:
							PolyPath
							approachX
							(+ (gEgo z:) approachY)
							CueObj
					)
				else
					(gEgo setMotion: 0)
					(CueObj changeState: 3)
				)
			)
		)
		(event claimed:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((and (< level 3) (!= global166 level))
						(if (== global166 2)
							(Print 703 2) ; "You can't see that from down here."
						else
							(Print 703 3) ; "You can't see that from up here."
						)
					)
					((not lookStr)
						(switch (mod (++ local195) 6)
							(0
								(Print 703 4) ; "You're darned if you can figure out what most of this stuff is for."
							)
							(1
								(Print 703 5) ; "What a perfectly useless-looking piece of decoration!"
							)
							(2
								(Print 703 6) ; "You are continually astonished by the Sarien decorative scheme."
							)
							(3
								(Print 703 7) ; "Interesting."
							)
							(4
								(Print 703 8) ; "Hmmm. Another one of those thingies."
							)
							(5
								(Print 703 9) ; "Just another one of those fascinating bits of alien hardware."
							)
							(6
								(Print 703 10) ; "Boy. These spaceship interior designers must be one strange lot."
							)
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(5 ; Talk
				(if (or (and (!= level 3) (!= global166 level)) (== level 4))
					(if (== global166 2)
						(Print 703 11) ; "You can't talk to that from down here."
					else
						(Print 703 12) ; "You can't talk to that from up here."
					)
				else
					(switch (mod (++ local198) 4)
						(0
							(Print 703 13) ; "This kind of behavior is likely to get you noticed by the Sariens."
						)
						(1
							(Print 703 14) ; "It doesn't talk back."
						)
						(2
							(Print 703 15) ; "If you keep talking to inanimate objects, you're bound to attract attention."
						)
						(3
							(Print 703 16) ; "You begin to get the feeling that talking to things that don't talk back is a serious waste of time."
						)
						(4
							(Print 703 17) ; "It looks at you in amazement. What kind animated object would talk to inanimates."
						)
					)
				)
			)
			(3 ; Do
				(if (or (and (!= level 3) (!= global166 level)) (== level 4))
					(if (== global166 2)
						(Print 703 18) ; "You can't do that from down here."
					else
						(Print 703 19) ; "You can't do that from up here."
					)
				else
					(switch (mod (++ local194) 5)
						(0
							(Print 703 20) ; "Never mind that now - you're in a hurry."
						)
						(1
							(Print 703 21) ; "You don't have time to stop and touch all this neat stuff - you've got a galaxy to save."
						)
						(2
							(Print 703 22) ; "You find you must fight the urge to dust and polish everywhere you go."
						)
						(3
							(Print 703 23) ; "You don't want to leave your fingerprints all over the ship, do you?"
						)
						(4
							(Print 703 24) ; "You can't imagine what you'd do with it."
						)
						(5
							(Print 703 25) ; "Try as you might, you can affect no change."
						)
					)
				)
			)
			(12 ; Smell
				(if (or (and (!= level 3) (!= global166 level)) (== level 4))
					(if (== global166 2)
						(Print 703 26) ; "You can't smell that from down here."
					else
						(Print 703 27) ; "You can't smell that from up here."
					)
				else
					(switch (mod (++ local197) 5)
						(0
							(Print 703 28) ; "The whole ship smells like Sariens."
						)
						(1
							(Print 703 29) ; "You can't smell anything beyond the general smell of Sariens, which is unpleasant. These guys definitely need a change in diet."
						)
						(2
							(Print 703 30) ; "An offensive smell permeates the entire ship."
						)
						(3
							(Print 703 31) ; "The Sariens smell so horrible it's hard to smell anything else."
						)
						(4
							(Print 703 32) ; "You get no clues from the smell."
						)
						(5
							(Print)
						)
					)
				)
			)
			(11 ; Taste
				(if (or (and (!= level 3) (!= global166 level)) (== level 4))
					(if (== global166 2)
						(Print 703 33) ; "You can't taste that from down here."
					else
						(Print 703 34) ; "You can't taste that from up here."
					)
				else
					(switch (mod (++ local196) 5)
						(0
							(Print 703 35) ; "Sarien cooties are everywhere."
						)
						(1
							(Print 703 36) ; "You really don't want to put your mouth on that."
						)
						(2
							(Print 703 37) ; "You can't imagine that's going to taste good."
						)
						(3
							(Print 703 38) ; "If it smells like Sariens, how good do you suppose it's going to taste?"
						)
						(4
							(Print 703 39) ; "Don't put that in your mouth - you don't know where it's been!"
						)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(12 ; Pulseray_Laser_Pistol
						(if
							(and
								(OneOf gCurRoomNum 59 60 62 61 63)
								(!= global166 level)
							)
							(Print 703 40) ; "You can't shoot that from here."
						else
							(= local193 0)
							(gEgo setScript: firePulsar)
						)
					)
					(13 ; Grenade
						(gEgo setScript: (ScriptID 707 0)) ; dropGrenade
					)
					(else
						(Print 703 41) ; "You can't use that here."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(class DeltaurRegion of Rgn
	(properties
		eDoor1 0
		eDoor2 0
		egoStatus 0
		numGrenades 2
		timesShownID 0
		theRoom 0
		timeToBlow 300
		timerWindow 0
		timeToBlowLast 0
	)

	(method (newRoom newRoomNumber)
		(gEgo ignoreActors: 1)
		(= keep (OneOf newRoomNumber 54 55 57 58 59 60 61 62 63 64 65 66 67))
		(= initialized 0)
		(if (OneOf newRoomNumber 53 54 55 57 58 64)
			(gLongSong fade:)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 703 42) ; "You're in another area of the Deltaur."
			)
			(4 ; Inventory
				(switch invItem
					(13 ; Grenade
						(if (!= gCurRoomNum 64)
							(gCurRoom setScript: (ScriptID 707 0)) ; dropGrenade
						)
					)
					(12 ; Pulseray_Laser_Pistol
						(if
							(and
								(not (gCurRoom script:))
								(not (OneOf gCurRoomNum 59 60 62 61 63))
							)
							(= local193 0)
							(gCurRoom setScript: firePulsar)
						else
							(super doVerb: theVerb invItem &rest)
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(= eDoor2 (= eDoor1 0))
		(if (OneOf gCurRoomNum 59 60 61 62 63 66)
			(LoadMany rsVIEW 69 417 66)
			(LoadMany rsTEXT 170)
		)
		(if (!= (DeltaurRegion egoStatus:) 1)
			(LoadMany rsVIEW 415 48 50 479)
		)
		(if (gEgo has: 12) ; Pulseray_Laser_Pistol
			(LoadMany rsVIEW 41 419 479)
		)
		(gFeatures add: pipes)
		(if (IsFlag 53)
			(LoadMany rsVIEW 3)
		)
		(if (gEgo has: 13) ; Grenade
			(LoadMany rsSOUND 518 519)
			(LoadMany rsVIEW 75)
		)
		(if (or (!= egoStatus 1) (gEgo has: 12)) ; Pulseray_Laser_Pistol
			(Load rsSOUND 312)
		)
		(if (OneOf gCurRoomNum 59 60 66 62)
			(gFeatures add: elevators)
			(LoadMany rsSOUND 315)
		)
		(if (OneOf gCurRoomNum 62 66)
			(gFeatures add: tubes)
		)
		(if (OneOf gCurRoomNum 59 60 62 61 63)
			(gFeatures add: upperLevel lowerLevel)
		)
		(gFeatures eachElementDo: #init doit:)
		(if (OneOf gCurRoomNum 61 62)
			(sarienOfficer1
				level: 2
				shootEgo: shootTheEgo1
				blastID: blast1
				regionPathID: guardPath1
				setMotion: guardPath1
				_head: sarienOfficer1Head
				init:
				activate:
			)
			(sarienOfficer1Head init: sarienOfficer1 setLoop: 8)
		)
		(if (OneOf gCurRoomNum 61 62 66 63)
			(sarienOfficer2
				level: 1
				shootEgo: shootTheEgo1
				blastID: blast1
				regionPathID: guardPath2
				setMotion: guardPath2
				_head: sarienOfficer2Head
				init:
				activate:
			)
			(sarienOfficer2Head init: sarienOfficer2 setLoop: 8)
		)
		(if (OneOf gCurRoomNum 60 59)
			(sarienOfficer3
				level: 2
				regionPathID: guardPath3
				shootEgo: shootTheEgo1
				blastID: blast1
				setMotion: guardPath3
				_head: sarienOfficer3Head
				init:
				activate:
			)
			(sarienOfficer3Head init: sarienOfficer3 setLoop: 8)
			(sarienOfficer4
				level: 1
				regionPathID: guardPath4
				shootEgo: shootTheEgo1
				blastID: blast1
				setMotion: guardPath4
				_head: sarienOfficer4Head
				init:
				activate:
			)
			(sarienOfficer4Head init: sarienOfficer4 setLoop: 8)
		)
		(if
			(and
				(!= (gLongSong number:) 508)
				(not (OneOf gCurRoomNum 53 54 55 57 58 64))
			)
			(gLongSong number: 508 loop: -1 hold: 0 flags: 1 play:)
		)
		(if (IsFlag 53)
			(detonationWindow
				x: [local163 (* (- gCurRoomNum 54) 2)]
				y: [local163 (+ (* (- gCurRoomNum 54) 2) 1)]
			)
			(detonationWindow init: stopUpd:)
		)
		(if (< gPrevRoomNum 50)
			(Print 703 43) ; "DEBUG *REMOVE* Teleport initialization."
			(if (== gCurRoomNum 54)
				(= egoStatus 0)
				(gEgo get: 4) ; Knife
			else
				(= egoStatus 1)
			)
			(proc703_1)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (IsFlag 53) (!= theRoom gCurRoomNum))
			(= theRoom gCurRoomNum)
			(self setScript: countDown)
			(= timeToBlowLast 0)
			(detonationWindow
				x: [local163 (* (- gCurRoomNum 54) 2)]
				y: [local163 (+ (* (- gCurRoomNum 54) 2) 1)]
			)
			(= local191
				(Display
					703
					44
					dsCOORD
					(detonationWindow x:)
					(detonationWindow y:)
					dsCOLOR
					global142
					dsFONT
					2
					dsSAVEPIXELS
				)
			)
		)
		(if (and (IsFlag 53) (!= timeToBlowLast timeToBlow))
			(localproc_0 (= timeToBlowLast timeToBlow))
		)
	)
)

(class sarienGuard of Actor
	(properties
		description {sarien officer}
		lookStr {It's one of the Sarien gaurds.}
		view 417
		cycleSpeed 6
		xStep 4
		moveSpeed 6
		guardLocked 0
		regionPathID 0
		level 0
		shotsFired 0
		dead 0
		guardSalutes 0
		shootEgo 0
		gd 0
		lastLoop 0
		blastID 0
		_head 0
		normal 1
		moveHead 1
	)

	(method (headView param1)
		(_head view: param1)
		(if (not (& (_head signal:) $0008))
			(_head showSelf:)
		)
	)

	(method (dispose)
		(if _head
			(_head dispose:)
		)
		(super dispose:)
	)

	(method (stopUpd)
		(if _head
			(_head stopUpd:)
		)
		(super stopUpd:)
	)

	(method (hide)
		(if _head
			(_head hide:)
		)
		(super hide:)
	)

	(method (pushToNextRoom)
		(if regionPathID
			(while
				(and
					(!= (regionPathID at: (+ (regionPathID value:) 1)) 32767)
					(not (regionPathID atEnd:))
				)
				(regionPathID next:)
			)
			(_head dispose:)
			(regionPathID moveDone:)
			(self activate:)
		)
	)

	(method (inSameRoom)
		(if regionPathID
			(return (== gCurRoomNum (regionPathID currentRoom:)))
		else
			(return 1)
		)
	)

	(method (setToBeginning)
		(if regionPathID
			(regionPathID value: -1)
			(self activate: 1)
		)
	)

	(method (activate param1 &tmp temp0)
		(if argc
			(= temp0 param1)
		else
			(= temp0 1)
		)
		(if (IsObject blastID)
			(blastID dispose:)
		)
		(if (== script shootEgo)
			(shootEgo dispose:)
		)
		(if temp0
			(if (IsObject _head)
				(= moveHead 1)
				(_head init: self)
			)
			(self
				loop: lastLoop
				dead: 0
				ignoreActors: 0
				show:
				view: 417
				setStep: 4 2
				moveSpeed: 6
				cycleSpeed: 6
				setLoop: -1
				setCycle: StopWalk 66
				setLoop: Grooper
				setMotion: regionPathID
				shotsFired: 0
				setScript: 0
			)
		else
			(self hide: setMotion: 0)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(if (== level global166)
					(switch invItem
						(12 ; Pulseray_Laser_Pistol
							(= local193 self)
							(gEgo setScript: firePulsar)
						)
						(0 ; Cartridge
							(Print 703 45) ; "You don't really want to show an Arcada data cartridge to the guys who blew the ship to smithereens."
						)
						(19 ; Sarien_ID_Card
							(Print 703 46) ; "He seems satisfied that you're a Sarien, all right."
						)
						(else
							(super doVerb: theVerb invItem &rest)
						)
					)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(5 ; Talk
				(cond
					((and (== gCurRoomNum 66) (not regionPathID))
						(if (== (DeltaurRegion egoStatus:) 1)
							(self setScript: (ScriptID 705 0)) ; launchBayScript
						else
							(Print 703 47) ; "Are you crazy! You haven't got time to talk to this guy. He's too busy doing his talking with his gun."
						)
					)
					(
						(and
							(< (gEgo distanceTo: self) 35)
							(== (self level:) global166)
						)
						((ScriptID 705 1) ; printGuard
							register: (= local192 (mod (++ local192) 5))
						)
						(self setScript: (ScriptID 705 1)) ; printGuard
					)
					(else
						(Print 703 48) ; "You're not close enough to talk to the guard."
					)
				)
			)
			(2 ; Look
				(if (== global166 level)
					(Print 703 49) ; "It's just another one of those ugly Sarien guards."
				else
					(Print 703 50) ; "You can't do that from here."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		(self setCycle: StopWalk 66 setLoop: Grooper)
		(super init: &rest)
	)

	(method (doit)
		(cond
			((and (self inSameRoom:) (> 280 x 40) (> 190 y 10))
				(if (& signal $4000)
					(self ignoreActors: 0)
				)
				(cond
					(
						(and
							(not script)
							regionPathID
							(== view 66)
							(> (self distanceTo: gEgo) 35)
						)
						(self guardSalutes: 0 activate:)
					)
					((and (OneOf gCurRoomNum 63 61) (< y 71)) 0)
					(
						(and
							(not guardLocked)
							(not script)
							(== level global166)
							(not (gEgo script:))
							(not (localproc_1 (DeltaurRegion eDoor1:)))
							(not (localproc_1 (DeltaurRegion eDoor2:)))
							(not dead)
							(!= (DeltaurRegion egoStatus:) 1)
							(not (gCurRoom script:))
						)
						(self setScript: shootEgo)
					)
					(
						(and
							(not guardLocked)
							(not (gEgo script:))
							(not script)
							(not (localproc_1 (DeltaurRegion eDoor1:)))
							(not (localproc_1 (DeltaurRegion eDoor2:)))
							(not dead)
							(not (gCurRoom script:))
							regionPathID
							(== (DeltaurRegion egoStatus:) 1)
							(not guardSalutes)
							(== level global166)
							(< (self distanceTo: gEgo) 35)
						)
						(self guardSalutes: 1 setScript: saluteScript)
					)
					(
						(and
							(not guardLocked)
							regionPathID
							guardSalutes
							(> (self distanceTo: gEgo) 40)
						)
						(self guardSalutes: 0 activate:)
					)
					((and regionPathID (!= global166 level) (== view 415))
						(self guardSalutes: 0 activate:)
					)
				)
			)
			((not (& signal $4000))
				(self ignoreActors: 1)
			)
		)
		(super doit: &rest)
	)
)

(instance detonationWindow of View
	(properties
		view 3
		priority 15
		signal 16
	)

	(method (init)
		(self view: (proc0_19 3 1003 3 3 3))
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 703 51) ; "It's the amount of time remaining before you're pushin' up daisies, Roger!!!!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sarienOfficer1 of sarienGuard
	(properties)
)

(instance sarienOfficer2 of sarienGuard
	(properties)
)

(instance sarienOfficer3 of sarienGuard
	(properties)
)

(instance sarienOfficer4 of sarienGuard
	(properties)
)

(instance sarienOfficer1Head of Head
	(properties
		description {sarien officer}
		lookStr {It's a Sarien officer.}
		view 66
		cycleSpeed 210
	)

	(method (doVerb theVerb invItem)
		(sarienOfficer1 doVerb: theVerb invItem)
	)
)

(instance sarienOfficer2Head of Head
	(properties
		description {sarien officer}
		lookStr {It's a Sarien officer.}
		view 66
		cycleSpeed 210
	)

	(method (doVerb theVerb invItem)
		(sarienOfficer2 doVerb: theVerb invItem)
	)
)

(instance sarienOfficer3Head of Head
	(properties
		description {sarien officer}
		lookStr {It's a Sarien officer.}
		view 66
		cycleSpeed 210
	)

	(method (doVerb theVerb invItem)
		(sarienOfficer3 doVerb: theVerb invItem)
	)
)

(instance sarienOfficer4Head of Head
	(properties
		description {sarien officer}
		lookStr {It's a Sarien officer.}
		view 66
		cycleSpeed 210
	)

	(method (doVerb theVerb invItem)
		(sarienOfficer4 doVerb: theVerb invItem)
	)
)

(instance blast of Prop
	(properties
		view 479
		loop 15
		priority 15
		signal 16400
		cycleSpeed 6
	)
)

(instance blast1 of Prop
	(properties
		view 479
		loop 15
		priority 15
		signal 16400
		cycleSpeed 6
	)
)

(instance guardPath1 of RegionPath
	(properties
		theRegion 703
	)

	(method (at param1)
		(return [local0 param1])
	)

	(method (doit)
		(super doit: &rest)
		(if (and (sarienOfficer1 inSameRoom:) (== gCurRoomNum 61))
			(cond
				(
					(and
						(<= (sarienOfficer1 y:) 145)
						(!= (sarienOfficer1 priority:) 2)
					)
					(sarienOfficer1 guardLocked: 1 setPri: 2)
				)
				(
					(and
						(> (sarienOfficer1 y:) 145)
						(== (sarienOfficer1 priority:) 2)
					)
					(sarienOfficer1 guardLocked: 0 setPri: -1)
				)
			)
		)
	)
)

(instance guardPath2 of RegionPath
	(properties
		theRegion 703
	)

	(method (at param1)
		(return [local31 param1])
	)
)

(instance guardPath3 of RegionPath
	(properties
		theRegion 703
	)

	(method (at param1)
		(return [local78 param1])
	)
)

(instance guardPath4 of RegionPath
	(properties
		theRegion 703
	)

	(method (at param1)
		(return [local95 param1])
	)
)

(instance shootTheEgo1 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (not (client regionPathID:))
					(client cel: 0 setMotion: 0 view: 415)
				)
				(client setLoop: (proc703_2 client gEgo))
				(= ticks 18)
			)
			(1
				(if (< (+ (client shotsFired:) 1) 5)
					(client shotsFired: (+ (client shotsFired:) 1))
					(= register 0)
				else
					(= register 1)
					(HandsOff)
				)
				(if (== (client view:) 415)
					(sarienShot play:)
					(client cel: (- (client lastCel:) 2) setCycle: End self)
				else
					(client view: 415 setMotion: 0 cel: 0 setCycle: End self)
				)
			)
			(2
				(if register
					(= temp0 (gEgo x:))
					(= temp1 (- (gEgo y:) 35))
				else
					(switch (Random 1 2)
						(1
							(= temp0 (- (gEgo nsLeft:) (Random 1 5)))
						)
						(2
							(= temp0 (+ (gEgo nsRight:) (Random 1 5)))
						)
					)
					(switch (Random 1 2)
						(1
							(= temp1 (- (gEgo nsTop:) (Random 1 5)))
						)
						(2
							(= temp1 (+ (gEgo nsBottom:) (Random 1 5)))
						)
					)
				)
				((client blastID:) init:)
				(if (OneOf (client loop:) 0 2 4)
					((client blastID:) setLoop: 1)
				else
					((client blastID:) setLoop: 2)
				)
				((client blastID:)
					ignoreActors: 1
					view: 479
					posn: temp0 temp1
					cel: 0
					setCycle: End self
				)
			)
			(3
				((client blastID:) dispose:)
				(= local161 (client x:))
				(if (and register (not (gEgo script:)))
					(gCurRoom setScript: (ScriptID 707 1)) ; egoShot
				)
				(= seconds 2)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance firePulsar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local193
					(= local160 (local193 x:))
					(= local162 (- (local193 y:) 30))
				else
					(= local160 ((gUser curEvent:) x:))
					(= local162 ((gUser curEvent:) y:))
				)
				(if local193
					(local193 setMotion: 0)
				)
				(Face gEgo local160 local162 self)
			)
			(1
				(cond
					((== (DeltaurRegion egoStatus:) 1)
						(if (OneOf (gEgo loop:) 0 4 6 3)
							(gEgo setLoop: 6)
						else
							(gEgo setLoop: 7)
						)
					)
					((> (gEgo loop:) 3)
						(gEgo setLoop: (- (gEgo loop:) 2))
					)
					(else
						(switch (gEgo loop:)
							(2
								(if (> (gEgo x:) local160)
									(gEgo setLoop: 3)
								)
							)
							(3
								(if (> (gEgo x:) local160)
									(gEgo setLoop: 5)
								else
									(gEgo setLoop: 4)
								)
							)
						)
					)
				)
				(gEgo view: 41 cel: 0 setCycle: CT 1 1 self)
			)
			(2
				(gSoundEffects number: 312 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(if (not local193)
					(if (OneOf (gEgo loop:) 0 2 4)
						(blast setLoop: 1)
					else
						(blast setLoop: 2)
					)
					(blast
						init:
						startUpd:
						ignoreActors: 1
						view: 479
						posn: local160 local162
						cel: 0
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(4
				(blast dispose:)
				(if local193
					(local193 setScript: gd1 self)
				else
					(self cue:)
				)
			)
			(5
				(= register (gEgo loop:))
				(proc703_1)
				(gEgo loop: register)
				(= local193 0)
				(= ticks 18)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance gd1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 3 169)
				(client
					looper: 0
					setCycle: 0
					setLoop: (proc703_2 client)
					setMotion: 0
				)
				(= register 0)
				(if (IsObject (client blastID:))
					((client blastID:) dispose:)
				)
				(client view: 419 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(gSoundEffects number: 368 loop: 1 play:)
				(client setCycle: RangeOsc 2 3 4 self)
			)
			(2
				(client setCycle: RangeOsc 2 5 6 self)
			)
			(3
				(if (local193 regionPathID:)
					(client pushToNextRoom: init: activate:)
				else
					(client dead: 1)
					(client dispose:)
				)
				(= ticks 18)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance countDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DeltaurRegion timeToBlow: (- (DeltaurRegion timeToBlow:) 1))
				(if (== (DeltaurRegion timeToBlow:) 20)
					(Print 703 52) ; "You'd better hurry up, Roger! You've got 20 seconds before you're turned into such tiny particles that they couldn't find you with an ion microscope."
				)
				(if (> (DeltaurRegion timeToBlow:) 0)
					(-- state)
				)
				(= seconds 1)
			)
			(1
				(SetFlag 54)
				(gCurRoom newRoom: 71)
			)
		)
	)
)

(instance saluteScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((client _head:) view: 66 setLoop: 8 cel: 0)
				(client lastLoop: (client loop:))
				(if (< (gEgo x:) (client x:))
					(client loop: 1)
				else
					(client loop: 0)
				)
				(client
					view: 69
					show:
					guardSalutes: 1
					setMotion: 0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(= ticks 300)
			)
			(2
				(client activate:)
				(self dispose:)
			)
		)
	)
)

(instance pipes of RegionFeature
	(properties
		description {pipes}
		onMeCheck 128
		level 3
	)

	(method (init)
		(= lookStr 0)
		(super init: &rest)
	)

	(method (doVerb)
		(if (not lookStr)
			(= lookStr
				{Like everything around here, the pipes are extremely colorful. It makes you wonder if the Sariens got a good deal on paint.}
			)
		else
			(= lookStr {Yep. More pipes.})
		)
		(super doVerb: &rest)
	)
)

(instance elevators of RegionFeature
	(properties
		description {elevator}
		onMeCheck 256
		level 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 703 53) ; "An elevator shaft runs up through the ceiling and down through the floor."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tubes of RegionFeature
	(properties
		description {access tubes}
		onMeCheck 512
		level 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 703 54) ; "This is a hallway access tube leading to another part of the Deltaur."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance upperLevel of RegionFeature
	(properties
		description {upper level}
		onMeCheck 16
		level 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 703 55) ; "You are on the upper level of one of the hallways on the Deltaur."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lowerLevel of RegionFeature
	(properties
		description {lower level}
		onMeCheck 32
		level 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 703 56) ; "You are on the lower level of one of the hallways on the Deltaur."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sarienShot of Sound
	(properties
		number 312
	)
)

