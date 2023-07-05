;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Interface)
(use DCIcon)
(use RFeature)
(use Path)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room37 0
)

(synonyms
	(stair upstair)
	(helmet head mask)
	(body chest)
	(balcony balcony banister)
	(room hall)
)

(local
	local0
	local1 = 150
	[local2 25] = [65 173 91 171 96 156 82 175 122 210 104 163 157 145 92 142 128 145 154 171 174 162 179 174 157]
	[local27 7] = [103 178 56 150 30 148 -32768]
	[local34 7] = [218 177 269 148 290 148 -32768]
	[local41 5] = [263 152 205 183 -32768]
	[local46 5] = [57 153 117 182 -32768]
	local51
	local52
	local53
	local54
	local55
	local56
	local57
	local58
	local59
	local60
)

(procedure (localproc_0)
	(Print &rest #at 160 150 #font 4 #width 140 #mode 1 #draw #dispose)
)

(procedure (localproc_1)
	(if (not local53)
		(= local53 1)
		(User canControl: 0)
		(Room37 drawPic: 49 7)
		(gCast eachElementDo: #hide)
		(Visor show:)
		(note show:)
		(if (not (gEgo has: 13)) ; valve_handle
			(valve setPri: 1 init:)
		)
		(if local57
			(= local0 (Display 37 0 dsCOORD 48 8 dsWIDTH 256 dsCOLOR 15 dsBACKGROUND -1 dsFONT 0 dsSAVEPIXELS)) ; "Press the 'E' key to exit."
		)
	)
)

(procedure (localproc_2)
	(if local53
		(cls)
		(= local53 0)
		(User canControl: 1)
		(if local57
			(Display 37 1 dsRESTOREPIXELS local0)
		)
		(Room37 drawPic: gCurRoomNum 6)
		(gCast eachElementDo: #show)
		(gAddToPics
			add: postR postL phone lamp clock mirror
			eachElementDo: #init
			doit:
		)
		(Can hide:)
		(Visor hide:)
		(note hide:)
		(valve hide:)
		(if (and (!= local52 2) (!= local52 5) (!= local52 6))
			(HandsOn)
		)
	)
)

(instance Room37 of Rm
	(properties
		picture 37
	)

	(method (init)
		(= horizon 80)
		(= south 16)
		(= global102 0)
		(super init:)
		(Load rsFONT 4)
		(Load rsPIC 49)
		(LoadMany rsVIEW 10 12)
		(LoadMany rsSOUND 9 36 83 73)
		(Load rsSCRIPT 985)
		(if
			(and
				(or (not (IsFlag 41)) (not (IsFlag 42)) (not (IsFlag 43)))
				(> gAct 0)
			)
			(Load rsVIEW 925)
			(LoadMany rsMESSAGE 412)
			(= local60 1)
		)
		(gAddToPics
			add: postR postL phone lamp clock mirror
			eachElementDo: #init
			doit:
		)
		(self
			setRegions: 211 ; stairReg
			setFeatures: phone lamp clock mirror Armor Axe Carpet Couch
		)
		(note setPri: 1 init: hide:)
		(lampL setPri: 7 init: stopUpd:)
		(lampR setPri: 7 init: stopUpd:)
		(if gDetailLevel
			(lampR startUpd: setCycle: Fwd)
			(lampL startUpd: setCycle: Fwd)
		)
		(Can setStep: 5 5 ignoreHorizon: 1 init: hide:)
		(Visor setPri: 2 init: hide:)
		(knight ignoreActors: 1 init: stopUpd:)
		(chand
			setLoop: 2
			ignoreHorizon:
			illegalBits: 0
			setPri: 15
			yStep: 10
			init:
			stopUpd:
		)
		(= local59 gConMusic)
		(if (!= gPrevRoomNum 33)
			(local59 number: 28 loop: -1 play:)
		)
		(switch gPrevRoomNum
			(36
				(gEgo illegalBits: 16384 setPri: -1 posn: 92 88)
			)
			(38
				(gEgo illegalBits: 16384 setPri: -1 posn: 229 88)
			)
			(47
				(HandsOff)
				(= local54 1)
				(gEgo
					illegalBits: 8192
					setPri: 14
					setMotion: MoveTo (if (< (gEgo x:) 160) 30 else 290) 150
				)
			)
			(33
				(if (< (gEgo x:) 99)
					(gEgo posn: 110 (gEgo y:))
				)
				(if (> (gEgo x:) 222)
					(gEgo posn: 205 (gEgo y:))
				)
			)
			(else
				(gEgo illegalBits: 16384 setPri: -1)
			)
		)
		(gEgo view: 0 init:)
	)

	(method (doit)
		(switch (gEgo onControl: 1)
			(256
				(if (and (== (gEgo loop:) 0) (not local54))
					(= local54 1)
					(= local56 0)
					(= global101 1)
					(= horizon 50)
					(= local58 1)
					(= north 47)
					(HandsOff)
					(gEgo
						ignoreActors: 1
						illegalBits: 0
						setPri: 14
						setMotion: rightBotPath
					)
				)
			)
			(4096
				(if (and (== (gEgo loop:) 1) (not local54))
					(= local54 1)
					(= local58 1)
					(= local56 0)
					(= horizon 50)
					(= north 47)
					(= global101 1)
					(gEgo illegalBits: 0 setPri: 14)
					(HandsOff)
					(gEgo setMotion: leftBotPath)
				)
			)
			(1
				(if (not local56)
					(= local56 1)
					(HandsOn)
					(= global101 0)
					(gEgo illegalBits: 16384 setPri: -1)
					(= horizon 80)
					(= north 33)
					(= local54 0)
				)
			)
			(4
				(gCurRoom newRoom: 36)
			)
			(2
				(gCurRoom newRoom: 38)
			)
			(32
				(if (not local55)
					(= local58 0)
					(= global101 0)
					(= local55 1)
					(HandsOn)
					(gEgo ignoreActors: 0 illegalBits: 8192)
				)
			)
			(64
				(if (not local55)
					(= local55 1)
					(= local58 0)
					(= global101 0)
					(HandsOn)
					(gEgo ignoreActors: 0 illegalBits: 8192)
				)
			)
			(128
				(if local55
					(HandsOff)
					(= local55 0)
					(gEgo illegalBits: 0 setMotion: MoveTo 52 33)
				)
			)
			(1024
				(if local55
					(HandsOff)
					(= local55 0)
					(gEgo illegalBits: 0 setMotion: MoveTo 264 17)
				)
			)
			(512
				(if local55
					(= local55 0)
					(= local58 1)
					(HandsOff)
					(gEgo setMotion: leftTopPath)
				)
			)
			(8
				(if local55
					(= local55 0)
					(= local58 1)
					(HandsOff)
					(gEgo setMotion: rightTopPath)
				)
			)
			(16384
				(= north 47)
				(= horizon 50)
			)
			(16
				(if (and (== (gEgo loop:) 2) (== script 0))
					(self setScript: crush)
				)
			)
		)
		(cond
			((< (gEgo x:) 130)
				(= vertAngle 10)
			)
			((< (gEgo x:) 190)
				(= vertAngle 0)
			)
			(else
				(= vertAngle 170)
			)
		)
		(super doit:)
		(if (IsFirstTimeInRoom)
			(Print 37 2) ; "This is the front downstairs hallway of the big house. A grand stairway leads upstairs."
		)
		(if (and local60 (& (gEgo onControl: 1) $0001))
			(HandsOff)
			(= local60 0)
			(self setScript: (ScriptID 412 0)) ; Daddy
		)
	)

	(method (dispose)
		(DisposeScript 983)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (and (== local59 gConMusic) (!= newRoomNumber 33))
			(local59 stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				local57
				(or (== (event message:) KEY_E) (== (event message:) KEY_e))
				(== evKEYBOARD (event type:))
				(== local53 1)
			)
			(event claimed: 1)
			(if (or local53 local57)
				(Crash stop:)
				(localproc_2)
				(if local57
					(self setScript: 0)
					(gEgo setAvoider: 0)
					(= local57 0)
				)
			)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'get,force,rotate,detach,rotate/bird,post[<newel]')
						(Print 37 3) ; "The wooden eagles are firmly attached to the newel posts. They do not move."
					)
					((Said 'get>')
						(cond
							((Said '/armor,cloth')
								(Print 37 4) ; "You couldn't even MOVE this heavy armor!"
							)
							((Said '/ax[<battle]')
								(Print 37 5) ; "The battle-axe is firmly attached to the armor."
							)
							((Said '/letter')
								(Print 37 6) ; "You try, but find it permanently attached to the armor."
							)
						)
					)
					((Said 'detach/ax[<battle]')
						(Print 37 5) ; "The battle-axe is firmly attached to the armor."
					)
					((Said 'lift,force,open,lift,(look<in)/helmet')
						(if (& global142 $0002)
							(self setScript: openVisor)
						else
							(Print 37 7) ; "The joints of the armor are hopelessly rusted. You can't move any part of it."
						)
					)
					((Said '(press,move,rotate,open,lift,break,(look<in))>')
						(= local52 0)
						(cond
							((Said '/armor,cloth')
								(Print 37 7) ; "The joints of the armor are hopelessly rusted. You can't move any part of it."
							)
							((Said '/neck')
								(= local52 4)
							)
							((Said '/body')
								(= local52 3)
							)
							((Said '/knee<right')
								(= local52 12)
							)
							((Said '/knee<left')
								(= local52 11)
							)
							((Said '/knee')
								(= local52 11)
							)
							((Said '/leg<right')
								(= local52 7)
							)
							((Said '/leg<left')
								(= local52 13)
							)
							((Said '/leg')
								(= local52 13)
							)
							((Said '/give<right')
								(= local52 10)
							)
							((or (Said '/give<left') (Said '/ax[<battle]'))
								(= local52 6)
							)
							((Said '/give')
								(= local52 6)
							)
							((Said '/elbow<right')
								(= local52 9)
							)
							((Said '/elbow<left')
								(= local52 5)
							)
							((Said '/elbow')
								(= local52 5)
							)
							((Said '/arm<right')
								(= local52 8)
							)
							((Said '/arm<left')
								(= local52 2)
							)
							((Said '/arm')
								(= local52 2)
							)
						)
						(if local52
							(if (& global142 (<< $0001 local52))
								(Print 37 8) ; "It moves a little bit, but it does you no good; there's nothing there."
							else
								(Print 37 9) ; "It is hopelessly rusted. You can't move it at all."
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '[<around,at][/room]')
								(Print 37 2) ; "This is the front downstairs hallway of the big house. A grand stairway leads upstairs."
							)
							((or (Said '/chandelier,ceiling') (Said '<up'))
								(Print 37 10) ; "A huge, crystal chandelier hangs high above the downstairs foyer."
							)
							((Said '/hidden<door')
								(Print 37 11) ; "You see an old, yellowed note pasted to the inside of the helmet."
							)
							((Said '/door<back')
								(Print 37 12) ; "You see the back door further down the hall."
							)
							(
								(or
									(Said '<(in,behind)/clock')
									(Said '<(in,behind)/mirror')
									(Said '/time')
								)
								(NotClose) ; "You're not close enough."
							)
							((Said '/ax[<battle]')
								(Print 37 13) ; "It's a fourteenth-century Swiss battle-axe, finely handcrafted by Doge Guiseppe Minelli of Venice on his 90th birthday for his daughter who was to wed Antonio Fermaccelli, the bologna merchant. Later it became a favorite piece of Anne Boleyn's. Of course, Lizzie had the most fun with it!"
							)
							((Said '/door')
								(Print 37 14) ; "The front door leads outside."
							)
							((Said '/bird,post[<newel]')
								(Print 37 15) ; "Finely carved eagles adorn the top of the stairway's newel posts."
							)
							((Said '<below/stair')
								(Print 37 16) ; "You see nothing of interest under the stairs."
							)
							((Said '/downstair')
								(Print 37 17) ; "The stairs lead down to the first level of the house."
							)
						)
					)
					((Said 'oil>')
						(cond
							((gEgo has: 3) ; oilcan
								(if (& (gEgo onControl: 1) $0001)
									(= local52 0)
									(cond
										((Said '/helmet,helmet')
											(= local52 1)
										)
										((Said '/neck')
											(= local52 4)
										)
										((Said '/body')
											(= local52 3)
										)
										((Said '/knee<right')
											(= local52 12)
										)
										((Said '/knee<left')
											(= local52 11)
										)
										((Said '/knee')
											(= local52 11)
										)
										((Said '/leg<right')
											(= local52 7)
										)
										((Said '/leg<left')
											(= local52 13)
										)
										((Said '/leg')
											(= local52 13)
										)
										((Said '/give<right')
											(= local52 10)
										)
										(
											(or
												(Said '/give<left')
												(Said '/ax[<battle]')
											)
											(= local52 6)
										)
										((Said '/give')
											(= local52 6)
										)
										((Said '/elbow<right')
											(= local52 9)
										)
										((Said '/elbow<left')
											(= local52 5)
										)
										((Said '/elbow')
											(= local52 5)
										)
										((Said '/arm<right')
											(= local52 8)
										)
										((Said '/arm<left')
											(= local52 2)
										)
										((Said '/arm')
											(= local52 2)
										)
										((Said '/armor,cloth')
											(Print 37 18) ; "Which part of the armor would you like to oil?"
											(= local52 0)
										)
									)
									(if local52
										(|= global142 (<< $0001 local52))
										(self setScript: oiling)
									)
								else
									(NotClose) ; "You're not close enough."
									(event claimed: 1)
								)
							)
							((Said '[<*][/*]')
								(Print 37 19) ; "Using what? Rudy's hair tonic?!"
							)
						)
					)
					((Said 'force>')
						(cond
							((Said '/ax')
								(Print 37 6) ; "You try, but find it permanently attached to the armor."
							)
							(
								(or
									(Said '/arm,leg,helmet,helmet')
									(Said '/armor,cloth')
								)
								(Print 37 7) ; "The joints of the armor are hopelessly rusted. You can't move any part of it."
							)
						)
					)
					((Said 'wear,attach<on>')
						(if
							(or
								(Said '/arm,leg,helmet,helmet')
								(Said '/armor,cloth')
							)
							(Print 37 20) ; "It wouldn't become you"
						)
					)
					((Said 'climb[<up]/stair')
						(Print 37 21) ; "You must do that yourself."
					)
					((Said 'clock,time')
						(NotClose) ; "You're not close enough."
					)
					((Said 'listen/clock')
						(Print 37 22) ; "You hear the incessant ticking of the old grandfather clock."
					)
				)
				(super handleEvent: event)
			)
			((or 1 2)
				(if (or local58 (not local54))
					(return)
				)
				(if (& (gEgo onControl: 1) $4000)
					(if (< (gEgo x:) 160)
						(gEgo
							setMotion:
								MoveTo
								(cond
									((< (event y:) (gEgo y:)) 52)
									((> (event y:) (gEgo y:)) 30)
								)
								(cond
									((> (event y:) (gEgo y:)) 148)
									((< (event y:) (gEgo y:)) 33)
								)
						)
					else
						(gEgo
							setMotion:
								MoveTo
								(cond
									((< (event y:) (gEgo y:)) 261)
									((> (event y:) (gEgo y:)) 290)
								)
								(cond
									((< (event y:) (gEgo y:)) 17)
									((> (event y:) (gEgo y:)) 148)
								)
						)
					)
					(event claimed: 1)
				)
			)
			($0040 ; direction
				(if (or (not local54) local58)
					(return)
				)
				(if (& (gEgo onControl: 1) $4000)
					(switch (event message:)
						(JOY_UP
							(if (< (gEgo x:) 160)
								(gEgo setMotion: MoveTo 52 33)
							else
								(gEgo setMotion: MoveTo 264 17)
							)
							(event claimed: 1)
						)
						(JOY_DOWN
							(if (< (gEgo x:) 160)
								(gEgo setMotion: MoveTo 30 148)
							else
								(gEgo setMotion: MoveTo 290 148)
							)
							(event claimed: 1)
						)
						(else
							(event claimed: 1)
							(return)
						)
					)
				)
			)
		)
	)
)

