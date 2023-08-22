;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room24 0
)

(synonyms
	(attorney person man)
)

(local
	local0
	local1
	local2
)

(instance Room24 of Rm
	(properties
		picture 24
	)

	(method (init)
		(= west 23)
		(= east 8)
		(super init:)
		(self setFeatures: Hedge Gazebo)
		(if
			(and
				(>= gAct 3)
				(not (& gCorpseFlags $0004)) ; Gloria
				(not (& gCorpseFlags $0040)) ; Lillian
			)
			(if (and (!= global122 23) (!= global122 gCurRoomNum))
				(switch (Random 1 2)
					(1
						(= global122 gCurRoomNum)
					)
					(2
						(= global122 23)
					)
				)
			)
			(if (and (== gAct 3) (< gJeevesChoresState 7))
				(= global122 24)
			)
			(if (== global122 gCurRoomNum)
				(= local2 1)
				(self setRegions: 263) ; Dglor
			)
		)
		(if (and (or (== gClarenceWilburState 5) (== [gCycleTimers 1] 1)) (== gAct 1))
			(Clarence init: setScript: clarActions)
			(LoadMany rsMESSAGE 243 248)
			(Load rsVIEW 906)
			(= global208 64)
			(= [global377 6] 248)
		)
		(switch gPrevRoomNum
			(18
				(gEgo posn: 10 135)
			)
			(8
				(gEgo posn: 315 175 loop: 1)
			)
			(30
				(gEgo posn: 272 188)
			)
			(29
				(gEgo posn: 34 188)
			)
			(23
				(gEgo posn: 10 150)
			)
		)
		(gEgo view: 0 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 24 0) ; "This quaint gazebo looks like it was once a nice spot for quiet reflecting. Looking north you see some tall hedges."
		)
		(switch (gEgo onControl: 0)
			(2
				(gCurRoom newRoom: 18)
			)
			(16
				(if (and (not local1) (not local2))
					(= local1 1)
					(User canControl: 0)
					(if (< (gEgo y:) 150)
						(gEgo setMotion: MoveTo 189 172)
					else
						(gEgo setMotion: MoveTo 197 126)
					)
				)
			)
			(else
				(if local1
					(= local1 0)
					(User canControl: 1)
				)
			)
		)
		(if (== (gEgo edgeHit:) EDGE_BOTTOM)
			(if (< (gEgo x:) 159)
				(gCurRoom newRoom: 29)
			else
				(gCurRoom newRoom: 30)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				global208
				(Said 'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>')
			)
			(self setScript: (ScriptID 243 0)) ; atsgl
			((self script:) handleEvent: event)
			(if (event claimed:)
				(return)
			)
		)
		(if (== (event type:) evSAID)
			(if
				(and
					global208
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
				(if (event claimed:)
					(return)
				)
			)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 24 0) ; "This quaint gazebo looks like it was once a nice spot for quiet reflecting. Looking north you see some tall hedges."
						)
						((Said '/path')
							(Print 24 1) ; "A dirt path leads to the gazebo."
						)
						((Said '/stair,stair')
							(Print 24 2) ; "The rickety steps lead into the gazebo."
						)
						((Said '[<down][/dirt]')
							(if (& (gEgo onControl: 0) $4000)
								(Print 24 3) ; "You see the wooden floor of the gazebo."
							else
								(event claimed: 0)
							)
						)
						((or (Said '/ceiling') (Said '<up'))
							(if (& (gEgo onControl: 0) $4000)
								(Print 24 4) ; "You see the roof of the gazebo."
							else
								(event claimed: 0)
							)
						)
					)
				)
				((Said 'climb/stair')
					(Print 24 5) ; "Just climb them yourself."
				)
			)
		)
	)
)

(instance clarActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Clarence loop: 0 cel: 0 cycleSpeed: 1 setCycle: End)
				(= seconds 4)
			)
			(1
				(Clarence loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(Clarence setCycle: Beg)
				(= seconds (Random 5 10))
			)
			(3
				(Clarence loop: 2 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(Clarence setCycle: 0)
				(if (< (Random 1 100) 35)
					(= state 0)
				else
					(= state 2)
				)
				(= seconds (Random 5 15))
			)
		)
	)
)

(instance Clarence of Prop
	(properties
		y 167
		x 191
		view 412
		cel 1
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((and (MousedOn self event 3) (not (& global207 $0040)))
				(event claimed: 1)
				(DoLook {clarence})
			)
			(
				(and
					(& global207 $0040)
					(or
						(MousedOn self event 3)
						(Said 'look/attorney,attorney')
					)
				)
				(event claimed: 1)
				(Print 24 6) ; "Clarence seems to be sulking about something."
			)
			((Said 'talk/attorney,attorney')
				(= global213 7)
				(Say 1 24 7) ; "Please, I'm not really in the mood for conversation."
			)
		)
	)
)

(instance Hedge of RFeature
	(properties
		nsTop 97
		nsBottom 115
		nsRight 48
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/garden,bush'))
			(event claimed: 1)
			(Print 24 8) ; "You notice some unusual, tall hedges to the north."
		)
	)
)

(instance Gazebo of RFeature
	(properties
		nsTop 3
		nsLeft 148
		nsBottom 152
		nsRight 267
	)

	(method (handleEvent event)
		(cond
			((Said 'look<in/gazebo')
				(Print 24 9) ; "You see nothing but dust inside the gazebo."
			)
			((Said 'look<below/gazebo')
				(Print 24 10) ; "There is no way of looking under the gazebo."
			)
			((or (MousedOn self event 3) (Said 'look/gazebo'))
				(event claimed: 1)
				(Print 24 11) ; "Though now in disrepair, the old gazebo still looks peaceful and inviting."
			)
		)
	)
)

