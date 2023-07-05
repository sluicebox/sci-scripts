;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 74)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room74 0
)

(synonyms
	(stair upstair)
	(fifi person woman)
	(decanter bottle)
	(armoire armoire closet)
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
)

(procedure (localproc_0)
	(if local7
		(= local7 0)
		(= global61 0)
		(DrawPic 174 3 1 0)
		(DrawPic 74 3 0 0)
		(if (and (>= gAct 2) (< gAct 5))
			(gAddToPics add: glasses)
			(Room74 setFeatures: glasses)
		)
		(if (>= gAct 2)
			(gAddToPics add: decanter)
			(Room74 setFeatures: decanter)
		)
		(gAddToPics
			add:
				wardrobe
				sofa
				table1
				mirror
				chair1
				chair2
				table2
				phono
				bed
				photo
			eachElementDo: #init
			doit:
		)
		(Room74
			setFeatures:
				sofa
				table1
				mirror
				wardrobe
				chair1
				chair2
				table2
				bed
				photo
				phono
		)
		(gCast eachElementDo: #show)
	)
)

(procedure (localproc_1)
	(if (not local7)
		(= local7 1)
		(= global61 1)
		(DrawPic 174 2 1 1)
		(gAddToPics dispose:)
		(gFeatures dispose:)
		(gCast eachElementDo: #hide)
		(DrawPic 74 2 0 0)
		(door show:)
		(lamp2 show:)
		(gEgo show:)
	)
)

(instance Room74 of Rm
	(properties
		picture 74
		curPic 74
	)

	(method (init)
		(= south 47)
		(= west 76)
		(= local8 (DoSound sndVOLUME))
		(Load rsPIC 174)
		(Load rsPIC 74)
		(super init:)
		(= global57 174)
		(cond
			((== gPrevRoomNum 47)
				(gEgo setPri: -1 posn: 42 187)
			)
			((!= gPrevRoomNum 64)
				(gEgo posn: 6 98)
			)
			(else
				(= local8 (DoSound sndVOLUME))
			)
		)
		(door loop: (if (> gPrevRoomNum 74) 3 else 6))
		(if (and (>= gAct 2) (< gAct 5))
			(gAddToPics add: glasses)
			(self setFeatures: glasses)
		)
		(if (>= gAct 2)
			(if (< gAct 6)
				(gAddToPics add: decanter)
				(self setFeatures: decanter)
			)
			(if (and (& gCorpseFlags $0040) (not (gEgo has: 5))) ; Lillian, skeleton_key
				(door cel: (door lastCel:) ignoreActors: 1)
				(|= global117 $8000)
			)
		)
		(Load rsVIEW 56)
		(LoadMany rsSOUND 43 48)
		(if gDetailLevel
			(lamp1 setPri: 11 setCycle: Fwd ignoreActors: 1 init:)
			(lamp2 setPri: 13 setCycle: Fwd ignoreActors: 1 init:)
		else
			(lamp1 setPri: 11 ignoreActors: 1 init: stopUpd:)
			(lamp2 setPri: 13 ignoreActors: 1 init: stopUpd:)
		)
		(if (& global117 $8000)
			(door loop: 6 cel: 3)
		)
		(door setPri: 7 ignoreActors: 1 init: stopUpd:)
		(Tswing setPri: 6 ignoreActors: 1 init: stopUpd:)
		(Bswing setPri: 8 ignoreActors: 1 init: stopUpd:)
		(= global373 record)
		(switch gAct
			(1
				(if (== global126 1)
					(self setRegions: 244) ; fifiprim
				)
			)
			(2
				(self setRegions: 261) ; kissact3
			)
			(4
				(= local4 1)
				(Load rsSOUND 223)
				(= local5 gConMusic)
				(LoadMany rsMESSAGE 243 371)
				(LoadMany rsVIEW 474 928)
				(= global208 16)
				(= [global377 4] 371)
				(if (or (== gPrevRoomNum 64) (>= gFifiState 64))
					(if (== gFifiState 64)
						(Load rsVIEW 471)
						(Fifi view: 471 posn: 271 104 loop: 1 init:)
						(self setScript: finishDress)
					else
						(Fifi
							view: 474
							setPri: 13
							illegalBits: 0
							posn: 242 128
							loop: 0
							cycleSpeed: 2
							init:
						)
						(FifiButt setPri: 14 init: stopUpd:)
						(= local10 1)
						(self setScript: primp)
					)
				else
					(Fifi
						view: 462
						loop: 0
						cel: 0
						illegalBits: 0
						posn: 118 76
						init:
						hide:
					)
				)
			)
			(5
				(if (and (not (& gCorpseFlags $0010)) (not (& gCorpseFlags $0040))) ; Jeeves & Fifi, Lillian
					(= local4 1)
					(self setRegions: 273) ; Dfifi
					(flowers init: stopUpd:)
				)
			)
		)
		(if (== gPrevRoomNum 64)
			(= local7 1)
			(localproc_0)
		else
			(localproc_1)
		)
		(if (not (& global117 $8000))
			(gEgo illegalBits: -32760)
		else
			(gEgo illegalBits: -32768)
		)
		(gEgo view: 0 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(if (== gPrevRoomNum 47)
				(Print 74 0) ; "The stairs lead to a third level of the house. There is a doorway in front of you, and another to the right."
			else
				(Print 74 1) ; "You are in the east wing of the attic. There is an attic door before you."
			)
		)
		(super doit:)
		(if
			(or
				(and (& (gEgo onControl: 0) $0008) (& gCorpseFlags $0040)) ; Lillian
				(& (gEgo onControl: 0) $0002)
			)
			(ClearFlag 46)
			(gCurRoom newRoom: 75)
		)
		(cond
			((gEgo inRect: -10 0 58 100)
				(= local2 3)
			)
			((gEgo inRect: 0 100 64 200)
				(if (!= local2 1)
					(= local2 1)
					(localproc_1)
					(DoSound sndVOLUME 0)
					(Room74 picture: 74)
				)
			)
			(else
				(= local2 2)
				(DoSound sndVOLUME local8)
				(localproc_0)
				(if (not global100)
					(= global100 1)
					(Print 74 2) ; "This must be Fifi's room. Although her room is in the attic, she has fixed it up nicely."
				)
				(if (and (== gAct 4) (< gFifiState 64) (not local6))
					(++ local6)
					(HandsOff)
					(SetFlag 20)
					(self setScript: startDress)
				)
			)
		)
		(if (and (& (gEgo onControl: 1) $0010) (== local0 0))
			(= local0 1)
			(Tswing cel: 1 forceUpd:)
			(Bswing cel: 1 forceUpd:)
		)
		(if (& (gEgo onControl: 1) $4000)
			(= local3 1)
			(gEgo setPri: 5)
		else
			(= local3 0)
			(gEgo setPri: -1)
		)
		(if (and (& (gEgo onControl: 1) $0020) (== local0 0))
			(= local0 1)
			(Tswing cel: 3 forceUpd:)
			(Bswing cel: 3 forceUpd:)
		)
		(if
			(and
				(or
					(& (gEgo onControl: 1) $0001)
					(& (gEgo onControl: 1) $4000)
				)
				(== local0 1)
			)
			(Tswing setCycle: End)
			(Bswing setCycle: End)
			(= local0 0)
		)
		(cond
			((< (gEgo x:) 58)
				(= vertAngle 0)
			)
			((< (gEgo x:) 180)
				(= vertAngle 157)
			)
			(else
				(= vertAngle 140)
			)
		)
	)

	(method (dispose)
		(DisposeScript 985)
		(DisposeScript 983)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (and (== local5 gConMusic) (!= newRoomNumber 64))
			(local5 stop:)
		)
		(Wait 1)
		(Wait 10)
		(= global190 0)
		(DoSound sndVOLUME local8)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(DisposeScript 990)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(if
				(and
					(> (gEgo x:) 64)
					global208
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
				(if (event claimed:)
					(return 1)
				)
			)
			(if (Said 'look>')
				(cond
					((Said '/room<dressing')
						(if (and (not local7) 2)
							(Print 74 3) ; "You can see Fifi's dressing room behind a set of small, swinging doors."
						else
							(NotHere) ; "You don't see it here."
						)
					)
					((Said '/bedroom')
						(if 2
							(Print 74 2) ; "This must be Fifi's room. Although her room is in the attic, she has fixed it up nicely."
						else
							(Print 74 4) ; "You see a bedroom through the doorway."
						)
					)
					((Said '[<around,at][/room]')
						(cond
							(local3
								(Print 74 5) ; "This is a small dressing room. You notice a pile of clothes on the floor."
							)
							((== local2 1)
								(Print 74 0) ; "The stairs lead to a third level of the house. There is a doorway in front of you, and another to the right."
							)
							((== local2 3)
								(Print 74 1) ; "You are in the east wing of the attic. There is an attic door before you."
							)
							((and (not (& gCorpseFlags $0010)) (== gAct 5)) ; Jeeves & Fifi
								(|= gCorpseFlags $0010) ; Jeeves & Fifi
								(Print 74 6) ; "OH! This is terrible!! Fifi and Jeeves are sitting together on the sofa...DEAD!"
							)
							(else
								(Print 74 2) ; "This must be Fifi's room. Although her room is in the attic, she has fixed it up nicely."
							)
						)
					)
					((or (Said '<down') (Said '/downstair'))
						(cond
							((== local2 1)
								(Print 74 7) ; "The stairs lead down to the second level of the mansion."
							)
							(local3
								(Print 74 5) ; "This is a small dressing room. You notice a pile of clothes on the floor."
							)
							(local4
								(Print 74 8) ; "Fifi and Jeeves are lying DEAD on the floor with their spilled drinks."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((or (Said '<up') (Said '/stair'))
						(if (== local2 1)
							(Print 74 0) ; "The stairs lead to a third level of the house. There is a doorway in front of you, and another to the right."
						else
							(event claimed: 0)
						)
					)
					((Said '/dormer')
						(if (== local2 2)
							(Print 74 9) ; "Fifi's dressing room is in the small dormer off her bedroom."
						else
							(event claimed: 0)
						)
					)
					((Said '/attic')
						(if (!= local2 3)
							(Print 74 10) ; "You can't see the attic from here."
						else
							(Print 74 11) ; "You are in the east wing of the attic. There is an attic door before you."
						)
					)
					((Said '<below/carpet')
						(if (== local2 2)
							(Print 74 12) ; "Fifi is very clean. There is no dirt under her rug."
						else
							(event claimed: 0)
						)
					)
					((Said '/window')
						(if (== local2 2)
							(Print 74 13) ; "There is just one small window in the dressing room."
						else
							(event claimed: 0)
						)
					)
					((Said '/curtain')
						(if (== local2 2)
							(Print 74 14) ; "You see a flimsy shade on the window in the dressing room."
						else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

(instance startDress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(record setCycle: Fwd init:)
				(if (!= gPrevRoomNum 64)
					(local5 number: 223 loop: -1 play:)
				)
				(Fifi show: view: 462 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(Fifi loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(Fifi view: 460 setCycle: Walk setMotion: MoveTo 227 107 self)
			)
			(3
				(Tswing cel: 1 forceUpd:)
				(Bswing cel: 1 forceUpd:)
				(Fifi setMotion: MoveTo 241 107 self)
			)
			(4
				(Tswing cel: 0 forceUpd:)
				(Bswing cel: 0 forceUpd:)
				(Fifi setMotion: MoveTo 271 107 self)
			)
			(5
				(gCurRoom newRoom: 64)
			)
		)
	)
)

(instance finishDress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(record setCycle: Fwd init:)
				(= gFifiState 74)
				(Fifi setCycle: Walk setMotion: MoveTo 245 107 self)
			)
			(1
				(Tswing cel: 3 forceUpd:)
				(Bswing cel: 3 forceUpd:)
				(Fifi setMotion: MoveTo 225 110 self)
			)
			(2
				(Tswing cel: 0 forceUpd:)
				(Bswing cel: 0 forceUpd:)
				(Fifi setMotion: MoveTo 175 110 self)
			)
			(3
				(Fifi setMotion: MoveTo 181 151 self)
			)
			(4
				(Fifi illegalBits: 0 setMotion: MoveTo 250 156 self)
			)
			(5
				(Fifi setScript: primp)
				(client setScript: 0)
			)
		)
	)
)

(instance primp of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (!= gPrevRoomNum 64) local10)
			(if (> (gEgo x:) 65)
				(= local10 0)
				(local5 number: 223 loop: -1 play:)
				(record setCycle: Fwd init:)
			else
				(local5 stop:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(Fifi
					view: 474
					setPri: 13
					illegalBits: 0
					posn: 242 128
					loop: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(FifiButt setPri: 14 init: stopUpd:)
			)
			(1
				(Fifi loop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(Fifi loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(Fifi loop: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(Fifi loop: 0 cel: 1 setCycle: Beg self)
			)
			(5
				(= seconds 8)
				(= state 12)
			)
			(6
				(Fifi loop: 4 cel: 0 setCycle: End self)
			)
			(7
				(Fifi loop: 5 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(8
				(Fifi loop: 4 cel: 1 setCycle: Beg self)
			)
			(9
				(= seconds 8)
				(= state 12)
			)
			(10
				(Fifi loop: 6 cel: 0 setCycle: End self)
			)
			(11
				(Fifi loop: 7 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(12
				(Fifi loop: 6 cel: 1 setCycle: Beg self)
			)
			(13
				(if local9
					(switch (Random 1 3)
						(1
							(= state -1)
						)
						(2
							(= state 5)
						)
						(3
							(= state 9)
						)
					)
				)
				(= seconds 6)
			)
			(14
				(++ local9)
				(Fifi view: 478 loop: 0 cel: 0 setCycle: End self)
			)
			(15
				(Fifi loop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(16
				(Fifi loop: 2 cel: 0 setCycle: End self)
			)
			(17
				(Fifi loop: 3 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(18
				(Fifi loop: 2 cel: 3 setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance knockDoor of Script
	(properties)

	(method (doit)
		(if (== (myMusic prevSignal:) 11)
			(DoSound sndVOLUME 0)
			(= cycles 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myMusic prevSignal: 0)
				(HandsOff)
				(gEgo view: 56 loop: 0 setCycle: End self)
			)
			(1
				(myMusic number: 48 loop: 1 priority: 15 play:)
				(DoSound sndVOLUME local8)
				(gEgo loop: 2 setCycle: Fwd)
			)
			(2
				(Print 74 15) ; "You soundly knock on the attic door. There is no reply."
				(gEgo view: 56 loop: 0 cel: 3 setCycle: Beg self)
			)
			(3
				(HandsOn)
				(gEgo view: 0 setCycle: Walk loop: 3)
				(client setScript: 0)
			)
		)
	)
)

(instance wardrobe of RPicView
	(properties
		y 78
		x 84
		view 174
		loop 2
		cel 2
		priority 4
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/armoire')
				(Print 74 16) ; "There is nothing there for you."
			)
			((or (MousedOn self event 3) (Said 'look/armoire'))
				(event claimed: 1)
				(Print 74 17) ; "Fifi has an old armoire in the back corner of her room."
			)
		)
	)
)

(instance sofa of RPicView
	(properties
		y 78
		x 138
		view 174
		loop 2
		cel 1
		priority 3
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {couch})
		)
	)
)

(instance table1 of RPicView
	(properties
		y 79
		x 192
		view 174
		loop 2
		cel 7
		priority 3
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 74 18) ; "Some of these tables could use a good dusting!"
		)
	)
)

(instance bed of RPicView
	(properties
		y 142
		x 232
		view 174
		loop 2
		priority 10
	)

	(method (handleEvent event)
		(cond
			((Said 'look<below/bed')
				(Print 74 19) ; "There's only the floor under her bed."
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(DoLook {bed})
			)
		)
	)
)

(instance mirror of RPicView
	(properties
		y 158
		x 268
		view 174
		loop 2
		cel 3
		priority 12
	)

	(method (handleEvent event)
		(cond
			((or (Said 'look<in/mirror') (Said 'look/reflection'))
				(if (< (gEgo distanceTo: mirror) 80)
					(= global213 12)
					(Say 0 74 20) ; "You gaze into the mirror and appraise your appearance. A bit disheveled, perhaps, but not bad...considering the circumstances."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said 'look<(behind,below)/mirror')
				(Print 74 21) ; "There is nothing of interest behind the mirror."
			)
			((Said 'look/mirror')
				(Print 74 22) ; "The oval-framed mirror is attached to the vanity."
			)
			((Said 'get/mirror')
				(Print 74 23) ; "The mirror is firmly attached to the wall."
			)
			((Said 'open,(look<in)/vanity,drawer,(nightstand<dressing)')
				(if (== local2 2)
					(Print 74 24) ; "You don't need to get into Fifi's private things."
				else
					(event claimed: 0)
				)
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/vanity,(nightstand<dressing)')
				)
				(if (== local2 2)
					(Print 74 25) ; "Fifi has a little vanity by the bed."
					(event claimed: 1)
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance chair1 of RPicView
	(properties
		y 157
		x 245
		view 174
		loop 2
		cel 8
		priority 11
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair2 of RPicView
	(properties
		y 157
		x 101
		view 174
		loop 2
		cel 5
		priority 11
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance table2 of RPicView
	(properties
		y 157
		x 140
		view 174
		loop 2
		cel 7
		priority 11
	)

	(method (handleEvent event)
		(if
			(and
				(>= gAct 2)
				(< gAct 6)
				(or (MousedOn self event 3) (Said 'look/nightstand'))
			)
			(if (== gAct 5)
				(if local4
					(Print 74 26) ; "Some flowers and a decanter of cognac sit on the table."
				else
					(Print 74 27) ; "A decanter of cognac sits on the table."
				)
			else
				(Print 74 28) ; "Two glasses sit on the table near the cognac decanter."
			)
			(event claimed: 1)
		)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance glasses of RPicView
	(properties
		y 141
		x 142
		view 174
		loop 2
		cel 4
		priority 14
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((Said 'get/glass')
				(Print 74 29) ; "You don't care for liquor...remember?"
			)
			((Said 'look<in/glass')
				(Print 74 30) ; "The glasses are empty."
			)
			((or (Said 'look/glass') (MousedOn self event 3))
				(event claimed: 1)
				(Print 74 28) ; "Two glasses sit on the table near the cognac decanter."
			)
		)
	)
)

(instance decanter of RPicView
	(properties
		y 141
		x 130
		view 174
		loop 2
		cel 9
		priority 14
		signal 16384
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(Said 'look<use<monocle/decanter')
					(Said 'look,(look<at)/decanter/monocle<with')
					(Said 'look/fingerprint')
				)
				(if (gEgo has: 1) ; monocle
					(if (< (gEgo distanceTo: table2) 20)
						(if (< gAct 5)
							(Print 74 31 #icon 635 0 0) ; "Bending over the cognac decanter you carefully examine it with the monocle. Yes! Here is a clear fingerprint!"
						else
							(Print 74 32 #icon 635 0 2) ; "Bending over the cognac decanter you carefully examine it with the monocle. Yes! Here are two clear fingerprints!"
						)
						(SetFlag 11)
						(SetFlag 30)
					else
						(NotClose) ; "You're not close enough."
					)
				else
					(DontHave) ; "You don't have it."
				)
			)
			(
				(or
					(Said 'drink/[<alcohol]')
					(Said 'drink,pour,get/decanter,alcohol')
					(Said 'open,get/decanter,alcohol')
				)
				(if (and local4 (== gAct 5))
					(Print 74 33) ; "You want nothing to do with the cognac!"
				else
					(Print 74 29) ; "You don't care for liquor...remember?"
				)
			)
			((Said 'look<in/decanter,alcohol')
				(if (>= gAct 5)
					(Print 74 34) ; "A strange white powder has collected in the bottom of the cognac decanter."
				else
					(Print 74 35) ; "The decanter is half-filled with cognac."
				)
			)
			((or (Said 'look/decanter,alcohol') (MousedOn self event 3))
				(SetFlag 30)
				(if (>= gAct 5)
					(Print 74 34) ; "A strange white powder has collected in the bottom of the cognac decanter."
				else
					(Print 74 36) ; "Looks like fine cognac."
				)
				(event claimed: 1)
			)
		)
	)
)

(instance photo of RPicView
	(properties
		y 40
		x 138
		view 174
		loop 2
		cel 6
		priority 4
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {picture})
		)
	)
)

(instance phono of RPicView
	(properties
		y 62
		x 191
		view 174
		loop 2
		cel 11
		priority 4
	)

	(method (handleEvent event)
		(cond
			((Said 'stop,(rotate<off)/record,gramophone')
				(if (< (gEgo distanceTo: phono) 20)
					(if (and local4 (== gAct 5))
						(if (record cycler:)
							(record setCycle: 0)
							(global376 stop:)
							(Print 74 37) ; "You lift the Victrola's needle from the revolving record."
						else
							(Print 74 38) ; "It is off already."
						)
					else
						(Print 74 39) ; "The record doesn't belong to you."
					)
				else
					(NotClose) ; "You're not close enough."
				)
			)
			(
				(or
					(Said
						'wind,play,(rotate<on)/gramophone,music,record,(player<record)'
					)
					(Said 'get/music,record,(player<record)')
				)
				(if (and local4 (== gAct 5))
					(Print 74 40) ; "You're not interested in playing music right now."
				else
					(Print 74 39) ; "The record doesn't belong to you."
				)
			)
			((Said 'look,find/record')
				(cond
					((gEgo has: 9) ; broken_record
						(event claimed: 0)
					)
					((and local4 (== gAct 5) (record cycler:))
						(Print 74 41) ; "Having reached the end of the record, the Victrola needle scratches endlessly as it turns."
					)
					((record cycler:)
						(Print 74 42) ; "Fifi is playing a record on the Victrola."
					)
					(else
						(Print 74 43) ; "You see a record lying atop the Victrola."
					)
				)
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/gramophone,armoire,(player<record)')
				)
				(event claimed: 1)
				(cond
					((and local4 (== gAct 5) (record cycler:))
						(Print 74 41) ; "Having reached the end of the record, the Victrola needle scratches endlessly as it turns."
					)
					((>= gAct 5)
						(Print 74 44) ; "You see a Victrola in the back corner of the room."
					)
					(else
						(Print 74 45) ; "Fifi must enjoy listening to music as you see a Victrola in the back corner of the room."
					)
				)
			)
		)
	)
)

(instance record of Prop
	(properties
		y 53
		x 193
		view 174
		loop 7
		cel 5
		priority 4
		signal 16
	)
)

(instance flowers of Prop
	(properties
		y 143
		x 141
		view 174
		loop 2
		cel 10
		priority 14
		signal 16400
	)

	(method (handleEvent event)
		(cond
			((Said 'get/blossom')
				(Print 74 46) ; "It would be better to leave them alone."
			)
			((or (MousedOn self event 3) (Said 'look/blossom'))
				(event claimed: 1)
				(Print 74 47) ; "A lovely bouquet of flowers lies on the table next to the cognac decanter."
			)
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 93
		x 80
		view 174
	)

	(method (handleEvent event)
		(cond
			((Said 'change,(attach<on),wear/cloth')
				(Print 74 48) ; "You wouldn't be caught dead in those clothes!"
			)
			((Said 'get,get,move/cloth')
				(Print 74 49) ; "Those are not your clothes!"
			)
			((Said '(look<(below,through)),search/dirt,cloth')
				(if local3
					(Print 74 50) ; "You quickly look through the pile of clothes, but do not find anything of importance."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said 'look/dirt,cloth,pile')
				(cond
					(local3
						(Print 74 51) ; "You notice a pile of clothes on the floor."
					)
					(local4
						(Print 74 8) ; "Fifi and Jeeves are lying DEAD on the floor with their spilled drinks."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((and local3 (Said 'pull,close,open/curtain'))
				(Print 74 52) ; "The shade doesn't look very strong. Better not touch it."
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(DoLook {lamp})
			)
		)
	)
)

(instance lamp2 of Prop
	(properties
		y 92
		x 68
		view 174
		loop 1
	)

	(method (handleEvent event)
		(cond
			((Said 'get/lamp')
				(Print 74 53) ; "The kerosene lamps are firmly afixed to the wall."
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(DoLook {lamp})
			)
		)
	)
)

(instance door of Prop
	(properties
		y 104
		x 48
		view 174
	)

	(method (handleEvent event)
		(cond
			((Said 'open/door')
				(cond
					((gEgo inRect: 21 95 47 110)
						(cond
							(global117
								(if (& global117 $8000)
									(AlreadyOpen) ; "It is already open."
								else
									(if (< (gEgo y:) (door y:))
										(gEgo posn: 33 89)
									)
									(self setScript: myDoor)
								)
							)
							((== local2 1)
								(Print 74 54) ; "The door is locked from the other side."
							)
							(else
								(Print 74 55) ; "The door is locked from this side."
							)
						)
					)
					((== local2 2)
						(event claimed: 0)
					)
					(else
						(NotClose) ; "You're not close enough."
					)
				)
			)
			((Said 'close/door')
				(cond
					((gEgo inRect: 21 95 47 115)
						(if (not (& global117 $8000))
							(AlreadyClosed) ; "It is already closed."
						else
							(self setScript: myDoor)
						)
					)
					((== local2 2)
						(event claimed: 0)
					)
					(else
						(NotClose) ; "You're not close enough."
					)
				)
			)
			((or (Said 'use,unbar/key,door') (Said 'open/door/key'))
				(cond
					(global117
						(Print 74 56) ; "The door is already unlocked."
					)
					((gEgo inRect: 21 95 47 110)
						(cond
							((== local2 3)
								(= global117 1)
								(Print 74 57) ; "You reach down and unlock the door."
							)
							((gEgo has: 5) ; skeleton_key
								(= global117 1)
								(Print 74 58) ; "Using the skeleton key, you unlock the attic door."
							)
							(else
								(Print 74 59) ; "You don't have the key that unlocks this door."
							)
						)
					)
					(else
						(NotClose) ; "You're not close enough."
					)
				)
			)
			((Said 'bang[/door]')
				(if (gEgo inRect: 21 95 47 110)
					(if (not (& global117 $8000))
						(self setScript: knockDoor)
					else
						(Print 74 60) ; "There is no need to. The door is already open."
					)
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said 'find,enter,(go[<in])/attic')
				(if (== local2 1)
					(Print 74 61) ; "The attic is on the other side of this door."
				else
					(event claimed: 0)
				)
			)
			((Said 'look/keyhole')
				(if (== local2 1)
					(Print 74 62) ; "That won't work."
				else
					(event claimed: 0)
				)
			)
			((or (MousedOn self event 3) (Said 'look/door[<attic]'))
				(event claimed: 1)
				(if (== local2 2)
					(Print 74 63) ; "You can't see the attic door from here."
				else
					(Print 74 64) ; "This appears to be the attic door."
				)
			)
		)
	)
)

(instance Tswing of Prop
	(properties
		y 94
		x 233
		view 174
		loop 4
	)

	(method (handleEvent event)
		(if
			(and
				(== local2 2)
				(or (MousedOn self event 3) (Said 'look/door[<swinging]'))
			)
			(Print 74 65) ; "Small, swinging doors lead into Fifi's dressing room."
			(event claimed: 1)
		)
	)
)

(instance Bswing of Prop
	(properties
		y 105
		x 245
		view 174
		loop 5
	)

	(method (handleEvent event)
		(if
			(and
				(== local2 2)
				(or (MousedOn self event 3) (Said 'look/door[<swinging]'))
			)
			(Print 74 65) ; "Small, swinging doors lead into Fifi's dressing room."
			(event claimed: 1)
		)
	)
)

(instance FifiButt of Prop
	(properties
		y 153
		x 252
		view 478
		loop 4
	)
)

(instance Fifi of Act
	(properties)

	(method (handleEvent event)
		(if (not local7)
			(= global213 5)
			(cond
				((Said 'listen/fifi')
					(Print 74 66) ; "She's not talking to you."
				)
				((Said 'talk/fifi')
					(switch local1
						(0
							(Say 1 74 67) ; "You should not be een here, Mademoiselle. Zis eez my private room."
						)
						(1
							(Say 1 74 68) ; "S'il vous plait...please! Zis eez my own time!"
						)
						(2
							(Say 1 74 69) ; "I am busy right now. Please, Mademoiselle! Give me my privacy!"
						)
						(3
							(Say 1 74 70) ; "I do not have zee time to talk right now. Maybe later, oui?"
						)
						(4
							(Say 1 74 71) ; "Mademoiselle, please!"
						)
						(else
							(Print 74 72) ; "Fifi is tired of arguing with you and she doesn't respond anymore."
						)
					)
					(++ local1)
				)
				((or (MousedOn self event 3) (Said 'look/fifi'))
					(event claimed: 1)
					(if (not (& global207 $0010))
						(|= global207 $0010)
						(Say 0 74 73) ; "Fifi is the Colonel's pretty French maid. You surmise that she is probably very apt in her duties...whatever THEY may be! Fifi is young, blonde, and sexy. Although she seems to have a vivacious personality, you can sense a certain cunning underneath it all."
					else
						(Print 74 74) ; "Fifi must be getting ready to see someone special as she's taking great pains to make herself look pretty."
					)
				)
			)
		)
	)
)

(instance mySound of Sound
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance myDoor of Script
	(properties)

	(method (doit)
		(if (== (mySound prevSignal:) 11)
			(DoSound sndVOLUME 0)
			(= cycles 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (<= (gEgo y:) (door y:))
					(gEgo setMotion: MoveTo 33 89 self)
				else
					(gEgo setMotion: MoveTo 33 106 self)
				)
			)
			(1
				(if (<= (gEgo y:) (door y:))
					(gEgo loop: 2)
				else
					(gEgo loop: 3)
				)
				(mySound prevSignal: 0)
				(HandsOff)
				(if (not (& global117 $8000))
					(mySound number: 43 loop: 1 priority: 10 play:)
					(DoSound sndVOLUME local8)
					(door loop: 6 setCycle: End)
					(gEgo illegalBits: -32768)
					(|= global117 $8000)
				else
					(mySound number: 44 loop: 1 priority: 10 play:)
					(DoSound sndVOLUME local8)
					(door loop: 6 setCycle: Beg)
					(gEgo illegalBits: -32760)
					(&= global117 $7fff)
				)
			)
			(2
				(if (not (& global117 $8000))
					(door loop: (if (< (gEgo y:) 104) 3 else 6) stopUpd:)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