(instance crush of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (< (gEgo distanceTo: chand) 80) (== local51 0) (== state 0))
			(= local51 1)
			(gEgo view: 10 loop: 0 cel: 0 setCycle: End)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(chand setMotion: MoveTo 158 102 self)
				(local59 stop:)
				(Fall priority: 2 play:)
			)
			(1
				(Crash number: 36 play:)
				(chand hide:)
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(Fall stop:)
				(ShakeScreen 5 5) ; ssUPDOWN | $0004
				(= seconds 3)
			)
			(3
				(myIcon view: 10 loop: 3 cycleSpeed: 8)
				(= global128 myIcon)
				(= global129 3)
				(= global130 0)
				(= global132 1)
				(EgoDead 37 23) ; "It will take awhile to get the splinters out!"
			)
		)
	)
)

(instance openVisor of Script
	(properties)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said '(look,read,get)/letter')
					(if (== state 3)
						(= cycles 1)
					else
						(Print 37 24) ; "Open the visor first."
					)
				)
				((Said 'close/helmet')
					(= state 6)
					(= cycles 1)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo inRect: 106 150 108 152)
					(= cycles 1)
				else
					(gEgo
						setAvoider: (Avoid new:)
						setMotion: MoveTo 107 152 self
					)
				)
			)
			(1
				(gEgo loop: 1)
				(= cycles 3)
			)
			(2
				(localproc_1)
				(= cycles 7)
			)
			(3
				(Visor cycleSpeed: 3 setCycle: End self)
			)
			(4
				(if (== ((gInventory at: 13) owner:) 37) ; valve_handle
					(Print 37 25 #at 60 60) ; "You carefully open the armor's visor and peek inside..."
				)
				(= cycles 1)
			)
			(5
				(if (== ((gInventory at: 13) owner:) 37) ; valve_handle
					(Print 37 26 #at 60 60) ; "You see a small, metal valve handle hanging by a hook inside the armor's helmet. You grab the valve handle."
					(valve dispose:)
				)
				(= cycles 1)
			)
			(6
				(if (== ((gInventory at: 13) owner:) 37) ; valve_handle
					(Print 37 27 #at 60 60) ; "You also see an old, yellowed note pasted to the inside of the helmet."
				else
					(Print 37 11 #at 60 60) ; "You see an old, yellowed note pasted to the inside of the helmet."
				)
				(= cycles 1)
			)
			(7
				(User canInput: 0)
				(if (== ((gInventory at: 13) owner:) 37) ; valve_handle
					(Print 37 28 #at 60 90) ; "Curious about the old note, you read it. It says...."
					(= global182 1)
					(gEgo get: 13) ; valve_handle
				else
					(Print 37 29 #at 70 90) ; "You read the note. It says...."
				)
				(= cycles 1)
			)
			(8
				(Print 37 30) ; "Our dearest daughter, Sarah, We knew you would know to look in the armor. This war is terrible! We fear our end is near. In case you're not the only one to find this note, we won't give too much away. Use this valve handle with your favorite water nymph. Don't ever forget...we love you very much! Love forever, Papa and Mama"
				(= cycles 1)
			)
			(9
				(Visor setCycle: Beg self)
			)
			(10
				(localproc_2)
				(gEgo setAvoider: 0)
				(= cycles 1)
			)
			(11
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance oiling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local57 1)
				(if (gEgo inRect: 104 148 111 154)
					(= cycles 1)
				else
					(= seconds (= cycles 0))
					(gEgo
						setAvoider: (Avoid new:)
						setMotion: MoveTo 107 152 self
					)
				)
			)
			(1
				(gEgo loop: 1)
				(= cycles 3)
			)
			(2
				(localproc_1)
				(Can posn: 225 100 show:)
				(if local52
					(Can
						setMotion:
							MoveTo
							[local1 (<< (- local52 1) $0001)]
							[local2 (<< (- local52 1) $0001)]
							self
					)
					(localproc_0 37 31) ; "Okay."
				else
					(= state 5)
					(= cycles 1)
				)
			)
			(3
				(cls)
				(if local52
					(Can setLoop: 2 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(4
				(Crash number: 73 loop: -1 play:)
				(= seconds 3)
			)
			(5
				(Crash stop:)
				(if local52
					(Can setLoop: 1 setMotion: MoveTo 225 100 self)
					(if (or (== local52 2) (== local52 5) (== local52 6))
						(= state 6)
					else
						(= local52 0)
					)
				else
					(= cycles 1)
				)
			)
			(6
				(User canInput: 1)
				(client setScript: 0)
			)
			(7
				(localproc_2)
				(HandsOff)
				(= cycles 7)
			)
			(8
				(gEgo setPri: 12)
				(knight setCycle: End self)
				(Crash number: 83 loop: 1 play:)
			)
			(9
				(gEgo
					view: 12
					loop: 2
					cel: 0
					setPri: -1
					illegalBits: 0
					posn: 104 153
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(10
				(client setScript: 0)
				(myIcon view: 653)
				(= global128 myIcon)
				(= global129 0)
				(= global130 0)
				(= global132 1)
				(EgoDead 37 32) ; "Got a "splitting headache," Laura?"
			)
		)
	)
)

(instance postR of PV
	(properties
		y 142
		x 219
		view 137
		cel 1
		priority 13
	)
)

(instance postL of PV
	(properties
		y 145
		x 103
		view 137
		priority 13
	)
)

(instance phone of RPicView
	(properties
		y 75
		x 219
		view 137
		loop 1
		cel 1
		priority 3
	)

	(method (handleEvent event)
		(if (and (not local53) (MousedOn self event 3))
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance lamp of RPicView
	(properties
		y 75
		x 101
		view 137
		loop 1
		priority 3
	)

	(method (handleEvent event)
		(if (and (not local53) (MousedOn self event 3))
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance clock of RPicView
	(properties
		y 67
		x 108
		view 137
		loop 2
		priority 3
	)

	(method (handleEvent event &tmp [temp0 250])
		(if
			(and
				(not local53)
				(or (MousedOn self event 3) (Said 'look[<at]/clock'))
			)
			(event claimed: 1)
			(Print (Format @temp0 37 33 37 34)) ; "You see a %s further down the hall."
		)
	)
)

(instance mirror of RPicView
	(properties
		y 72
		x 220
		view 137
		loop 2
		cel 1
		priority 3
	)

	(method (handleEvent event &tmp [temp0 35])
		(cond
			(
				(or
					(Said 'rotate,move/mirror,clock')
					(Said '(pull,press)[<open,on]/clock')
					(Said '(press,pull)[<open,on]/mirror')
				)
				(NotClose) ; "You're not close enough."
			)
			((Said 'rotate,rotate/mirror')
				(NotClose) ; "You're not close enough."
			)
			(
				(and
					(not local53)
					(or (MousedOn self event 3) (Said 'look[<at]/mirror'))
				)
				(event claimed: 1)
				(Print (Format @temp0 37 33 37 35)) ; "You see a %s further down the hall."
			)
		)
	)
)

(instance knight of Prop
	(properties
		y 153
		x 81
		view 12
		loop 3
		priority 11
	)

	(method (handleEvent event)
		(cond
			(
				(Said
					'enter,wear,((get,hide,go,climb)<in),(attach<on)/armor,cloth'
				)
				(Print 37 36) ; "It wouldn't suit you."
			)
			((Said 'get/letter')
				(if (== ((gInventory at: 13) owner:) 37) ; valve_handle
					(Print 37 37) ; "You don'see it here."
				else
					(Print 37 38) ; "The note is permanently attached to the inside of the helmet."
				)
			)
			((Said 'get/valve,handle')
				(if (== ((gInventory at: 13) owner:) 37) ; valve_handle
					(Print 37 37) ; "You don'see it here."
				else
					(AlreadyTook) ; "You already took it."
				)
			)
			(
				(or
					(MousedOn self event 3)
					(and (Said 'look/armor,cloth>') (not (Said 'look<in>')))
				)
				(event claimed: 1)
				(if (not local53)
					(localproc_1)
				)
				(Print 37 39 #at 110 110) ; "A very old suit of armor, with one gloved hand holding a battle-axe, stands beside the stairway. Although it's well-polished, all of its joints are completely rusted."
				(if (not local57)
					(localproc_2)
				)
			)
		)
	)
)

(instance lampL of Prop
	(properties
		y 60
		x 89
		view 237
		loop 1
	)

	(method (handleEvent event)
		(if (and (not local53) (MousedOn self event 3))
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance lampR of Prop
	(properties
		y 60
		x 234
		view 237
		loop 2
	)

	(method (handleEvent event)
		(if (and (not local53) (MousedOn self event 3))
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance valve of Prop
	(properties
		y 46
		x 150
		view 137
		loop 3
	)
)

(instance note of Prop
	(properties
		y 42
		x 151
		view 137
		loop 3
		cel 1
	)
)

(instance Visor of Prop
	(properties
		y 35
		x 134
		view 149
	)
)

(instance chand of Act
	(properties
		y -1
		x 158
		view 10
	)
)

(instance Can of Act
	(properties
		y 100
		x 225
		view 149
		loop 1
	)
)

(instance Armor of RFeature
	(properties
		nsTop 24
		nsLeft 101
		nsBottom 189
		nsRight 162
	)

	(method (handleEvent event)
		(if (and local53 (MousedOn self event 3))
			(event claimed: 1)
			(Print 37 39 #at 110 110) ; "A very old suit of armor, with one gloved hand holding a battle-axe, stands beside the stairway. Although it's well-polished, all of its joints are completely rusted."
		)
	)
)

(instance Axe of RFeature
	(properties
		nsTop 25
		nsLeft 167
		nsBottom 116
		nsRight 215
	)

	(method (handleEvent event)
		(if
			(or
				(and local53 (MousedOn self event 3))
				(Said 'look/ax[<battle]')
			)
			(Print 37 13) ; "It's a fourteenth-century Swiss battle-axe, finely handcrafted by Doge Guiseppe Minelli of Venice on his 90th birthday for his daughter who was to wed Antonio Fermaccelli, the bologna merchant. Later it became a favorite piece of Anne Boleyn's. Of course, Lizzie had the most fun with it!"
			(event claimed: 1)
		)
	)
)

(instance Carpet of RFeature
	(properties
		nsTop 34
		nsLeft 131
		nsBottom 148
		nsRight 189
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {carpet})
		)
	)
)

(instance Couch of RFeature
	(properties
		nsTop 95
		nsLeft 227
		nsBottom 117
		nsRight 261
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {sofa})
		)
	)
)

(instance leftBotPath of Path
	(properties)

	(method (at param1)
		(return [local27 param1])
	)
)

(instance rightBotPath of Path
	(properties)

	(method (at param1)
		(return [local34 param1])
	)
)

(instance leftTopPath of Path
	(properties)

	(method (at param1)
		(return [local41 param1])
	)
)

(instance rightTopPath of Path
	(properties)

	(method (at param1)
		(return [local46 param1])
	)
)

(instance Crash of Sound
	(properties
		number 36
		priority 5
	)
)

(instance Fall of Sound
	(properties
		number 9
		priority 5
	)
)

(instance myIcon of DCIcon
	(properties)
)

