;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Gaza)
(use eRoom)
(use Interface)
(use Motion)
(use User)
(use System)

(public
	Rm40 0
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
)

(instance Rm40 of eRoom
	(properties
		picture 40
	)

	(method (init)
		(self
			style:
				(switch global103
					(0 100)
					(1 15)
					(2 17)
				)
		)
		(Load rsVIEW 35)
		(Load rsVIEW 425)
		(cond
			((not (IsFlag 116))
				(Load rsSCRIPT 130)
			)
			((not (IsFlag 83))
				(Load rsSCRIPT 148)
				(Load rsVIEW 343)
			)
		)
		(Load rsSCRIPT 147)
		(Load rsSCRIPT 149)
		(Load rsSCRIPT 201)
		(Load rsSOUND 90)
		(Load rsSOUND (proc0_20 89))
		(super init:)
		(self setRegions: 107) ; Gaza
		(if (IsFlag 20)
			(= local1 1)
			(gMuleObj illegalBits: -28672)
		)
		(if (IsFlag 106)
			(= local5 1)
		)
		(if (IsFlag 117)
			(= local6 1)
		)
		(gEgo init:)
		(switch gPrevRoomNum
			(49
				(self enterRoom: 50 -5 50 60)
				(if local1
					(gMuleObj loop: 2)
					(self muleEnterRoom: 20 0 20 75)
				)
			)
			(45
				(self enterRoom: 70 235 70 182)
				(if local1
					(gMuleObj loop: 3)
					(self muleEnterRoom: 40 220 40 180)
				)
			)
			(41
				(gEgo illegalBits: 0 setPri: 5)
				(= global112 0)
				(if local1
					(gMuleObj
						view: 425
						loop: 0
						cel: 9
						posn: 211 115
						ignoreActors:
						setCycle: Walk
					)
					(= local7 1)
				)
				(self enterRoom: 315 155 228 112)
			)
			(else
				(if (IsFlag 83)
					(self enterRoom: -10 120 20 120)
					(if local1
						(gMuleObj loop: 0)
						(self muleEnterRoom: -15 130 30 130)
					)
				else
					(self enterRoom: -10 182 20 182)
					(if local1
						(gMuleObj loop: 0)
						(self muleEnterRoom: -15 175 30 175)
					)
				)
			)
		)
		(proc0_13 65)
		(gAddToPics doit:)
		(cond
			((and (not global124) (< global189 9) (not (IsFlag 116)))
				((ScriptID 130 0) ; Jabir
					view: 392
					setLoop: 1
					cel: 0
					posn: 140 180
					init:
				)
				((ScriptID 130 1) posn: 140 180 hide:) ; jabirHead
			)
			((and (not (IsFlag 83)) (!= gPrevRoomNum 49))
				(SetFlag 83)
				(= local3 1)
				((ScriptID 148 0) init:) ; turkishGirl
			)
		)
	)

	(method (doit)
		(if
			(and
				(not local0)
				(not (gEgo script:))
				(== (gEgo illegalBits:) -32768)
			)
			(gEgo illegalBits: -30720)
		)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				(
					(and
						global169
						(not (gEgo script:))
						(not ((ScriptID 130 0) script:)) ; Jabir
					)
					(= local2 1)
					((ScriptID 130 0) setScript: (ScriptID 201 0)) ; Jabir, comeWithMe
				)
				((and local3 (not local4))
					(= local4 1)
					(User canControl: 0)
					(SetMenu 1283 112 0)
				)
				((not local1) 0)
				((and (!= gPrevRoomNum 41) (not local8))
					(= local8 1)
					(gMuleObj setScript: 0)
					(gMuleObj setMotion: MoveTo 40 150)
				)
				(
					(and
						(not local9)
						(== (gMuleObj x:) 40)
						(== (gMuleObj y:) 150)
					)
					(= local9 1)
					(if (!= (gMuleObj loop:) 0)
						(gMuleObj
							setMotion:
								MoveTo
								(+ (gMuleObj x:) 3)
								(gMuleObj y:)
						)
					)
				)
			)
			(cond
				(local7
					(= local7 0)
					(gEgo setPri: -1)
					(gMuleObj setScript: (ScriptID 201 1)) ; moveForMule
				)
				(
					(and
						(== (gEgo onControl: 1) 8)
						(or (== (gEgo loop:) 0) (== (gEgo loop:) 3))
					)
					(gEgo illegalBits: 0 setPri: 5)
					(gRegMusic stop:)
					(if local1
						(gMuleObj
							illegalBits: 0
							setStep: 5 3
							setMotion: MoveTo 210 140
						)
					)
					(if global124
						(self setScript: putItAway)
					else
						(self leaveRoom: 41 350 175)
					)
				)
				((< (gEgo x:) 10)
					(if (IsFlag 84)
						(ClearFlag 84)
					)
					(if local2
						(= global189 0)
					)
					(if local1
						(gMuleObj setMotion: MoveTo (gEgo x:) (gEgo y:))
					)
					(self leaveRoom: 39 -10 (gEgo y:))
				)
				((and (> (gEgo y:) 185) (not (gEgo script:)))
					(if (IsFlag 84)
						(ClearFlag 84)
					)
					(if local2
						(= global189 6)
					)
					(if local1
						(gMuleObj setMotion: MoveTo (gEgo x:) (gEgo y:))
					)
					(self leaveRoom: 45 (gEgo x:) 235)
				)
				((< (gEgo y:) 40)
					(if local2
						(= global189 0)
					)
					(ClearFlag 82)
					(self leaveRoom: 49 (gEgo x:) -5)
					(if local1
						(gMuleObj setMotion: MoveTo (gEgo x:) (gEgo y:))
					)
				)
			)
			(cond
				((not local1) 0)
				(
					(and
						(== (gMuleObj onControl: 1) 256)
						(!= (gMuleObj priority:) 1)
					)
					(gMuleObj setPri: 1)
				)
				(
					(and
						(== (gMuleObj priority:) 1)
						(!= (gMuleObj onControl: 1) 256)
					)
					(gMuleObj setPri: -1)
				)
			)
			(switch (gEgo onControl: 1)
				(256
					(if (!= (gEgo priority:) 1)
						(gEgo setPri: 1)
						(SetFlag 82)
					)
				)
				(2
					(if
						(and
							local1
							(gMuleObj mover:)
							(not (gEgo script:))
							(not (gMuleObj script:))
						)
						(gMuleObj setMotion: MoveTo 65 150)
					)
					(if
						(and
							(not (gEgo script:))
							(!= (gEgo priority:) 14)
						)
						(gEgo setPri: 14)
					)
					(if (not local0)
						(= local0 1)
						(SetFlag 82)
						(gEgo illegalBits: -32768)
					)
					(if (and (gEgo inRect: 182 48 310 135) (not local6))
						(gEgo setMotion: 0)
						(SetFlag 117)
						(= local6 1)
						(Print 40 0 #at -1 125) ; "Below you - and a lethal fall from here, I might add - is a long pool of fresh water."
					)
				)
				(2048
					(if (not (gEgo script:))
						(gEgo setScript: (ScriptID 149 0)) ; fallToSand
					)
				)
				(16
					(if (not (gEgo script:))
						(gEgo setScript: (ScriptID 149 1)) ; fallInHole
					)
				)
				(16384
					(if (and (== (gEgo loop:) 0) (not local0))
						(= local0 1)
						(SetFlag 82)
						(gEgo setScript: (ScriptID 147 0)) ; goingUpTopStairs
					)
				)
				(8192
					(if (and (== (gEgo loop:) 1) local0)
						(= local0 0)
						(gEgo setScript: (ScriptID 147 1)) ; comingDownTopStairs
					)
				)
				(1024
					(if (and (== (gEgo loop:) 0) (not local0))
						(= local0 1)
						(SetFlag 82)
						(gEgo setScript: (ScriptID 147 2)) ; goingUpBottomStairs
					)
				)
				(512
					(if (and (== (gEgo loop:) 1) local0)
						(= local0 0)
						(gEgo setScript: (ScriptID 147 3)) ; comingDownBottomStairs
					)
				)
				(1
					(if (and local0 (not (gEgo script:)))
						(= local0 0)
						(gEgo illegalBits: -30720)
						(ClearFlag 82)
					)
				)
			)
			(cond
				(
					(and
						(!= (gEgo onControl: 1) 256)
						(== (gEgo priority:) 1)
					)
					(ClearFlag 82)
					(gMuleObj setPri: -1)
					(gEgo setPri: -1)
				)
				(
					(and
						(not (== (gEgo onControl: 1) 2))
						(not (gEgo script:))
						(== (gEgo priority:) 14)
					)
					(gEgo setPri: -1)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (== (event type:) evMOUSEBUTTON)
			(= temp0 (OnControl CONTROL (event x:) (event y:)))
		)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(Said 'ask/merlin[/advice]')
					(Said 'ask/advice[<merlin][/!*]')
					(Said 'talk/merlin[/!*]')
				)
				(Print 40 1) ; "I suspect I should know what this place is. If you investigate further it may come to me."
			)
			((Said 'ask[/merlin][/girl,woman]')
				(cond
					(local3
						(Print 40 2) ; "The girl and her jug have vanished over the hill."
					)
					(local5
						(Print 40 3) ; "If you refer to Fatima, it would seem she had a lesson to teach you. Next time, heed her words more closely."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'look<in,in/building,window,ruin')
				(Print 40 4) ; "It appears dark and empty inside."
			)
			((Said 'look<down')
				(if (== (gEgo onControl: 1) 2)
					(if local6
						(Print 40 5) ; "Below you is an enticing pool of water."
					else
						(Print 40 6) ; "The platform around the pit is made of stone."
					)
				else
					(event claimed: 0)
				)
			)
			((Said 'talk,ask/girl,woman[/*]')
				(Print 40 7) ; "You are babbling, Arthur."
			)
			((Said 'talk,ask/hamid,guide[/*]')
				(if local2
					(Print 40 8) ; "He was so anxious for you to follow him, he did not wait to speak further with you."
				else
					(event claimed: 0)
				)
			)
			((Said 'get,drink/water')
				(cond
					((and (== gPrevRoomNum 41) (IsFlag 106))
						(Print 40 9) ; "You swallowed a great deal of water when you landed in the aqueduct. But if you want more, now is the time to do it."
					)
					((IsFlag 117)
						(Print 40 10) ; "A fine idea, but you will not do it from up here."
					)
					(else
						(Print 40 11) ; "You will have to find it, first."
					)
				)
			)
			((Said 'look,get/pot,jar,jug')
				(if local3
					(Print 40 2) ; "The girl and her jug have vanished over the hill."
				else
					(Print 40 12) ; "I see nothing like that here."
				)
			)
			((Said 'get,pick/date,palm')
				(Print 40 13) ; "The dates have all been harvested from the palm."
			)
			((Said 'get,pick/aloe,plant')
				(Print 40 14) ; "They will not soothe your thirst. You should rather look for the source of their water."
			)
			((Said 'eat/date,palm,aloe,plant')
				(Print 40 15) ; "The aloe is not for eating and the dates have all been harvested from the palm."
			)
			((Said 'give,feed[/aloe,date,plant,ass][/aloe,date,plant,ass]')
				(if local1
					(Print 40 16) ; "The mule knows better than you what she should eat."
				else
					(Print 40 17) ; "You no longer have your mule."
				)
			)
			((Said 'give,pay,sell,bargain[/girl,coin][/girl,coin]')
				(if local3
					(Print 40 18) ; "She has run away, Arthur."
				else
					(Print 40 19) ; "Dear me. The heat has affected you most severely."
				)
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
						)
						(if local5
							(Print 40 20) ; "You should remember the way back to Jerusalem from here."
						else
							(Print 40 21) ; "There is a building and a stone platform over a deep walled pit in the ground, and steps leading down into it."
							(Print 40 22) ; "There are some date palms, aloe vera and other plants nearby."
						)
					)
					(
						(or
							(Said '/boulder')
							(Said '//boulder')
							(OnButton event 65 73 80 88)
							(OnButton event 94 108 104 117)
						)
						(proc107_2)
					)
					((or (Said '/slab,base') (Said '//slab,base'))
						(Print 40 6) ; "The platform around the pit is made of stone."
					)
					(
						(or
							(Said '/window,niche')
							(Said '//window,niche')
							(OnButton event 247 19 255 42)
						)
						(Print 40 23) ; "The building appears dark and empty inside."
					)
					(
						(or
							(Said '/arch')
							(Said '//arch')
							(OnButton event 279 39 310 66)
						)
						(Print 40 24) ; "It is a puzzling arch for it seems to serve no purpose. It does not even span the pit next to it."
					)
					(
						(or
							(Said '/building,ruin')
							(Said '//building,ruin')
							(OnButton event 238 7 310 64)
						)
						(Print 40 25) ; "It is very old and appears to be no longer in use."
					)
					((or (Said '/wall') (Said '//wall'))
						(Print 40 26) ; "The pit is lined with stone walls."
					)
					((or (Said '/hole') (Said '//hole'))
						(Print 40 27) ; "It is deep and walled with stone."
					)
					(
						(or
							(Said '/cliff,mesa,hill,terrain')
							(Said '//cliff,mesa,hill,terrain')
						)
						(if (or (IsFlag 114) (IsFlag 109))
							(Print 40 28) ; "Up the steep slope to the north lies Jerusalem, as you know now."
						else
							(Print 40 29) ; "There is a steep slope to the north which blocks any view down here of what lies in that direction, and a large hill rises above this walled pit."
						)
					)
					((or (Said '/hill') (Said '//hill'))
						(Print 40 30) ; "Directly above and behind the walled pit there is a large hill."
					)
					((or (Said '/stair') (Said '//stair'))
						(if (and local6 (== (gEgo onControl: 1) 2))
							(Print 40 31) ; "Stairs lead down to the pool."
						else
							(Print 40 32) ; "There are narrow stone stairs to the stone platform and stairs going down in one corner of the pit."
						)
					)
					(
						(or
							(Said '/water,spring,pool,lake')
							(Said '//water,spring,pool,lake')
						)
						(cond
							(local5
								(Print 40 33) ; "As you know, you are at the Pool of Siloam."
							)
							((IsFlag 111)
								(Print 40 34) ; "It is a long, narrow pool filled with glorious, fresh water."
							)
							(else
								(Print 40 35) ; "The presence of plants is a hopeful sign."
							)
						)
					)
					((or (Said '/wadi,oasis') (Said '//wadi,oasis'))
						(if local6
							(Print 40 36) ; "The Pool in this walled pit is filled with fresh water, as good as any wadi or oasis."
						else
							(Print 40 35) ; "The presence of plants is a hopeful sign."
						)
					)
					((or (Said '/girl,woman') (Said '//girl,woman'))
						(if local3
							(Print 40 37) ; "She found you most frightening and wanted nothing to do with you."
						else
							(Print 40 38) ; "There is no girl here. You are suffering from delusions."
						)
					)
					((or (Said '/hamid,guide') (Said '//hamid,guide'))
						(if local2
							(Print 40 39) ; "He has not returned. Perhaps he waits for you elsewhere."
						else
							(event claimed: 0)
						)
					)
					((or (Said '/djin') (Said '//djin'))
						(Print 40 40) ; "They are spirits, either good or bad, which can appear in either human or animal form."
					)
					((or (Said '/thirst') (Said '//thirst'))
						(if (IsFlag 84)
							(Print 40 41) ; "The sweet water of the Pool of Siloam has quenched your thirst for now."
						else
							(Print 40 42) ; "Only water will quench your burning thirst."
						)
					)
					(
						(or
							(Said '/palm,tree,date')
							(Said '//palm,tree,date')
							(OnButton event 104 8 149 53)
						)
						(Print 40 43) ; "There are some date palms whose dates have been harvested."
					)
					(
						(or
							(Said '/plant,bush,aloe')
							(Said '//plant,bush,aloe')
							(OnButton event 128 125 149 135)
							(OnButton event 215 145 283 158)
							(OnButton event 104 65 116 83)
							(OnButton event 115 53 137 74)
							(OnButton event 151 35 171 54)
							(OnButton event 196 28 238 47)
						)
						(Print 40 44) ; "There are some aloe vera plants and other plants that I do not know."
					)
					(else
						(switch temp0
							(2
								(Print 40 6) ; "The platform around the pit is made of stone."
								(event claimed: 1)
							)
							(128
								(Print 40 45) ; "There are narrow stone stairs between the stone platform and the desert."
								(event claimed: 1)
							)
							(8
								(if (== (gEgo onControl: 1) 2)
									(Print 40 46) ; "Steps lead down to an enticing pool of water."
								else
									(Print 40 47) ; "Steps lead down into a deep walled pit in the ground."
								)
								(event claimed: 1)
							)
							(16
								(if (== (gEgo onControl: 1) 2)
									(Print 40 5) ; "Below you is an enticing pool of water."
								else
									(Print 40 48) ; "There is a deep walled pit in the ground, and steps leading down into it."
								)
								(event claimed: 1)
							)
							(64
								(Print 40 45) ; "There are narrow stone stairs between the stone platform and the desert."
								(event claimed: 1)
							)
							(else
								(event claimed: 0)
							)
						)
					)
				)
			)
		)
	)
)

(instance putItAway of Script
	(properties)

	(method (doit)
		(if (not global125)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global125 2)
			)
			(1
				(gCurRoom leaveRoom: 41 350 175)
			)
		)
	)
)

