;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63008)
(include sci.sh)
(use Main)
(use n63002)
(use P2View)
(use Plane)
(use Str)
(use Rectangle)
(use Array)
(use PolyEdit)
(use Polygon)
(use WriteFeature)
(use Feature)
(use PlaneManager)
(use Timer)
(use Cycle)
(use TextField)
(use Button)
(use Sound)
(use Jump)
(use File)
(use User)
(use Menu)
(use System)

(public
	debugFeature 0
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp2 0)
	(= temp3 -1)
	(for ((= temp4 (param1 first:))) temp4 ((= temp4 (param1 next: temp4)))
		(= temp0 (param1 value: temp4))
		(if
			(and
				(temp0 respondsTo: #onMe)
				(temp0 onMe: param2)
				(> (= temp1 (temp0 priority:)) temp3)
				(or (temp0 isKindOf: View) (temp0 isKindOf: P2View))
			)
			(= temp2 temp0)
			(= temp3 temp1)
		)
	)
	(return temp2)
)

(procedure (localproc_1 &tmp temp0) ; UNUSED
	(if ((gCurRoom obstacles:) size:)
		(= local2
			(AddPolygon (gCurRoom plane:) (gCurRoom obstacles:) 2000 255 0 0 1 1)
		)
	)
)

(procedure (localproc_2) ; UNUSED
	(return 0)
)

(procedure (localproc_3 param1 &tmp temp0)
	(drawList
		add:
			(myLine
				new:
					(AddLine
						gThePlane
						(param1 left:)
						(param1 top:)
						(param1 right:)
						(param1 top:)
					)
			)
	)
	(drawList
		add:
			(myLine
				new:
					(AddLine
						gThePlane
						(param1 right:)
						(param1 top:)
						(param1 right:)
						(param1 bottom:)
					)
			)
	)
	(drawList
		add:
			(myLine
				new:
					(AddLine
						gThePlane
						(param1 right:)
						(param1 bottom:)
						(param1 left:)
						(param1 bottom:)
					)
			)
	)
	(drawList
		add:
			(myLine
				new:
					(AddLine
						gThePlane
						(param1 left:)
						(param1 bottom:)
						(param1 left:)
						(param1 top:)
					)
			)
	)
)

(procedure (localproc_4 param1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
		(if (== temp0 (- (param1 size:) 1))
			(drawList
				add:
					(myLine
						new:
							(AddLine
								gThePlane
								((param1 points:) at: (* temp0 2))
								((param1 points:) at: (+ (* temp0 2) 1))
								((param1 points:) at: 0)
								((param1 points:) at: 1)
							)
					)
			)
		else
			(drawList
				add:
					(myLine
						new:
							(AddLine
								gThePlane
								((param1 points:) at: (* temp0 2))
								((param1 points:) at: (+ (* temp0 2) 1))
								((param1 points:) at: (+ (* temp0 2) 2))
								((param1 points:) at: (+ (* temp0 2) 3))
							)
					)
			)
		)
	)
)

(procedure (localproc_5 param1 &tmp temp0 temp1 temp2)
	(for ((= temp1 0)) (< temp1 (param1 size:)) ((++ temp1))
		(= temp0 (param1 at: temp1))
		(cond
			((temp0 isMemberOf: Rectangle)
				(localproc_3 temp0)
			)
			((temp0 isKindOf: Polygon)
				(localproc_4 temp0)
			)
			((temp0 isKindOf: View)
				(if (= temp2 (temp0 target:))
					(cond
						((temp2 isMemberOf: Rectangle)
							(localproc_3 temp2)
						)
						((temp2 isKindOf: Polygon)
							(localproc_4 temp2)
						)
					)
				else
					(drawList
						add:
							(myLine
								new:
									(AddLine
										gThePlane
										(temp0 left:)
										(temp0 top:)
										(temp0 right:)
										(temp0 top:)
									)
							)
					)
					(drawList
						add:
							(myLine
								new:
									(AddLine
										gThePlane
										(temp0 right:)
										(temp0 top:)
										(temp0 right:)
										(temp0 bottom:)
									)
							)
					)
					(drawList
						add:
							(myLine
								new:
									(AddLine
										gThePlane
										(temp0 right:)
										(temp0 bottom:)
										(temp0 left:)
										(temp0 bottom:)
									)
							)
					)
					(drawList
						add:
							(myLine
								new:
									(AddLine
										gThePlane
										(temp0 left:)
										(temp0 bottom:)
										(temp0 left:)
										(temp0 top:)
									)
							)
					)
				)
			)
		)
	)
)

(instance debugSound of Sound ; UNUSED
	(properties)
)

(instance drawList of List
	(properties)
)

(instance myLine of Obj
	(properties)

	(method (new param1 &tmp temp0)
		(= temp0 (super new:))
		(temp0 scratch: param1)
		(return temp0)
	)
)

(instance debugFeature of Feature
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(super init:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2] temp7 [temp8 2] temp10 [temp11 12] temp23 temp24 temp25)
		(if local4
			(switch (event type:)
				(evKEYBOARD
					(switch (event message:)
						(KEY_UP
							(if local4
								(local4 y: (- (local4 y:) 1))
								(local4 posn: (local4 x:) (local4 y:))
							)
						)
						(KEY_LEFT
							(local4 x: (- (local4 x:) 1))
							(local4 posn: (local4 x:) (local4 y:))
						)
						(KEY_RIGHT
							(local4 x: (+ (local4 x:) 1))
							(local4 posn: (local4 x:) (local4 y:))
						)
						(KEY_DOWN
							(local4 y: (+ (local4 y:) 1))
							(local4 posn: (local4 x:) (local4 y:))
						)
						(else
							(PrintDebug {x: %d y: %d} (local4 x:) (local4 y:))
							(local4 dispose:)
							(= local3 (= local4 0))
							((gUser hogs:) pop:)
						)
					)
				)
				(evMOUSEBUTTON
					(if (& emSHIFT (event modifiers:))
						(if (local4 isKindOf: Prop)
							(local4 cel: 0 setCycle: End)
						)
					else
						(if (local4 isKindOf: Prop)
							(local4 cel: 0)
						)
						(= local3 (if local3 0 else local4))
					)
				)
				(else
					(if local3
						(event localize: gThePlane)
						(local3 posn: (event x:) (event y:))
					)
				)
			)
			(return)
		)
		(if (or (event claimed:) (not (OneOf (event type:) evKEYBOARD evMOUSEBUTTON)))
			(return)
		)
		(if (== (event type:) evKEYBOARD)
			(event claimed: 1)
			(switch (event message:)
				(KEY_QUESTION
					(proc64986_0
						{ALT A - get all inventory items\nALT-C - show cast\nALT-D - set all movie flags\nALT-E - show Ego info\nALT-F - set or clear a flag\nALT-G - set global variable\nALT-I - get one Inventory Item\nALT-K - kill current song ALT-M - report free memory\nALT-P - change Picture\nALT-R - show Room info\nALT-S - test a sound\nALT-T - teleport\nALT-V - make a new view\nALT-W - wipe clean\nALT-X - exit the Game\nALT-Y - Toggle Rects/Polygons\nALT-Z - Do Scene\nALT-LMB- pick up and move a view\nALT-RMB- display mouse coords\n}
					)
				)
				(KEY_ALT_a
					(for ((= temp4 0)) (<= temp4 37) ((++ temp4))
						(gEgo get: temp4)
					)
				)
				(KEY_ALT_c
					(= temp10 ((gThePlane cast:) itemList:))
					(if (temp10 size:)
						(for
							((= temp4 (temp10 first:)))
							temp4
							((= temp4 (temp10 next: temp4)))
							
							(= temp3 (KList 8 temp4)) ; NodeValue
							(proc64986_0
								{class: %s\nname: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d\npri: %d\nsignal: $%x\n}
								((temp3 getSuper:) name:)
								(temp3 name:)
								(temp3 view:)
								(temp3 loop:)
								(temp3 cel:)
								(temp3 x:)
								(temp3 y:)
								(temp3 priority:)
								(temp3 signal:)
							)
						)
					else
						(proc64986_0 {No One Home!})
						(return)
					)
				)
				(KEY_ALT_d
					(gPlayback setAllMovieFlags:)
				)
				(KEY_ALT_e
					(= temp3
						(if (((plane cast:) itemList:) contains: gEgo)
							gEgo
						else
							(proc64986_0 {Sorry - ego's not init'd!})
							(return)
						)
					)
					(proc64986_0
						{name: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d\npri: %d\nsignal: $%x\nscript: %s\n}
						(temp3 name:)
						(temp3 view:)
						(temp3 loop:)
						(temp3 cel:)
						(temp3 x:)
						(temp3 y:)
						(temp3 priority:)
						(temp3 signal:)
						(if (temp3 script:)
							((temp3 script:) name:)
						else
							{..none..}
						)
					)
				)
				(KEY_ALT_f
					(= temp7 -1)
					(while (== (= temp7 (proc64986_2 {Flag number?} 0)) -1)
						(proc64986_0 {You must tell me a number!})
					)
					(if (IsFlag temp7)
						(proc64986_0 {Clearing flag %d} temp7)
						(ClearFlag temp7)
					else
						(proc64986_0 {Setting flag %d} temp7)
						(SetFlag temp7)
					)
				)
				(KEY_ALT_g
					(= temp7 -1)
					(while
						(==
							(= temp7 (proc64986_2 {Global variable number?} 0))
							-1
						)
						(proc64986_0 {You must tell me a number!})
					)
					(proc64986_0 {Old value: %d} [gEgo temp7])
					(= temp4 -1)
					(while
						(==
							(= temp4 (proc64986_2 {New value?} [gEgo temp7]))
							-1
						)
						(proc64986_0 {You must tell me a number!})
					)
					(proc64986_0
						{Setting global variable: %d to value: %d}
						temp7
						temp4
					)
					(= [gEgo temp7] temp4)
				)
				(KEY_ALT_i
					(if (!= gCurRoomNum 900) ; mapRoom
						(getInvItemPlane init: 10 80 630 396)
					else
						(PrintDebug {Not in the})
						(PrintDebug {Map Room. Sorry})
					)
				)
				(KEY_ALT_k
					(gP2SongPlyr stop: 0)
				)
				(KEY_ALT_n
					(proc64986_0 {You have to go through the control panel.})
				)
				(KEY_ALT_o
					(proc64986_0 {You have to go through the control panel.})
				)
				(KEY_ALT_p
					(= temp7 -1)
					(while
						(== (= temp7 (proc64986_2 {New picture number?} 0)) -1)
						(proc64986_0 {You must tell me a number!})
					)
					(if (ResCheck rsPIC temp7)
						(gCurRoom drawPic: temp7)
					else
						(proc64986_0 {Resource not found.})
					)
				)
				(KEY_ALT_r
					(proc64986_0
						{name: %s\nnumber: %u\npicture: %u\nstyle: %d\nnorth: %u\nsouth: %u\neast: %u\nwest: %u\n}
						(gCurRoom name:)
						gCurRoomNum
						(gCurRoom picture:)
						(gCurRoom style:)
						(gCurRoom north:)
						(gCurRoom south:)
						(gCurRoom east:)
						(gCurRoom west:)
						458
						240
					)
				)
				(KEY_ALT_s
					(= temp7 (proc64986_2 {which sound number?}))
					(gP2SongPlyr stop: 0)
					(gP2SongPlyr start: temp7 100)
				)
				(KEY_ALT_t
					(for ((= temp4 0)) (< temp4 (gCast size:)) ((++ temp4))
						(= temp3 (gCast at: temp4))
						(if (and (temp3 isClass:) (temp3 isKindOf: Timer))
							(PrintDebug {got rid of %s} (temp3 name:))
							(temp3 dispose:)
						)
					)
					(= temp7 (proc64986_2 {Which room number?} gCurRoomNum))
					(if (ResCheck rsSCRIPT temp7)
						(= gChapter (proc64986_2 {What chapter?} gChapter))
						(if (!= temp7 0)
							(gCurRoom newRoom: temp7)
						)
					else
						(proc64986_0 {Resource not found.})
					)
				)
				(KEY_ALT_v
					(= temp3 (Prop new:))
					(temp3 posn: 320 150)
					(= temp4 -1)
					(repeat
						(if (== (= temp4 (proc64986_2 {View number?} 0)) -1)
							(proc64986_0 {You must tell me a number!})
						else
							(temp3 view: temp4)
							(break)
						)
					)
					(if (not (ResCheck rsVIEW temp4))
						(proc64986_0 {Resource not Found.})
						(DisposeClone temp3)
					else
						(repeat
							(if (== (= temp4 (proc64986_2 {Loop number?} 0)) -1)
								(proc64986_0 {You must tell me a number!})
							else
								(temp3 loop: temp4)
								(break)
							)
						)
						(temp3 init:)
						((gUser hogs:) push: self 0)
						(= local3 (= local4 temp3))
					)
				)
				(KEY_ALT_m
					(proc64986_0
						{Free RAM (current): %u}
						(- (MemoryInfo 0) 500)
					)
				)
				(KEY_ALT_w)
				(KEY_ALT_x
					(= gQuit 1)
				)
				(KEY_ALT_y
					(if (not local5)
						(for
							((= temp4 0))
							(< temp4 ((gThePlane cast:) size:))
							((++ temp4))
							
							(= temp3 ((gThePlane cast:) at: temp4))
							(if
								(and
									(temp3 respondsTo: #target)
									(= temp23 (temp3 target:))
								)
								(cond
									((temp23 isMemberOf: OnMeList)
										(localproc_5 temp23)
									)
									((temp23 isMemberOf: Rectangle)
										(localproc_3 temp23)
									)
									((temp23 isKindOf: Polygon)
										(localproc_4 temp23)
									)
									((temp23 isKindOf: View)
										(if (= temp24 (temp23 target:))
											(cond
												((temp24 isMemberOf: Rectangle)
													(localproc_3 temp24)
												)
												((temp24 isKindOf: Polygon)
													(localproc_4 temp24)
												)
											)
										else
											(drawList
												add:
													(myLine
														new:
															(AddLine
																gThePlane
																(temp23 left:)
																(temp23 top:)
																(temp23 right:)
																(temp23 top:)
															)
													)
											)
											(drawList
												add:
													(myLine
														new:
															(AddLine
																gThePlane
																(temp23 right:)
																(temp23 top:)
																(temp23 right:)
																(temp23 bottom:)
															)
													)
											)
											(drawList
												add:
													(myLine
														new:
															(AddLine
																gThePlane
																(temp23 right:)
																(temp23 bottom:)
																(temp23 left:)
																(temp23 bottom:)
															)
													)
											)
											(drawList
												add:
													(myLine
														new:
															(AddLine
																gThePlane
																(temp23 left:)
																(temp23 bottom:)
																(temp23 left:)
																(temp23 top:)
															)
													)
											)
										)
									)
								)
							)
						)
						(= local5 1)
					else
						(for
							((= temp4 0))
							(< temp4 (drawList size:))
							((++ temp4))
							
							(DeleteLine ((drawList at: temp4) scratch:) gThePlane)
						)
						(drawList eachElementDo: #dispose)
						(drawList release:)
						(= local5 0)
					)
				)
				(KEY_ALT_z
					(proc63002_7 (proc64986_2 {What movie #: } 1630))
				)
				(else
					(event claimed: 0)
				)
			)
		else
			(switch (event modifiers:)
				($000d 0) ; emALT | emCTRL | emRIGHT_SHIFT
				($000e 0) ; emALT | emCTRL | emLEFT_SHIFT
				($000c ; emALT | emCTRL
					(event claimed: 1)
					(event globalize:)
					(= temp0 (event x:))
					(= temp1 (event y:))
					(proc64986_0
						{global: %d/%d\n_local: %d/%d}
						temp0
						temp1
						(event x:)
						(event y:)
						24
						320
						24
						452
						999
					)
				)
				($0005 ; emCTRL | emRIGHT_SHIFT
					(event type: evKEYBOARD message: KEY_ALT_r)
					(self handleEvent: event)
				)
				($0006 ; emCTRL | emLEFT_SHIFT
					(event type: evKEYBOARD message: KEY_ALT_e)
					(self handleEvent: event)
				)
				($0009 0) ; emALT | emRIGHT_SHIFT
				($000a 0) ; emALT | emLEFT_SHIFT
				(emRIGHT_SHIFT 0)
				(emLEFT_SHIFT 0)
				(emCTRL 0)
				($000b ; emALT | emSHIFT
					(= temp0 (event x:))
					(= temp1 (event y:))
					(PrintDebug {x=%d y=%d} (event x:) (event y:))
					(while (!= ((= temp2 (Event new:)) type:) evMOUSERELEASE)
						(temp2 localize: gThePlane)
						(if (or (!= temp0 (temp2 x:)) (!= temp1 (temp2 y:)))
							(PrintDebug {x=%d y=%d} (temp2 x:) (temp2 y:))
							(= temp0 (temp2 x:))
							(= temp1 (temp2 y:))
						)
						(temp2 dispose:)
					)
					(temp2 dispose:)
				)
				(emALT
					(event claimed: 1 localize: gThePlane)
					(if (= temp3 (localproc_0 (gThePlane cast:) event))
						(= temp0 (- (temp3 x:) (event x:)))
						(= temp1 (- (temp3 y:) (event y:)))
						(gTheCursor hide:)
						(while (!= ((= temp2 (Event new:)) type:) evMOUSERELEASE)
							(temp2 localize: gThePlane)
							(temp3
								posn: (+ (temp2 x:) temp0) (+ (temp2 y:) temp1)
							)
							(UpdateScreenItem
								(if (temp3 isKindOf: View)
									temp3
								else
									(temp3 target:)
								)
							)
							(FrameOut)
							(temp2 dispose:)
						)
						(temp2 dispose:)
						(gTheCursor show:)
						(proc64986_0
							{%s: x=%d y=%d}
							(temp3 name:)
							(temp3 x:)
							(temp3 y:)
						)
					)
					(event globalize:)
				)
			)
		)
	)
)

(instance poly_pol of File ; UNUSED
	(properties
		name {poly.pol}
	)
)

(instance getInvItemPlane of Plane
	(properties
		picture -2
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp4 (IDArray new:))
		(temp4
			at:
				0
				(Str with: {Bob's\nButton})
				(Str with: {Your\nwallet})
				(Str with: {Your\ncardkey})
				(Str with: {The\ncandybar})
				(Str with: {Photo of\nparents})
				(Str with: {Xmas\nparty photo})
				(Str with: {Sexy\npostcard})
				(Str with: {Bondage\npostcard})
				(Str with: {Dr H's\ncard})
				(Str with: {Orderly's\nkeys})
				(Str with: {Screwdriver})
				(Str with: {Letter\nfrom dad})
				(Str with: {Footlocker})
				(Str with: {Paul's\nkey})
				(Str with: {Hammer})
				(Str with: {Folder})
				(Str with: {Hairpin})
				(Str with: {Paul's\nbook})
				(Str with: {Logo\nPrintout})
				(Str with: {ID\nbracelet})
				(Str with: {Bundled\nmail})
				(Str with: {Blob the\nrat})
				(Str with: {Piece of\nlace})
				(Str with: {Paper\nw/anagrams})
				(Str with: {Note from\nTherese})
				(Str with: {Paul's\nspeech})
				(Str with: {Trevor's\ncardkey})
				(Str with: {Paperclip})
				(Str with: {Fire\nextinguisher})
				(Str with: {Alien\nfood})
				(Str with: {Alien})
				(Str with: {Slime})
				(Str with: {Bubble\nbeast})
				(Str with: {Alien\nskin})
				(Str with: {Alien\nhook})
		)
		(= temp1 0)
		(= temp2 10)
		(super init: &rest)
		(= temp5 -1)
		(for ((= temp0 0)) (< temp0 (temp4 size:)) ((++ temp0))
			(if (not (gEgo has: temp0))
				((= temp5 (inventoryGetButton new:))
					posn: temp1 temp2
					setPri: 100
					value: temp0
					setText: (temp4 at: temp0)
					setSize:
					init: self
				)
				(if (> (+= temp1 105) (- right 100))
					(= temp1 0)
					(+= temp2 35)
				)
			)
			((temp4 at: temp0) dispose:)
		)
		(self setRect: left top right (+ top temp2 25) 1)
		(temp4 dispose:)
		(self setPri: (+ (GetHighPlanePri) 1) 1)
		(if (== temp5 -1)
			(self dispose:)
		)
	)
)

(instance inventoryGetButton of TextButton
	(properties
		view 2886
	)

	(method (action)
		(super action: &rest)
		(gEgo get: value)
		(plane dispose:)
	)
)

